package AssignmentFinal.Pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    By color = By.xpath("//*[@id='a-autoid-11-announce']/div/div[1]/img");
    By size = By.xpath("//button[@id='a-autoid-17-announce']");
    By style = By.xpath("//button[@id='a-autoid-20-announce']");
    By quantity = By.xpath("//*[@id='selectQuantity']/span/div/div/span");
    By chooseQuantity = By.xpath("//*[@id='quantity']/option[2]");
    By addToCart = By.xpath("//*[@id='submit.add-to-cart']/span");
    By messenger = By.xpath("//*[@id='attachDisplayAddBaseAlert']/div");
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectColor(){
        WebElement element = driver.findElement(this.color);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        System.out.println("Color is selected");
    }

    public void selectSize(){
        driver.findElement(this.size).click();
        System.out.println("Size is selected");
    }

    public void selectStyle(){
        driver.findElement(this.style).click();
        System.out.println("Style is selected");
    }

    public void selectQuantity(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id='titleSection']")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(this.quantity));
        element.click();
    }
    public void setChooseQuantity(){
        driver.findElement(this.chooseQuantity).click();
    }
    public void selectAddToCart(){
        driver.findElement(this.addToCart).click();
    }
    public void getMessenger(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='attachDisplayAddBaseAlert']/div")));
        System.out.println(element.getText());
    }



}
