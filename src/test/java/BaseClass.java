import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;

public class BaseClass {
    WebDriver driver = null;

    @BeforeTest
    public void openHomePage (){

      //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\MavenFWD\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize the class-level driver
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        //implest wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    public void Register ()
    {   // navigate to Registration Page
        driver.findElement(By.linkText("Register")).click();

        // verify the URL
        String  expectedURL = "https://demo.nopcommerce.com/register?returnUrl=%2F" ;
        String  actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"URL does not match");

        // verify the Page Title
        String expectedTitle = "nopCommerce demo store. Register" ;
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title does not match");

        // verify the presence of the Registration button
        WebElement RegisterButt = driver.findElement(By.id("register-button"));
        Assert.assertTrue(RegisterButt.isDisplayed(),"Register button is not displayed ");

        // verify the presence of first name field
        WebElement firstName = driver.findElement(By.id("FirstName"));
        Assert.assertTrue(firstName.isDisplayed(),"First name Field is not displayed");
       // Assert.assertTrue(driver.findEl ement(By.partialLinkText("Your")).isDisplayed());

    }

    @AfterTest
    public void teardown (){ driver.quit();  }
}
