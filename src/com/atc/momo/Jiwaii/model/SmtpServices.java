package com.atc.momo.Jiwaii.model;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

//@author: JY & Mohamad

public class SmtpServices {
    final static org.apache.log4j.Logger logger = Logger.getLogger( SmtpServices.class );

    /**
     * @param pFrom
     * @param pPassword
     * @param pHost
     * @param pTo
     * @param messageBody
     */

    public static void emailConfig( String pFrom, String pPassword, String pHost, String pTo, String messageBody,
            String namePdf )
            throws MessagingException {
        String sujet;
        sujet = "Réponse de votre demande";

        Properties props = System.getProperties();
        //String host = "smtp.gmail.com";
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", pHost );
        props.put( "mail.smtp.user", pFrom );
        props.put( "mail.smtp.password", pPassword );
        props.put( "mail.smtp.port", "587" );
        props.put( "mail.smtp.auth", "true" );

        Session session = Session.getDefaultInstance( props );
        MimeMessage message = new MimeMessage( session );

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        //<editor-fold desc="TRY bloc for SENT EMAIL   7-08-2020">

        try {
            message.setFrom( new InternetAddress( pFrom ) );

            message.addRecipients( Message.RecipientType.TO, pTo );

            message.setSubject( sujet );
            message.setText( messageBody );

            //piece jointe fichier pdf

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = namePdf;
            String fileName = "attachment.pdf";
            DataSource source = new FileDataSource( file );
            messageBodyPart.setDataHandler( new DataHandler( source ) );
            messageBodyPart.setFileName( fileName );
            multipart.addBodyPart( messageBodyPart );

            message.setContent( multipart );

            Transport transport = session.getTransport( "smtp" );
            transport.connect( pHost, pFrom, pPassword );
            transport.sendMessage( message, message.getAllRecipients() );
            transport.close();
        } catch ( MessagingException e ) {
            e.getMessage();
        }
        //</editor-fold>

    }
}
