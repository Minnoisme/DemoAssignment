package Assignment.NMNGOC.Ass8.Ex3.Test;

import Assignment.NMNGOC.Ass8.Ex2.Pages.SignupLoginPage;
import Assignment.NMNGOC.Ass8.Ex2.Pages.SingupPage;
import Assignment.NMNGOC.Ass8.Ex3.Pages.HeaderPage;
import Assignment.NMNGOC.Ass8.Ex3.Pages.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    HeaderPage headerPage;
    ProductsPage productsPage;

    public static String URL = "https://www.ebay.com/";

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.headerPage = new HeaderPage(this.driver);
        this.productsPage = new ProductsPage(this.driver);
    }


}
