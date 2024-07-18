package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver inputDriver) {
        super(inputDriver);
        PageFactory.initElements(inputDriver, this);
    }
// UI elemek

    @FindBy(css = ".ddsweb-cookies-notification__form:nth-of-type(1) >button")
    WebElement acceptCookieButton;

    @FindBy(xpath = "//a[@id='utility-header-login-link']")
    WebElement loginPageButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailAdressField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='signin-button']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='utility-header-greetings']")
    WebElement greetingSign;

    @FindBy(xpath = "//a[@id='utility-header-account-link']")
    WebElement userProfileLink;

    @FindBy(xpath = "//input[@id='search-input']")
    WebElement productSearchField;

    @FindBy(xpath = "//*[@id='search-form']/button[@type='submit']")
    WebElement productSearchButton;


    // metódusok

    public void acceptHomepageCookies() {
        wait.until(ExpectedConditions.visibilityOf(acceptCookieButton));
        acceptCookieButton.click();
    }

    public void openLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPageButton));
        loginPageButton.click();
    }

    public void enterEmailAdress(String email) {
        emailAdressField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void startLogin() {
        loginButton.click();
    }

    public void validateGreetingSign() {
        wait.until(ExpectedConditions.visibilityOf(greetingSign));
        Assertions.assertEquals("Üdvözlünk Karesz", greetingSign.getText());

    }

    public void validateUserProfile() {
        wait.until(ExpectedConditions.visibilityOf(userProfileLink));
        Assertions.assertEquals("Felhasználói Fiókom", userProfileLink.getText());
    }

    public SearchResultPage searchProduct(String productName) {
        productSearchField.sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(productSearchButton));
        productSearchButton.click();
        return new SearchResultPage(driver);
    }

}

