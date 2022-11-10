package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

public class ProjectOverviewTest {
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
    public void test_Edit_AllFieldsFilledInCorrectly_ProjectIsEdited() {
        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Mulu");
        projectRegisterPage.setStart("16102022");
        projectRegisterPage.setEnd("18102022");
        projectRegisterPage.setTeam("epsilon");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);
        assertEquals("Project Overview", projectOverviewPage.getTitle());
        assertTrue(projectOverviewPage.containsProject("Mulu"));

        projectOverviewPage.edit("Mulu");

        projectOverviewPage.setProjectName("Mili");
        projectOverviewPage.setStart("18012023");
        projectOverviewPage.setEnd("19012023");
        projectOverviewPage.setTeam("gamma");

        projectOverviewPage.submit();

        assertTrue(projectOverviewPage.containsProject("Mili"));
        assertFalse(projectOverviewPage.containsProject("Mulu"));
    }

    @Test
    public void test_Edit_ProjectNameNotFilledIn_ErrorMessageGivenForProjectNameAndOtherFieldsValueKept(){
        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Everest");
        projectRegisterPage.setStart("16102023");
        projectRegisterPage.setEnd("18102023");
        projectRegisterPage.setTeam("epsilon");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);
        assertEquals("Project Overview", projectOverviewPage.getTitle());
        assertTrue(projectOverviewPage.containsProject("Everest"));

        projectOverviewPage.edit("Everest");

        projectOverviewPage.setProjectName("");
        projectOverviewPage.setStart("16112023");
        projectOverviewPage.setEnd("18112023");
        projectOverviewPage.setTeam("beta");

        projectOverviewPage.submit();

        assertTrue(projectOverviewPage.hasErrorMessage("No project name given"));

        //assertTrue(projectOverviewPage.hasStickyStart("16102023"));
        //assertTrue(projectOverviewPage.hasStickyEnd("18102023"));
        //assertTrue(projectOverviewPage.hasStickyTeam("epsilon"));

        projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);
        assertTrue(projectOverviewPage.containsProject("Everest"));
    }

    @Test
    public void test_Delete_Project_And_Confirm(){
        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Discord");
        projectRegisterPage.setStart("16102023");
        projectRegisterPage.setEnd("18102023");
        projectRegisterPage.setTeam("epsilon");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);

        projectOverviewPage.delete("Discord");
        assertEquals("Delete", projectOverviewPage.getTitle());

        projectOverviewPage.submitJa();

        assertFalse(projectOverviewPage.containsProject("Discord"));
    }

    @Test
    public void test_Delete_Project_And_Cancel(){
        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Web");
        projectRegisterPage.setStart("16102023");
        projectRegisterPage.setEnd("18102023");
        projectRegisterPage.setTeam("epsilon");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);

        projectOverviewPage.delete("Web");
        assertEquals("Delete", projectOverviewPage.getTitle());

        projectOverviewPage.submitNee();

        assertTrue(projectOverviewPage.containsProject("Web"));
    }

    @Test
    public void test_Search_Project_And_Find(){
        ProjectRegisterPage projectRegisterPage = PageFactory.initElements(driver, ProjectRegisterPage.class);
        projectRegisterPage.setProjectName("Mash");
        projectRegisterPage.setStart("16102023");
        projectRegisterPage.setEnd("18102023");
        projectRegisterPage.setTeam("beta");

        projectRegisterPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);

        projectOverviewPage.submitSearch();

        projectOverviewPage.setProjectName("Mash");

        projectOverviewPage.submit();

        assertTrue(projectOverviewPage.hasSearchMessage("Name: Mash"));
        assertFalse(projectOverviewPage.hasSearchErrorMessage("We couldn't find that project"));
    }

    @Test
    public void test_Search_Project_And_Can_Not_Find(){
        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);

        projectOverviewPage.submitSearch();

        projectOverviewPage.setProjectName("Potato");

        projectOverviewPage.submit();

        assertFalse(projectOverviewPage.hasSearchMessage("Name: Potato"));
        assertTrue(projectOverviewPage.hasSearchErrorMessage("We couldn't find that project"));
    }
}
