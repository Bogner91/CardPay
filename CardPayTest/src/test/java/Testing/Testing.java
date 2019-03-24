package Testing;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Testing extends ChromeWebDriver{

    @Test //Check various payment statuses as 3-D Secure transactions.
    public void TestCase () {
        NotionPage notionPage = PageFactory.initElements(driver, NotionPage.class);
        PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);
        SecureACSPage secureACSPage = PageFactory.initElements(driver, SecureACSPage.class);
        PaymentResultPage paymentResultPage = PageFactory.initElements(driver, PaymentResultPage.class);

        notionPage.openNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("4000000000000002");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonSuccess();

        Assert.assertEquals(paymentResultPage.getStatusSuccess(), "Success");
        Assert.assertEquals(paymentResultPage.getPayStatusConf(), "Confirmed");
        Assert.assertEquals(paymentResultPage.getAuthCode(), "Authorization code");

        paymentResultPage.backToNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("4000000000000002");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonFailure();

        Assert.assertEquals(paymentResultPage.getStatusDecline(), "Decline");
        Assert.assertEquals(paymentResultPage.getPayStatusDecl(), "Declined by issuing bank");

        paymentResultPage.backToNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("5555555555554444");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonSuccessForDecl();

        Assert.assertEquals(paymentResultPage.getStatusDecline(), "Decline");
        Assert.assertEquals(paymentResultPage.getPayStatusDecl(), "Declined by issuing bank");

        paymentResultPage.backToNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("5555555555554444");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonFailure();

        Assert.assertEquals(paymentResultPage.getStatusDecline(), "Decline");
        Assert.assertEquals(paymentResultPage.getPayStatusDecl(), "Declined by issuing bank");

        paymentResultPage.backToNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("4000000000000044");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonSuccessForInfo();

        Assert.assertEquals(paymentResultPage.getStatusInfo(), "Info");
        Assert.assertEquals(paymentResultPage.getPayStatusInfo(), "CONFIRMED");
        Assert.assertEquals(paymentResultPage.getAuthCode(), "Authorization code");

        paymentResultPage.backToNotionPage();

        paymentPage.openPaymentPage();
        paymentPage.enterCardNumber("4000000000000044");
        paymentPage.enterCardholderName("NAME FNAME");
        paymentPage.selectExpires();
        paymentPage.selectCVC("333");
        paymentPage.clickButtonPay();
        secureACSPage.clickButtonFailure();

        Assert.assertEquals(paymentResultPage.getStatusDecline(), "Decline");
        Assert.assertEquals(paymentResultPage.getPayStatusDecl(), "Declined by issuing bank");
    }

}
