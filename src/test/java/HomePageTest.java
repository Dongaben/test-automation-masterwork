import static org.assertj.core.api.Assertions.assertThat;

import Pages.AllProduct1Page;
import Pages.AllProduct2Page;
import Pages.HomePage;
import Pages.LoginPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageTest extends BaseTest{

  @Test
  @DisplayName("After listing a more than one page long data list," +
      " navigate to the next page of the data list. (Pag_01)")
  public void pagination() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    AllProduct1Page allProduct1Page = PageFactory.initElements(driver, AllProduct1Page.class);
    AllProduct2Page allProduct2Page = PageFactory.initElements(driver, AllProduct2Page.class);
    home.getAllProductsLink().click();
    assertThat(allProduct1Page.isLoaded()).isTrue();
    allProduct1Page.getNextButton().click();
    wait.until(ExpectedConditions
        .urlToBe("http://test-automation-shop1.greenfox.academy/2-home?page=2"));
    assertThat(allProduct2Page.isLoaded()).isTrue();
  }

  @Test
  @DisplayName("At least one new data input, validate the input was successful. (New_01)")
  public void inputOfNewData() {
    String searchedWord = "mug";
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    home.getSearchInputField().sendKeys(searchedWord);
    home.getSearchInputField().sendKeys(Keys.ENTER);
    home.productInspector(searchedWord);
  }

  @Test
  @DisplayName("Logout. (Out_01)")
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
