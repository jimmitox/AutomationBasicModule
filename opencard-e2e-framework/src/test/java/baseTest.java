import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class baseTest {

    //Global variables to use along the code for this class
    public WebDriver driver;
    public String baseURL= "https://demo.opencart.com/";


    @BeforeTest
    public void setUpGeneral()
    {


    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)

    public void setUpTest(@Optional("chrome")String browser)
    {
        //Validates browser to use and run test
        if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
            driver.get(baseURL);

    }

    @AfterMethod(alwaysRun = true)

    public void tearDown() {
        driver.close();
        try {
            driver.quit();
        }catch (WebDriverException ex)
        {
            System.out.println("Browser session is closed");
        }
    }


}
