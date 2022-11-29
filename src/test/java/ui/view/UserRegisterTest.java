package ui.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
/* add dependency to your pom.xml 
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.0.0</version>
        </dependency>
*/

public class UserRegisterTest {
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
	public void test_Register_AllFieldsFilledInCorrectly_UserIsRegistered_and_RoleIsEmployee() {
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Jan");
		userRegisterPage.setLastName("Janssens");
		userRegisterPage.setEmail("jan.janssens@hotmail.com");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
		assertEquals("User Overview", userOverviewPage.getTitle());
		assertTrue(userOverviewPage.containsUserWithSpecified("Jan","EMPLOYEE"));
	}

	@Test
	public void test_Register_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("");
		userRegisterPage.setLastName("Janssens");
		userRegisterPage.setEmail("jan.janssens@hotmail.com");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		assertEquals("User Register", userRegisterPage.getTitle());
		assertTrue(userRegisterPage.hasEmptyFirstName());
		assertTrue(userRegisterPage.hasErrorMessage("No firstname given"));

		assertTrue(userRegisterPage.hasStickyLastName("Janssens"));
		assertTrue(userRegisterPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(userRegisterPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Jan");
		userRegisterPage.setLastName("");
		userRegisterPage.setEmail("jan.janssens@hotmail.com");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		assertEquals("User Register", userRegisterPage.getTitle());
		assertTrue(userRegisterPage.hasEmptyLastName());
		assertTrue(userRegisterPage.hasErrorMessage("No last name given"));

		assertTrue(userRegisterPage.hasStickyFirstName("Jan"));
		assertTrue(userRegisterPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(userRegisterPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Jan");
		userRegisterPage.setLastName("Janssens");
		userRegisterPage.setEmail("");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		assertEquals("User Register", userRegisterPage.getTitle());
		assertTrue(userRegisterPage.hasEmptyEmail());
		assertTrue(userRegisterPage.hasErrorMessage("No email given"));

		assertTrue(userRegisterPage.hasStickyFirstName("Jan"));
		assertTrue(userRegisterPage.hasStickyLastName("Janssens"));
		assertTrue(userRegisterPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_PasswordNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Jan");
		userRegisterPage.setLastName("Janssens");
		userRegisterPage.setEmail("jan.janssens@hotmail.com");
		userRegisterPage.setPassword("");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		assertEquals("User Register", userRegisterPage.getTitle());
		assertTrue(userRegisterPage.hasEmptyPassword());
		assertTrue(userRegisterPage.hasErrorMessage("No password given"));


		assertTrue(userRegisterPage.hasStickyFirstName("Jan"));
		assertTrue(userRegisterPage.hasStickyLastName("Janssens"));
		assertTrue(userRegisterPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(userRegisterPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_UserAlreadyExists_ErrorMessageGiven(){
		IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.setEmail("director@ucll.be");
		indexPage.setPassword("t");
		indexPage.submit();

		UserRegisterPage userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Pieter");
		userRegisterPage.setLastName("Pieters");
		userRegisterPage.setEmail("pieter.pieters@hotmail.com");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();

		userRegisterPage = PageFactory.initElements(driver, UserRegisterPage.class);
		userRegisterPage.setFirstName("Pieter");
		userRegisterPage.setLastName("Pieters");
		userRegisterPage.setEmail("pieter.pieters@hotmail.com");
		userRegisterPage.setPassword("1234");
		userRegisterPage.setTeam("alpha");

		userRegisterPage.add();


		assertEquals("User Register", userRegisterPage.getTitle());
		assertTrue(userRegisterPage.hasErrorMessage("No duplicate emails"));

		assertTrue(userRegisterPage.hasStickyFirstName("Pieter"));
		assertTrue(userRegisterPage.hasStickyLastName("Pieters"));
		assertTrue(userRegisterPage.hasStickyEmail("pieter.pieters@hotmail.com"));
		assertTrue(userRegisterPage.hasStickyTeam("alpha"));
	}
}
