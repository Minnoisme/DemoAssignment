package Assignment.NMNGOC.Ass8.Ex2.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

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

    @Test(priority = 1)
    void test1() throws InterruptedException {
        System.out.println("1. Valid Email address");
        signupLoginPage.setName("Mai Anh");
        signupLoginPage.setEmail("mngoc355@gmail.com");
        signupLoginPage.selectSignupButton();
        Thread.sleep(2000);

        singupPage.getTitle();
    }

    @Test(priority = 2)
    void test2() throws InterruptedException {
        System.out.println("2. Invalid Email address");
        signupLoginPage.setName("Mai Anh");
        signupLoginPage.setEmail("mngoc355gmail.com");
        signupLoginPage.selectSignupButton();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void test3() throws InterruptedException {
        System.out.println("3. Blank Email address");
        signupLoginPage.setName("Mai Anh");
        signupLoginPage.setEmail("");
        signupLoginPage.selectSignupButton();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void test4() throws InterruptedException {
        System.out.println("4. Blank Email address");
        signupLoginPage.setName("Minh Ngoc");
        signupLoginPage.setEmail("minhngocnxx@gmail.com");
        signupLoginPage.selectSignupButton();
        signupLoginPage.getEroMessenger();
        Thread.sleep(2000);
    }

}
