package pl.agh.wfiis;

import java.net.URI;
import java.net.URISyntaxException;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static pl.agh.wfiis.Common.fillLoginForm;
import pl.agh.wfiis.utils.TestMe;


public class OrganizerIntegrationTest {

    private URI siteBase;
    private WebDriver driver;

    @Inject
    TestMe test;
    
    @Before
    public void setUp() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Patryk\\Documents\\NetBeansProjects\\Gathering\\Utilities\\chromedriver.exe");
        siteBase = new URI("http://localhost:8080/Gathering-web/");
        driver = new ChromeDriver();
    }

    @Test
    public void createNewEventByOrganizer() throws InterruptedException {
        driver.get(siteBase.toString());
        fillLoginForm("recepcja@wybrzeze.pl", "pass", driver);
        redirectToNewEventPage();
        fillNewEventForm();


        Thread.sleep(2000);
        driver.close();
    }

    private void redirectToNewEventPage() throws InterruptedException {
        driver.findElement(By.id("eventDropdown")).click();
        driver.findElement(By.id("newEventLink")).click();
        Thread.sleep(2000);
    }

    private void fillNewEventForm() {
        driver.findElement(By.id("j_idt35:eventTitle")).sendKeys("Test");
        driver.findElement(By.id("j_idt35:eventDescription")).sendKeys("Test description");
        driver.findElement(By.id("j_idt35:eventDate")).sendKeys("2016-12-24 20:00");
        driver.findElement(By.id("j_idt35:eventPlace")).sendKeys("Test place");
        driver.findElement(By.id("j_idt35:eventPictureLink")).sendKeys("http://x3.cdn03.imgwykop.pl/c3201142/comment_RjOdnuCPsltzPkF4v79uDtq61Jjs4TIY,wat.jpg?author=Stachan&auth=e5cf6a2645d95bebac0dd1e1f28bfa30");
        driver.findElement(By.id("j_idt35:eventMaxPeople")).sendKeys("100");
        driver.findElement(By.id("j_idt35:submitNewEvent")).submit();
    }

}
