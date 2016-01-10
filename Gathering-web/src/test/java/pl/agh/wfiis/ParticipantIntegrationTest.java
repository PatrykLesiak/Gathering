package pl.agh.wfiis;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static pl.agh.wfiis.Common.*;

public class ParticipantIntegrationTest {  
    
    private URI siteBase;
    private WebDriver driver;

    public ParticipantIntegrationTest() {
    }

    @Before
    public void setUp() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Patryk\\Documents\\NetBeansProjects\\Gathering\\Utilities\\chromedriver.exe");
        siteBase = new URI("http://localhost:8080/Gathering-web/");
        driver = new ChromeDriver();
    }

    @Test
    public void testParticipantLogin() {
        driver.get(siteBase.toString());
        fillLoginForm("patryk.lesiakk@gmail.com", "pass", driver);
        driver.close();
    }


}
