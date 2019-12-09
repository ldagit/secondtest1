import org.junit.Assert;
import org.junit.Test;
import pages.MainPersonPage;
import pages.SendFormPage;
import pages.TravelIsurancePage;
import pages.TravelPage;
import steps.*;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class MyRefactoringTest extends BaseSteps {
    //protected static final File DEFAULT_RESULTS_DIRECTORY = new File("target/site/allure-results");

    @Test
    public void newInsuranceTest(){
        driver.get(baseUrl);
        MainPersonSteps mainPersonSteps = new MainPersonSteps();
        mainPersonSteps.stepSelectMainMenu("Страхование");
        mainPersonSteps.stepSelectSubMenu("Страхование путешественников");

        TravelSteps travelSteps = new TravelSteps();
        travelSteps.stepGoToBlank();

        TravelInsuranceSteps travelInsuranceSteps = new TravelInsuranceSteps();
        travelInsuranceSteps.stepCheckPageTitle("Выбор полиса");
        travelInsuranceSteps.stepSelectInsuranceType();
        travelInsuranceSteps.stepIssueButtonClick();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("insured_surname", "Petrova");
        testData.put("insured_name", "Marija");
        testData.put("insured_birthDate", "12052014");
        testData.put("surname", "Петров");
        testData.put("middlename", "Петрович");
        testData.put("birthDate", "06071997");
        testData.put("docSeries", "0607");
        testData.put("docNumber", "236755");
        testData.put("issueDate", "25072019");
        testData.put("issuePlace", "Какой-то УВД г.Москвы");

        SendFormSteps sendFormSteps = new SendFormSteps();

        sendFormSteps.fillFields(testData);
        sendFormSteps.stepСontinueButton();
        sendFormSteps.stepCheckAllFieldsFillingMessage();

        /*MainPersonPage mainPersonPage = new MainPersonPage(driver);
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
        sendFormPage.CheckAllFieldsFillingMessage();*/

    }
}
