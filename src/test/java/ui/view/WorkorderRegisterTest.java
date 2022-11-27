package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WorkorderRegisterTest {
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
    public void test_Register_AllFieldsFilledInCorrectly_WorkorderIsRegistered() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setEmail("director@ucll.be");
        indexPage.setPassword("t");
        indexPage.submit();

        WorkorderRegisterPage workorderRegisterPage = PageFactory.initElements(driver, WorkorderRegisterPage.class);
        workorderRegisterPage.setDate("01112023");
        workorderRegisterPage.setStart("080000");
        workorderRegisterPage.setEnd("090000");
        workorderRegisterPage.setDescription("Lorem ipsum");
        workorderRegisterPage.submit();

        WorkorderOverviewPage workorderOverviewPage = PageFactory.initElements(driver, WorkorderOverviewPage.class);
        assertEquals("Work Overview", workorderRegisterPage.getTitle());
        assertTrue(workorderOverviewPage.containsWorkorder("Lorem ipsum"));
    }

    @Test
    public void test_Register_DescriptionNotFilledIn_ErrorMessageGivenForDescriptionAndOtherFieldsValueKept(){
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setEmail("teamleader@ucll.be");
        indexPage.setPassword("t");
        indexPage.submit();

        WorkorderRegisterPage workorderRegisterPage = PageFactory.initElements(driver, WorkorderRegisterPage.class);
        workorderRegisterPage.setDate("01112022");
        workorderRegisterPage.setStart("080000");
        workorderRegisterPage.setEnd("180000");
        workorderRegisterPage.setDescription("");

        workorderRegisterPage.hasErrorMessage("No description given");

        workorderRegisterPage.hasStickyDate("01112022");
        workorderRegisterPage.hasStickyStart("080000");
        workorderRegisterPage.hasStickyEnd("180000");
    }
}
