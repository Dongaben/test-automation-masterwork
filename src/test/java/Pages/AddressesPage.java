package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage{

  public AddressesPage(WebDriver driver) {
    super(driver);
  }

  @FindBy(partialLinkText = "Create new address")
  WebElement createNewAddressLink;

  @FindBy(xpath = "//*[@id=\"notifications\"]/div/article/ul/li")
  WebElement addressMessage;

  public boolean isLoaded() {
    return driver.getTitle().equals("Addresses") &&
        driver.getCurrentUrl().equals("http://test-automation-shop1.greenfox.academy/addresses");
  }

  public boolean presentedAddedNewAddressMessage() {
    return addressMessage.isDisplayed() &&
        addressMessage.getText().equals("Address successfully added!");
  }

  public boolean presentedAddressUpdatedMessage() {
    return addressMessage.isDisplayed() &&
        addressMessage.getText().equals("Address successfully updated!");
  }

  public boolean presentedAddressDeletedMessage() {
    return addressMessage.isDisplayed() &&
        addressMessage.getText().equals("Address successfully deleted!");
  }

  public void navigateToNewAddressPage() {
    createNewAddressLink.click();
  }

  public WebElement addressTicketSelector(String alias) {
    WebElement selectedTicket = null;
    List<WebElement> tickets = driver.findElements(By.xpath("//*[@id=\"content\"]/div/article"));
    String searchAliasText = alias.toLowerCase();
    String ticketAliasText = "";
    for (int i = 0; i < tickets.size(); i++) {
      ticketAliasText = tickets.get(i).findElement(By.xpath("div/h4")).getText().toLowerCase();
      if (ticketAliasText.contains(searchAliasText)) {
        selectedTicket = tickets.get(i);
        break;
      }
    }
    if (selectedTicket == null) {
      System.out.println("The searched address field not found!");
    }
    return selectedTicket;
  }

  public WebElement updateButton(String alias) {
    WebElement updateButton = addressTicketSelector(alias).findElement(By.xpath("div[2]/a"));
    return updateButton;
  }

  public WebElement deleteButton(String alias) {
    WebElement deleteButton = addressTicketSelector(alias).findElement(By.xpath("div[2]/a[2]"));
    return deleteButton;
  }

}
