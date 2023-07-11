package AssignmentFinal.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HeaderPage {
    By searchBox    = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By categories   = By.id("nav-search-dropdown-card");
    By cartIcon     = By.id("nav-cart");
    By product      = By.xpath("SAMSUNG Galaxy S23 Ultra Cell Phone, Factory Unlocked Android " +
            "Smartphone, 256GB, 200MP Camera, Night Mode, Long Battery Life, S Pen, US Version, 2023, Lavender");

    WebDriver driver;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSearchBox(String text) {
        Assert.assertTrue(this.driver.findElement(this.searchBox).isDisplayed(), "Search Text box is not displayed");
        this.driver.findElement(this.searchBox).sendKeys(text);
    }

    public void selectSearchButton() {
        this.driver.findElement(this.searchButton).click();
    }

    public void selectCategories() {
        Assert.assertTrue(this.driver.findElement(this.categories).isDisplayed(), "Category Menu is not displayed");
    }

    public void selectCartIcon() {
        Assert.assertTrue(this.driver.findElement(this.cartIcon).isDisplayed(), "Cart Icon is not displayed");
        driver.findElement(this.cartIcon).click();
    }

    public void selectProduct(){
        WebElement element = driver.findElement(this.product);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
