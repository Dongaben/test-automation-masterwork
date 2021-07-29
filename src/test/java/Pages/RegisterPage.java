package Pages;

import java.util.Iterator;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input")
  WebElement socialMrRadioButton;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input")
  WebElement socialMrsRadioButton;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input")
  WebElement firstNameInputField;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input")
  WebElement lastNameInputField;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input")
  WebElement emailInputField;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/input")
  WebElement passwordInputField;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input")
  WebElement birthDateInputField;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[8]/div[1]/span/label/input")
  WebElement customerDataPrivacyAccessCheckBox;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[10]/div[1]/span/label/input")
  WebElement termAndCondAndPrivacyPolicyAccessCheckBox;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/section/div[10]/div[1]/span/label/a")
  WebElement termAndCondAndPrivacyPolicyOpenerLink;

  @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
  WebElement saveButton;

  public WebElement getCustomerDataPrivacyAccessCheckBox() {
    return customerDataPrivacyAccessCheckBox;
  }

  public WebElement getTermAndCondAndPrivacyPolicyAccessCheckBox() {
    return termAndCondAndPrivacyPolicyAccessCheckBox;
  }

  public WebElement getTermAndCondAndPrivacyPolicyOpenerLink() {
    return termAndCondAndPrivacyPolicyOpenerLink;
  }

  public WebElement getSaveButton() {
    return saveButton;
  }

  public boolean isLoaded() {
    return driver.getTitle().equals("Login") &&
        driver.getCurrentUrl()
            .equals("http://test-automation-shop1.greenfox.academy/login?create_account=1");
  }

  public void navigateToRegisterPage() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    home.navigateToSignInPage();
    Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
    login.navigateToRegisterPage();
    Assertions.assertThat(register.isLoaded()).isTrue();
  }

  public void registerStepsWithoutAccessPrivacyAndSaveClick (String socialTitle, String firstName,
                              String lastName, String email, String password, String birthDate) {
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    navigateToRegisterPage();
    register.personalDataRegister(socialTitle, firstName, lastName, email, password, birthDate);
    register.getCustomerDataPrivacyAccessCheckBox().click();
    openAndClosePrivacyPolicy();
    Assertions.assertThat(register.isLoaded()).isTrue();
  }

  public void personalDataRegister(String socialTitle, String firstName, String lastName,
                                   String email, String password, String birthDate) {
    if (socialTitle.equals("Mr.")) {
      socialMrRadioButton.click();
    } else {
      socialMrsRadioButton.click();
    }
    firstNameInputField.sendKeys(firstName);
    lastNameInputField.sendKeys(lastName);
    emailInputField.sendKeys(email);
    passwordInputField.sendKeys(password);
    birthDateInputField.sendKeys(birthDate);
  }

  public void openAndClosePrivacyPolicy() {
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    TermsAndConditionsOfUsePage terms = new TermsAndConditionsOfUsePage(driver);
    register.getTermAndCondAndPrivacyPolicyOpenerLink().click();
    Set<String> windows = driver.getWindowHandles();
    Iterator<String> iterator = windows.iterator();
    String registerWindow = iterator.next();
    String termsWindow = iterator.next();
    driver.switchTo().window(termsWindow);
    Assertions.assertThat(terms.isLoaded()).isTrue();
    terms.closePage();
    driver.switchTo().window(registerWindow);
  }

  public void windowsSwitcherToSecondWindow() {
    Set<String> windows = driver.getWindowHandles();
    Iterator<String> iterator = windows.iterator();
    String termsWindow = "";
    for (int i = 0; iterator.hasNext(); i++) {
      termsWindow = iterator.next();
      if (i == 2) {
        break;
      }
    }
    driver.switchTo().window(termsWindow);
  }


}
