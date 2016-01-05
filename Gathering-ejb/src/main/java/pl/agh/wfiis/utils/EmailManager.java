package pl.agh.wfiis.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class Autentyfikator extends Authenticator {
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("projekt.io", "wfiisagh");
    }
}

@Stateless
@LocalBean
public class EmailManager {

    public void sendEmail() {
        Properties props = prepareEmailProperties();
        Session session = Session.getInstance(props, new Autentyfikator());

        try {
            sendMessage(createMessage(session), session);
        } catch (Exception ex) {
            Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Properties prepareEmailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "poczta.o2.pl");
        properties.setProperty("mail.user", "projekt.io");
        properties.setProperty("mail.password", "wfiisagh");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.from", "projekt.io@o2.pl");

        return properties;
    }

    private MimeMessage createMessage(Session session) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setSubject("Gathering - potwierdzenie zapisu");
        message.setContent("This is a test", "text/plain");
        message.setFrom("projekt.io@o2.pl");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("patryk.lesiakk@gmail.com"));

        return message;
    }

    private void sendMessage(MimeMessage message, Session session) throws NoSuchProviderException, MessagingException {
        Transport transport;
        transport = session.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
}
