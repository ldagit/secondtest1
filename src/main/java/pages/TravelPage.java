package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class TravelPage extends BasePage {

    @FindBy(xpath = "//img[contains(@src, 'banner-zashita-traveler')]")//parent::a")
    WebElement sendButton;

    public TravelPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void goToBlanc(WebDriver driver, Set<String> oldWindowsSet){
        //driver.get(sendButton.getAttribute("href"));
        sendButton.click();
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

}
