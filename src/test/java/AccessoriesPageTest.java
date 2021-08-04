import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import Pages.AccessoriesPage;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DisplayName("Listing data test")
public class AccessoriesPageTest extends BaseTest {

  @Test
  @DisplayName("Execute a data listing from any data available on the page (List_01)")
  @Feature("Data listing")
  @Description("Listing the \"Studio Design\" product group and product number control.")
  public void listingData() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    AccessoriesPage accessories = PageFactory.initElements(driver, AccessoriesPage.class);
    home.navigateToAccessories();
    Assertions.assertThat(accessories.isLoaded()).isTrue();
    accessories.getStudioDesignLink().click();
    wait.until(ExpectedConditions.urlContains
      ("http://test-automation-shop1.greenfox.academy/6-accessories?q=Brand-Studio+Design"));
    assertThat(accessories.numberOfProduct()).isEqualTo(7);
  }
}
