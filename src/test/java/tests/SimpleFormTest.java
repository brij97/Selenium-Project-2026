
package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFormTest extends BaseTest {

    @Test
    public void simpleFormDemo() {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Simple Form Demo")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));
        String message = "Welcome to LambdaTest";
        driver.findElement(By.id("user-message")).sendKeys(message);
        driver.findElement(By.id("showInput")).click();
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), message);
    }
}
