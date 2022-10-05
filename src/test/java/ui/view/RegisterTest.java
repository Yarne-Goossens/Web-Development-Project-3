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
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		OverviewPage overviewPage = PageFactory.initElements(driver, OverviewPage.class);
		assertEquals("Users", overviewPage.getTitle());
		assertTrue(overviewPage.containsUserWithName("Jan"));
		assertTrue(overviewPage.containsUserWithRole("Jan","EMPLOYEE"));
	}

	@Test
	public void test_Register_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyFirstName());
		assertTrue(registerPage.hasErrorMessage("No firstname given"));
		/***
		 *
		 * checken of data in fields blijft
		 *
		 * ***/
	}

	@Test
	public void test_Register_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyLastName());
		assertTrue(registerPage.hasErrorMessage("No last name given"));
		/***
		 *
		 * checken of data in fields blijft
		 *
		 * ***/
	}

	@Test
	public void test_Register_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("");
		registerPage.setPassword("1234");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyEmail());
		assertTrue(registerPage.hasErrorMessage("No email given"));
		/***
		 *
		 * checken of data in fields blijft
		 *
		 * ***/
	}

	@Test
	public void test_Register_PasswordNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Jan");
		registerPage.setLastName("Janssens");
		registerPage.setEmail("jan.janssens@hotmail.com");
		registerPage.setPassword("");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasEmptyPassword());
		assertTrue(registerPage.hasErrorMessage("No password given"));
		/***
		 *
		 * checken of data in fields blijft
		 *
		 * ***/
	}

	@Test
	public void test_Register_UserAlreadyExists_ErrorMessageGiven(){
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		registerPage.setFirstName("Pieter");
		registerPage.setLastName("Pieters");
		registerPage.setEmail("pieter.pieters@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();

		/***
		 *
		 * dupe werkt nog niet
		 * moet terug gaan naar register maar blijft op overview
		 *
		 * ***/
		registerPage.setFirstName("Pieter");
		registerPage.setLastName("Pieters");
		registerPage.setEmail("pieter.pieters@hotmail.com");
		registerPage.setPassword("1234");
		registerPage.setRole("user");
		registerPage.setTeam("alpha");

		registerPage.add();


		assertEquals("Register", registerPage.getTitle());
		assertTrue(registerPage.hasErrorMessage("No duplicate emails"));
		/***
		 *
		 * checken of data in fields blijft
		 *
		 * ***/
	}

	/*@Test
	public void test_Register_AllFieldsFilledInCorrectly_UserIsRegistered_and_RoleIsEmployee() {
		submitForm("Jan", "Janssens", "jan.janssens@hotmail.com" , "1234");

		String title = driver.getTitle();
		assertEquals("Overview",title);

		driver.get(path+"?command=Overview");

		ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr"));
		boolean found=false;
		for (WebElement listItem:listItems) {
				if (listItem.getText().contains("jan.janssens@hotmail.com") &&  listItem.getText().contains(" Jan Janssens") && listItem.getText().contains("employee")) {
				    found=true;
			}
		}
		assertTrue(found);
	}

	
	@Test
	public void test_Register_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept(){
		submitForm("", "Janssens", "jan.janssens@hotmail.com", "1234");
		
		String title = driver.getTitle();
		assertEquals("Register",title);
		
		WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
		assertEquals("No firstname given", errorMsg.getText());

		WebElement fieldFirstName=driver.findElement(By.id("firstName"));
		assertEquals("",fieldFirstName.getAttribute("value"));
		
		WebElement fieldLastName=driver.findElement(By.id("lastName"));
		assertEquals("Janssens",fieldLastName.getAttribute("value"));
		
		WebElement fieldEmail=driver.findElement(By.id("email"));
		assertEquals("jan.janssens@hotmail.com",fieldEmail.getAttribute("value"));
	}

	@Test
	public void test_Register_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept(){
		submitForm("Jan", "", "jan.janssens@hotmail.com", "1234");
		
		String title = driver.getTitle();
		assertEquals("Sign Up",title);
		
		WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
		assertEquals("No last name given", errorMsg.getText());

		WebElement fieldFirstName=driver.findElement(By.id("firstName"));
		assertEquals("Jan",fieldFirstName.getAttribute("value"));
		
		WebElement fieldLastName=driver.findElement(By.id("lastName"));
		assertEquals("",fieldLastName.getAttribute("value"));
		
		WebElement fieldEmail=driver.findElement(By.id("email"));
		assertEquals("jan.janssens@hotmail.com",fieldEmail.getAttribute("value"));
	}

	@Test
	public void test_Register_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		submitForm("Jan", "Janssens", "", "1234");
		
		String title = driver.getTitle();
		assertEquals("Sign Up",title);

		WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
		assertEquals("No email given", errorMsg.getText());

		WebElement fieldFirstName=driver.findElement(By.id("firstName"));
		assertEquals("Jan",fieldFirstName.getAttribute("value"));
		
		WebElement fieldLastName=driver.findElement(By.id("lastName"));
		assertEquals("Janssens",fieldLastName.getAttribute("value"));
		
		WebElement fieldEmail=driver.findElement(By.id("email"));
		assertEquals("",fieldEmail.getAttribute("value"));
	}


	@Test
	public void test_Register_PasswordNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept(){
		submitForm("Jan", "Janssens", "jan.janssens@hotmail.com", "");
		
		String title = driver.getTitle();
		assertEquals("Sign Up",title);
		
		WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
		assertEquals("No password given", errorMsg.getText());

		WebElement fieldFirstName=driver.findElement(By.id("firstName"));
		assertEquals("Jan",fieldFirstName.getAttribute("value"));
		
		WebElement fieldLastName=driver.findElement(By.id("lastName"));
		assertEquals("Janssens",fieldLastName.getAttribute("value"));
		
		WebElement fieldEmail=driver.findElement(By.id("email"));
		assertEquals("jan.janssens@hotmail.com",fieldEmail.getAttribute("value"));
	}
	
	@Test
	public void test_Register_UserAlreadyExists_ErrorMessageGiven(){
		submitForm("Pieter", "Pieters", "pieter.pieters@hotmail.com", "1234");
		
		driver.get(path+"?action=signUp");

		submitForm( "Pieter", "Pieters", "pieter.pieters@hotmail.com", "1234");
		
		WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
		assertEquals("User already exists", errorMsg.getText());

		WebElement fieldFirstName=driver.findElement(By.id("firstName"));
		assertEquals("Pieter",fieldFirstName.getAttribute("value"));
		
		WebElement fieldLastName=driver.findElement(By.id("lastName"));
		assertEquals("Pieters",fieldLastName.getAttribute("value"));
		
		WebElement fieldEmail=driver.findElement(By.id("email"));
		assertEquals("pieter.pieters@hotmail.com",fieldEmail.getAttribute("value"));
	}


	private void fillOutField(String name,String value) {
		WebElement field=driver.findElement(By.id(name));
		field.clear();
		field.sendKeys(value);
	}

	private void submitForm(String firstName,String lastName, String email, String password) {
		fillOutField("firstName", firstName);
		fillOutField("lastName",lastName);
		fillOutField("email", email);
		fillOutField("password", password);

		WebElement button=driver.findElement(By.id("signUp"));
		button.click();
	}*/

}
