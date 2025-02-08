import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariOptions;  // Updated import for Safari
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "platform", "browserVersion"})
    public void setup(String browser, String platform, String browserVersion) {
        if (browser.equalsIgnoreCase("Edge")) {
            EdgeOptions options = new EdgeOptions();
            options.setCapability("browserName", "MicrosoftEdge");
            options.setCapability("platformName", platform);
            options.setCapability("browserVersion", browserVersion);
            try {

                URL url = new URL("https://tusharamar1:1cyIbO4Azr3N3xagKC8uHXHhESBfTlcIW26kjoTrVH5ChdQ1lf@hub.lambdatest.com/wd/hub");

                driver = new RemoteWebDriver(url, options);
                //throw new SkipException("skipped");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else if (browser.equalsIgnoreCase("Safari")) {  // Updated for Safari
            SafariOptions options = new SafariOptions();
            options.setCapability("browserName", "safari");
            options.setCapability("platformName", platform);  // Ensure platform is macOS
            options.setCapability("browserVersion", browserVersion);

            try {
                URL url = new URL("https://tusharamar1:1cyIbO4Azr3N3xagKC8uHXHhESBfTlcIW26kjoTrVH5ChdQ1lf@hub.lambdatest.com/wd/hub");
                driver = new RemoteWebDriver(url, options);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
