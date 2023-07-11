package Assignment.NMNGOC.Ass9.Ex2.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By productInformation = By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-base']");
    By quantity = By.xpath("//*[@id='a-autoid-0-announce']");
    By subtotal = By.xpath("//*[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']");


    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public void displayProductInformation(){
        System.out.println("----------------");
        System.out.println(driver.findElement(this.productInformation).getText());
        System.out.println("----------------");
        System.out.println(driver.findElement(this.quantity).getText());
        System.out.println("----------------");
        System.out.println(driver.findElement(this.subtotal).getText());
    }
}
