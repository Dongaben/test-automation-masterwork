package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProduct2Page extends BasePage{

  public AllProduct2Page(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"js-product-list\"]/nav/div[2]/ul/li[1]/a")
  WebElement previousButton;

  public WebElement getPreviousButton() {
    return previousButton;
  }

  public boolean isLoaded() {
    return driver.getTitle().equals("Home") &&
        driver.getCurrentUrl().equals("http://test-automation-shop1.greenfox.academy/2-home?page=2");
  }
}
