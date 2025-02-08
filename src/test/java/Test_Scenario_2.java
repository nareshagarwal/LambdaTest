import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_Scenario_2 extends BaseTest{

    @Test
    public void testdragdropslliders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement draganddropslider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Drag & Drop Sliders")));
        draganddropslider.click();
        WebElement slider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='15']")));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider,215,0).perform();
        WebElement slidervalue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rangeSuccess")));
        Assert.assertEquals(slidervalue.getText(),"95");
    }
}
