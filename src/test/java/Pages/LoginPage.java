package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
  WebElement emailInputField;

  @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
  WebElement passwordInputField;

  @FindBy(id = "submit-login")
  WebElement signInButton;

  @FindBy(xpath = "//*[@id=\"content\"]/div/a")
  WebElement newAccountCreateLink;

  public boolean isLoadedBeforeLogin() {
    return driver.getTitle().equals("Login") &&
        driver.getCurrentUrl()
            .equals("http://test-automation-shop1.greenfox.academy/login?back=my-account");
  }

  public boolean isLoadedAfterLogin() {
    return driver.getTitle().equals("My account") &&
        driver.getCurrentUrl()
            .equals("http://test-automation-shop1.greenfox.academy/my-account");
  }


  public void login(String email, String password) {
    emailInputField.sendKeys(email);
    passwordInputField.sendKeys(password);
    signInButton.click();
  }

  public void navigateToRegisterPage() {
    newAccountCreateLink.click();
  }
}
