package StepDefinitions;

import Utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static StepDefinitions.PageInitializer.login;
import static Utils.CommonMethods.*;

public class Task_20 {

    @Given("“Admin” user is logged in")
    public void admin_user_is_logged_in() {
        sendText(login.usernameTextBox, ConfigReader.getPropertyValue("username"));

        sendText(login.passwordTextBox,ConfigReader.getPropertyValue("password"));

        doClick(login.loginBtn);
    }
    @When("“Admin” navigates to Qualifications")
    public void admin_navigates_to_qualifications() {
      WebElement adminBtn = driver.findElement(By.id("menu_admin_viewAdminModule"));
      doClick(adminBtn);
      WebElement qualificationsBtn = driver.findElement(By.id("menu_admin_Qualifications"));
      doClick(qualificationsBtn);

    }
    @When("selects Language")
    public void selects_language() {
        WebElement languagesBtn = driver.findElement(By.id("menu_admin_viewLanguages"));
        doClick(languagesBtn);
    }
    @Then("“Admin” user can add any Language")
    public void admin_user_can_add_any_language() {


      WebElement actualText = driver.findElement(By.xpath("//div[@class='message success fadable']"));
      String actText = actualText.getText();
      String expText = "Successfully Saved";
        Assert.assertEquals(expText,actText);
    }

}
