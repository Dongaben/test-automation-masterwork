# Teszt-automatiz�l�s-mestermunka

### Mestermunka t�m�ja:  
A Prestashop nev� online webshop tesztel�se. 

### A tesztelt webapplik�ci� linkje:  
http://test-automation-shop1.greenfox.academy/

### A manu�lis teszt esetek linkje:  
https://docs.google.com/spreadsheets/d/1lL9W6TsEgTTjIZKY7VVJrsZlt23fcIp_pkKKN81Fr-s/edit?usp=sharing

### Inform�ci� �s futtat�si m�dszer az automatiz�lt teszt esetekhez:  
**Inform�ci�:**  
 * A tesztek az IntelliJ szofverrel Gradle projektekben k�sz�ltek JAVA nyelven.
 * A tesztek chrome webdriverrel lettek tesztelve.

**Teszt futtat�s:**
 * Kl�nozd a repositoryt a saj�t sz�m�t�g�pedre
 * Nyisd meg a kl�nozott gradle projectet
 * �rd be a termin�lba (Windows-t haszn�lva): "gradlew test"
 * Nyomj "Enter"-t

**Allure riport:**
 * Egym�st ut�n �rd be a termin�lba a k�vetkez� parancsokat az Allure Riport elk�sz�t�s�hez:
   * gradlew clean test
   * gradlew allureReport
   * gradlew allureServe
   
   **vagy haszn�ld ezt**
   * allure serve build/allure-results
   
 **Fontos inform�ci� a teszt vagy riport futtat�s�hoz:**
 * N�h�ny futtat�si k�rnyezetben a gradlew parancs el� be kell �rni a k�vetkez�t "./".