import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowser {
    WebDriver driver = null;
    LoginPage login ;         //   here we declare the login class all over the class to use it in every test methods

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {

        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\MavenFWD\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize the class-level driver
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    @Test
    public void validData() throws InterruptedException {

        driver.navigate().to("https://the-internet.herokuapp.com/login"); // Add navigation to the URL

        login = new LoginPage(driver);
        login.usernamePOM().clear();       // we send our current working driver to loginpage class to use it
        login.usernamePOM().sendKeys("tomsmith");

       login.passwordPOM().sendKeys("SuperSecretPassword!");
       login.passwordPOM().sendKeys(Keys.ENTER); // Act as we hit the submit button
//        Thread.sleep(1000);

    // Hard Assertion
        // first asserstion
        System.out.println(" 1ST assertion ");
        String expectedResult = "You logged into a secure area!";           // the string with no spaces to success
        String actualResult = driver.findElement(login.flashPOM()).getText().trim(); // using trim to avoid leading or trailing spaces or newlines
        Assert.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
// SEcnd asserstion
        System.out.println(" 2nd assertion ");
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed());
// therd asserstion
        System.out.println(" 3rd assertion ");
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");

    }

    //@Test
    public void invalidData() {
        driver.navigate().to("https://the-internet.herokuapp.com/login"); // Add navigation to the URL
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecret");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER); // Act as we hit the submit button

       // String expectedResult = "You logged into a secure area! ";           // the string with no spaces to success
      //  String actualResult = driver.findElement(By.id("flash")).getText();
      //  Assert.assertTrue(actualResult.contains(expectedResult));
    }

   // @AfterTest
    public void CloseDriver() {
        driver.quit();
    }
}
