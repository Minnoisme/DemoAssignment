package AssignmentFinal.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductTest extends BaseTest{
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_product);
        this.driver.manage().window().maximize();
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        // 2. Verify that on the product page, the user can select the desired attribute of the product e.g. size,
        //color, etc.
        System.out.println("2. Verify that on the product page, the user can select the desired " +
                "attribute of the product e.g. size, color, etc.");
        productPage.selectColor();
        productPage.selectSize();
        productPage.selectStyle();
    }
    @Test
    void test2() throws InterruptedException {
        // 3. Verify that the user can add to cart one or more products.
        System.out.println("3. Verify that the user can add to cart one or more products.");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='titleSection']")));
        productPage.selectQuantity();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='selectQuantity']/span/div/div/span")));
//        element.click();

        productPage.setChooseQuantity();
        productPage.selectAddToCart();

        // Verify item is displayed on Shopping Cart list
         productPage.getMessenger();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='attachDisplayAddBaseAlert']/div")));
//        System.out.println(element2.getText());

        System.out.println("----------------");
        WebElement cart = driver.findElement(By.xpath("//*[@id='attach-sidesheet-view-cart-button']/span"));
        cart.click();

        cartPage.displayProductInformation();
//        System.out.println(driver.findElement(By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-base']")).getText());
//        System.out.println("----------------");
//        System.out.println(driver.findElement(By.xpath("//*[@id='a-autoid-0-announce']")).getText());
//        System.out.println("----------------");
//        System.out.println(driver.findElement(By.xpath("//*[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']")).getText());
    }


}
