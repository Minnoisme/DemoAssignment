package AutomationtestforWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    By seleniumCondition = By.xpath("//a[text()='Selenium']");
    By login = By.xpath("//a[text()='Login']");
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void selectSeleniumCondition(){
        // Verify element present on Home page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(seleniumCondition));
        System.out.println("Verify element present on Home page: " + element.isDisplayed());

    }

}
