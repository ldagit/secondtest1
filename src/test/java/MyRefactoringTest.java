import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPersonPage;
import pages.SendFormPage;
import pages.TravelIsurancePage;
import pages.TravelPage;

import java.util.Set;

public class MyRefactoringTest extends BaseTest {

    @Test
    public void newInsuranceTest(){
        driver.get(baseUrl);
        MainPersonPage mainPersonPage = new MainPersonPage(driver);
        mainPersonPage.selectMainMenu("Страхование");
        mainPersonPage.selectSubMenu("Страхование путешественников");

        TravelPage travelPage = new TravelPage(driver);
        Set<String> oldWindowsSet = driver.getWindowHandles();
        travelPage.goToBlanc(driver, oldWindowsSet);


        TravelIsurancePage travelIsurancePage = new TravelIsurancePage(driver);
        Assert.assertEquals("Выбор полиса", travelIsurancePage.titlePolice.getText());

        travelIsurancePage.insuranceType.click();
        travelIsurancePage.issueButton.click();

        SendFormPage sendFormPage = new SendFormPage(driver);
        //Заполнение полей
        sendFormPage.fillField("insured_surname", "Petrova");
        sendFormPage.fillField("insured_name", "Marija");
        sendFormPage.fillField("insured_birthDate", "12052014");
        sendFormPage.fillField("surname", "Петров");
        sendFormPage.fillField("name", "Петр");
        sendFormPage.fillField("middlename", "Петрович");
        sendFormPage.fillField("birthDate", "06071997");
        sendFormPage.fillField("docSeries", "0607");
        sendFormPage.fillField("docNumber", "236755");
        sendFormPage.fillField("issueDate", "25072019");
        sendFormPage.fillField("issuePlace", "Какой-то УВД г.Москвы");

        //Проверка заполнения
        sendFormPage.checkFillField("insured_surname", "Petrova");
        sendFormPage.checkFillField("insured_name", "Marija");
        //String Str = sendFormPage.getIssueDate();
        sendFormPage.checkFillField("insured_birthDate", "12.05.2014");
        sendFormPage.checkFillField("surname", "Петров");
        sendFormPage.checkFillField("name", "Петр");
        sendFormPage.checkFillField("middlename", "Петрович");
        sendFormPage.checkFillField("birthDate", "06.07.1997");
        sendFormPage.checkFillField("docSeries", "0607");
        sendFormPage.checkFillField("docNumber", "236755");
        sendFormPage.checkFillField("issueDate", "25.07.2019");
        sendFormPage.checkFillField("issuePlace", "Какой-то УВД г.Москвы");

        sendFormPage.continueButton.click();

        //проверка сообщения об ошибке
        sendFormPage.CheckAllFieldsFillingMessage();

    }
}
