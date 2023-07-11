package Assignment.NMNGOC.Ass8.Ex1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSuccess {
    WebDriver driver;
    By messenger = By.xpath("//*[text()='You logged into a secure area!']");
    By logout    = By.xpath("//*[text()=' Logout']");
    public LoginSuccess(WebDriver driver){
        this.driver = driver;
    }

    public void getMessenger() {
        System.out.println(driver.findElement(this.messenger).getText());
    }

    public void selectLogout(){
        driver.findElement(this.logout).click();
    }
}
