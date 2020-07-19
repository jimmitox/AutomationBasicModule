package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
public class headerPage extends BasePage {

    private By myAccountLink = By.linkText("My Account");
    private By loginLink = By.linkText("Login");
    private By registerLink = By.linkText("Register");
    private By searchBar = By.xpath("//input[@placeholder='Search']");
    //*[@id="search"]/input
    private By searchBarButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By shoppingCartLink = By.linkText("Shopping Cart");
    private By checkoutLink = By.linkText("Checkout");
    private By cartInfo =  By.xpath("  //a[contains(text(),'shopping cart')]");
    private By currencyDropdown = By.xpath("//span[contains(text(),'Currency')]");
    private By eurCurrencyButton = By.xpath("//button[@name='EUR']");
    private By poundCurrencyButton = By.xpath("//button[@name='GBP']");
    private By usdCurrencyButton = By.xpath("//button[@name='USD']");




    public headerPage(WebDriver driver){
        super(driver);
    }
    public void clickMyAccountLink(){
        driver.findElement(this.myAccountLink).click();
    }
    public void clickLoginLink(){
        driver.findElement(this.loginLink).click();
    }
    public void clickSearchBar(){
        driver.findElement(this.searchBar).click();
    }
    public void clickSearchBarButton(){
        driver.findElement(this.searchBarButton).click();
    }
    public void clickShoppingCartButton(){
        driver.findElement(this.cartInfo).click();
    }
    public void clickCheckoutButton(){
        driver.findElement(this.checkoutLink).click();
    }
    public void clickCurrencyDropdown(){
        driver.findElement(this.currencyDropdown).click();
    }
    public void clickEurButton(){
        driver.findElement(this.eurCurrencyButton).click();
    }
    public void clickPoundButton(){
        driver.findElement(this.poundCurrencyButton).click();
    }
    public void clickUsdButton(){
        driver.findElement(this.usdCurrencyButton).click();
    }


    //Method to do click on Register

    public void clickRegisterLink(){
        driver.findElement(this.registerLink).click();
    }
    //Action going to Login Page
    public void goToLogin(){
        this.clickMyAccountLink();
        this.clickLoginLink();
    }

    //Action going to Register Page
    public void goToRegister(){
        this.clickMyAccountLink();
        this.clickRegisterLink();
    }

    //Action to navigate to search bar
    public void goToSearchBar(){
        this.clickSearchBar();
    }
    //Action to click the search button
    public void goToSearchButton(){
        this.clickSearchBarButton();
    }
    //Action to Click the search button
    public void goToShoppingCart(){
        this.clickShoppingCartButton();
    }
    //Action to Click the checkout button
    public void goToCheckout(){
        this.clickCheckoutButton();
    }

    //Action Select Currency button
    public void selectCurrencyDropdown(){
        this.clickCurrencyDropdown();
    }
    //Actions to select different currencies
    public void selectEurCurrency(){
        this.clickEurButton();
    }
    public void selectUsdCurrency(){
        this.clickUsdButton();
    }
    public void selectPoundCurrency(){
        this.clickPoundButton();
    }



}
