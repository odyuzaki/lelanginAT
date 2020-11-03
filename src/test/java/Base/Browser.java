package Base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Browser {
    static WebDriver driver = null;

    public static WebDriver Open(String browser){
        if ("Chrome".equals(browser)) {
            Chrome();
        } else if ("FireFox".equals(browser)) {
            Mozilla();
        }
        return driver;
    }

    private static void Chrome(){
        ChromeDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File("src/test/java/Extension/gps.crx"));
//        options.setCapability(ChromeOptions.CAPABILITY,options);
        options.addArguments("enable-strict-powerful-feature-restrictions");
        options.addArguments("disable-geolocation");
        driver = new ChromeDriver(options);
        Option(driver);
        driver.get(Config.URL);
    }

    private static void Mozilla(){
        //FirefoxDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "src/test/java/driver/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette",true);
        options.addPreference("geo.prompt.testing", true);
        options.addPreference("geo.prompt.testing.allow", true);
        driver = new FirefoxDriver(options);
        //Option(driver);
        driver.get(Config.URL);
    }

    // Configure browser
    private static void Option(WebDriver driver){
        driver.manage().window().maximize();
    }
}
