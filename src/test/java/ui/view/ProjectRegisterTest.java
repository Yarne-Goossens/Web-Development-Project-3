package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectRegisterTest {
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
    public void test_Register_AllFieldsFilledInCorrectly_ProjectIsRegistered() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setEmail("teamleader@ucll.be");
        indexPage.setPassword("t");
        indexPage.submit();

        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Touhou");
        projectRegisterPage.setStart("01112022");
        projectRegisterPage.setEnd("10112022");
        projectRegisterPage.setTeam("gamma");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);
        assertEquals("Project Overview", projectOverviewPage.getTitle());
        assertTrue(projectOverviewPage.containsProject("Touhou"));
    }

    @Test
    public void test_Register_ProjectNameNotFilledIn_ErrorMessageGivenForProjectNameAndOtherFieldsValueKept(){
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setEmail("teamleader@ucll.be");
        indexPage.setPassword("t");
        indexPage.submit();

        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("");
        projectRegisterPage.setStart("01112022");
        projectRegisterPage.setEnd("10112022");
        projectRegisterPage.setTeam("beta");

        projectRegisterPage.add();

        assertEquals("Project Register", projectRegisterPage.getTitle());
        assertTrue(projectRegisterPage.hasEmptyProjectName());
        assertTrue(projectRegisterPage.hasErrorMessage("No project name given"));

        assertTrue(projectRegisterPage.hasStickyStart("2022-01-11"));
        assertTrue(projectRegisterPage.hasStickyEnd("2022-10-11"));
        assertTrue(projectRegisterPage.hasStickyTeam("beta"));
    }
}
