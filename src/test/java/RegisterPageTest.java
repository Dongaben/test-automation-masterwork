import Pages.HomePage;
import Pages.RegisterPage;
import Pages.TermsAndConditionsOfUsePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Registration, Using Privacy Statement and Data saving tests")
public class RegisterPageTest extends BaseTest{

  @ParameterizedTest(name = "Unsuccessful registration test (Reg_01)")
  @DisplayName("Unsuccessful registration test (Reg_01)")
  @Feature("Registration")
  @Description("Unsuccessful registration without accepting access terms and conditions " +
      "and the privacy policy.")
  @CsvFileSource(resources = "registration_data.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void unSuccessRegister(String socialTitle, String firstName, String lastName,
                                String email, String password, String birthDate) {
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    register.registerStepsWithoutAccessPrivacyAndSaveClick(socialTitle, firstName, lastName, email,
            password, birthDate);
    register.getSaveButton().click();
    Assertions.assertThat(register.isLoaded()).isTrue();
  }

  @ParameterizedTest(name = "Successful registration test (Reg_02)")
  @DisplayName("Successful registration test (Reg_02)")
  @Feature("Registration")
  @Description("In the test, the email address is generated randomly.")
  @CsvFileSource(resources = "registration_data.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void successRegister(String socialTitle, String firstName, String lastName,
                              String email, String password, String birthDate) {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    String randomNumbers = ""+(int)(Math.random()*Integer.MAX_VALUE);
    String randomEmailAddress = "User"+ randomNumbers +"@example.com";
    register.registerStepsWithoutAccessPrivacyAndSaveClick(socialTitle, firstName, lastName,
        randomEmailAddress, password, birthDate);
    register.getTermAndCondAndPrivacyPolicyAccessCheckBox().click();
    register.getSaveButton().click();
    Assertions.assertThat(home.isLoaded()).isTrue();
  }

  @Test
  @DisplayName("Using Privacy Statement test (UPS_01)")
  @Feature("Registration")
  @Description("Open Privacy Statement and check the box.")
  public void usingPrivacyStatement() {
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    register.navigateToRegisterPage();
    register.openAndClosePrivacyPolicy();
    Assertions.assertThat(register.isLoaded()).isTrue();
    register.getTermAndCondAndPrivacyPolicyAccessCheckBox().click();
    Assertions.assertThat(register.getTermAndCondAndPrivacyPolicyAccessCheckBox()
        .isSelected()).isTrue();
  }

  @Test
  @DisplayName("Saving data from the web application test (Sav_01)")
  @Feature("Data handling")
  @Description("Save a list of data form the page into the \"Terms_and_conditions_of_use.txt\" file.")
  public void savingDataFromTheWebApplication() throws InterruptedException {
    RegisterPage register = PageFactory.initElements(driver, RegisterPage.class);
    TermsAndConditionsOfUsePage terms = new TermsAndConditionsOfUsePage(driver);
    register.navigateToRegisterPage();
    register.getTermAndCondAndPrivacyPolicyOpenerLink().click();
    register.windowsSwitcherToSecondWindow();
    Assertions.assertThat(terms.isLoaded()).isTrue();
    Thread.sleep(5000);
    terms.textCopyToFile();
  }
}