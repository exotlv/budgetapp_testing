package lv.vsikhvart.cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import lv.vsikhvart.cucumber.config.ApplicationProperties;
import lv.vsikhvart.cucumber.enums.CategorySelector;
import lv.vsikhvart.cucumber.pageobjects.BudgetingAppPage;
import lv.vsikhvart.cucumber.pageobjects.Budget;
import lv.vsikhvart.cucumber.pageobjects.Reports;
import lv.vsikhvart.cucumber.util.TestDataContext;

import static lv.vsikhvart.cucumber.config.ApplicationProperties.ApplicationProperty.TEST_DATA;
import static lv.vsikhvart.cucumber.config.ApplicationProperties.ApplicationProperty.VALUE_DATA;

public class CommonSteps {
    private BudgetingAppPage BudgetingAppPage;
    private Budget budget;
    private Reports reports;
    private TestDataContext testDataContext = TestDataContext.getInstance();

    @Given("^open Budgeting App web$")
    public void openBudgetAppweb() throws Throwable {
      BudgetingAppPage = BudgetingAppPage.navigate();
        budget = new Budget();
    }


    @When("^page is loaded - check navigation buttons$")
    public void pageNavigationbuttons() throws Throwable {
        budget = new Budget();
        budget.checkMenu();
    }

    @And("^open Reports page$")
    public void openReportsPage() throws Throwable {
        reports = new Reports();
        reports.reportsPage();
    }

    @And("^check that Reports page contain 2 Panels$")
    public void checkReportspageforTwoPanels() throws Throwable {
        reports.reportsPagePanels();
  }

    @And("^check that Budget grid exist and contains 3 elements$")
    public void navigationUserLogsOut() throws Throwable {
        budget.budgetGrid();
    }

    @And("^check Balance Container$")
    public void checkBalanceContainer() throws Throwable {
        budget.balanceContainer();
    }

    @And("^check active fields for adding in budget changes$")
    public void checkActiveFields() throws Throwable {
        budget.activeFields();
    }

    @And("^click on category selector and choose inflow category (Income|Outcome)$")
    public void chooseInflowCategory(String categoryId) throws Throwable {
        budget.chooseCategoryId(CategorySelector.valueOf(categoryId));

    }

    @And("^click on category field$")
    public void chooseCategoryField() throws Throwable {
        budget.chooseCategoryField();
        budget = new Budget();

    }

    @And("^click on description field and enter \"Test\"$")
    public void clickDescriptionFieldAndEnterText() throws Throwable {
        budget.descriptionField(ApplicationProperties.getString(TEST_DATA));

    }

    @And("^enter value 100$")
    public void enterValueHundred() throws Throwable {
        budget.valueField(ApplicationProperties.getString(VALUE_DATA));

  }
    @And("^click on Add button$")
    public void clickAddButton() throws Throwable {
        budget.clickAddButton();

  }

    @And("^store Total Inflow sum$")
    public void storeTotalInflow(String totalInflow) throws Throwable {
        String inflowSum = budget.getTotalInflow();
        testDataContext.getTestDataMap().put(totalInflow, () -> inflowSum);

  }
}
