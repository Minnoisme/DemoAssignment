package Assignment.NMNGOC.Ass8.Ex3.Test;

import Assignment.NMNGOC.Ass8.Ex3.Test.BaseTest;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class MainTest extends BaseTest {
    @BeforeTest
    void setup(){
        this.driver.get(URL);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        headerPage.selectCategoriies("Women");
        productsPage.getTitle();

        headerPage.selectCategoriies("Men");
        productsPage.getTitle();

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Get cookies: " + cookies);
    }

}
