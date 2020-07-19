package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class registerPage extends BasePage{

    //Private Variables the ones to interact with

    private By firstNameTextBox = By.id("input-firstname");
    private By lastNameTextBox = By.id("input-lastname");
    private By emailTextBox =  By.id("input-email");
    private By telephoneTextBox = By.id("input-telephone");
    private By passwordTextBox = By.id("input-password");
    private By passConfirmTextBox = By.id("input-confirm");
    private By privacyPolicyCheckBox = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@type='submit']");
    private By messageAccountCreated = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    //Constructor
    public registerPage(String url, WebDriver driver)
    {
        super(url, driver);

    }

    public void gotoRegisterPage(){
        loadPage();
    }

    //Creating public methods to return the By variables

    public WebElement setFirstNameTextBox(){
        return driver.findElement(this.firstNameTextBox);
   }
    public WebElement setLastNameTextBox(){
        return driver.findElement(this.lastNameTextBox);
   }
    public WebElement setEmailTextBox(){
        return driver.findElement(this.emailTextBox);
    }
    public WebElement setTelephoneTextBox(){
        return driver.findElement(this.telephoneTextBox);
   }
    public WebElement setPasswordTextBox(){
        return driver.findElement(this.passwordTextBox);
    }
    public WebElement setPassConfirmTextBox(){
        return driver.findElement(this.passConfirmTextBox);
    }
    public WebElement selectPrivacyPolicyCheckBox(){
        return driver.findElement(this.privacyPolicyCheckBox);
    }
    public WebElement setContinueButton(){
        return driver.findElement(this.continueButton);
    }


    //Function to create random email
    public String  randomNewEmail(String pUsername){
        Random randomGenerator = new Random();
        int randomint = randomGenerator.nextInt(1000);
        String randomEmail = (pUsername + randomint +"@" + "testemail.com");
        System.out.println(randomEmail);
        return randomEmail;
    }

    //In this section we use our public web elements to do the actions we need to do

    @Step
    public void insertFirstName(String name){
        setFirstNameTextBox().sendKeys(name);
    }

    @Step
    public void insertLastName(String lastName){
        setLastNameTextBox().sendKeys(lastName);
    }

    @Step
    public void insertEmail(String username){
        setEmailTextBox().sendKeys(randomNewEmail(username));
       // setEmailTextBox().sendKeys(username);

    }

    @Step
    public void insertTelephone(String telephone){
        setTelephoneTextBox().sendKeys(telephone);
    }
    @Step
    public void insertPass(String password){
        setPasswordTextBox().sendKeys(password);
    }
    @Step
    public void insertConfirmPass(String confirmPass){
        setPassConfirmTextBox().sendKeys(confirmPass);
    }
    @Step
    public void clickPrivacyPolicyCheckBox() {
        selectPrivacyPolicyCheckBox().click();
    }
    @Step
    public void clickContinueButton() {
        setContinueButton().click();
    }

    //Element we use to validate you are now registered
    public WebElement displayRegistrationMessage(){
        return  driver.findElement(messageAccountCreated);
    }

}
