package Assignment.NMNGOC.Ass9.Ex1.Tests;

import Assignment.NMNGOC.Ass9.Ex1.Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @DataProvider(name = "Book1")
    public Object[][] getData() throws IOException {
        return BaseTest.getDataFromExcel();
    }

    @Test(dataProvider = "Book1")
    void test(String searchKey, String productTitle) throws InterruptedException {
        this.driver.findElement(By.id("nav-search-dropdown-card")).click();
        this.driver.findElement(By.xpath("//option[text()='Books']")).click();

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
        actions.keyDown(element, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.DELETE).perform();
        element.sendKeys(searchKey);

        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(1000);

        String actualText = this.driver.findElement(By.xpath(
                "//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/" +
                        "div/div/div/div[2]/div/div/div[1]/h2/a/span")).getText();

        Assert.assertEquals(actualText, productTitle, "Fail");

//        if(actualText.equals(productTitle)){
//            System.out.println("True");
//        }else{
//            System.out.println("Fail");
//        }
    }
}
