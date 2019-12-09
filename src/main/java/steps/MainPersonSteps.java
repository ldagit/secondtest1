package steps;

    import pages.MainPersonPage;
    import ru.yandex.qatools.allure.annotations.*;

public class MainPersonSteps extends BaseSteps {

    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPersonPage mainPersonPage = new MainPersonPage(driver);
        mainPersonPage.selectMainMenu(menuItem);

    }
    @Step("Выбран пункт меню {1}")
    public void stepSelectSubMenu(String menuItem){
        MainPersonPage mainPersonPage = new MainPersonPage(driver);
        mainPersonPage.selectSubMenu(menuItem);
    }

}
