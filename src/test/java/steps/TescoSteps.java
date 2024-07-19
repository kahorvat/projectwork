package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DeliveryCheckPage;
import pages.HomePage;
import pages.SearchResultPage;

import java.time.Duration;


public class TescoSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private DeliveryCheckPage deliveryCheckPage;
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    /* Selenium Webdriver elindítása */
    @Before
    public static void setup() {
        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @After
    public static void cleanup() {
        driver.quit();
    }


    @Given("I open the delivery check page")
    public void iOpenTheDeliveryCheckPage() {
        driver.get("https://tesco.hu/bevasarlas/tesco-otthonrol/");
        deliveryCheckPage = new DeliveryCheckPage(driver);
    }

    @And("I accept the cookies")
    public void iAcceptTheCookies() {
        deliveryCheckPage.acceptCookies();
    }


    @When("I search for the ZIP code {string}")
    public void iSearchForTheZIPCode(String zipCode) {
        deliveryCheckPage.checkZipCode(zipCode);
    }

    @Then("I should see the {string}")
    public void iShouldSeeThe(String positiveResult) {
        Assertions.assertEquals(positiveResult, deliveryCheckPage.getPositiveResultText());
    }


    @When("I search for the invalid ZIP code {string}")
    public void iSearchForTheInvalidZIPCode(String invalidZipCode) {
        deliveryCheckPage.checkZipCode(invalidZipCode);
    }

    @Then("I should get the {string}")
    public void iShouldGetThe(String negativeResult) {
        Assertions.assertEquals(negativeResult, deliveryCheckPage.getNegativeResultText());
    }

    @Given("I open the home page")
    public void iOpenTheHomePage() {
        driver.get("https://bevasarlas.tesco.hu/groceries/hu-HU");
        homePage = new HomePage(driver);
    }

    @And("I accept homepage cookies")
    public void iAcceptHomepageCookies() {
        homePage.acceptHomepageCookies();
    }

    @And("I navigate to the Sign-in page")
    public void iNavigateToTheSignInPage() {
        homePage.openLoginPage();
    }

    @When("I login with e-mail {string} and password {string}")
    public void iLoginWithEMailAndPassword(String email, String pass) {
        homePage.enterEmailAdress(email);
        homePage.enterPassword(pass);
        homePage.startLogin();
    }


    @Then("a greeting message is displayed")
    public void aGreetingMessageIsDisplayed() {
        homePage.validateGreetingSign();
    }

    @And("my user profile is available")
    public void myUserProfileIsAvailable() {
        homePage.validateUserProfile();
    }

    @When("I search for a product {string}")
    public void iSearchForAProduct(String productName) {
        homePage.searchProduct(productName);
    }

    @Then("products are displayed {string}")
    public void productsAreDisplayed(String numberOfProducts) {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.verifySearchResultNumber(numberOfProducts);
    }

    @And("the name of the product contains {string}")
    public void theNameOfTheProductContainsProductName(String productName) {
        searchResultPage.checkProductName(productName);
    }

    @And("the result page shows {string}")
    public void theResultPageShows(String productName) {
        searchResultPage.checkSearchKeyword(productName);
    }


    @When("I search for {string}")
    public void iSearchFor(String invalidProductName) {
        homePage.searchProduct(invalidProductName);
    }

    @Then("a {string} message is displayed")
    public void a_message_is_displayed(String warningMessage) {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkWarningMessage();
    }

    @And("the start shopping button is displayed")
    public void theButtonIsDisplayed() {
        searchResultPage.checkStartShoppingButton();
    }
}



