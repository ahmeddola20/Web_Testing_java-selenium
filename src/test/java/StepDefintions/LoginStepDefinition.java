package StepDefintions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
@Given("user open browser")
    public void user_open_brwoser()
    {
// but your code here as in the openBrowsre class
    }
    @And("user navigate to login page")
    public void  user_navigate_to_login_page(){
    
    
    }

//    When user enters valid username and password
@When("user enters valid username and password")
public void  user_enters_valid_username_and_password(){


}
//    And usre click on login button
 @And("And usre click on login button")
 public void usre_click_on_login_button()
 {
     

 }   

//    Then user could login succesfully and go to home page
    @Then("user could login succesfully and go to home page")
    public void user_could_login_succesfully_and_go_to_home_page()
    {

    }
//    And user go to home page
@And("user go to home page")
    public void user_go_to_home_page(){

}
}

