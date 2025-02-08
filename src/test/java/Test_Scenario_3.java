import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Scenario_3 extends BaseTest{
    @Test
    public void testinputformsubmit(){
        try {
            driver.get("https://www.lambdatest.com/selenium-playground");
            driver.findElement(By.linkText("Input Form Submit")).click();
            WebElement submit = driver.findElement(By.xpath("//button[@type='submit' and text()='Submit']"));
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.name("password")).sendKeys("Johndoe10000");
            driver.findElement(By.name("company")).sendKeys("newcompany");
            driver.findElement(By.name("website")).sendKeys("newcompany@company.com");
            driver.findElement(By.name("city")).sendKeys("pensylvania");
            driver.findElement(By.name("address_line1")).sendKeys("new address pensylvania");
            driver.findElement(By.name("address_line2")).sendKeys("new address2");
            driver.findElement(By.id("inputState")).sendKeys("Chicago");
            driver.findElement(By.name("zip")).sendKeys("123456");
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("johndoe@example.com");
            WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
            Select select = new Select(country);
            select.selectByValue("US");
            submit.click();
            WebElement successmessage = driver.findElement(By.cssSelector(".success-msg"));
            Assert.assertTrue(successmessage.getText().contains("Thanks for contacting us"));
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
