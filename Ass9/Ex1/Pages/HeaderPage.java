package Assignment.NMNGOC.Ass9.Ex1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderPage {
    WebDriver driver;
    By searchBox    = By.id("twotabsearchtextbox");
    By categories   = By.id("nav-search-dropdown-card");
    By searchButton = By.id("nav-search-submit-button");

    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchBox(String seacrhKey){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(this.searchBox);
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(seacrhKey);
    }

    public void selectCategories(String category){
        driver.findElement(this.categories).click();
        String locator = String.format("//*[@id='searchDropdownBox']//option[text()='%s']", category);
        driver.findElement(By.xpath(locator)).click();
    }

    public void selectSearchButton(){
        driver.findElement(this.searchButton).click();
    }
}
