package docker;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {
    static RemoteWebDriver driver;

    @BeforeClass
    public static void setup() throws Exception {
        System.out.print("Running Test in Docker Container <<Chrome>>");

        ChromeOptions cap = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void startWebDriver() {
        driver.navigate().to("http://test1:80");
        Assert.assertTrue("title should start with Docker Demo Page",
                driver.getTitle().startsWith("Docker Demo Page"));

        driver.close();
        driver.quit();

    }
}