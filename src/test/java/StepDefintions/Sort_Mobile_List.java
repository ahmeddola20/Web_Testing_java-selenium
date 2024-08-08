package StepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Sort_Mobile_List {
    WebDriverWait wait;

@Given("User open Browser")
public void User_open_Browser(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

WebDriver driver ;

    @Given("user navigate to Home page")
    public void user_navigate_to_home_page() {
        driver.navigate().to("http://live.techpanda.org/index.php/");
        WebElement mobileListLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/index.php/mobile-list']")));
        mobileListLink.click();

    }
    @Given("verify the title of the page")
    public void verify_the_title_of_the_page() {
        String actualResult = driver.getTitle();
        String expectedResult = "Home page";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Given("user navigate to Mobile List Page")
    public void user_navigate_to_mobile_list_page_useing_xpath  () {
        driver.findElement(By.xpath("//a[@href='/index.php/mobile-list']")).click();
    }

    @When("user Select sort by List with name")
    public void user_select_sort_by_list() {
 //   driver.findElement(By.xpath("//a[@href='/index.php/mobile-list?sort=list']")).click();
        //using select class to select an option from a dropdown list
        WebElement sortDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[title='Sort By']")));

        WebElement element = driver.findElement(By.xpath("//select[@title='Sort By']"));
        Select dropdownlist = new Select(element);
        dropdownlist.selectByVisibleText("Name");

    }


    @Then("verify all the products are sorted by their names")
    public void verify_all_the_products_are_sorted_by_thier_names() {
        String actualResult = driver.findElement(By.xpath("//h2[@class='product-name']")).getText();
        String expectedResult = "Samsung Galaxy S10";
    Assert.assertTrue(actualResult.contains(expectedResult));
    }
    @Then("quit the browser")
    public void quit_the_browser() {
        driver.quit();
    }
}
