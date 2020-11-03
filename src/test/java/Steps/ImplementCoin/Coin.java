package Steps.ImplementCoin;

import Base.Config;
import Base.LoginElement;
import Base.myCoinElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import java.util.concurrent.TimeUnit;

public class Coin {
    WebDriver driver = null;
    @Given("User at homepage")
    public void UserAtHomepage() {
        driver = LoginElement.Main(driver, Config.Role_Admin);
    }


    @And("user hover on the my coins menu")
    public void userHoverOnTheMyCoinsMenu() {
        myCoinElement.MyCoin_Btn(driver);

    }

    @And("user login")
    public void userLogin() throws InterruptedException {
        LoginElement.FindSignInMenu(driver).click();
        Config.delayTime();
        Assert.assertTrue(LoginElement.AssertLinkLoginPage(driver));
        Config.delayTime();
        LoginElement.FindUsernameField(driver).sendKeys(Config.Admin_user);
        LoginElement.FindPasswordField(driver).sendKeys(Config.Admin_pass);
        LoginElement.FindSignInBtn(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals("You are successfully logged in.", driver.findElement(By.xpath("/div/div/div/div[2]")).getText());
        Config.delayTime();

    }

    @When("the user clicks on the coin details button")
    public void theUserClicksOnTheCoinDetailsButton() {
        myCoinElement.CoinDetails_Btn(driver);
    }

    @Then("the user should be navigated to the coin page")
    public void theUserShouldBeNavigatedToTheCoinPage() throws InterruptedException {
        Assert.assertEquals("My Coins Detail", driver.findElement(By.xpath("\n" +
                "//*[@id=\"root\"]/div/section/main/div[2]/div/div/div[1]/span")).getText());
        Config.delayTime();
    }

    @Then("the user should see the amount of users coins")
    public void theUserShouldSeeTheAmountOfUsersCoins() {
        if(driver.findElements(By.xpath("//*[@id=\"total-coins-amount\"]")).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }
    }
}
