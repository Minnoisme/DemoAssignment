package AssignmentFinal.Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest{
    @BeforeTest
    void setup(){
        this.driver.get(BaseTest.URL_header);
        this.driver.manage().window().maximize();
    }

    @AfterTest
    void after() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }

    @Test
    void test() throws InterruptedException {
        // 1. Verify that on the home page, the user can see search textbox, category menu, cart icon.
        System.out.println("1. Verify that on the home page, the user can see search textbox, " +
                "category menu, cart icon.");

        headerPage.setSearchBox("Samsung");
        System.out.println("- Search Text box is displayed");

        headerPage.selectCategories();
        System.out.println("- Category Menu is displayed");

        headerPage.selectCartIcon();
        System.out.println("- Cart Icon is displayed");

        headerPage.selectSearchButton();
    }
}
