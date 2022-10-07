package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class OverviewTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Edit_AllFieldsFilledInCorrectly_UserIsEdited() {
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setFirstName("Jos");
        registerPage.setLastName("Josser");
        registerPage.setEmail("jos.josser@hotmail.com");
        registerPage.setPassword("1234");
        registerPage.setRole("employee");
        registerPage.setTeam("alpha");

        registerPage.add();

        OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Users", overviewPage.getTitle());

        overviewPage.edit("Jos");

        overviewPage.setFirstName("Walter");
        overviewPage.setLastName("White");
        overviewPage.setEmail("walter.white@hotmail.com");
        overviewPage.setRole("teamleader");
        overviewPage.setTeam("delta");

        overviewPage.submit();

        assertTrue(overviewPage.containsUserWithSpecified("Walter","walter.white@hotmail.com"));
        assertFalse(overviewPage.containsUserWithSpecified("Jos","jos.josser@hotmail.com"));
    }

    @Test
    public void test_Edit_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setFirstName("Nazrin");
        registerPage.setLastName("Mouse");
        registerPage.setEmail("nazrin.mouse@hotmail.com");
        registerPage.setPassword("1234");
        registerPage.setRole("teamleader");
        registerPage.setTeam("epsilon");

        registerPage.add();

        OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Users", overviewPage.getTitle());

        overviewPage.edit("Nazrin");

        overviewPage.setFirstName("");
        overviewPage.setLastName("Ibuki");
        overviewPage.setEmail("suika.ibuki@hotmail.com");
        overviewPage.setRole("employee");
        overviewPage.setTeam("beta");

        overviewPage.submit();

        assertTrue(registerPage.hasErrorMessage("No firstname given"));

        overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertTrue(overviewPage.containsUserWithSpecified("Nazrin","nazrin.mouse@hotmail.com"));
        assertFalse(overviewPage.containsUserWithSpecified("Suika","suika.ibuki@hotmail.com"));
    }

    @Test
    public void test_Edit_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setFirstName("Saul");
        registerPage.setLastName("Goodman");
        registerPage.setEmail("saul.goodman@hotmail.com");
        registerPage.setPassword("1234");
        registerPage.setRole("teamleader");
        registerPage.setTeam("delta");

        registerPage.add();

        OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Users", overviewPage.getTitle());

        overviewPage.edit("Saul");

        overviewPage.setFirstName("Sol");
        overviewPage.setLastName("");
        overviewPage.setEmail("sol.badguy@hotmail.com");
        overviewPage.setRole("employee");
        overviewPage.setTeam("beta");

        overviewPage.submit();

        assertTrue(registerPage.hasErrorMessage("No lastname given"));
        assertTrue(overviewPage.containsUserWithSpecified("Saul","saul.goodman@hotmail.com"));
        assertFalse(overviewPage.containsUserWithSpecified("Sol","sol.badguy@hotmail.com"));
    }

    @Test
    public void test_Edit_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setFirstName("Cirno");
        registerPage.setLastName("Nineball");
        registerPage.setEmail("cirno.nineball@hotmail.com");
        registerPage.setPassword("1234");
        registerPage.setRole("director");
        registerPage.setTeam("gamma");

        registerPage.add();

        OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
        assertEquals("Users", overviewPage.getTitle());

        overviewPage.edit("Cirno");

        overviewPage.setFirstName("Reimu");
        overviewPage.setLastName("Hakurei");
        overviewPage.setEmail("reimu.hakurei@hotmail.com");
        overviewPage.setRole("employee");
        overviewPage.setTeam("beta");

        overviewPage.submit();

        assertTrue(registerPage.hasErrorMessage("No email given"));
        assertTrue(overviewPage.containsUserWithSpecified("Cirno","cirno.nineball@hotmail.com"));
        assertFalse(overviewPage.containsUserWithSpecified("Reimu","reimu.hakurei@hotmail.com"));
    }
}
