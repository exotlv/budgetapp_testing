package lv.vsikhvart.cucumber.pageobjects;


import lv.vsikhvart.cucumber.core.WebElementHelper;
import lv.vsikhvart.cucumber.pageobjects.base.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lv.vsikhvart.cucumber.core.DriverBase.getDriver;

public class Reports extends Page {

    @FindBy(xpath = "//*[contains(@class,'components-ReportsPanel-style__navLink') and contains(text(),'Inflow vs Outflow')]")
    private WebElement reportPanelInflow;

    @FindBy(xpath = "//*[contains(@class,'components-ReportsPanel-style__navLink') and contains(text(),'Spending by Category')]")
    private WebElement reportPanelCategory;

    @FindBy(xpath = "//*[contains(@class,'components-Header-style__navLink') and contains(text(),'Reports')]")
    private WebElement reports;

    @FindBy(css = ".components-ReportsPanel-style__tabbar")
    private WebElement reportsTabbar;

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

    @FindBy(xpath = "//*[contains(@class,'components-Balance-style__balanceTitle') and contains(text(),'Working Balances')]")
    private WebElement workingBalance;

    private WebElement getLanguageElement(String language) {
        return getDriver().findElement(By.xpath("//*[@id='langmenu']//a[text()='" + language + "']"));
    }

    public void reportsPage() {
      WebElementHelper.click(reports);
  }

    public void reportsPagePanels() {
      wait.until(ExpectedConditions.visibilityOf(reportsTabbar));
      WebElementHelper.waitForVisibility(reportPanelInflow);
      WebElementHelper.waitForVisibility(reportPanelCategory);
  }

    public Reports switchLanguage(String language) {
        WebElement element = getLanguageElement(language);

        String elementState = WebElementHelper.getAttribute(element, "class");
        if (!elementState.equals("active")) {
            WebElementHelper.click(element);
        }

        return this;
    }
}
