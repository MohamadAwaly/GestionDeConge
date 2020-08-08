package model;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

//@author: JY & Mohamad

public class SmtpServices {

    public static void emailConfig( String pFrom, String pPassword, String pHost, String pTo,String messageBody  ) {
        String  sujet;
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

        //<editor-fold desc="TRY bloc for SENT EMAIL   7-08-2020">

        try {
            message.setFrom( new InternetAddress( pFrom ) );

            message.addRecipients( Message.RecipientType.TO, pTo );

            message.setSubject( sujet );
            message.setText( messageBody );
            String filename = "C:/pdfBox/ListeEmploye.pdf";
            DataSource source = new FileDataSource(filename);
            message.setDataHandler(new DataHandler(source));
            message.setFileName(filename);


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