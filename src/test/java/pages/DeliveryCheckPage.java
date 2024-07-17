package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeliveryCheckPage extends BasePage {

    public DeliveryCheckPage(WebDriver inputDriver) {
        super(inputDriver);
        PageFactory.initElements(inputDriver, this);
    }

    //UI elemek

    @FindBy(xpath = "//button[@type='submit'] /span[contains(text(),'Cookie')]")
    WebElement acceptCookiesButton;

    @FindBy(xpath = "//input [@id='FTS_Zip_code_checker__zip_code_input']")
    WebElement zipCodeCheckerField;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Ellenőriz')]")
    WebElement zipCodeCheckerButton;

    @FindBy(xpath = "//h2 [contains(text(),'Jó hírünk van')]")
    WebElement positiveResultText;

    @FindBy(xpath = "//h2 [contains(text(),'Sajnáljuk')]")
    WebElement negativeResultText;

    //metódusok

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
    }

    public void enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.elementToBeClickable(zipCodeCheckerField));
        zipCodeCheckerField.sendKeys(zipCode);
    }


    public void checkZipCode(String zipCode) {
        wait.until(ExpectedConditions.elementToBeClickable(zipCodeCheckerField));
        zipCodeCheckerField.sendKeys(zipCode);
        zipCodeCheckerButton.click();
    }

    public String getPositiveResultText() {
        wait.until(ExpectedConditions.visibilityOf(positiveResultText));
        return positiveResultText.getText();

    }

    public String getNegativeResultText() {
        wait.until(ExpectedConditions.visibilityOf(negativeResultText));
        return negativeResultText.getText();
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

}
