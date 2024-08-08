import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
// note we should declare and use only on driver and pass it to the class
// note we should declare and use only on driver and pass it to the class
    // using oop constractor help us to code reusablity
WebDriver driver ;
    public LoginPage (WebDriver driver) {
        this.driver = driver ;
    }
    public WebElement usernamePOM (){
        By username = By.id("username");
        WebElement usernameEL  =  driver.findElement(username);
        return usernameEL ;

    }
    public WebElement passwordPOM (){
        By password = By.name("password");
        WebElement passwordEL  =  driver.findElement(password);
        return passwordEL ;

    }
    public By flashPOM (){

        return By.id("flash");

    }
}
