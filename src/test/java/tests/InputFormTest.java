package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputFormTest extends BaseTest {

    @Test
    public void validateFormSubmission() {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Input Form Submit")).click();

        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        String msg = driver.findElement(By.cssSelector("input[placeholder='Name']")).getAttribute("validationMessage");
        Assert.assertTrue(msg.contains("Please fill"));

        driver.findElement(By.name("name")).sendKeys("Brijesh Mishra");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("inputEmail4")));
        driver.findElement(By.id("inputEmail4")).sendKeys("brijesh@test.com");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.name("company")).sendKeys("ABC Corp");
        driver.findElement(By.name("website")).sendKeys("https://test.com");

        driver.findElement(By.name("country")).sendKeys("United States");

        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.id("inputAddress1")).sendKeys("Address1");
        driver.findElement(By.id("inputAddress2")).sendKeys("Address2");
        driver.findElement(By.cssSelector("#inputState")).sendKeys("NY");
        driver.findElement(By.id("inputZip")).sendKeys("10001");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        String success = driver.findElement(By.xpath("//p[contains(@class,'success-msg')]")).getText();
        Assert.assertEquals(success, "Thanks for contacting us, we will get back to you shortly.");
    }
}
