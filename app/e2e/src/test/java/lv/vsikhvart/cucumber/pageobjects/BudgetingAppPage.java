package lv.vsikhvart.cucumber.pageobjects;


import lv.vsikhvart.cucumber.config.ApplicationProperties;
import lv.vsikhvart.cucumber.core.WebElementHelper;
import lv.vsikhvart.cucumber.pageobjects.base.Page;

import static lv.vsikhvart.cucumber.config.ApplicationProperties.ApplicationProperty.APP_URL;

public class BudgetingAppPage extends Page {

    public static BudgetingAppPage navigate() {
        WebElementHelper.navigateToPage(ApplicationProperties.getString(APP_URL));
        return new BudgetingAppPage();
    }

}
