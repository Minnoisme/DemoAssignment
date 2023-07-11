package AutomationtestforWeb.Tests;

import AutomationtestforWeb.Tests.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPOM extends BaseTest {
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_HomePage);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }

    @Test
    void test(){
        homePage.selectSeleniumCondition();
    }
}
