package eCommerceLive;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.apache.tools.ant.util.FileUtils; // Importing FileUtils for file operations

import java.io.File;
import java.util.concurrent.TimeUnit;

public class testcase01 {
    private WebDriver driver;
    private String baseUrl;
    public int scc = 0;

    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    @BeforeTest
    public void setUp() throws Exception {
       // System.setProperty("webdriver.gecko.driver", "C:\\Users\\ahmed\\IdeaProjects\\Guru99_Tasks\\src\\main\\resources\\geckodriver.exe"); // Ensure the path to geckodriver is correct
        driver = new FirefoxDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testDay1TestCase1() throws Exception {
        driver.get(baseUrl);

        // Step 2. Verify Title of the page
        String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
        System.out.println(demoSite);
        try {
            Assert.assertEquals(demoSite, "THIS IS DEMO SITE FOR   ");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        // Step 3. Click on "MOBILE" menu
        driver.findElement(By.linkText("MOBILE")).click();

        // Step 4. Verify Title of the page
        String mobilePageTitle = driver.getTitle();
        try {
            Assert.assertEquals(mobilePageTitle, "Mobile");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

        // Step 5. In the list of all mobile, select "SORT BY" dropdown as "name"
        new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

        // Step 6. Verify all products are sorted by name
        // Taking a screenshot
        scc = (scc + 1);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String png = ("H:\\Testing\\Guru99\\screenshots\\" + scc + ".png");
      //  FileUtils.copyFile(scrFile, new File(png));
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
        if (!"".equals(verificationErrors.toString())) {
            throw new Exception(verificationErrors.toString());
        }
    }
}

