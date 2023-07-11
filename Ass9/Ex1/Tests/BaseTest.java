package Assignment.NMNGOC.Ass9.Ex1.Tests;

import Assignment.NMNGOC.Ass9.Ex1.Pages.HeaderPage;
import Assignment.NMNGOC.Ass9.Ex1.Pages.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    HeaderPage headerPage;
    ProductsPage productsPage;
    public static String URL = "https://www.amazon.com/ref=nav_logo";

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.headerPage = new HeaderPage(this.driver);
        this.productsPage = new ProductsPage(this.driver);
    }

    public static Object[][] getDataFromExcel() throws IOException {
        String[][] arrayData = null;

        // Reading file from local directory
        FileInputStream file = new FileInputStream((System.getProperty("user.dir")+
                "/src/test/java/Assignment/NMNGOC/Ass9/Book1.xlsx"));

        // Create Workbook instance holding reference to
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRow = sheet.getPhysicalNumberOfRows();
        int totalCol = 5;
        arrayData = new String[totalRow - 1][2];

        for (int row = 1; row < totalRow; ++row){
            for(int col = 2; col < totalCol-1; ++col){
                if(sheet.getRow(row).getCell(col).getCellType() == CellType.NUMERIC){
                    arrayData[row - 1][col - 2] = Long.toString(Math.round(sheet.getRow(row).getCell(col).getNumericCellValue()));
                }
                else {
                    arrayData[row - 1][col - 2] = sheet.getRow(row).getCell(col).getStringCellValue();
                }
                System.out.println(arrayData[row - 1][col - 2]);
            }
        }
        return (arrayData);
    }
}
