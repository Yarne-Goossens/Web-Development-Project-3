
package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends Page {

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

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL + "Web3_war_exploded/Controller?command=Register");
    }

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

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void add() {
        submitButton.click();
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

    public boolean hasEmptyPassword() {
        return passwordField.getAttribute("value").isEmpty();
    }


}


