package Assignment.NMNGOC.Ass8.Ex3.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;
    By title = By.xpath("//*[@class='b-pageheader__text']");
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle() {
        System.out.println(driver.findElement(this.title).getText());
        driver.navigate().back();
    }

}
