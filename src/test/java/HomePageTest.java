import static org.assertj.core.api.Assertions.assertThat;

import Pages.AllProduct1Page;
import Pages.AllProduct2Page;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DisplayName("Products searching tests")
public class HomePageTest extends BaseTest{

  @Test
  @DisplayName("Pagination test (Pag_01)")
  @Feature("Products searching")
  @Description("After listing a more than one page long data list," +
      " navigate to the next page of the data list.")
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
  @DisplayName("Input of new data test (New_01)")
  @Feature("Products searching")
  @Description("Enter the word \"mug\" in the search box and check the conformity of " +
      "the listed products.")
  public void inputOfNewData() {
    String searchedWord = "mug";
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    home.getSearchInputField().sendKeys(searchedWord);
    home.getSearchInputField().sendKeys(Keys.ENTER);
    home.productInspector(searchedWord);
  }
}
