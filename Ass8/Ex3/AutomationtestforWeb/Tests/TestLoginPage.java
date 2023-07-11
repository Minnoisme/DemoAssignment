package AutomationtestforWeb.Tests;

import AutomationtestforWeb.Tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestLoginPage extends BaseTest {
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_LoginPage);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }

    @DataProvider(name = "data-test")
    public Object[][] getData() throws IOException {
        return BaseTest.getDataFromExcel();
    }

    @Test(dataProvider = "data-test")
        // 1. Login with valid user and pass
    void test(String username, String password) throws InterruptedException {
        this.driver.findElement(By.id("email")).sendKeys(username);
        this.driver.findElement(By.id("passwd")).sendKeys(password);

        Thread.sleep(1000);
        this.driver.findElement(By.id("SubmitLogin")).click();

        WebElement loginSuccess = this.driver.findElement(By.className("error-copy"));
        System.out.println(loginSuccess.getText());

    }
}
