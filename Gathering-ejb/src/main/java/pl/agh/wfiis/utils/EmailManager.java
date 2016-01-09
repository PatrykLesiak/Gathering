package pl.agh.wfiis.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.model.EventsModel;

class Autentyfikator extends Authenticator {
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("projekt.io", "wfiisagh");
    }
}

@Stateless
@LocalBean
public class EmailManager {
    
    private Session session;
    private Properties props;
    
    @EJB
    EventsModel eventsModel;
    
    @PostConstruct
    void init() {
        props = prepareEmailProperties();
        session = Session.getInstance(props, new Autentyfikator());  
    }

    public void sendEmail(MimeMessage message) {
        try {
            sendMessage(message, session);
        } catch (Exception ex) {
            Logger.getLogger(EmailManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendEmailForSigningUpForEvent(int eventId, String userEmail) throws MessagingException {
        sendEmail(createMessageForSigningIntoEvent(userEmail, eventsModel.getEventById(eventId)));
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

    private MimeMessage createMessageForSigningIntoEvent(String userEmail, Event event) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setSubject("Gathering - potwierdzenie zapisu");
        message.setContent(confirmationMessage(event), "text/plain; charset=ISO-8859-2");
        message.setFrom("projekt.io@o2.pl");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

        return message;
    }

    private void sendMessage(MimeMessage message, Session session) throws NoSuchProviderException, MessagingException {
        Transport transport;
        transport = session.getTransport();
        transport.connect();
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }
    
    private String confirmationMessage(Event event) {
        return "Potwierdzenie zapisu na wydarzenie " + event.getTitle() + 
                "\nOrganizator wydarzenia (" + event.getOrganizer().getCompanyname() + ")" +
                " skontaktuje się z Panem/Panią w związku z przekazaniem biletu wstępu." + 
                "\n\n Pozdrawiamy ! \n Zespół Gathering";
    }
}
