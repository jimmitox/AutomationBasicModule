package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dashboardPage extends BasePage {

    //Variables By

    private By dashboard = By.id("account-account");
    //Constructor
    public dashboardPage(WebDriver driver){
        super(driver);
    }

    public WebElement  showDashboard() {
        return driver.findElement(this.dashboard);
    }

}
