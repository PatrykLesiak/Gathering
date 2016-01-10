package pl.agh.wfiis;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Common {
    static void fillLoginForm(String email, String password, WebDriver driver) {
        try {
            driver.findElement(By.id("j_username")).sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.id("j_password")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.name("Submit")).click();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParticipantIntegrationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
