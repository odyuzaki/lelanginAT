package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class myCoinElement {
        //put element/action relate healthcare activity in healthcare page here
        static WebElement element = null;
        public static void MyCoin_Btn(WebDriver driver){
            element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/header/div[2]/div[2]/div/div[1]/span/span/ul/li[2]/div/span[2]"));
            Assert.assertNotNull(element);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.click();
        }

        public static void CoinDetails_Btn(WebDriver driver){
            element = driver.findElement(By.xpath("//*[@id=\"item_0$Menu\"]/li/a"));
            Assert.assertNotNull(element);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            element.click();
        }



}
