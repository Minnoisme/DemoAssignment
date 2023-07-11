package Assignment.NMNGOC.Ass8.Ex1.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainTest extends BaseTest{
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
    void test1() {
        // 1. valid Email address& Password
        System.out.println("1. valid Email address& Password");
        loginPage.setUsername("practice");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.selectLoginButton();

        loginSuccess.getMessenger();
        loginSuccess.selectLogout();
    }
    @Test(priority = 2)
    void test2() {
        // 2. invalid Email address& Password
        System.out.println("2. invalid Email address& Password");
        loginPage.setUsername("practice123");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.selectLoginButton();
        loginPage.getEroMessenger();
    }

    @Test(priority = 3)
    void test3() {
        // 3. Email address is Empty
        System.out.println("3. Email address is Empty");
        loginPage.setUsername("");
        loginPage.setPassword("SuperSecretPassword!");
        loginPage.selectLoginButton();
        loginPage.getEroMessenger();
    }

}
