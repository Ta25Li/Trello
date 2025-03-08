package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AppManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    @BeforeMethod
    public void setup(Method method){

            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("intl.accept_languages", "en,en_US");
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--lang-eng");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            logger.info("Start testing ---> " + method.getName());
        }





    @AfterMethod
    public void tearDown(Method method){
        logger.info("Stop testing ---> " + method.getName());
      //   if (driver != null)
      //   driver.quit();
    }

}
