//Need package here
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.asserts.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.loginPage;
import pageobject.dashboardPage;
//import package
import dataproviders.usersProvider;
import pojo.loginData;
import pageobject.headerPage;
import pojo.productData;
import pageobject.registerPage;
import pojo.registerData;
import dataproviders.productsProvider;
import pageobject.productPage;

//All parameters and before and after test come from basetest
public class loginTest extends baseTest {

    //We specify to run the groups we want, which are set on testng.xml
    @Test(groups = {"sucessTests"} ,dataProvider = "getUserDataFromJson", dataProviderClass = usersProvider.class)

    public void allow_user_to_do_login(loginData _loginData)  throws InterruptedException {

        loginPage login = new loginPage(baseURL, driver);
        headerPage header = new headerPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);
        header.goToLogin();
        login.insertEmail(_loginData.getEmail());
        login.insertPassword(_loginData.getPassword());
        login.clickLoginButton();
        //Waits until dashboard element exists
        login.waitUntilElementExists(dashboardPage.showDashboard());

        //WebElement dashboard = driver.findElement(By.id("account-account"));
        Assert.assertEquals(dashboardPage.showDashboard().isDisplayed(), true);

    }

    @Test(groups = {"sucessTests"} ,dataProvider = "getWrongUsersDataFromJson", dataProviderClass = usersProvider.class)
    public void fail_user_login(loginData _loginData) {

        loginPage login = new loginPage(baseURL,driver);
        headerPage header = new headerPage(driver);
        header.goToLogin();
        login.insertEmail(_loginData.getEmail());
        login.insertPassword(_loginData.getPassword());
        login.clickLoginButton();


        //Explicit wait
        login.waitUntilElementExists(login.displayAlertMessage());

        Assert.assertEquals(login.displayAlertMessage().isDisplayed(),true);

    }
    @Test (groups = "sucessTest" , dataProvider = "getRegistrationUserDataFromJson",dataProviderClass = usersProvider.class)
    public void allow_user_to_register(registerData _registerData){

        registerPage register = new registerPage(baseURL,driver);
        headerPage header = new headerPage(driver);

        header.goToRegister();
        register.insertFirstName(_registerData.getFirstName());
        register.insertLastName(_registerData.getLastName());
        //Pasar parametro email
        register.insertEmail("userTest");
        register.insertTelephone(_registerData.getTelephone());
        register.insertPass(_registerData.getPassword());
        register.insertConfirmPass(_registerData.getConfirmPass());
        register.clickPrivacyPolicyCheckBox();
        register.clickContinueButton();

        //Waits until  registration page element exists

        register.waitUntilElementExists(register.displayRegistrationMessage());

        //Assert to validate the element is there displayed
        Assert.assertEquals(register.displayRegistrationMessage().isDisplayed(),true);


    }

    @Test (groups = "successTest", dataProvider = "getProductDataFromJson", dataProviderClass = productsProvider.class)

    public void allow_user_to_add_product_to_cart(productData _productData) throws InterruptedException {

       productPage product = new productPage(baseURL,driver);
       headerPage header = new headerPage(driver);
       header.goToSearchBar();
       product.implicitWaitTime();
      // Thread.sleep(3000);
       product.insertProductName(_productData.getProduct());
       header.goToSearchButton();
       product.waitUntilElementExists(product.displaySearchedProduct());
       product.clickMacbookLink();
        product.clickAddItemToCartButton();
        product.implicitWaitTime();
//        Thread.sleep(3000);
        //Validates the message of success added item to cart
        Assert.assertEquals(product.displaySuccessAddedCartMessage().isDisplayed(),true);
    }

    @Test (groups = "successTest", dataProvider = "getProductDataFromJson", dataProviderClass = productsProvider.class)

    public void verify_user_cannot_add_product_to_cart(productData _productData) throws InterruptedException {

        productPage product = new productPage(baseURL,driver);
        headerPage header = new headerPage(driver);
        header.goToSearchBar();
        product.implicitWaitTime();
//        Thread.sleep(3000);
        product.insertProductName(_productData.getProduct());
        header.goToSearchButton();
        product.waitUntilElementExists(product.displaySearchedProduct());
        product.clickMacbookLink();
        product.clickAddItemToCartButton();
        product.implicitWaitTime();
//        Thread.sleep(3000);
        header.goToShoppingCart();
        //Waits until that element for shopping cart is displayed
        product.waitUntilElementExists(product.displayShoppingCartScreen());
        product.clickCheckoutBtn();
        product.implicitWaitTime();

//        Thread.sleep(3000);
        //Validates the message of alert error is displayed
        Assert.assertEquals(product.displayNotInStockMessage().isDisplayed(),true);
    }

    @Test (groups = "successTest", dataProvider = "getProductDataFromJson", dataProviderClass = productsProvider.class)

    public void verify_product_price_onUSD(productData _productData) throws InterruptedException {

        productPage product = new productPage(baseURL,driver);
        headerPage header = new headerPage(driver);

        header.goToSearchBar();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.insertProductName(_productData.getProduct());
        Thread.sleep(3000); //product.implicitWaitTime();
        //System.out.println(_productData.getProduct());
        //System.out.println(_productData.getUSDCurrency());
        //El q viene del pojo
        System.out.println(_productData.getAmountDollar());
        header.goToSearchButton();
        product.waitUntilElementExists(product.displaySearchedProduct());
        product.clickMacbookLink();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickCurrencyDropdown();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickUsdButton();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.waitUntilElementExists(product.displayDollarAmount());
        //El q tengo en dollarAmount
        System.out.print(product.displayDollarAmount().getText().substring(1));
        Thread.sleep(3000); //product.implicitWaitTime();
        //Validates the currency displayed matches the one in the json file message of success added item to cart
        Assert.assertEquals(_productData.getAmountDollar(), product.displayDollarAmount().getText().substring(1));
    }

    @Test (groups = "successTest", dataProvider = "getProductDataEURFromJson", dataProviderClass = productsProvider.class)

    public void verify_product_price_onEUR(productData _productData) throws InterruptedException {

        productPage product = new productPage(baseURL,driver);
        headerPage header = new headerPage(driver);

        header.goToSearchBar();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.insertProductName(_productData.getProduct());
        Thread.sleep(3000); //product.implicitWaitTime();
        //El q viene del pojo
        System.out.println(_productData.getAmountEuro());
        header.goToSearchButton();
        product.waitUntilElementExists(product.displaySearchedProduct());
        product.clickMacbookLink();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickCurrencyDropdown();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickEurButton();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.waitUntilElementExists(product.displayEurAmount());
        //El q tengo en EurAmount
        System.out.println(product.removeLastChar(product.displayEurAmount().getText()));
        Thread.sleep(3000); //product.implicitWaitTime();
        //Validates the currency displayed matches the one in the json file message of success added item to cart
        Assert.assertEquals(_productData.getAmountEuro(), product.removeLastChar(product.displayEurAmount().getText()));

    }

    @Test (groups = "successTest", dataProvider = "getProductDataGBPFromJson", dataProviderClass = productsProvider.class)

    public void verify_product_price_onGBP(productData _productData) throws InterruptedException {

        productPage product = new productPage(baseURL,driver);
        headerPage header = new headerPage(driver);

        header.goToSearchBar();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.insertProductName(_productData.getProduct());
        Thread.sleep(3000); //product.implicitWaitTime();
        //El q viene del pojo
        System.out.println(_productData.getAmountPound());
        header.goToSearchButton();
        product.waitUntilElementExists(product.displaySearchedProduct());
        product.clickMacbookLink();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickCurrencyDropdown();
        Thread.sleep(3000); //product.implicitWaitTime();
        header.clickPoundButton();
        Thread.sleep(3000); //product.implicitWaitTime();
        product.waitUntilElementExists(product.displayPoundAmount());
        //El q tengo en PountAmount
        System.out.print(product.displayPoundAmount().getText().substring(1));
        Thread.sleep(3000); //product.implicitWaitTime();
        //Validates the currency displayed matches the one in the json file message of success added item to cart
        Assert.assertEquals(_productData.getAmountPound(), product.displayPoundAmount().getText().substring(1));
    }





    /*
    @Test(groups = {"otherTests"})

    public void allow_user_to_logout()  {
        //Arrange
       WebElement emailTextBox = driver.findElement(By.id("input-email"));
        WebElement passwordTextBox = driver.findElement(By.id("input-password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        //Act
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement logOutButton = driver.findElement(By.xpath("//li[@class='dropdown open']//li[5]"));


        logOutButton.click();
        WebElement logoutMessage = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]"));



        //Assert

        Assert.assertEquals(logoutMessage,true);


    } */


}
