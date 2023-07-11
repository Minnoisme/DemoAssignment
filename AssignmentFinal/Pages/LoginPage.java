package AssignmentFinal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    By email = By.id("ap_email");
    By password = By.id("ap_password");
    By continueButton = By.xpath("//input[@id='continue']");
    By signInButton = By.id("signInSubmit");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String text){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(this.email);
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(text);
//        System.out.println("- Email field is displayed");

        WebElement continueButton = driver.findElement(this.continueButton);
        continueButton.click();
//        System.out.println("- Continue Button is displayed");
    }

    public void setPassword(String text){
        WebElement element = driver.findElement(this.password);
        element.sendKeys(text);
//        System.out.println("- Password field is displayed");

        WebElement signInButton = driver.findElement(this.signInButton);
        signInButton.click();
//        System.out.println("- Sign In Button is displayed");
    }

//    public void selectContinueButton(){
//        WebElement element = driver.findElement(this.continueButton);
//        element.click();
//        System.out.println("- Continue Button is displayed");
//
//    }
//    public void selectSignInButton(){
//        WebElement element = driver.findElement(this.signInButton);
//        element.click();
//        System.out.println("- Sign In Button is displayed");
//
//    }
}
