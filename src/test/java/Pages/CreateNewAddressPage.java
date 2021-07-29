package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAddressPage extends BasePage{

  public CreateNewAddressPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
  WebElement aliasInputField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[5]/div[1]/input")
  WebElement addressInputField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[7]/div[1]/input")
  WebElement cityInputField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
  WebElement postalCodeInputField;

  @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
  WebElement saveButton;

  public boolean isLoaded() {
    return driver.getTitle().equals("Address") &&
        driver.getCurrentUrl().equals("http://test-automation-shop1.greenfox.academy/address");
  }

  public void fillNewAddressForm(String alias, String address, String city, String state,
                                 String postalCode, String country) {
    aliasInputField.sendKeys(alias);
    addressInputField.sendKeys(address);
    cityInputField.sendKeys(city);
    Select states = new Select(driver
        .findElement(By.name("id_state")));
    states.selectByVisibleText(state);
    postalCodeInputField.sendKeys(postalCode);
    Select countries = new Select(driver
        .findElement(By.name("id_country")));
    countries.selectByVisibleText(country);
    saveButton.click();
  }

  public void addressModifier(String address) {
    addressInputField.clear();
    addressInputField.sendKeys(address);
    saveButton.click();
  }

  public void navigateToAddressesPage() {
    driver.get("http://test-automation-shop1.greenfox.academy/addresses");
  }

}
