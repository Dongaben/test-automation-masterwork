import static org.assertj.core.api.Assertions.assertThat;

import Pages.AddressesPage;
import Pages.CreateNewAddressPage;
import Pages.HomePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.PageFactory;

public class AddressesPageTest extends BaseTest{

  @ParameterizedTest
  @DisplayName("From a .csv file do a parameterized test and fill the page up " +
      "with at least 3 pieces of data. (Rep_01-03)")
  @CsvFileSource(resources = "new_addresses.csv", numLinesToSkip = 1, encoding = "utf-8")
  public void repetitiveDataEntry(String alias, String address, String city, String state,
                                  String postalCode, String country) {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    AddressesPage addresses = PageFactory.initElements(driver, AddressesPage.class);
    CreateNewAddressPage newAddress = PageFactory.initElements(driver, CreateNewAddressPage.class);
    home.loginControl();
    home.navigateToAddressesPage();
    assertThat(addresses.isLoaded()).isTrue();
    addresses.navigateToNewAddressPage();
    assertThat(newAddress.isLoaded()).isTrue();
    newAddress.fillNewAddressForm(alias, address, city, state, postalCode, country);
    assertThat(addresses.presentedAddedNewAddressMessage()).isTrue();
  }

  @Test
  @DisplayName("Modifying data, validate that the change was successful. (Mod_01)")
  public void existingDataModification() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    AddressesPage addresses = PageFactory.initElements(driver, AddressesPage.class);
    CreateNewAddressPage newAddress = PageFactory.initElements(driver, CreateNewAddressPage.class);
    home.loginControl();
    home.navigateToAddressesPage();
    shouldBeAddressTicketIsPresent("Otthon");
    addresses.updateButton("Otthon").click();
    newAddress.addressModifier("Siker u. 33.");
    assertThat(addresses.presentedAddressUpdatedMessage()).isTrue();
  }

  @Test
  @DisplayName("Deleting data, validate that the deletion was successful. (Del_01)")
  public void deletingData() {
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    AddressesPage addresses = PageFactory.initElements(driver, AddressesPage.class);
    home.loginControl();
    home.navigateToAddressesPage();
    shouldBeAddressTicketIsPresent("Telephely4");
    addresses.deleteButton("Telephely4").click();
    assertThat(addresses.presentedAddressDeletedMessage()).isTrue();
  }

  public void shouldBeAddressTicketIsPresent(String alias) {
    AddressesPage addresses = PageFactory.initElements(driver, AddressesPage.class);
    CreateNewAddressPage newAddress = PageFactory.initElements(driver, CreateNewAddressPage.class);
    if (addresses.addressTicketSelector(alias) == null) {
      addresses.navigateToNewAddressPage();
      assertThat(newAddress.isLoaded()).isTrue();
      newAddress.fillNewAddressForm(alias, "Lakat u. 13.", "Szeged",
        "California", "55555", "United States");
      newAddress.navigateToAddressesPage();
    }
    assertThat(addresses.isLoaded()).isTrue();
  }
}