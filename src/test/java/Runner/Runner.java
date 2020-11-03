package Runner;

import Base.BrowserType;
import Base.Config;
import Base.Features;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.RunWith;
import org.testng.annotations.*;
import com.trivago.cluecumber.rendering.ReportGenerator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = {"src/test/resource"},glue = "steps" )
// public class Runner{
//
//}


@CucumberOptions(features = {"src/test/java/resource/ImplementCoin"},
        plugin = {"json:target/cucumber.json"},
        glue = {Config.Feature})
public class Runner extends AbstractTestNGCucumberTests {
}
//    @BeforeTest
//    @Parameters("browser")
//    public void multiple(@Optional String browser) throws Exception{
//        if (browser == null){
//            System.out.println("Run selected browser");
//        }
//        else if(browser.equalsIgnoreCase("firefox")){
//            //create firefox instance
//            Config.Browser = BrowserType.FireFox;
//        }
//        else if(browser.equalsIgnoreCase("chrome")){
//            //create chrome instance
//            Config.Browser = BrowserType.Chrome;
//        }
//    }
//
//    @AfterTest
//    @Parameters("browser")
//    public void generateDemoReport(@Optional String browser) throws IOException{
//        if (browser == null){
//            Report("Selected");
//        }
//        else if(browser.equalsIgnoreCase("firefox")){
//            //create firefox report
//            Report(Config.Browser);
//        }
//        else if(browser.equalsIgnoreCase("chrome")){
//            //create chrome report
//            Report(Config.Browser);
//        }
//    }

//    public void Report(String browser){
//        File reportOutputDirectory = new File("target/report"+browser);
//        List<String> jsonFiles = new ArrayList<>();
//        jsonFiles.add("target/cucumber.json");
//
//        String buildNumber = "1";
//        String projectName = "PBH Project";
//        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
//        configuration.setBuildNumber(buildNumber);
//
//        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//        reportBuilder.generateReports();
//
//    }

//    public void extentReport() throws IOException{
//        ExtentAventReporter aventReporter = new ExtentAventReporter("target/cucumber-report/report.html");
//        JsonFormatter jsonFormatter = new JsonFormatter("target/cucumber.json");
//        ExtentReports reports = new ExtentReports();
//        reports.attachReporter(jsonFormatter,aventReporter);
//        reports.flush();
//    }


