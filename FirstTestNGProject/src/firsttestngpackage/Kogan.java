package firsttestngpackage;


import java.util.List;

//import java.util.regex.Pattern;

//import javax.swing.text.html.parser.Element;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

//import net.sourceforge.htmlunit.corejs.javascript.ast.ContinueStatement;

import static org.testng.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kogan {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\AccessHQ\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.kogan.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testUntitled3() throws Exception {
		driver.get(baseUrl + "/au/");
		driver.findElement(By.id("product-search-field")).clear();
		driver.findElement(By.id("product-search-field")).sendKeys("iphone");
		driver.findElement(By.cssSelector("button.search-nav__button.search-nav__button--blue")).click();
		driver.findElement(By.cssSelector("span.title")).click();
		//driver.findElement(By.id("kespa-close-button")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.id("product-search-field")).clear();
		driver.findElement(By.id("product-search-field")).sendKeys("trampoline");
		driver.findElement(By.cssSelector("button.search-nav__button.search-nav__button--blue")).click();


		driver.findElement(By.cssSelector("img[alt=\"Pawever Pets Trampoline Dog Bed\"]")).click();
		//driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.cssSelector("img.logo")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();

		driver.findElement(By.xpath("//button[@type='button']")).click();

		//explicitWaitCondition(By.cssSelector("div.default-title > header")).click();
		//driver.findElement(By.id("kespa-close-button")).click();



		System.out.println("We are here!!!!");
		driver.findElement(By.name("email"));
		//explicitWaitElement(By.cssSelector("div.default-title > header")).click();

		//driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).sendKeys("test@test.com");

		driver.findElement(By.name("full_name")).click();
		driver.findElement(By.name("email")).click();

		if ( explicitWaitElement(By.id("express-checkout")).isDisplayed()!=true)
		{

			System.out.println("element is not avaliable!!");

		}
		else
			driver.findElement(By.className("no-thanks")).click();

		//driver.findElement(By.linkText("No thanks")).click();

		//Enter name and phone number
		explicitWaitElement(By.name("full_name")).clear();
		explicitWaitElement(By.name("full_name")).sendKeys("test test");
		explicitWaitElement(By.name("phone")).clear();
		explicitWaitElement(By.name("phone")).sendKeys("1234567890");
		explicitWaitElement(By.xpath("(//button[@type='submit'])[3]")).click();


		Thread.sleep(2000);

		//Enter Business name
		explicitWaitElement(By.name("company_name")).clear();
		explicitWaitElement(By.name("company_name")).sendKeys("test");


		//Enter address
		explicitWaitElement(By.name("address")).clear();
		explicitWaitElement(By.name("address")).sendKeys("1 test street");


		//Enter suburb and confirm drop down
		/*    explicitWaitElement(By.name("address_suburb")).clear();
    explicitWaitElement(By.name("address_suburb")).sendKeys("Mount Whitestone");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tt-dropdown-menu")));
    driver.findElement(By.className("tt-dropdown-menu")).click();*/


		WebElement postCodeDD =  driver.findElement(By.name("address_suburb"));
		postCodeDD.sendKeys("Mount Whitestone");

		Thread.sleep(1000);
		postCodeDD.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		postCodeDD.sendKeys(Keys.ENTER);


		//ActionChains(driver).moveToElement(driver.findElement(By.className("branded-button-label"))).click().perform();


		/*WebElement continueButton = driver.findElement(By.className("branded-button-label"));
    Point location = continueButton.getLocation();
    new Actions(driver).moveToElement(continueButton).click().perform();
		 */
		
		WebElement continueBtn = driver.findElement(By.xpath("//*[@id='checkout-process']/section[2]/div/div[2]/div/form/fieldset/div[5]/button"));
		continueBtn.sendKeys("");
		continueBtn.click();

		driver.findElement(By.xpath("//div[@id='checkout-process']/section[3]/div/section/div[2]/header")).click();


		driver.findElement(By.name("holderName")).clear();
		driver.findElement(By.name("holderName")).sendKeys("test test");
		driver.findElement(By.name("number")).clear();
		driver.findElement(By.name("number")).sendKeys("4111 1111 1111 1111");


		new Select(driver.findElement(By.name("expiryMonth"))).selectByVisibleText("10 - Oct");
		new Select(driver.findElement(By.name("expiryYear"))).selectByVisibleText("2023");
		//driver.findElement(By.xpath("//input[@name='cvc']")).clear();
		driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
		
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		
		Thread.sleep(1000);
		//store error message into a String (getText) then compare the message String with an expected String text. Then assert in testNG. 
		String errorMsgExpected = "Sorry, your payment was not successful. Please check your payment details and try again.";
			
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='errors alert-box alert radius']/span"));
				//("//*[contains(text(), 'Sorry, your payment was not successful. Please check your payment details and try again.')]"));
		System.out.println(errorMsg.getAttribute("innerHTML"));
		String errorMsgActual = errorMsg.getAttribute("innerHTML");
	
		Assert.assertEquals(errorMsgExpected,errorMsgActual);
	}

	private Actions ActionChains(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public WebElement explicitWaitElement(By locator){

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement wbelmnt = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		return wbelmnt;
	}

	public WebElement explicitWaitCondition(By locator){

		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement click = wait1.until(ExpectedConditions.elementToBeClickable(locator));

		return click; 
	}
	


	/*private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
	 */
}
