package Assignment.NMNGOC.Ass8.Ex3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderPage {
    WebDriver driver;

    By categories = By.id("gh-shop-a");
    By items = By.xpath("//*[@data-qa='signup-email'] ");

    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectCategoriies(String item) {
        driver.findElement(this.categories).click();
        String locator = String.format("//a[@class='scnd' and text()='%s']", item);
        this.driver.findElement(By.xpath(locator)).click();
    }


}
