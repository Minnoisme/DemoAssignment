package AutomationtestforWeb.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestChangePassword extends BaseTest {
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_ChangePasswordPage);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(3000);
        this.driver.quit();
    }

    @Test
    void test2(){
        changePasswordPage.setOldPass("tanuped");
        changePasswordPage.setNewPass("minianna2!");
        changePasswordPage.setconfirmPass("minianna2!");
        changePasswordPage.selectSubmit();
        changePasswordPage.setUser("mngr512787");
        changePasswordPage.setPass("minianna!2");
        changePasswordPage.selectlogin();
    }
}
