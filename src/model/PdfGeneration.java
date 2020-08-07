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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class PdfGeneration {
    final static org.apache.log4j.Logger logger      = Logger.getLogger( PdfGeneration.class );
    private      PDDocument              document;
    private      PDPage                  page;
    private      File                    file;
    private      PDFTextStripper         pdfStripper;
    private      DaoPersonne             daoPersonne = new DaoPersonneImpl();


    public void creationPdf () throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:/pdfBox/ListeEmploye.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Paragraph paragraph = new Paragraph("Liste des employe \n", font);
        paragraph.setAlignment( Element.ALIGN_CENTER );
        paragraph.setLeading(0, 1);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        addTableHeader(table);
        addRows(table);
        document.add( paragraph );
        document.add( Chunk.NEWLINE );
        document.add( Chunk.NEWLINE );
        document.add(table);

        document.close();

    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Nom", "Prenom", "email")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table) {

        List<PersonnesEntity> listTest = null;

        try {
            listTest = daoPersonne.lister();
            for ( PersonnesEntity stringPersonne : listTest ) {
                logger.log( Level.INFO, "forEach: " + stringPersonne.getEmail() );
                table.addCell( stringPersonne.getNom() );
                table.addCell( stringPersonne.getPrenom() );
                table.addCell( stringPersonne.getEmail() );
            }
        } catch ( DaoException e ) {
            e.getMessage();
        }
    }

}
