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

    /**
     * Creation d'un fichier pdf liste des employes dans la table Personnes
     * @throws Exception
     */
    public void creationPdf () throws Exception {
        //Cree repertoir si il n'existe pas
        String dossier = "C:/pdfBox/";
        if(!new File(dossier).exists())
        {
            // Créer le dossier avec tous ses parents
            new File(dossier).mkdirs();

        } else {
            logger.log( Level.INFO,"ce dossier existe deja" );
        }
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:/pdfBox/ListeEmploye.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        Paragraph paragraph = new Paragraph("Liste des employe \n", font);
        paragraph.setAlignment( Element.ALIGN_CENTER );
        paragraph.setLeading(0, 1);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.setTotalWidth(new float[]{ 50, 50, 150 });
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

    //test
    /**
     * Creates a table; widths are set with special setWidthPercentage() method.
     * @return a PdfPTable
     * @throws DocumentException
     */
    public static PdfPTable createTable4() throws DocumentException {
        PdfPTable table = new PdfPTable(3);
        Rectangle rect = new Rectangle(523, 770);
        table.setWidthPercentage(new float[]{ 144, 72, 72 }, rect);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Table 4"));
        cell.setColspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");
        return table;
    }

}
