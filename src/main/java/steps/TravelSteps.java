package steps;

import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.*;

import java.util.Set;

public class TravelSteps extends BaseSteps {

    @Step("Нажата кнопка Оформить онлайн")
    public void stepGoToBlank(){
        TravelPage travelPage = new TravelPage(driver);
        Set<String> oldWindowsSet = driver.getWindowHandles();
        travelPage.goToBlanc(driver, oldWindowsSet);
    }


}
