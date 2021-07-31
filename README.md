# test-automation-masterwork

### Masterwork theme:  
Online webshop testing called Prestashop. 

### Tested webapplication link:  
http://test-automation-shop1.greenfox.academy/

### Manual test cases link:  
https://docs.google.com/spreadsheets/d/1lL9W6TsEgTTjIZKY7VVJrsZlt23fcIp_pkKKN81Fr-s/edit?usp=sharing

### Automation test cases information and running method:  
**Information:**  
 * The tests were prepared in IntelliJ in Gradle projects in JAVA language.
 * Tested with chrome webdriver.

**Test running:**
 * Clone repository to your computer
 * Open the cloned gradle project
 * Enter into the terminal (using Windows): "gradlew test"
 * Press "Enter"

**Allure report:**
 * Command for Allure Report in terminal:
   * gradlew clean test
   * gradlew allureReport
   * gradlew allureServe
   
   **or use**
   * allure serve build/allure-results
   
 **Important information for test or report running:**
 * In some runtime environment, the gradlew command must also be anticipated by "./".