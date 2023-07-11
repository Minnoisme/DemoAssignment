package AutomationtestforWeb.Tests;

import AutomationtestforWeb.Pages.ChangePasswordPage;
import AutomationtestforWeb.Pages.HomePage;
import AutomationtestforWeb.Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ChangePasswordPage changePasswordPage;

    public static String URL_HomePage = "https://www.demo.guru99.com/";
    public static String URL_LoginPage = "https://www.demo.guru99.com/test/login.html";
    public static String URL_ChangePasswordPage = "https://www.demo.guru99.com/v4/manager/PasswordInput.php";

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.homePage = new HomePage(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.changePasswordPage =new ChangePasswordPage(this.driver);
    }

    public static Object[][] getDataFromExcel() throws IOException {
        String[][] arrayData = null;

        FileInputStream file = new FileInputStream((System.getProperty("user.dir")+
                "/src/test/java/AutomationtestforWeb/Book1.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRow = sheet.getPhysicalNumberOfRows();
        int totalCol = 3;
        arrayData = new String[totalRow - 1][totalCol - 1];

        for (int row = 1; row < totalRow; ++row){
            for(int col = 1; col < totalCol; ++col){
                if(sheet.getRow(row).getCell(col).getCellType() == CellType.NUMERIC){
                    arrayData[row - 1][col - 1] = Long.toString(Math.round(sheet.getRow(row).getCell(col).getNumericCellValue()));
                }
                else {
                    arrayData[row - 1][col - 1] = sheet.getRow(row).getCell(col).getStringCellValue();
                }
                System.out.println((arrayData[row - 1][col - 1]));
            }
        }
        return (arrayData);
    }

    public static Object[][] getDataFromExcelSheet2() throws IOException {
        String[][] arrayData = null;

        FileInputStream file = new FileInputStream((System.getProperty("user.dir")+
                "/src/test/java/AutomationtestforWeb/Book1.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(1);

        int totalRow = sheet.getPhysicalNumberOfRows();
        int totalCol = 4;
        arrayData = new String[totalRow - 1][totalCol - 1];

        for (int row = 1; row < totalRow; ++row){
            for(int col = 1; col < totalCol; ++col){
                if(sheet.getRow(row).getCell(col).getCellType() == CellType.NUMERIC){
                    arrayData[row - 1][col - 1] = Long.toString(Math.round(sheet.getRow(row).getCell(col).getNumericCellValue()));
                }
                else {
                    arrayData[row - 1][col - 1] = sheet.getRow(row).getCell(col).getStringCellValue();
                }
                System.out.println((arrayData[row - 1][col - 1]));
            }
        }
        return (arrayData);
    }
}
