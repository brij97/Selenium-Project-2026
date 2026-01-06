
package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test
    public void moveSliderTo95() {
        driver.get("https://www.lambdatest.com/selenium-playground");
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
        WebElement slider = driver.findElement(By.xpath("//h4[text()=' Default value 15']/following::input[1]"));
        new Actions(driver).dragAndDropBy(slider, 215, 0).perform();
        Assert.assertEquals(driver.findElement(By.id("rangeSuccess")).getText(), "95");
    }
}
