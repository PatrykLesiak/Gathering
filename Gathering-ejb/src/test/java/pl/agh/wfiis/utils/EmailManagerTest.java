package pl.agh.wfiis.utils;

import java.util.Properties;
import static org.junit.Assert.*;
import pl.agh.wfiis.database.Event;
import pl.agh.wfiis.database.Organizer;

public class EmailManagerTest {
    
    private EmailManager instance;
    private Event eventMock;
    private Organizer organizerMock;
    
    public EmailManagerTest() {
        instance = new EmailManager();
        eventMock = new Event();
        organizerMock = new Organizer();
        
        eventMock.setOrganizer(organizerMock);
    }
    
    @org.junit.Test
    public void testPrepareEmailProperties() throws Exception {
        String expectedFromAddress = "projekt.io@o2.pl";
        Properties properties = instance.prepareEmailProperties();
        
        assertEquals(properties.getProperty("mail.from"), expectedFromAddress);
    }
    
    @org.junit.Test
    public void testConfirmationMessageNotNull() throws Exception {
        assertNotNull(instance.confirmationMessage(eventMock));
    }
}
    
