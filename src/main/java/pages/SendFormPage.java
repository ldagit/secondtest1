package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendFormPage extends BasePage {

    @FindBy(xpath="//h3[contains(text(), 'Застрахованные')][contains(@class, 'b-form-section-title')]")
    WebElement titlePers;

    @FindBy(name = "insured0_surname")
    WebElement insured_surname;

    @FindBy(name = "insured0_name")
    WebElement insured_name;

    @FindBy(name = "insured0_birthDate")
    WebElement insured_birthDate;

    @FindBy(name = "surname")
    WebElement surname;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middlename;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "//h3[text()='Страхователь']")
    WebElement insurant;

    @FindBy(xpath = "//input[contains(@ng-model, 'DOCSERIES')]")
    WebElement docSeries;

    @FindBy(xpath = "//input[contains(@ng-model, 'DOCNUMBER')]")
    WebElement docNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(xpath = "//h3[text()='Данные паспорта РФ']")
    WebElement docData;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//span[text() ='Продолжить']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[contains(@ng-show, 'invalid')]")
    public WebElement errMessage;


    public SendFormPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(titlePers));

    }

    public void fillField (String fieldName, String value){
        FieldNames arg;
        arg = FieldNames.valueOf(fieldName);
        switch (arg) {
            case insured_surname:
                fillField(insured_surname, value);
                break;
            case insured_name:
                fillField(insured_name, value);
                break;
            case insured_birthDate:
                fillField(insured_birthDate, value);
                break;
            case surname:
                fillField(surname, value);
                break;
            case name:
                fillField(name, value);
                break;
            case middlename:
                fillField(middlename, value);
                break;
            case birthDate:
                fillField(birthDate, value);
                //insurant.click();
                break;
            case docSeries:
                fillField(docSeries, value);
                break;
            case docNumber:
                fillField(docNumber, value);
                break;
            case issueDate:
                fillField(issueDate, value);
                //docData.click();
                break;
            case issuePlace:
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице.");
        }
    }


    public void checkFillField(String fieldName, String value){
        FieldNames arg;
        arg = FieldNames.valueOf(fieldName);
        switch (arg) {
            case insured_surname:
                checkFillField(value, insured_surname);
                break;
            case insured_name:
                checkFillField(value, insured_name);
                break;
            case insured_birthDate:
                checkFillField(value, insured_birthDate);
                break;
            case surname:
                checkFillField(value, surname);
                break;
            case name:
                checkFillField(value, name);
                break;
            case middlename:
                checkFillField(value, middlename);
                break;
            case birthDate:
                checkFillField(value, birthDate);
                break;
            case docSeries:
                checkFillField(value, docSeries);
                break;
            case docNumber:
                checkFillField(value, docNumber);
                break;
            case issueDate:
                checkFillField(value, issueDate);
                break;
            case issuePlace:
                checkFillField(value, issuePlace);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице.");
        }
    }


    public void CheckAllFieldsFillingMessage(){

        if (errMessage.isDisplayed()){
            Assert.assertEquals("Заполнены не все обязательные поля", errMessage.getText());
        } else {
            throw new AssertionError("Все поля заполнены. Сообщения об ошибке нет.");
        }
    }

    /*public void checkFieldErrorMessage(String field, String errorMessage){
        String xpath = "//*[text()='"+field+"']/..//*[@class='validation-error-text']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }*/

    public enum FieldNames {
        insured_surname,
        insured_name,
        insured_birthDate,
        surname,
        name,
        middlename,
        birthDate,
        docSeries,
        docNumber,
        issueDate,
        issuePlace;
    }
}
