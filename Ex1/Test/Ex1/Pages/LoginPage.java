package Assignment.NMNGOC.Ass8.Ex1.Test.Ex1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.xpath("//*[text()='Login']");
    By eroMessenger = By.id("flash");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void selectLoginButton() {
        driver.findElement(this.loginButton).click();
    }

    public void getEroMessenger(){
        System.out.println(driver.findElement(this.eroMessenger).getText());
    }

}
