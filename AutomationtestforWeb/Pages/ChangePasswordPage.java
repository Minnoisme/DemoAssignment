package AutomationtestforWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPage {
    By oldPass = By.xpath("//input[@name='oldpassword']");
    By newPass = By.xpath("//input[@name='newpassword']");
    By confirmPass = By.xpath("//input[@name='confirmpassword']");
    By submit = By.xpath("//input[@name='sub']");
    By logout = By.xpath("/html/body/div[3]/div/ul/li[15]/a");

    By user = By.xpath("//input[@name='uid']");
    By pass = By.xpath("//input[@name='password']");
    By login = By.xpath("//input[@name='btnLogin']");
    WebDriver driver;
    public ChangePasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void setOldPass(String oldPass){
        WebElement element = driver.findElement(this.oldPass);
        element.sendKeys(oldPass);
        WebElement message20 = this.driver.findElement(By.id("message20"));
        System.out.println(message20.getText());
    }

    public void setNewPass(String newPass){
        WebElement element = driver.findElement(this.newPass);
        element.sendKeys(newPass);
        WebElement message21 = this.driver.findElement(By.id("message21"));
        System.out.println(message21.getText());
    }

    public void setconfirmPass(String confirmPass){
        WebElement element = driver.findElement(this.confirmPass);
        element.sendKeys(confirmPass);
        WebElement message22 = this.driver.findElement(By.id("message22"));
        System.out.println(message22.getText());
    }
    public void selectSubmit(){
        driver.findElement(submit).click();
        driver.navigate().back();
        driver.findElement(logout).click();
    }

    public void setUser(String user){
        WebElement element = driver.findElement(this.user);
        element.sendKeys(user);
    }

    public void setPass(String pass){
        WebElement element = driver.findElement(this.pass);
        element.sendKeys(pass);
    }

    public void selectlogin(){
        driver.findElement(login).click();
    }

}
