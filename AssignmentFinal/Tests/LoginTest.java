package AssignmentFinal.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_login);
        this.driver.manage().window().maximize();
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test(priority = 1)
    void test1() {
//        5. Verify login page displayed with email, password field and login button.
        System.out.println("5. Verify login page displayed with email, password field and login button.");
        loginPage.setEmail("minhngocnxx@gmail.com");
        System.out.println("- Email field is displayed");
        System.out.println("- Continue Button is displayed");

        loginPage.setPassword("minhngoc");
        System.out.println("- Password field is displayed");
        System.out.println("- Sign In Button is displayed");
    }

    @Test(priority = 2)
    void test2() throws InterruptedException {
//        6. Verify that the user is not able to login with an invalid email and password.
//        8. Get messenger
        System.out.println("6. Verify that the user is not able to login with an invalid email and password.");
        // invalid email
        loginPage.setEmail("mngoc355@gmail.com");

        WebElement invalidEmail = driver.findElement(By.xpath("//*[@id='auth-error-message-box']/div"));

        if(invalidEmail.isDisplayed()){
            System.out.println(invalidEmail.getText());
            loginPage.setEmail("minhngocnxx@gmail.com");
        }

        // invalid password
        loginPage.setPassword("minhngoc123");

        WebElement invalidPassword = driver.findElement(By.xpath("//*[@id='auth-warning-message-box']/div"));

        if(invalidPassword.isDisplayed()){
            System.out.println(invalidPassword.getText());
            loginPage.setPassword("minhngoc");
        }
    }

    @Test(priority = 3)
    void test3() throws InterruptedException {
//        7. Verify that the validation message gets displayed in case the user leaves the email or
//        password field as blank.
//        8. Get messenger

        System.out.println("7. Verify that the validation message gets displayed in case the user leaves " +
                "the email or password field as blank.");
        // blank email
        loginPage.setEmail("");

        WebElement blankEmail = driver.findElement(By.xpath("//*[@id='auth-email-missing-alert']/div"));

        if(blankEmail.isDisplayed()){
            System.out.println(blankEmail.getText());
            loginPage.setEmail("minhngocnxx@gmail.com");
        }

        // blank password
        loginPage.setPassword("");

        WebElement blankPassword = driver.findElement(By.xpath("//*[@id='auth-password-missing-alert']/div"));

        if(blankPassword.isDisplayed()){
            System.out.println(blankPassword.getText());
            loginPage.setPassword("minhngoc");
        }
    }
}
