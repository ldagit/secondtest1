package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPersonPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class, 'lg-menu__list')]")
    WebElement mainMenu;

    @FindBy(xpath = "//ul[contains(@aria-label,'Подменю')]")
    WebElement subMenu;

    public MainPersonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//button//*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String menuItem){
        mainMenu.findElement(By.xpath(".//li//*[text()='" + menuItem + "']")).click();
    }

}
