package com.atc.momo.Jiwaii.beans;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoPersonne;
import com.atc.momo.Jiwaii.dao.DaoPersonneImpl;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ConnexionForm {
    private static final String                  CHAMP_EMAIL           = "email";
    private static final String                  CHAMP_PASS            = "motdepasse";
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    final static         org.apache.log4j.Logger logger                = Logger.getLogger( ConnexionForm.class );
    private              String                  resultat;
    private              Map<String, String>     erreurs               = new HashMap<String, String>();
    private              EntityManagerFactory    entityManagerFactory  = null;
    private              EntityManager           em;
    private int firstResult;

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public PersonnesEntity connecterUtilisateur( HttpServletRequest request ) throws Exception {

        logger.log( Level.INFO, "méthode" );
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        PersonnesEntity utilisateur = new PersonnesEntity();

        logger.log( Level.INFO, "champ email: " + email );

        /* Validation du champ email. */
        try {
            logger.log( Level.INFO, "try validation du champ email" );
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        /* Validation du champ mot de passe. */
        try {
            logger.log( Level.INFO, "try validation du champ mdp" );
            validationMotDePasse( motDePasse, email );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setMotDePasse( motDePasse );





        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            DaoPersonne userDao = new DaoPersonneImpl();
            try {
                utilisateur = userDao.userFind(email,motDePasse);
            } catch (DaoException e) {
                e.getMessage();
            }
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Recuepre toutes les info de la personne connecter
     */


    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {

        //PersonnesEntity utilisateur = null;

        entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        em = entityManagerFactory.createEntityManager();
        Query requete = (Query) em.createQuery( "select p.email from PersonnesEntity p WHERE p.email=:email" );

        //utilisateur = em.createQuery("select p.email from PersonnesEntity p WHERE p.email=:email" );

        //List<PersonnesEntity> pers = new ArrayList<>();
        requete.setParameter( "email", email );
        try {

            logger.log( Level.INFO, "*********************dans le try if******************" );
            if ( email == null || !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
            String pers = (String) requete.getSingleResult();
            if ( pers.equals( email ) ) {
                //logger.log( Level.INFO, "++++++++++++++++pers adresse correct++++++++++++++: " + pers );
            } else {
                throw new Exception( "Adresse email incorrecte" );
            }
            //utilisateur = (PersonnesEntity) requete.getSingleResult();
            logger.log( Level.INFO, "L'email  correspend  " );
        } catch ( NoResultException e ) {
            logger.log( Level.INFO, "L'email ne correspend pas " );
            throw new DaoException( "Adresse email incorrecte" );
        } catch ( Exception e ) {
            throw new DaoException( e.getMessage() );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse, String email ) throws Exception {
        //PersonnesEntity utilisateur = null;

        entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        em = entityManagerFactory.createEntityManager();

        Query requete = (Query) em
                .createQuery(
                        "select p.motDePasse from PersonnesEntity p WHERE p.motDePasse=:motDePasse and p.email=:email" );

        requete.setParameter( "motDePasse", motDePasse );
        requete.setParameter( "email", email );

        try {
            if ( motDePasse != null ) {
                if ( motDePasse.length() < 3 ) {
                    throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
                }
            } else {
                throw new Exception( "Merci de saisir votre mot de passe." );
            }
            String pers = (String) requete.getSingleResult();
            logger.log( Level.INFO, "personne to string" + pers );
            if ( pers.equals( motDePasse ) ) {
                logger.log( Level.INFO, "++++++++++++++++pers mot de passe correct++++++++++++++: " + pers );
            } else {
                throw new Exception( "Le mot de passe ne correspond pas a la base de donnée" );
            }

            //utilisateur = (PersonnesEntity) requete.getSingleResult();
            logger.log( Level.INFO, "le mot de passe correspond a la db" );

        } catch ( NoResultException e ) {
            throw new Exception( "mot de passe incorrecte" );
        } catch ( Exception e ) {
            throw new DaoException( e.getMessage() );
        }

    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
