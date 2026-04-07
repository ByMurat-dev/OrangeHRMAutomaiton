# QA Automation Case Study (OrangeHRM Web + Android ApiDemos)

Bu proje, Web (OrangeHRM) ve Mobil (Android ApiDemos) platformları için hazırlanmış, Page Object Model (POM) mimarisine sahip bir UI Otomasyon projesidir. Testler BDD yaklaşımıyla Cucumber kullanılarak yazılmış ve Allure ile raporlanmıştır.



## 🛠️ Kullanılan Teknolojiler
* **Dil:** Java 11
* **Proje Yönetimi:** Maven
* **Web Otomasyonu:** Selenium WebDriver (v4.18.1)
* **Mobil Otomasyon:** Appium (v9.2.0) - UiAutomator2
* **Test Çerçevesi:** Cucumber & TestNG
* **Raporlama:** Allure Reports

## ⚙️ Kurulum (Prerequisites)
Projeyi çalıştırmadan önce bilgisayarınızda aşağıdakilerin kurulu olduğundan emin olun:
1. Java JDK 11 veya üstü.
2. Maven.
3. Node.js ve Appium (`npm install -g appium`).
4. Android Studio (Emülatör çalıştırmak için).
5. Allure Commandline (Raporları görüntüleyebilmek için).

Projeyi yerel bilgisayarınıza indirin:
```bash
git clone <[-github-repo-](https://github.com/ByMurat-dev/OrangeHRMAutomaiton.git)>
cd QaAutomationCaseStudy
mvn clean install -DskipTests
