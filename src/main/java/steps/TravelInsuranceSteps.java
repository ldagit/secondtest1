package steps;

import pages.TravelIsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class TravelInsuranceSteps extends BaseSteps {

    @Step("Выбран тип стрaховки")
    public void stepSelectInsuranceType(){
        new TravelIsurancePage(driver).insuranceType.click();
    }


    @Step("Заголовок страницы - Выбор полиса равен {0}")
    public void stepCheckPageTitle(String expectedTitle){
        String actualTitle = new TravelIsurancePage(driver).titlePolice.getText(); //title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажата кнопка Оформить")
    public void stepIssueButtonClick(){
        new TravelIsurancePage(driver).issueButton.click();
    }
}
