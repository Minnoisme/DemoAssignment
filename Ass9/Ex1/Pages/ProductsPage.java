package Assignment.NMNGOC.Ass9.Ex1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;
    By title = By.xpath(
            "//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/" +
                    "div/div/div/div[2]/div/div/div[1]/h2/a/span");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void getTitle(){
        System.out.println(driver.findElement(this.title).getText());
    }

}
