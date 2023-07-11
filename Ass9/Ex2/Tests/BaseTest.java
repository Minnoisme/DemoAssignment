package Assignment.NMNGOC.Ass9.Ex2.Tests;


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
    CartPage cartPage;

    public static String URL = "https://www.amazon.com/ref=nav_logo";

    public BaseTest() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.cartPage = new CartPage(this.driver);
    }

    public static Object[][] getDataFromExcel() throws IOException {
        String[][] arrayData = null;

        // Reading file from local directory
        FileInputStream file = new FileInputStream((System.getProperty("user.dir")+
                "/src/test/java/Assignment/NMNGOC/Ass9/Ex2/Book2.xlsx"));

        // Create Workbook instance holding reference to
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
                System.out.println(arrayData[row - 1][col - 1]);
            }
        }
        return (arrayData);
    }
}




