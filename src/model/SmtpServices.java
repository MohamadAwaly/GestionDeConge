package model;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//@author: JY & Mohamad

public class SmtpServices {

    public static void emailConfig( String pFrom, String pPassword, String pHost, String pTo ) {
        String messageBody, sujet;
        sujet = "Réponse de votre demande";
        messageBody = "Vous aviez fait une demande de congé ces derniers jours, votre employeur vous à répondu. " +
                "Retrouvez la réponse dans le pdf que vous aviez reçu en piece ci-joint. ";

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
