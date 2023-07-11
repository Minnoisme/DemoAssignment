package Assignment.NMNGOC.Ass8.Ex1.Test;

import Assignment.NMNGOC.Ass8.Ex1.Pages.LoginPage;
import Assignment.NMNGOC.Ass8.Ex1.Pages.LoginSuccess;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    LoginSuccess loginSuccess;

    public static String URL = "https://practice.expandtesting.com/login";

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(this.driver);
        this.loginSuccess = new LoginSuccess(this.driver);
    }


}
