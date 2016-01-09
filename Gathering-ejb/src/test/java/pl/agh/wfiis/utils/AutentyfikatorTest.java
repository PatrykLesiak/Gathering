package pl.agh.wfiis.utils;

import javax.mail.PasswordAuthentication;
import org.junit.Test;
import static org.junit.Assert.*;

public class AutentyfikatorTest {
    
    public AutentyfikatorTest() {
    }

    @org.junit.Test
    public void testGetPasswordAuthentication() {
        Autentyfikator instance = new Autentyfikator();
        PasswordAuthentication result = instance.getPasswordAuthentication();
        assertNotNull(result);
    }
    
}
