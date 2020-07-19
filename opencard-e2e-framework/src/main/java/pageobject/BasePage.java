package pageobject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    //Constructor

    public String pageURL;
    public WebDriver driver;

    public BasePage(String _pageURL, WebDriver _driver){
        this.pageURL= _pageURL;
        this.driver= _driver;

    }

    //Constructor tipo BasePage only one parameter
    public BasePage(WebDriver _driver){
        this.driver = _driver;
    }

    public void loadPage() {
        driver.navigate().to(pageURL);

    }

    //Method for wait until finds element 20 seg
    public void waitUntilElementExists(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Method for explicit wait of 10 seconds

    public void implicitWaitTime(){
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);

    }

    //Do a timeout or wait up to 30 seconds will check element every 5 seconds max
    public void fluentWaitTime(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }







}
