package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class TravelIsurancePage extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Выбор полиса')]")
    public WebElement titlePolice;

    @FindBy(xpath = "//div[contains(text(), 'Минимальная')]//parent::div[contains(@ng-class, '1')]")
    public WebElement insuranceType;

    @FindBy(xpath = "//span[contains(text(), 'Оформить')]")
    public WebElement issueButton;

    public TravelIsurancePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(titlePolice));

    }


}
