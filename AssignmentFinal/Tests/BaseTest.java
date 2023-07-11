package AssignmentFinal.Tests;

import AssignmentFinal.Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    HeaderPage headerPage;
    ProductPage productPage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    CartPage cartPage;

    public static String URL_header = "https://www.amazon.com/ref=nav_logo";
    public static String URL_product = "https://www.amazon.com/SAMSUNG-Factory-Unlocked-Smartphone-Lavender/dp/B0BLP2B5DZ/ref=mp_s_a_1_1_sspa?crid=2QT030ETXLY8Y&keywords=samsung&qid=1687346667&sprefix=samsung%2Caps%2C589&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9waG9uZV9zZWFyY2hfYXRm&th=1#";
    public static String URL_login = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
    public static String URL_signup = "https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-o" +
            "ut%26ref_%3Dnav_AccountFlyout_signout&prevRID=M9QFQ8DEZWS0KYJH154W&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&mobileBrowserWeblabTreatment=C";

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.headerPage = new HeaderPage(this.driver);
        this.productPage = new ProductPage(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.signUpPage = new SignUpPage(this.driver);
        this.cartPage = new CartPage(this.driver);
    }
}
