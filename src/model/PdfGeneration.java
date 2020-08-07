package model;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoPersonne;
import com.atc.momo.Jiwaii.dao.DaoPersonneImpl;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class PdfGeneration {
    final static org.apache.log4j.Logger logger      = Logger.getLogger( PdfGeneration.class );
    private      PDDocument              document;
    private      PDPage                  page;
    private      File                    file;
    private      PDFTextStripper         pdfStripper;
    private      DaoPersonne             daoPersonne = new DaoPersonneImpl();

    /**
     * Creation du fichier pdf
     *
     * @throws IOException
     */
    public void creationPdf() throws IOException {
        //Creation docuement vide
        document = new PDDocument();

        /**
         * Creating the document Object
         */
        PDDocumentInformation pdDocumentInformation = document.getDocumentInformation();

        //Autheur
        pdDocumentInformation.setAuthor( "ATC" );
        //Titre
        pdDocumentInformation.setTitle( "Employe de la societe" );
        //Createur
        pdDocumentInformation.setCreator( "Employe" );
        //Sujet
        pdDocumentInformation.setSubject( "les employe present dans la societe" );

        //Setting the created date of the document
        Calendar date = new GregorianCalendar();
        date.set( 2015, 11, 5 );
        pdDocumentInformation.setCreationDate( date );
        //Setting the modified date of the document
        date.set( 2016, 6, 5 );
        pdDocumentInformation.setModificationDate( date );

        //Setting keywords for the document
        pdDocumentInformation.setKeywords( "sample, first example, my pdf" );

        //Creer une page vide
        page = new PDPage();
        //Ajout de la page au document
        document.addPage( page );
        //enregistrer le document
        document.save( "C:/pdfBox/BlankPdf.pdf" );
        logger.log( Level.INFO, "PDF Created" );
        //Fermer l'objet
        document.close();

    }

    /**
     * Ajout du text a un fichier existant
     *
     * @throws IOException
     */
    public void addingTextPdf() throws IOException {

        //Chargement d'un document PDF existant
        file = new File( "C:/pdfBox/BlankPdf.pdf" );
        document = PDDocument.load( file );

        //Recuperation de la page 1
        page = document.getPage( 0 );
        //PDPage page = new PDPage(PDRectangle.A4);
        // Preparation du flux du contenue
        PDPageContentStream contentStream = new PDPageContentStream( document, page );
        //Ajout du text
        contentStream.beginText();
        //Definir le font de la content stream
        contentStream.setFont( PDType1Font.TIMES_ROMAN, 12 );
        // définir l' interlignage du texte
        contentStream.setLeading( 14.5f );
        //Definir la position de la ligne
        contentStream.newLineAtOffset( 25, 500 );


        List<PersonnesEntity> listTest = null;
        contentStream.showText( "Nom " );
        contentStream.showText( "Prenom " );
        contentStream.showText( "Email " );
        contentStream.newLine();
        try {
            listTest = daoPersonne.lister();
            for ( PersonnesEntity stringPersonne : listTest ) {
                logger.log( Level.INFO, "forEach: " + stringPersonne.getEmail() );
                contentStream.showText( stringPersonne.getNom() );
                contentStream.showText( stringPersonne.getPrenom() );
                contentStream.showText( stringPersonne.getEmail() );
                contentStream.newLine();
            }
        } catch ( DaoException e ) {
            e.getMessage();
        }

        //Mettre fin au fluix de contenue
        contentStream.endText();
        logger.log( Level.INFO, "Content added" );
        //Fermeture du content stream
        contentStream.close();

        // enregistrement du document
        document.save( "C:/pdfBox/BlankPdf.pdf" );

        //Fermeture du document
        document.close();
    }

    /**
     * Récuperation du text d'un document PDF et le sous forme d'un objet String
     *
     * @throws IOException
     */
    public void extractingTextPdf() throws IOException {
        //chargement du fichier existant
        file = new File( "C:/pdfBox/my_doc.pdf" );
        document = PDDocument.load( file );
        //Instantiation de de PDFTextStripper class
        pdfStripper = new PDFTextStripper();

        //Recuperation du text a partir du fichier pdf
        String text = pdfStripper.getText( document );
        logger.log( Level.INFO, "text recupere du PDF: " + text );
    }


}
