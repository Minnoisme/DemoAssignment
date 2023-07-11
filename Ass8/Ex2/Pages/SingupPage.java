package Assignment.NMNGOC.Ass8.Ex2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingupPage {
    WebDriver driver;
    By title = By.xpath("//*[text()='Enter Account Information']");
    public SingupPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle() {
        System.out.println(driver.findElement(this.title).getText());
        driver.navigate().back();
    }

}
