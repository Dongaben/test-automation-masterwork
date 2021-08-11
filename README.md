# Teszt-automatizálás-mestermunka

### Mestermunka témája:  
A Prestashop nevû online webshop tesztelése. 

### A tesztelt webapplikáció linkje:  
http://test-automation-shop1.greenfox.academy/

### A manuális teszt esetek linkje:  
https://docs.google.com/spreadsheets/d/1lL9W6TsEgTTjIZKY7VVJrsZlt23fcIp_pkKKN81Fr-s/edit?usp=sharing

### Információ és futtatási módszer az automatizált teszt esetekhez:  
**Információ:**  
 * A tesztek az IntelliJ szofverrel Gradle projektekben készültek JAVA nyelven.
 * A tesztek chrome webdriverrel lettek tesztelve.

**Teszt futtatás:**
 * Klónozd a repositoryt a saját számítógépedre
 * Nyisd meg a klónozott gradle projectet
 * Írd be a terminálba (Windows-t használva): "gradlew test"
 * Nyomj "Enter"-t

**Allure riport:**
 * Egymást után írd be a terminálba a következõ parancsokat az Allure Riport elkészítéséhez:
   * gradlew clean test
   * gradlew allureReport
   * gradlew allureServe
   
   **vagy használd ezt**
   * allure serve build/allure-results
   
 **Fontos információ a teszt vagy riport futtatásához:**
 * Néhány futtatási környezetben a gradlew parancs elé be kell írni a következõt "./".