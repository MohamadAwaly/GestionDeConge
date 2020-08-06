package model;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfGeneration {

    public void creationPdf() throws IOException {
        PDDocument document = new PDDocument();

        document.addPage( new PDPage() );
        document.save( "C:/pdfBox/BlankPdf.pdf" );

        System.out.println( "PDF created" );
        document.close();

    }

}
