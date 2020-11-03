package Steps;

import Base.Browser;
import Base.Config;
import Base.LoginElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver = null;
    @Given("I in LP homepages")
    public void iInLPHomepages() throws InterruptedException {
        driver = Browser.Open(Config.Browser);
        Config.delayTime();
    }



    @When("I click signin button")
    public void iClickSigninButton() throws InterruptedException {
        LoginElement.FindSignInMenu(driver).click();
        Config.delayTime();
    }

    @Then("sign in page will appears")
    public void signInPageWillAppears() throws InterruptedException {
        Assert.assertTrue(LoginElement.AssertLinkLoginPage(driver));
        Config.delayTime();
    }

    @And("I input the usernames")
    public void iInputTheUsernames() {
        LoginElement.FindUsernameField(driver).sendKeys(Config.Username);
    }
    @And("I input the admin usernames")
    public void iInputTheAdminUsernames() {
        LoginElement.FindUsernameField(driver).sendKeys(Config.Admin_user);
    }

    @And("Input password")
    public void inputPassword() {
        LoginElement.FindPasswordField(driver).sendKeys(Config.Password);
    }


    @And("Input admin password")
    public void inputAdminPassword() {
        LoginElement.FindPasswordField(driver).sendKeys(Config.Admin_pass);
    }

    @When("I click sign in button")
    public void iClickSignInButton() {
        LoginElement.FindSignInBtn(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("I will success login")
    public void IWillSuccessLogin() throws InterruptedException {
        Assert.assertEquals("You are successfully logged in.", driver.findElement(By.xpath("/div/div/div/div[2]")).getText());
        Config.delayTime();
    }
    }

