package ui.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.PageFactory;
/* add dependency to your pom.xml 
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.0.0</version>
        </dependency>
*/

public class RegisterTest {
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
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
		assertEquals("Users", overviewPage.getTitle());
		assertTrue(overviewPage.containsUserWithSpecified("Jan","EMPLOYEE"));
	}

	@Test
	public void test_Register_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyFirstName());
		assertTrue(registerPage.hasErrorMessage("No firstname given"));

		assertTrue(registerPage.hasStickyLastName("Janssens"));
		assertTrue(registerPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(registerPage.hasStickyRole("employee"));
		assertTrue(registerPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyLastName());
		assertTrue(registerPage.hasErrorMessage("No last name given"));

		assertTrue(registerPage.hasStickyFirstName("Jan"));
		assertTrue(registerPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(registerPage.hasStickyRole("employee"));
		assertTrue(registerPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyEmail());
		assertTrue(registerPage.hasErrorMessage("No email given"));

		assertTrue(registerPage.hasStickyFirstName("Jan"));
		assertTrue(registerPage.hasStickyLastName("Janssens"));
		assertTrue(registerPage.hasStickyRole("employee"));
		assertTrue(registerPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_PasswordNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyPassword());
		assertTrue(registerPage.hasErrorMessage("No password given"));


		assertTrue(registerPage.hasStickyFirstName("Jan"));
		assertTrue(registerPage.hasStickyLastName("Janssens"));
		assertTrue(registerPage.hasStickyEmail("jan.janssens@hotmail.com"));
		assertTrue(registerPage.hasStickyRole("employee"));
		assertTrue(registerPage.hasStickyTeam("alpha"));
	}

	@Test
	public void test_Register_UserAlreadyExists_ErrorMessageGiven(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Pieter");
		registerPage.setLastName("Pieters");
		registerPage.setEmail("pieter.pieters@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();

		registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Pieter");
		registerPage.setLastName("Pieters");
		registerPage.setEmail("pieter.pieters@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("employee");
		registerPage.setTeam("alpha");

		registerPage.add();


		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasErrorMessage("No duplicate emails"));

		assertTrue(registerPage.hasStickyFirstName("Pieter"));
		assertTrue(registerPage.hasStickyLastName("Pieters"));
		assertTrue(registerPage.hasStickyEmail("pieter.pieters@hotmail.com"));
		assertTrue(registerPage.hasStickyRole("employee"));
		assertTrue(registerPage.hasStickyTeam("alpha"));
	}
}
