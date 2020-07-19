package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import java.util.Random;

public class loginPage extends BasePage{
//Private variables only usable in that class

    //Changed WebElement to BY private WebElement emailTextBox =  driver.findElement(By.id("input-email"));
   private By emailTextBox =  By.id("input-email");
   private By passwordTextBox = By.id("input-password");;
   private By loginButton = By.xpath("//input[@type='submit']");
   private By alertMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public loginPage(String url, WebDriver driver)
    {
        super(url, driver);

    }
    public void gotoLoginPage(){
        loadPage();
    }


    //Creating public methods to return the By variables

    public WebElement setEmailTextBox(){
        return driver.findElement(this.emailTextBox);
    }

    public WebElement setPasswordTextBox(){
        return driver.findElement(this.passwordTextBox);
    }

    public WebElement setLoginButton(){
        return driver.findElement(this.loginButton);
    }


    @Step
    public void insertEmail(String username) {
        setEmailTextBox().sendKeys(username);
    }

    @Step
    public void insertPassword(String password) {
        setPasswordTextBox().sendKeys(password);
    }

    @Step
    public void clickLoginButton() {
        setLoginButton().click();
    }

    public WebElement displayAlertMessage(){

       return  driver.findElement(alertMessage);

    }




}
