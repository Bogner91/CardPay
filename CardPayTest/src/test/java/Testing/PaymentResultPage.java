package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentResultPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//div[@id = \"payment-status-title\"]/span[contains(text(), 'Success')]")
    private WebElement statusSuccess;
    @FindBy (xpath = "//div[@data-i18n = \"resultPage.status.confirmed\" and contains(text(), 'Confirmed')]")
    private WebElement paymentStatusConf;
    @FindBy (xpath = "//span[@data-i18n = \"result.info.authcode\" and contains(text(), 'Authorization code')]")
    private WebElement authCodeTrue;
    @FindBy(xpath = "//div[@id = \"payment-status-title\"]/span[contains(text(), 'Decline')]")
    private WebElement statusDecline;
    @FindBy (xpath = "//div[contains(text(), 'Declined by issuing bank')]")
    private WebElement paymentStatusDecl;
    @FindBy(xpath = "//div[@id = \"payment-status-title\"]/span[contains(text(), 'Info')]")
    private WebElement statusInfo;
    @FindBy (xpath = "//div[@data-i18n = \"resultPage.status.authorizationsuccess\" and contains(text(), 'CONFIRMED')]")
    private WebElement paymentStatusInfo;


    public String getStatusSuccess() {
        return statusSuccess.getText();
    }

    public String getPayStatusConf() {
        return paymentStatusConf.getText();
    }

    public String getAuthCode() {
        return authCodeTrue.getText();
    }

    public String getStatusDecline(){
        return statusDecline.getText();
    }

    public String getPayStatusDecl(){
        return paymentStatusDecl.getText();
    }

    public String getStatusInfo() {
        return statusInfo.getText();
    }

    public String getPayStatusInfo() {
        return paymentStatusInfo.getText();
    }

    public void backToNotionPage(){
        driver.close();
        driver.switchTo().window("");
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));
    }
}
