import static org.assertj.core.api.Assertions.assertThat;

import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

@DisplayName("Login and logout tests")
public class LoginPageTest extends BaseTest{

  @Test
  @DisplayName("Unsuccessful login test (Log_01)")
  @Feature("Login")
  @Description("Unsuccessful login with non registrated data.")
  public void unSuccessLoginWithInvalidData() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    home.navigateToSignInPage();
    Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
    login.login("mekkelek32@gmail.com", "123321");
    Assertions.assertThat(login.isLoadedAfterLogin()).isFalse();
  }

  @Test
  @DisplayName("Successful login test (Log_02)")
  @Feature("Login")
  @Description("Successful login with valid data.")
  public void successLogin() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    home.navigateToSignInPage();
    Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
    login.login("mekkelek14@gmail.com", "123321");
    Assertions.assertThat(login.isLoadedAfterLogin()).isTrue();
  }

  @Test
  @DisplayName("Logout test (Out_01)")
  @Feature("Logout")
  @Description("Successful logout.")
  public void logout() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    if (home.statusIsSignOut()) {
      home.navigateToSignInPage();
      Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
      login.login("mekkelek14@gmail.com", "123321");
      Assertions.assertThat(login.isLoadedAfterLogin()).isTrue();
    }
    home.getSignInLink().click();
    assertThat(home.statusIsSignOut()).isEqualTo(true);
  }
}
