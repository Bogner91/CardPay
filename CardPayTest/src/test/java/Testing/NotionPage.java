package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Class NotionPage this https://www.notion.so/QA-c731ab8fca6945539b3388154e8ed263
public class NotionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public NotionPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    By waitNotion = By.xpath("//div[contains(text(), 'Тестовое задание на позицию QA')]");

    public void openNotionPage(){
        driver.get("https://www.notion.so/QA-c731ab8fca6945539b3388154e8ed263");
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitNotion));
    }


}
