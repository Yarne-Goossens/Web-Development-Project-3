package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class WorkorderRegisterPage extends Page {
    public WorkorderRegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Web3_war_exploded/Controller?command=WorkorderRegister");
    }

    public boolean containsWorkorderWithDescription(String description) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(description)) {
                found = true;
            }
        }
        return found;
    }

    @FindBy(id = "employee")
    private WebElement employeeField;

    @FindBy(id = "team")
    private WebElement teamField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(id = "date")
    private WebElement dateField;

    @FindBy(id = "startTime")
    private WebElement startField;

    @FindBy(id = "endTime")
    private WebElement endField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public void setEmployee(String employee) {
        employeeField.clear();
        employeeField.sendKeys(employee);
    }

    public void setTeam(String team) {
        teamField.clear();
        teamField.sendKeys(team);
    }

    public void setDescription(String description) {
        descriptionField.clear();
        descriptionField.sendKeys(description);
    }

    public void setDate(String date) {
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void setStart(String start) {
        startField.clear();
        startField.sendKeys(start);
    }

    public void setEnd(String end) {
        endField.clear();
        endField.sendKeys(end);
    }


    public void submit() {
        submitButton.click();
    }


    public boolean hasErrorMessage(String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasStickyDescription(String type) {
        return type.equals(descriptionField.getAttribute("value"));
    }

    public boolean hasStickyDate(String type) {
        System.out.println(dateField.getAttribute("value"));
        return type.equals(dateField.getAttribute("value"));
    }

    public boolean hasStickyStart(String type) {
        System.out.println(startField.getAttribute("value"));
        return type.equals(startField.getAttribute("value"));
    }

    public boolean hasStickyEnd(String type) {
        System.out.println(endField.getAttribute("value"));
        return type.equals(endField.getAttribute("value"));
    }


    public boolean hasEmptyEmployee() {
        return employeeField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyDescription() {
        return descriptionField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyDate() {
        return dateField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyStart() {
        return startField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyEnd() {
        return endField.getAttribute("value").isEmpty();
    }
}
