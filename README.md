# QuantumLeap – E-Commerce Test Automation Framework

End-to-end, portfolio-ready automation for:
- **UI Web**: Sauce Demo (https://www.saucedemo.com)
- **REST API**: ReqRes (https://reqres.in)

Tech stack: **Java 17**, **Maven**, **Selenium WebDriver**, **TestNG**, **Cucumber (BDD)**, **REST Assured**, **ExtentReports**, **WebDriverManager**, **JavaFaker**

---

## 📁 Project Structure

quantumleap/
├─ pom.xml
├─ testng.xml

├─ src/
│ ├─ main/java/com/quantumleap/
│ │ ├─ core/ # Driver, Extent manager (no TestNG annotations here)
│ │ └─ pages/ # Page Objects (Login, Products, Cart, Checkout)
│ └─ test/java/com/quantumleap/
│ ├─ core/ # BaseTest, TestListener (TestNG)
│ ├─ utils/ # TestDataProvider
│ ├─ tests/
│ │ ├─ ui/ # LoginTests, PurchaseFlowTests
│ │ └─ api/ # ReqResCrudTests
│ └─ bdd/
│ ├─ runners/ # CucumberTestRunner (TestNG)
│ └─ steps/ # Step defs reusing Page Objects
└─ src/test/resources/features/
└─ add_to_cart.feature


---

## 🚀 Getting Started

### Prerequisites
- **Java 17+**
- **Maven 3.9+**
- Google **Chrome** (WebDriverManager auto-handles driver)

Verify:
```bash
java -version
mvn -v

