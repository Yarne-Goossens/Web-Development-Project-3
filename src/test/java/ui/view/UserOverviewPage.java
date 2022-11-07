package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class UserOverviewPage extends Page {

    public UserOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Web3_war_exploded/Controller?command=UserOverview");
    }

    public boolean containsUserWithSpecified(String name, String spec) {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("tr"));
        boolean found = false;
        for (WebElement listItem : listItems) {
            if (listItem.getText().contains(name)) {
                listItems = (ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
                for (WebElement rowItem : listItems) {
                    if (rowItem.getText().contains(spec)) {
                        found = true;
                    }
                }
            }
        }
        return found;
    }

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "role")
    private WebElement roleField;

    @FindBy(id = "team")
    private WebElement teamField;

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

    public void setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setRole(String role) {
        Select dropdown = new Select(roleField);
        dropdown.selectByVisibleText(role);
    }

    public void setTeam(String team) {
        Select dropdown = new Select(teamField);
        dropdown.selectByVisibleText(team);
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

    public boolean hasErrorMessage(String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasStickyFirstName(String type) {
        return type.equals(firstNameField.getAttribute("value"));
    }

    public boolean hasStickyLastName(String type) {
        return type.equals(lastNameField.getAttribute("value"));
    }

    public boolean hasStickyEmail(String type) {
        return type.equals(emailField.getAttribute("value"));
    }

    public boolean hasStickyRole(String type) {
        return type.equals(roleField.getAttribute("value"));
    }

    public boolean hasStickyTeam(String type) {
        return type.equals(teamField.getAttribute("value"));
    }


    public boolean hasEmptyFirstName() {
        return firstNameField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyLastName() {
        return lastNameField.getAttribute("value").isEmpty();
    }

    public boolean hasEmptyEmail() {
        return emailField.getAttribute("value").isEmpty();
    }
}
