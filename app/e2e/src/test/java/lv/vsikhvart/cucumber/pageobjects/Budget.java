package lv.vsikhvart.cucumber.pageobjects;


import lv.vsikhvart.cucumber.core.WebElementHelper;
import lv.vsikhvart.cucumber.enums.CategorySelector;
import lv.vsikhvart.cucumber.pageobjects.base.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Budget extends Page {

    @FindBy(xpath = "//*[contains(@class,'components-Header-style__navLink') and contains(text(),'Budget')]")
    private WebElement budget;

    @FindBy(xpath = "//*[contains(@class,'components-Header-style__navLink') and contains(text(),'Reports')]")
    private WebElement reports;

    @FindBy(css = ".containers-BudgetGrid-style__budgetGrid")
    private WebElement budgetGrid;

    @FindBy(xpath = "//th[contains(text(),'Category')]")
    private WebElement category;

    @FindBy(xpath = "//th[contains(text(),'Description')]")
    private WebElement description;

    @FindBy(xpath = "//th[contains(text(),'Amount')]")
    private WebElement amount;

    @FindBy(css = ".containers-BudgetGrid-style__budgetGrid")
     private WebElement balanceContainer;

    @FindBy(xpath = "//*[contains(@class,'components-Balance-style__balanceTitle') and contains(text(),'Total Inflow')]")
    private WebElement inflow;

    @FindBy(xpath = "//*[contains(@class,'components-Balance-style__balanceTitle') and contains(text(),'Total Outflow')]")
    private WebElement outflow;

    @FindBy(xpath = "//*[contains(@class,'components-Balance-style__balanceTitle') and contains(text(),'Working Balance')]")
    private WebElement workingBalance;

    @FindBy(css = ".containers-EntryFormRow-style__formSection [name='categoryId']")
    private WebElement categorySelectors;

    @FindBy(css = ".containers-EntryFormRow-style__formSection [name='description']")
    private WebElement descriptionField;

    @FindBy(css = ".containers-EntryFormRow-style__formSection [name='value']")
    private WebElement valueField;

    @FindBy(css = ".containers-EntryFormRow-style__formSection button[type='submit']")
    private WebElement addButton;

    @FindBy(css = ".containers-EntryFormRow-style__formSection button[type='submit']:disabled")
    private WebElement addButtonDisabled;

    @FindBy(css = ".components-Balance-style__balanceAmount components-Balance-style__pos")
    private WebElement inflowSum;

    public Budget() {
        wait.until(ExpectedConditions.visibilityOf(budget));
    }

    public void checkMenu() {
        WebElementHelper.click(reports);
        WebElementHelper.click(budget);
    }

    public void budgetGrid() {
      wait.until(ExpectedConditions.visibilityOf(budgetGrid));
      WebElementHelper.waitForVisibility(category);
      WebElementHelper.waitForVisibility(description);
      WebElementHelper.waitForVisibility(amount);
  }

    public void balanceContainer() {
      wait.until(ExpectedConditions.visibilityOf(balanceContainer));
      WebElementHelper.waitForVisibility(inflow);
      WebElementHelper.waitForVisibility(outflow);
      WebElementHelper.waitForVisibility(workingBalance);
  }

    public void activeFields() {
      wait.until(ExpectedConditions.visibilityOf(budgetGrid));
      WebElementHelper.waitForVisibility(categorySelectors);
      WebElementHelper.waitForVisibility(descriptionField);
      WebElementHelper.waitForVisibility(valueField);
  }

    public void chooseCategoryField () {
      WebElementHelper.waitForVisibility(categorySelectors);
      WebElementHelper.click(categorySelectors);
    }

    public void descriptionField (String text) {
      WebElementHelper.waitForVisibility(descriptionField);
      WebElementHelper.click(descriptionField);
      WebElementHelper.sendKeys(descriptionField, text);
  }

    public void valueField (String value) {
      WebElementHelper.waitForVisibility(valueField);
      WebElementHelper.click(valueField);
      WebElementHelper.sendKeys(valueField, value);
  }

    public void clickAddButton () {
      WebElementHelper.waitForVisibility(addButton);
      WebElementHelper.waitForElementToBeClickable(addButton);
      WebElementHelper.click(addButton);
  }

    public Budget chooseCategoryId(CategorySelector categorySelector) {
      WebElementHelper.selectByValue(categorySelectors, categorySelector.toString());
      return this;
  }

    public String getTotalInflow () {
      return WebElementHelper.getText(inflowSum);
    }
}
