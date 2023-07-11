package Assignment.NMNGOC.Ass9.Ex1.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MainTest2 extends BaseTest {
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
        headerPage.selectCategories("Books");
        headerPage.setSearchBox(searchKey);
        headerPage.selectSearchButton();

        productsPage.getTitle();
    }
}
