import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
  protected static WebDriver driver = null;
  protected static WebDriverWait wait = null;
  protected static JavascriptExecutor js = null;

  @BeforeEach
  public void setup() throws IOException {
    String browser;

    Properties properties = new Properties();
    InputStream propertiesStream = this.getClass().getResourceAsStream("/test.properties");
    properties.load(propertiesStream);
    browser = properties.getProperty("browser");

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();
    } else  {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }
    wait = new WebDriverWait(driver, 10);
    driver.manage().window().maximize();
    driver.get("http://test-automation-shop1.greenfox.academy/");
  }

  @AfterEach
  public void teardown() {
    driver.quit();
  }
}
