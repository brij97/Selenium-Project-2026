package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 10");

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", System.getenv("LT_USERNAME"));
        ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
        ltOptions.put("build", "Java-TestNG-Build");
        ltOptions.put("project", "SeleniumRemoteDemo");
        ltOptions.put("name", "Chrome Windows Test");
        ltOptions.put("network", true);
        ltOptions.put("video", true);
        ltOptions.put("console", true);
        ltOptions.put("visual", true);

        caps.setCapability("LT:Options", ltOptions);

        driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), caps);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }
}
