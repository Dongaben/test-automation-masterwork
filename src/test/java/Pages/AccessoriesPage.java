package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage extends BasePage{

  public AccessoriesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(partialLinkText = "Studio Design")
  WebElement studioDesignLink;

  public WebElement getStudioDesignLink() {
    return studioDesignLink;
  }

  public boolean isLoaded() {
    return driver.getTitle().equals("Accessories") &&
        driver.getCurrentUrl().equals("http://test-automation-shop1.greenfox.academy/6-accessories");
  }

  public int numberOfProduct() {
    int result = 0;
    List<WebElement> products = driver
        .findElements(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div"));
    result = products.size();
    return result;
  }

}
