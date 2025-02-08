import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_Scenario_1 extends BaseTest{


    @Test
    public void simpleformdemo() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement simpleform = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Simple Form Demo")));
        simpleform.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("simple-form-demo"));
        String message = "Welcome to LambdaTest";
        WebElement messagebox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-message")));
        messagebox.sendKeys(message);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @id='showInput']")));
        button.click();
        WebElement displayedmessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(displayedmessage.getText(),message);
    }


}
