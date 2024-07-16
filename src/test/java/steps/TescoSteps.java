package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DeliveryCheckPage;

import java.time.Duration;


public class TescoSteps {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private DeliveryCheckPage deliveryCheckPage;

    /* Selenium Webdriver elindítása */
    @Before
    public static void setup() {
        // set chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");

        // init driver
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().setSize(new Dimension(900, 900));
    }

    @After
    public static void cleanup() {
        driver.quit();
    }


    @Given("I open the delivery check page")
    public void iOpenTheDeliveryCheckPage() {
     driver.get("https://tesco.hu/bevasarlas/tesco-otthonrol/#shoponline");
     deliveryCheckPage = new DeliveryCheckPage(driver);
     //deliveryCheckPage.isLoaded(deliveryCheckPage.getAcceptCookiesButton());
    }

    @And("I accept the cookies")
    public void iAcceptTheCookies() {
        deliveryCheckPage.acceptCookies();
    }

    @When("I enter a valid ZIP code {string}")
    public void iEnterAValidZIPCode(String zipCode) {
        deliveryCheckPage = new DeliveryCheckPage(driver);
        deliveryCheckPage.enterZipCode(zipCode);
    }

    @And("I search for the ZIP code {string}")
    public void iSearchForTheZIPCode(String zipCode) {
        deliveryCheckPage.checkZipCode();
    }

    @Then("I should see the {string}")
    public void iShouldSeeThe(String positiveResult) {
        Assertions.assertEquals("Jó hírünk van!",deliveryCheckPage.getPositiveResultText());
    }

    @When("I enter an invalid ZIP code {string}")
    public void iEnterAnInvalidZIPCode(String invalidZipCode) {
        deliveryCheckPage = new DeliveryCheckPage(driver);
    deliveryCheckPage.enterInvalidZipCode(invalidZipCode);
    }

    @And("I search for the invalid ZIP code {string}")
    public void iSearchForTheInvalidZIPCode(String invalidZipCode) {
        deliveryCheckPage.checkZipCode();
    }
    @Then("I should get the {string}")
    public void iShouldGetThe(String negativeResult) {
        Assertions.assertEquals("Sajnáljuk, de jelenleg még nem tudunk szállítani hozzád.",deliveryCheckPage.getNegativeResultText());
    }
}


