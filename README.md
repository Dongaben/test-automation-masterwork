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
 * Open the cloned gradle project with IntelliJ
 * Enter into the IntelliJ terminal (using Windows): ./gradlew test 
 * Press "Enter"

**Allure report:**
 * Link in repository: build/reports/tests/test/index.html
 * Command for Allure Report in IntelliJ terminal:
   * ./gradlew clean test
   * ./gradlew allureReport
   * ./gradlew allureServe
