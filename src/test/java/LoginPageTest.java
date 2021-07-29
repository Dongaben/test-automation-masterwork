import Pages.HomePage;
import Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest extends BaseTest{

  @Test
  @DisplayName("Unsuccessfully login with non registrated data. (Log_01)")
  public void unSuccessLoginWithInvalidData() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    home.navigateToSignInPage();
    Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
    login.login("mekkelek32@gmail.com", "123321");
    Assertions.assertThat(login.isLoadedAfterLogin()).isFalse();
  }

  @Test
  @DisplayName("Successfully login. (Log_02)")
  public void successLogin() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    LoginPage login = PageFactory.initElements(driver, LoginPage.class);
    home.navigateToSignInPage();
    Assertions.assertThat(login.isLoadedBeforeLogin()).isTrue();
    login.login("mekkelek14@gmail.com", "123321");
    Assertions.assertThat(login.isLoadedAfterLogin()).isTrue();
  }
}
