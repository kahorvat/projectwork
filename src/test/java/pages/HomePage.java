package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver inputDriver) {
        super(inputDriver);
        PageFactory.initElements(inputDriver, this);
    }
// UI elemek

    @FindBy(xpath = "//button[@type='submit'] /span[contains(text(),'Cookie')]")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//span[contains(text(),'Hova szállítunk?')]")
    private WebElement deliveryCheckButton;



    // metódusok

    public void clickOnCookieButton(){
        acceptCookieButton.click();
    }

    public void clickOnDeliveryCheckButton(){
        deliveryCheckButton.click();
    }

}
