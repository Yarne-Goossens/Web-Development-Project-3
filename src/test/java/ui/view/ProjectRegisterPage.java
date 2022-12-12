package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProjectRegisterPage extends Page {

    public ProjectRegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Controller?command=ProjectRegister");
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


    public void add() {
        submitButton.click();
    }


    public boolean hasErrorMessage(String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
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

