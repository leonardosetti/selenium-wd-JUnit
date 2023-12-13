import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleTest {

    @Test
    public void testFirefox() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Assertions.assertEquals("Google", driver.getTitle());
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testGoogleChrome() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Assertions.assertEquals("Google", driver.getTitle());
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void testBrave() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/brave");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        Assertions.assertEquals("Google", driver.getTitle());
        driver.close();
        driver.quit();
    }
}
