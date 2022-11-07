package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ProjectOverviewPage extends Page {


    public ProjectOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Web3_war_exploded/Controller?command=ProjectOverview");
    }

    public boolean containsProject(String name) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                found = true;
            }
        }
        return found;
    }

    @FindBy(id = "projectName")
    private WebElement projectNameField;

    @FindBy(id = "team")
    private WebElement teamField;

    @FindBy(id = "start")
    private WebElement startField;

    @FindBy(id = "end")
    private WebElement endField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(id = "submitJa")
    private WebElement submitJaButton;

    @FindBy(id = "submitNee")
    private WebElement submitNeeButton;

    @FindBy(id = "search")
    private WebElement searchButton;

    public void setProjectName(String projectName) {
        projectNameField.clear();
        projectNameField.sendKeys(projectName);
    }

    public void setTeam(String team) {
        Select dropdown = new Select(teamField);
        dropdown.selectByVisibleText(team);
    }

    public void setStart(String start) {
        startField.clear();
        startField.sendKeys(start);
    }

    public void setEnd(String end) {
        endField.clear();
        endField.sendKeys(end);
    }

    public void edit(String name) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                editButton = listItem.findElement(By.id("edit"));
                editButton.click();
                break;
            }
        }
    }

    public void delete(String name) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                deleteButton = listItem.findElement(By.id("delete"));
                deleteButton.click();
                break;
            }
        }
    }

    public void submit() {
        submitButton.click();
    }

    public void submitJa() {
        submitJaButton.click();
    }

    public void submitNee() {
        submitNeeButton.click();
    }

    public void submitSearch() {
        searchButton.click();
    }

    public boolean hasErrorMessage(String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasSearchMessage(String message) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("ul li"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(message)) {
                found = true;
            }
        }
        return found;
    }

    public boolean hasSearchErrorMessage(String message) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("p"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(message)) {
                found = true;
            }
        }
        return found;
    }

    public boolean hasStickyProjectName(String type) {
        return type.equals(projectNameField.getAttribute("value"));
    }

    public boolean hasStickyTeam(String type) {
        return type.equals(teamField.getAttribute("value"));
    }

    public boolean hasStickyStart(String type) {
        return type.equals(startField.getAttribute("value"));
    }

    public boolean hasStickyEnd(String type) {
        return type.equals(endField.getAttribute("value"));
    }


    public boolean hasEmptyProjectName() {
        return projectNameField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyStart() {
        return startField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyEnd() {
        return endField.getAttribute("value").isEmpty();
    }
}
