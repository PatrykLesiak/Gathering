package pl.agh.wfiis.utils;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

    class Autentyfikator extends Authenticator
    {
        @Override
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("projekt.io","wfiisagh");
        }
    }

@Stateless
@LocalBean
public class EmailManager {
Logger logger = Logger.getLogger(getClass().getName());
    public void sendEmail() {
    Properties props = new Properties();
    props.setProperty("mail.transport.protocol", "smtp");
    props.setProperty("mail.host", "poczta.o2.pl");
    props.setProperty("mail.user", "projekt.io");
    props.setProperty("mail.password", "wfiisagh");
    props.setProperty("mail.smtp.auth", "true");
    props.setProperty("mail.from", "projekt.io@o2.pl");
    
    Session session = Session.getInstance(props, new Autentyfikator());
    
      Transport transport;
        try {
            transport = session.getTransport();

            MimeMessage message = new MimeMessage(session);
            message.setSubject("Testing javamail plain");
            message.setContent("This is a test", "text/plain");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("patryk.lesiak@o2.pl"));

            transport.connect();
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            logger.info("OK");
            
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
