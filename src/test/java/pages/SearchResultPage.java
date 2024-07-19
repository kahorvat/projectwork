package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    //UI elemek

    @FindBy(css = "#product-list .pagination__items-displayed>strong:nth-of-type(2)")
    WebElement productResultList;

    @FindBy(xpath = "//h1[@class='heading query']")
    WebElement searchKeyword;

    @FindBy(css = ".product-details--wrapper > h3 span")
    WebElement productDescriptionField;

    @FindBy(css = ".empty-section--empty-text>h3")
    WebElement warningMessage;

    @FindBy(xpath = "//a[text()= 'Bevásárlás megkezdése']")
    WebElement startShoppingButton;


    // metódusok


    public boolean isLoaded() {
        boolean isLoaded = isLoaded(productResultList);
        return isLoaded;
    }

    public void verifySearchResultNumber(String numOfProducts) {
        wait.until(ExpectedConditions.visibilityOf(productResultList));
        assertTrue(productResultList.getText().contains(numOfProducts));
    }

    public void checkSearchKeyword(String productName) {
        Assertions.assertTrue(searchKeyword.getText().contains(productName));
    }

    public void checkProductName(String productName) {
        Assertions.assertTrue(productDescriptionField.getText().contains(productName));
    }

    public String checkWarningMessage() {
        wait.until(ExpectedConditions.visibilityOf(warningMessage));
        return warningMessage.getText();
    }

    public void checkStartShoppingButton() {
        Assertions.assertTrue(startShoppingButton.isDisplayed());

    }
}

