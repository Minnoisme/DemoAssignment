package Assignment.NMNGOC.Ass9.Ex2.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MainTest extends BaseTest {
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @DataProvider(name = "Book2")
    public Object[][] getData() throws IOException {
        return BaseTest.getDataFromExcel();
    }

    @Test(dataProvider = "Book2")
    void test(String producTitle, String productPrice) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(producTitle);

        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();

        String actualText = this.driver.findElement(By.xpath("(//*[@id='productTitle'])[1]")).getText();
        Assert.assertEquals(actualText, producTitle, "Product Title Fail");
        System.out.println("-------Product Title---------");

        String actualPrice = this.driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        Assert.assertEquals(actualPrice, productPrice, "Price Fail");
        System.out.println("---------Price-------");

        // Add to cart
        driver.findElement(By.xpath("//*[@id='submit.add-to-cart']/span")).click();

        // Verify confirmation test appears: “1 item added to Cart”
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='attachDisplayAddBaseAlert']/div")));
        System.out.println("Verify: " + element2.getText());

        // Verify item is displayed on Shopping Cart list
        driver.findElement(By.xpath("//*[@id='attach-sidesheet-view-cart-button']/span")).click();
        cartPage.displayProductInformation();
    }
}
