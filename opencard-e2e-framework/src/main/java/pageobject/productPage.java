package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class productPage extends BasePage {
    //Private Variables the ones to interact with


   // private By macbookItem = By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//div[1]//h4[1]//a[1]");
    private By searched_product = By.xpath("//h1[contains(text(),'Search - macbook')]");
    private By macbookLink = By.linkText("MacBook");
    private By addToCartButton = By.xpath("//button[@id='button-cart']");
    //div[@id='content']//div[1]//div[1]//div[2]//div[2]//button[1]//span[1]
    private By successAddedMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By notInStockAlertMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By searchField = By.xpath("//input[@placeholder='Search']");
    private By checkoutButton = By.xpath("//a[@class='btn btn-primary']");
    private By shoppingCartscreen = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    private By dollarAmount = By.xpath("//h2[contains(text(),'$602.00')]");
    private By eurAmount = By.xpath("//h2[contains(text(),'518.16')]");
    private By poundAmount = By.xpath("//h2[contains(text(),'£454.10')]");
   // public String dollarString = driver.findElement(By.xpath("//h2[contains(text(),'$602.00')]")).getText();


    //Constructor

    public productPage(String url, WebDriver driver)
    {
        super(url, driver);

    }



    public void gotoProductPage(){
        loadPage();
    }


    //Creating public methods to return the By variables

   public WebElement setSearchProductName(){
        return driver.findElement(this.searchField);
   }
   public WebElement setCartButton(){
        return driver.findElement(this.addToCartButton);
   }
   public WebElement setMacbookLink(){
        return driver.findElement(this.macbookLink);
   }
   public WebElement setCheckoutBtn(){
        return driver.findElement(this.checkoutButton);
   }



    public  String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }


  /*  //Method to get a cleaner version of dollar currency amount
        public String setDollarString(){
        String str=  dollarString;
        String strTrimmed = str.substring(21);
        return strTrimmed;

    }*/

  /*  public String dollarconverted(){
        List<WebElement> links =driver.findElements(By.xpath("//h2[contains(text(),'$602.00')]"));

        String []linkText =new String[links.size()];
        int i=0;

        //Now store List elements (one or more) text into String array

        for(WebElement a: links)
        {
            linkText[i]=a.getText();
            i++;
        }
        return linkText[i];
    } */


    //In this section we use our public web elements to do the actions we need to do

    @Step
    public void insertProductName(String productName){
        setSearchProductName().sendKeys(productName);
    }
    @Step
    public void clickAddItemToCartButton() {
        setCartButton().click();
    }
    @Step
    public void clickMacbookLink(){
        setMacbookLink().click();
    }
    @Step
    public void clickCheckoutBtn(){
        setCheckoutBtn().click();
    }

    //Element we use to validate the item was found and displayed in current page

    public WebElement displaySearchedProduct(){
        return  driver.findElement(searched_product);
    }


    //Element we use to validate we added a new item to cart
    public WebElement displaySuccessAddedCartMessage(){
        return  driver.findElement(successAddedMessage);
    }

    //Element we use to validate we added an item outstock to cart so process can't be completed
    public WebElement displayNotInStockMessage(){
        return  driver.findElement(notInStockAlertMessage);
    }

    public WebElement displayShoppingCartScreen(){
        return driver.findElement(shoppingCartscreen);
    }

    //Currency and amount steps

    public WebElement displayDollarAmount(){
        return driver.findElement(this.dollarAmount);
    }
    public WebElement displayEurAmount(){
        return driver.findElement(this.eurAmount);
    }
    public WebElement displayPoundAmount(){
        return driver.findElement(this.poundAmount);
    }

}
