package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class UserOverviewTest {
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
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Jos");
        userRegisterPage.setLastName("Josser");
        userRegisterPage.setEmail("jos.josser@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("alpha");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("User Overview", userOverviewPage.getTitle());

        userOverviewPage.edit("Jos");

        userOverviewPage.setFirstName("Walter");
        userOverviewPage.setLastName("White");
        userOverviewPage.setEmail("walter.white@hotmail.com");
        userOverviewPage.setRole("teamleader");
        userOverviewPage.setTeam("delta");

        userOverviewPage.submit();

        assertTrue(userOverviewPage.containsUserWithSpecified("Walter","walter.white@hotmail.com"));
        assertFalse(userOverviewPage.containsUserWithSpecified("Jos","jos.josser@hotmail.com"));
    }

    @Test
    public void test_Edit_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Nazrin");
        userRegisterPage.setLastName("Mouse");
        userRegisterPage.setEmail("nazrin.mouse@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("epsilon");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("User Overview", userOverviewPage.getTitle());

        userOverviewPage.edit("Nazrin");

        userOverviewPage.setFirstName("");
        userOverviewPage.setLastName("Ibuki");
        userOverviewPage.setEmail("suika.ibuki@hotmail.com");
        userOverviewPage.setRole("teamleader");
        userOverviewPage.setTeam("beta");

        userOverviewPage.submit();

        assertTrue(userRegisterPage.hasErrorMessage("No firstname given"));

        assertTrue(userRegisterPage.hasStickyFirstName("Nazrin"));
        assertTrue(userRegisterPage.hasStickyLastName("Mouse"));
        assertTrue(userRegisterPage.hasStickyEmail("nazrin.mouse@hotmail.com"));
        assertTrue(userRegisterPage.hasStickyRole("EMPLOYEE"));
        assertTrue(userRegisterPage.hasStickyTeam("EPSILON"));

        userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertTrue(userOverviewPage.containsUserWithSpecified("Nazrin","nazrin.mouse@hotmail.com"));
        assertFalse(userOverviewPage.containsUserWithSpecified("Suika","suika.ibuki@hotmail.com"));
    }

    @Test
    public void test_Edit_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Saul");
        userRegisterPage.setLastName("Goodman");
        userRegisterPage.setEmail("saul.goodman@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("delta");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("User Overview", userOverviewPage.getTitle());

        userOverviewPage.edit("Saul");

        userOverviewPage.setFirstName("Sol");
        userOverviewPage.setLastName("");
        userOverviewPage.setEmail("sol.badguy@hotmail.com");
        userOverviewPage.setRole("director");
        userOverviewPage.setTeam("beta");

        userOverviewPage.submit();

        assertTrue(userRegisterPage.hasErrorMessage("No last name given"));

        assertTrue(userRegisterPage.hasStickyFirstName("Saul"));
        assertTrue(userRegisterPage.hasStickyLastName("Goodman"));
        assertTrue(userRegisterPage.hasStickyEmail("saul.goodman@hotmail.com"));
        assertTrue(userRegisterPage.hasStickyRole("EMPLOYEE"));
        assertTrue(userRegisterPage.hasStickyTeam("DELTA"));

        userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);

        assertTrue(userOverviewPage.containsUserWithSpecified("Saul","saul.goodman@hotmail.com"));
        assertFalse(userOverviewPage.containsUserWithSpecified("Sol","sol.badguy@hotmail.com"));
    }

    @Test
    public void test_Edit_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Cirno");
        userRegisterPage.setLastName("Nineball");
        userRegisterPage.setEmail("cirno.nineball@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("gamma");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("User Overview", userOverviewPage.getTitle());

        userOverviewPage.edit("Cirno");

        userOverviewPage.setFirstName("Reimu");
        userOverviewPage.setLastName("Hakurei");
        userOverviewPage.setEmail("");
        userOverviewPage.setRole("director");
        userOverviewPage.setTeam("beta");

        userOverviewPage.submit();

        assertTrue(userRegisterPage.hasErrorMessage("No email given"));

        assertTrue(userRegisterPage.hasStickyFirstName("Cirno"));
        assertTrue(userRegisterPage.hasStickyLastName("Nineball"));
        assertTrue(userRegisterPage.hasStickyEmail("cirno.nineball@hotmail.com"));
        assertTrue(userRegisterPage.hasStickyRole("EMPLOYEE"));
        assertTrue(userRegisterPage.hasStickyTeam("GAMMA"));

        userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);

        assertTrue(userOverviewPage.containsUserWithSpecified("Cirno","cirno.nineball@hotmail.com"));
        assertFalse(userOverviewPage.containsUserWithSpecified("Reimu","reimu.hakurei@hotmail.com"));
    }

    @Test
    public void test_Delete_User_And_Confirm(){
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Astolfo");
        userRegisterPage.setLastName("Rider");
        userRegisterPage.setEmail("astolfo.rider@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("gamma");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);

        userOverviewPage.delete("Astolfo");
        assertEquals("Delete", userOverviewPage.getTitle());

        userOverviewPage.submitJa();

        assertFalse(userOverviewPage.containsUserWithSpecified("Astolfo","astolfo.rider@hotmail.com"));
    }

    @Test
    public void test_Delete_User_And_Cancel(){
        UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
        userRegisterPage.setFirstName("Mutsuki");
        userRegisterPage.setLastName("California");
        userRegisterPage.setEmail("mutsuki.california@hotmail.com");
        userRegisterPage.setPassword("1234");
        userRegisterPage.setTeam("gamma");

        userRegisterPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("User Overview", userOverviewPage.getTitle());

        userOverviewPage.delete("Mutsuki");
        assertEquals("Delete", userOverviewPage.getTitle());

        userOverviewPage.submitNee();

        assertTrue(userOverviewPage.containsUserWithSpecified("Mutsuki","mutsuki.california@hotmail.com"));
    }
}
