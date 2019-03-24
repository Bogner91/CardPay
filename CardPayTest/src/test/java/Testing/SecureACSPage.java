package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureACSPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SecureACSPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    By waitPaymentResultPageSuc = By.xpath("//div[@id = \"payment-status-title\"]/span[contains(text(), 'Success')]");
    By waitPaymentResultPageDecl = By.xpath("//div[@id = \"payment-status-title\"]/span[contains(text(), 'Decline')]");
    By waitPaymentResultPageInfo= By.xpath("//div[@id = \"payment-status-title\"]/span[contains(text(), 'Info')]");

    @FindBy (xpath = "//button[@id = \"success\"]")
    private WebElement buttonSuccess;
    @FindBy (xpath = "//button[@id = \"failure\"]")
    private WebElement buttonFailure;

    public void clickButtonSuccess() {
        buttonSuccess.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitPaymentResultPageSuc));
    }

    public void clickButtonFailure() {
        buttonFailure.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitPaymentResultPageDecl));
    }

    public void clickButtonSuccessForDecl() {
        buttonSuccess.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitPaymentResultPageDecl));
    }

    public void clickButtonSuccessForInfo() {
        buttonSuccess.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitPaymentResultPageInfo));
    }
}
