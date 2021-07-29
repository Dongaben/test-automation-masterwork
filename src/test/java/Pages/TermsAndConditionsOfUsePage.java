package Pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermsAndConditionsOfUsePage extends BasePage{

  public TermsAndConditionsOfUsePage(WebDriver driver) {
    super(driver);
  }

  public boolean isLoaded() {
    return driver.getTitle().equals("Terms and conditions of use") &&
        driver.getCurrentUrl()
            .equals("http://test-automation-shop1.greenfox.academy/content/3-terms-and-conditions-of-use");
  }

  public void closePage() {
    driver.close();
  }

  public void textCopyToFile() {
    Path targetPath = Paths.get("src" + File.separator + "Terms_and_conditions_of_use.txt");
    List<String> sentences = new ArrayList<>();
    WebElement ruleTitle = driver.findElement(By.id("content"));
    sentences.add(ruleTitle.getText());
    try {
      Files.write(targetPath, sentences);
    } catch (IOException e) {
      System.out.println("Unable to write file: Terms_and_conditions_of_use.txt");
    }
  }

}
