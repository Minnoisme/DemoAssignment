package AssignmentFinal.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_signup);
        this.driver.manage().window().maximize();
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        System.out.println("4. Verify that all the specified fields are present on the registration page.");
        signUpPage.setUsername("Minh Minh");
        signUpPage.setPhoneOrEmail("mngoc355@gmail.com");
        signUpPage.setPassword("minhngoc");
        signUpPage.setRePassword("minhngoc");
        signUpPage.selectContinueButton();
    }
}
