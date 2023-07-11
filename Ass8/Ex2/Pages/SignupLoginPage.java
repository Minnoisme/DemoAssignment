package Assignment.NMNGOC.Ass8.Ex2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignupLoginPage {
    WebDriver driver;

    By name = By.xpath("//*[@name='name']");
    By email = By.xpath("//*[@data-qa='signup-email'] ");
    By signupButton = By.xpath("//*[@data-qa='signup-button'] ");
    By eroMessenger = By.xpath("//*[@id='form']/div/div/div[3]/div/form/p");

    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setName(String name) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(this.name);
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(name);
    }

    public void setEmail(String email) {
//        driver.findElement(this.email).sendKeys(email);

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(this.email);
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(email);
    }

    public void selectSignupButton() {
        driver.findElement(this.signupButton).click();
    }

    public void getEroMessenger(){
        System.out.println(driver.findElement(this.eroMessenger).getText());
    }

}
