package Base;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginElement {
    static WebElement element = null;
    static String username = "";
    public static WebDriver LoginPage(WebDriver driver){
        if(driver == null){
            driver = Browser.Open(Config.Browser);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        FindSignInMenu(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebElement FindSignInMenu(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/header/div[2]/div[2]/div/div[2]/button/span[1]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(element);
        System.out.println("Element menu sign in Found");
        return element;
    }

    public static WebElement FindUsernameField(WebDriver driver){
        //element = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[2]/div/div[2]/form/div[1]/div/input"));
        element = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(element);
        System.out.println("Element email Found");
        return element;
    }

    public static WebElement FindPasswordField(WebDriver driver){
        //element = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div[2]/div/div[2]/form/div[2]/div/input"));
        element = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertNotNull(element);
        System.out.println("Element password Found");
        return element;
    }

    public static WebElement FindSignInBtn(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"submitButton\"]/span"));
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertNotNull(element);
        System.out.println("Element sign in btn Found");
        return element;
    }

    public static boolean AssertLinkLoginPage(WebDriver driver){
        boolean link = driver.getCurrentUrl().contains("sign-in");
        Assert.assertTrue(link);
        System.out.println("Now in login page");
        return link;
    }

    public static boolean UserDashboard(WebDriver driver){
        boolean link = driver.getCurrentUrl().endsWith("/dashboard");
        Assert.assertTrue(link);
        System.out.println(driver.getCurrentUrl());
        return link;
    }

    public static WebDriver Main(WebDriver driver, String Role){
        if (Role.equals("user")){
            driver = LoginPage(driver);
            FindUsernameField(driver).sendKeys(Config.Username);
            FindPasswordField(driver).sendKeys(Config.Password);
            FindSignInBtn(driver).click();
        }else if (Role.equals("admin")){
            driver = LoginPage(driver);
            FindUsernameField(driver).sendKeys(Config.Admin_user);
            FindPasswordField(driver).sendKeys(Config.Admin_pass);
            FindSignInBtn(driver).click();
        }
        return driver;
    }

    public static WebElement Messagge(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@data-testid='error-response']"));
        Assert.assertNotNull(element);
        return element;
    }

    public static void MessaggeEmptyField(WebDriver driver){
        List<WebElement> webElements = driver.findElements(By.xpath("//p[@data-testid='error-message']"));
        Assert.assertNotNull(webElements);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    public static String GetUserName(WebDriver driver){
        try {
            element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/h4[text()='" + Config.Username + "']"));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertNotNull(element);
            username = element.getText();
            return username;
        }catch (Exception e){
            username = "null";
            return username;
        }
    }
}
