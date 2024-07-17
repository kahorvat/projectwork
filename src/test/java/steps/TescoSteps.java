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

import java.time.Duration;


public class TescoSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private DeliveryCheckPage deliveryCheckPage;
    private HomePage homePage;

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
        Assertions.assertEquals("Jó hírünk van!", deliveryCheckPage.getPositiveResultText());
    }


    @When("I search for the invalid ZIP code {string}")
    public void iSearchForTheInvalidZIPCode(String invalidZipCode) {
        deliveryCheckPage.checkZipCode(invalidZipCode);
    }

    @Then("I should get the {string}")
    public void iShouldGetThe(String negativeResult) {
        Assertions.assertEquals("Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád.", deliveryCheckPage.getNegativeResultText());
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

    /*@When("I enter my e-mail address {String}")
    public void iEnterMyEMailAddress(String email) {
        homePage.enterEmailAdress(email);
    }

    @And("I enter my password {String}")
    public void iEnterMyPassword(String password) {
        homePage.enterPassword(password);
    } */


    @Then("a greeting message is displayed")
    public void aGreetingMessageIsDisplayed() {
        homePage.validateGreetingSign();
    }

    @And("my user profile is available")
    public void myUserProfileIsAvailable() {
        homePage.validateUserProfile();
    }


}


