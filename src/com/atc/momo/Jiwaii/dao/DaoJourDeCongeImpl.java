package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;
import model.CalendarTools;
import model.PdfGeneration;
import model.SmtpServices;
import model.Tools;
import org.apache.log4j.Level;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DaoJourDeCongeImpl implements DaoJourDeConge {
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoJourDeCongeImpl.class );

    @Override public void insertDemande( PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity )
            throws DaoException {
        EntityManager entityManager = null;
        try {
            entityManager = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( personnejourdecongetypedemandeEntity );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouter Demande Congé" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }

    }

    @Override
    public void insertDemandeParProcedure( Integer pPersonneId, String pDateDebut, String pDateFin ) {
        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "InsererUneDemande" );
            //parametres SQL : pPersonneId INT,pDateDebut Nvarchar(10),pDateFin Nvarchar(10)
            storedprocedure.registerStoredProcedureParameter( "pPersonneId", Integer.class, ParameterMode.IN );
            storedprocedure.registerStoredProcedureParameter( "pDateDebut", Date.class, ParameterMode.IN );
            storedprocedure.registerStoredProcedureParameter( "pDateFin", Date.class, ParameterMode.IN );

            storedprocedure.setParameter( "pPersonneId", pPersonneId );
            storedprocedure.setParameter( "pDateDebut", pDateDebut );
            storedprocedure.setParameter( "pDateFin", pDateFin );

            storedprocedure.execute();
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur dans la Demande" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
    }

    @Override public List<Object[]> listerDemandeEnCours() throws DaoException {

        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        Query query = em.createQuery(
                "select pjc.idPersonneJourDeCongeTypeDemande, p.nom,pjc.dateDemande , pjc.datedebut,pjc.datefin,p.prenom "
                        + " from PersonnejourdecongetypedemandeEntity pjc "
                        + " join PersonnesEntity p ON p.idPersonne = pjc.fkPersonne"
                        + " where pjc.aprouver = com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity.EnumApprouver.En_Cours " );

        List<Object[]> lst_demande = query.getResultList();
        return lst_demande;
    }

    @Override public void updateDemande( int idPersonneJourDeCongeTypeDemande, String messageApprobateur,
            String approuver )
            throws DaoException {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( pattern );
        String date = simpleDateFormat.format( new Date() );
        java.sql.Date dateReponse = java.sql.Date.valueOf( date );

        PersonnejourdecongetypedemandeEntity.EnumApprouver aprouver;
        aprouver = PersonnejourdecongetypedemandeEntity.EnumApprouver.valueOf( approuver );

        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            Query query = em.createQuery( "UPDATE PersonnejourdecongetypedemandeEntity pjc "
                    + "SET pjc.aprouver = :aprouver, pjc.messageApprobateur = :messageApprobateur, pjc.dateReponse = :dateReponse"
                    + " WHERE pjc.idPersonneJourDeCongeTypeDemande = :idPersonneJourDeCongeTypeDemande" );

            query.setParameter( "messageApprobateur", messageApprobateur );
            query.setParameter( "aprouver", aprouver );
            query.setParameter( "dateReponse", dateReponse );
            query.setParameter( "idPersonneJourDeCongeTypeDemande", idPersonneJourDeCongeTypeDemande );

            query.executeUpdate();
            trans.commit();

            List<Object[]> lst_querySelect;
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "ListeDeDemandeById" );
            //parametres SQL : pIdDemande
            storedprocedure.registerStoredProcedureParameter( "pIdDemande", Integer.class, ParameterMode.IN );
            storedprocedure.setParameter( "pIdDemande", idPersonneJourDeCongeTypeDemande );
            storedprocedure.execute();
            trans.commit();

            lst_querySelect = storedprocedure.getResultList();

            // 0 Prenom, 1 Nom, 2 Email, 3 DateDemande, 4 DateReponse, 5 Aprouver,6 MessageApprobateur, 7 DateDebut, 8 DateFin;
            //lst_querySelect.get(0)[0].toString();
            String Message = "Chèr(e) " + lst_querySelect.get( 0 )[0].toString()
                    + ", \n  Vous aviez demandé congé du " + lst_querySelect.get( 0 )[7].toString() + " au "
                    + lst_querySelect.get( 0 )[8].toString() + ". Cette demande n°" + idPersonneJourDeCongeTypeDemande
                    + " du " + lst_querySelect.get( 0 )[3].toString() + "\n à été << "
                    + lst_querySelect.get( 0 )[5].toString() + " >> \n"
                    + " commentaire de votre superieur : \n \"" + lst_querySelect.get( 0 )[6].toString() + "\""
                    + "\n \n Bien à vous \n -HolidayManager-";

            // Création du PDF
            PdfGeneration pdfGeneration = new PdfGeneration();
            pdfGeneration.pdfReponse( idPersonneJourDeCongeTypeDemande, Message, idPersonneJourDeCongeTypeDemande );
            String fileName = "C:/Conge/Reponse/demande_numero_" + idPersonneJourDeCongeTypeDemande + ".pdf";

            SmtpServices
                    .emailConfig( "gestioncongee@gmail.com", "Atc123456", "smtp.gmail.com",
                            lst_querySelect.get( 0 )[2].toString(), Message, fileName );

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur update demande  n" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
    }

    @Override public List<Object[]> listerDemandeEmployer( int idPersonne ) throws DaoException {
        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        List<Object[]> list = null;
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "ListeDeDemandeByIdUSer" );
            storedprocedure.registerStoredProcedureParameter( "idPersonne", Integer.class, ParameterMode.IN );

            storedprocedure.setParameter( "idPersonne", idPersonne );
            storedprocedure.execute();
            trans.commit();

            list = storedprocedure.getResultList();

            logger.log( Level.INFO, "Procedure: " + storedprocedure.getResultList() + "\n\n\n" );

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur dans la Demande" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
        return list;
    }

    @Override public List<Object[]> JourRestant( int idPersonne ) throws DaoException {
        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        List<Object[]> lst = null;
        try {

            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "CountDate" );
            storedprocedure.registerStoredProcedureParameter( "idPersonne", Integer.class, ParameterMode.IN );
            storedprocedure.setParameter( "idPersonne", idPersonne );
            storedprocedure.execute();

            lst = storedprocedure.getResultList();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur dans la Demande" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
        return lst;
    }

    @Override public List<Object[]> CountDateToDate( int idPersonne ) throws DaoException, ParseException {
        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        List<Object[]> lst = null;
        try {
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "CountDatePro" )
                    .registerStoredProcedureParameter( "idPersonne", Integer.class, ParameterMode.IN )
                    .setParameter( "idPersonne", idPersonne );
            storedprocedure.execute();
            lst = storedprocedure.getResultList();

            lst.get( 0 )[0].toString();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur de date count" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
        return lst;
    }

    //Méthode principale
    public String ValidationDateDemande( Date dateDebutConge, Date dateFinconge, int idPersonne )
            throws ParseException, DaoException {
        List<Object[]> countDateToDate = CountDateToDate( idPersonne );
        int nbjoursDemande = getNbJours( dateDebutConge.toString(), dateFinconge.toString() );

        int jourRestant = 0;
        try {
            jourRestant = Integer.parseInt( countDateToDate.get( 0 )[4].toString() );
        } catch ( NullPointerException e ) {
            jourRestant = 0;
        }
        Date dateFinContrat = (Date) countDateToDate.get( 0 )[6];

        int jourAutorise = Integer.parseInt( countDateToDate.get( 0 )[3].toString() );
        String messageErreur = limitationJourSelection( nbjoursDemande, jourRestant, dateDebutConge, dateFinconge,
                dateFinContrat, jourAutorise, idPersonne );
        return messageErreur;

    }

    public static int getNbJours( String pDateDebut, String pDateFin ) {
        int joursPris = 0;
        LocalDate dateDebut = LocalDate.parse( pDateDebut );
        LocalDate dateFin = LocalDate.parse( pDateFin );
        while ( dateDebut.isBefore( dateFin.plusDays( 1 ) ) ) {
            if ( dateDebut.getDayOfWeek().getValue() != 6 && dateDebut.getDayOfWeek().getValue() != 7 ) {
                joursPris++;
            }
            dateDebut = dateDebut.plusDays( 1 );
        }
        return joursPris;
    }

    /**
     * Verification de la somme des jours demande par le demandeur s'ils ne depasse pas les nombres des jours restant.
     * Verification que les vacanse demande doit être faite au moin 2 jours a l'avance!!
     *
     * @param nbJourDemade
     * @param jourRestant
     * @return
     */
    public String limitationJourSelection( int nbJourDemade, int jourRestant, Date dateDebutConge,
            Date dateFinconge, Date dateFinContrat, int jourAutorise, int idPersonne ) throws DaoException {

        String messageErreur = null;
        LocalDate afterTomorrow = LocalDate.now().plusDays( 2 );
        LocalDate dateDebutCongeLC = LocalDate.parse( new SimpleDateFormat( "yyyy-MM-dd" ).format( dateDebutConge ) );
        LocalDate dateFincongeLC = LocalDate.parse( new SimpleDateFormat( "yyyy-MM-dd" ).format( dateFinconge ) );
        LocalDate dateFinContratLC = LocalDate.parse( new SimpleDateFormat( "yyyy-MM-dd" ).format( dateFinContrat ) );

        if ( nbJourDemade <= jourRestant || nbJourDemade <= jourAutorise ) {
            messageErreur = null;
        } else {
            return messageErreur = "Votre demande depasse vos jours restant";
        }
        if ( dateDebutCongeLC.isBefore( afterTomorrow ) ) {
            return messageErreur = "Votre demande doit etre faite deux jours a l'avance !!!";
        } else {
            messageErreur = null;
        }
        if ( dateDebutCongeLC.isAfter( dateFincongeLC ) ) {
            return messageErreur = "La date de fin est inferieur a la date debut";
        } else {
            messageErreur = null;
        }
        if ( dateFincongeLC.isAfter( dateFinContratLC ) ) {
            return messageErreur = "la date de fin de conge depasse votre date de fin de contrat";
        } else {
            messageErreur = null;
        }

//<editor-fold desc="Dates Already used"

        List<Object[]> lstDemandeEnCours = listerDemandeEmployer( idPersonne );
        List<LocalDate> lst_LocalDateFromForm = CalendarTools.getListOfBetwenDates(dateDebutCongeLC,dateFincongeLC);

        TestParLigne:
        for (int i=0;i < lstDemandeEnCours.size(); i++) {
            LocalDate dateDebutRow = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(lstDemandeEnCours.get(i)[8]).toString());
            LocalDate dateFinRow = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(lstDemandeEnCours.get(i)[9]).toString());
            List<LocalDate> lst_dateDb = CalendarTools.getListOfBetwenDates(dateDebutRow,dateFinRow);

            for (LocalDate lcItem:lst_dateDb
                 ) {
                if(lst_LocalDateFromForm.contains(lcItem)){
                  messageErreur = "Enchevauchement pour le :"+lcItem.toString();
                  break TestParLigne;
                }
            }
        }


//</editor-fold>





//        ListerDebutDeConge:
//        for ( int i = 0; i < lstDemandeEnCours.size(); i++ ) {
//            LocalDate dateDebutIncrementable = dateDebutCongeLC;
//            LocalDate dateDebutLigneDB = LocalDate
//                    .parse( new SimpleDateFormat( "yyyy-MM-dd" ).format( lstDemandeEnCours.get( i )[8] ).toString() );
//
//            while (dateDebutIncrementable.isBefore(dateFincongeLC.plusDays( 1 ))){
//
//                if ( dateDebutLigneDB.equals( dateDebutIncrementable ) ) {
//                    messageErreur = "Vous avez deja choisie ce jour ";
//                }else {
//                    dateDebutIncrementable = dateDebutIncrementable.plusDays( 1 );//
//                    logger.log( Level.INFO,
//                            "dans le else Date demande conge: " + dateDebutIncrementable + " " + dateFincongeLC + "\n\n\n" );
//                }
//            }
//        }

        //logger.log( Level.INFO, "Test lsr: " + lstDemandeEnCours.get( 0 )[0] + "\n\n\n" );


        return messageErreur;

    }

}


