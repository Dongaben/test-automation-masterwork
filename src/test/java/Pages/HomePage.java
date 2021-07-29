package Pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
  WebElement signInLink;

  @FindBy(xpath = "//*[@id=\"category-6\"]/a")
  WebElement accessoriesLink;

  @FindBy(xpath = "//*[@id=\"content\"]/section/a")
  WebElement allProductsLink;

  @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
  WebElement searchInputField;

  @FindBy(xpath = "//*[@id=\"footer_account_list\"]/li[4]/a")
  WebElement addressesLink;

  public WebElement getSignInLink() {
    return signInLink;
  }

  public boolean isLoaded() {
    return driver.getTitle().equals("PrestaShop") &&
        driver.getCurrentUrl().equals("http://test-automation-shop1.greenfox.academy/");
  }

  public void navigateToSignInPage() {
    driver.get("http://test-automation-shop1.greenfox.academy/");
    signInLink.click();
  }

  public boolean statusIsSignOut() {
    String signInLinkText = signInLink.getText();
    if (signInLinkText.toLowerCase().contains("sign in")) {
      return true;
    }
    return false;
  }

  public void navigateToAccessories() {
    driver.get("http://test-automation-shop1.greenfox.academy/");
    accessoriesLink.click();
  }

  public void navigateToAddressesPage() {
    addressesLink.click();
  }

  public WebElement getAllProductsLink() {
    return allProductsLink;
  }

  public WebElement getSearchInputField() {
    return searchInputField;
  }

  public void productInspector(String searchedWord) {
    List<WebElement> products = driver
        .findElements(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div"));
    String productName = "";
    for (int i = 0; i < products.size(); i++) {
      productName = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div["
          + (i+1) + "]/article/div/div[1]/h2")).getText();
      assertThat(productName.toLowerCase().contains(searchedWord.toLowerCase())).isTrue();
    }
  }

  public void loginControl() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    if (home.statusIsSignOut()) {
      home.navigateToSignInPage();
      login.login("mekkelek14@gmail.com", "123321");
    }
  }
}
