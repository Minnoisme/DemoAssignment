package AssignmentFinal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
    WebDriver driver;
    By username = By.id("ap_customer_name");
    By phoneOrEmail = By.id("ap_email");
    By password = By.id("ap_password");
    By rePassword = By.id("ap_password_check");
    By continueButton = By.xpath("//input[@id='continue']");

    public SignUpPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String text){
        WebElement element = driver.findElement(this.username);
        element.sendKeys(text);
        System.out.println("Username field is presented: " + element.isDisplayed());
    }

    public void setPhoneOrEmail(String text){
        WebElement element = driver.findElement(this.phoneOrEmail);
        element.sendKeys(text);
        System.out.println("Phone or Email field is presented: " + element.isDisplayed());
    }

    public void setPassword(String text){
        WebElement element = driver.findElement(this.password);
        element.sendKeys(text);
        System.out.println("Password field is presented: " + element.isDisplayed());
    }

    public void setRePassword(String text){
        WebElement element = driver.findElement(this.rePassword);
        element.sendKeys(text);
        System.out.println("RePassword field is presented: " + element.isDisplayed());
    }

    public void selectContinueButton(){
        WebElement element = driver.findElement(this.continueButton);
        element.click();
        System.out.println("Verify Button is presented");
    }
}
