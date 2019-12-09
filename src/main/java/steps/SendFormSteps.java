package steps;

import pages.SendFormPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class SendFormSteps extends BaseSteps {

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new SendFormPage(driver).fillField(field, value);
    }

    @Step("заполняются поля")
    public void fillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("нажата кнопка Оформить")
    public void stepСontinueButton(){
        new SendFormPage(driver).continueButton.click();
    }

    @Step("проверка сообщений об ошибке")
    public void stepCheckAllFieldsFillingMessage(){
        new SendFormPage(driver).CheckAllFieldsFillingMessage();
    }



}
