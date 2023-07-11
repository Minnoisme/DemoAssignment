package Assignment.NMNGOC.Ass8.Ex2.Test;

import Assignment.NMNGOC.Ass8.Ex2.Pages.SignupLoginPage;
import Assignment.NMNGOC.Ass8.Ex2.Pages.SingupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    SignupLoginPage signupLoginPage;
    SingupPage singupPage;

    public static String URL = "https://automationexercise.com/signup";

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.signupLoginPage = new SignupLoginPage(this.driver);
        this.singupPage = new SingupPage(this.driver);
    }


}
