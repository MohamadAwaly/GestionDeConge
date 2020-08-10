package model;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoPersonne;
import com.atc.momo.Jiwaii.dao.DaoPersonneImpl;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfGeneration {
    final static org.apache.log4j.Logger logger      = Logger.getLogger( PdfGeneration.class );
    private      DaoPersonne             daoPersonne = new DaoPersonneImpl();
    private      Document                document    = new Document();
    private      Font                    font        = FontFactory.getFont( FontFactory.COURIER, 16, BaseColor.BLACK );

    /**
     * PDF piece jointe pour joindre a la réponse d'une demande de conge
     *
     * @param numeroDemande
     * @param message
     * @throws Exception
     */
    public void pdfReponse( int numeroDemande, String message, int idPersonneJourDeCongeTypeDemande ) throws Exception {

        //Cree repertoir si il n'existe pas
        String dossier = "C:/Conge/Reponse";
        if ( !new File( dossier ).exists() ) {
            // Créer le dossier avec tous ses parents
            new File( dossier ).mkdirs();

        } else {
            logger.log( Level.INFO, "ce dossier existe deja" );
        }
        PdfWriter.getInstance( document,
                new FileOutputStream( "C:/Conge/Reponse/demande_numero_" + idPersonneJourDeCongeTypeDemande + ".pdf" ) );
        document.open();
        Paragraph paragraph = new Paragraph( message, font );
        paragraph.setAlignment( Element.ALIGN_LEFT );
        paragraph.setLeading( 0, 1 );
        document.add( paragraph );
        document.close();
    }

    /**
     * Creation d'un fichier pdf liste des employes dans la table Personnes
     *
     * @throws Exception
     */
    public void creationPdf() throws Exception {
        //Cree repertoir si il n'existe pas
        String dossier = "C:/Conge/Employe";
        if ( !new File( dossier ).exists() ) {
            // Créer le dossier avec tous ses parents
            new File( dossier ).mkdirs();

        } else {
            logger.log( Level.INFO, "ce dossier existe deja" );
        }

        PdfWriter.getInstance( document, new FileOutputStream( "C:/Conge/Employe/ListeEmploye.pdf" ) );

        document.open();

        Paragraph paragraph = new Paragraph( "Liste des employe \n", font );
        paragraph.setAlignment( Element.ALIGN_CENTER );
        paragraph.setLeading( 0, 1 );

        PdfPTable table = new PdfPTable( 3 );
        table.setWidthPercentage( 100 );
        table.setHorizontalAlignment( Element.ALIGN_CENTER );
        table.setTotalWidth( new float[] { 50, 50, 150 } );
        addTableHeader( table );
        addRows( table );
        document.add( paragraph );
        document.add( Chunk.NEWLINE );
        document.add( Chunk.NEWLINE );
        document.add( table );
        document.close();
    }

    private void addTableHeader( PdfPTable table ) {
        Stream.of( "Nom", "Prenom", "email" )
                .forEach( columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor( BaseColor.LIGHT_GRAY );
                    header.setBorderWidth( 2 );
                    header.setPhrase( new Phrase( columnTitle ) );
                    table.addCell( header );
                } );
    }

    private void addRows( PdfPTable table ) {

        List<PersonnesEntity> listEmp = null;

        try {
            listEmp = daoPersonne.lister();
            for ( PersonnesEntity stringPersonne : listEmp ) {
                //logger.log( Level.INFO, "forEach: " + stringPersonne.getEmail() );
                table.addCell( stringPersonne.getNom() );
                table.addCell( stringPersonne.getPrenom() );
                table.addCell( stringPersonne.getEmail() );
            }
        } catch ( DaoException e ) {
            e.getMessage();
        }
    }

}
