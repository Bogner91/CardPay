package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    By waitSecureACSPage = By.xpath("//header[@class = \"page-header\"]");

    @FindBy (xpath = "//a[contains(text(), 'ссылке')]")
    private WebElement locatorFieldCardNumber;
    @FindBy (xpath = "//input[@id = \"input-card-number\"]")
    private WebElement fieldCardNumber;
    @FindBy (xpath = "//input[@id = \"input-card-holder\"]")
    private WebElement fieldCardholderName;
    @FindBy (xpath = "//select[@id = \"card-expires-month\"]/option[@value = \"1\"]")
    private WebElement ddlMonth;
    @FindBy (xpath = "//select[@id = \"card-expires-year\"]/option[@value = \"2025\"]")
    private WebElement ddlYear;
    @FindBy (xpath = "//input[@id = \"input-card-cvc\"]")
    private WebElement fieldCVC;
    @FindBy (xpath = "//input[@id = \"action-submit\"]")
    private WebElement buttonPay;
    @FindBy(xpath = "//a[contains(text(), 'ссылке')]")
    private WebElement paymentPage;

    public void openPaymentPage(){
        paymentPage.click();
        ArrayList<String> handleList = new ArrayList<String>(driver.getWindowHandles());
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(handleList.get(1));
    }

    public void  enterCardNumber(String cardNumber){
       fieldCardNumber.sendKeys(cardNumber);
    }

    public void  enterCardholderName(String cardholderName){
        fieldCardholderName.sendKeys(cardholderName);
    }

    public void selectExpires() {
        ddlMonth.click();
        ddlYear.click();
    }

    public void selectCVC(String CVC) {
        fieldCVC.sendKeys(CVC);
    }


    public void clickButtonPay() {
        buttonPay.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitSecureACSPage));
    }
}
