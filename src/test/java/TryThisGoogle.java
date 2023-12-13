import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TryThisGoogle {

        @Test
        public void test() {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.google.com");
            System.out.println(driver.getTitle());
        }
    }

