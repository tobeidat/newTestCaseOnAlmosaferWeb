package newTestCasesForAlmosafer;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestCases {
	WebDriver driver = new ChromeDriver();
	String[] cities = { "amman", "dubai", "jeddah", "muscat" };
	Random rand = new Random();
	int index = rand.nextInt(cities.length);

	@BeforeTest
	public void setup() {
		driver.get("https://www.almosafer.com/ar/hotel/details/atg/%D9%81%D9%86%D8%AF%D9%82-%D9%83%D8%B1%D8%A7%D9%88%D9%86-%D8%B1%D9%88%D8%B2-1798809");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void printTheFeedBackAndEnterDataInHotelTab() throws InterruptedException {

		WebElement welcomeScreenButton = driver.findElement(By.className("cta__continue"));
		welcomeScreenButton.click();

		WebElement ratingsButton = driver.findElement(By.cssSelector("div[class='sc-kVfTjK gxYZWM'] a:nth-child(3)"));
		ratingsButton.click();

		List<WebElement> allRatings = driver.findElements(By.className("iPdku"));
		for (int i = 1; i < allRatings.size(); i++) {
			System.out.println(allRatings.get(i).getText());

		}

		Thread.sleep(8000);
		WebElement almosaferButton = driver.findElement(By.className("sc-hwcHae"));
		almosaferButton.click();

		WebElement hotelsButton = driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
		hotelsButton.click();

		WebElement searchLabel = driver.findElement(By.className("phbroq-2"));
		searchLabel.sendKeys(cities[index]);
		Thread.sleep(2000);
		
		WebElement hotelSearchBox = driver.findElement(By.cssSelector(".tln3e3-1.eFsRGb"));
		Select select = new Select(hotelSearchBox);
		select.selectByValue("B");

		WebElement allCitieList = driver.findElement(By.className("UzzIN"));
		List<WebElement> theCity = allCitieList.findElements(By.tagName("li"));
		theCity.get(1).click();
		
		WebElement checkinElement = driver.findElement(By.id("js-hotelsSearchBoxDatePickerCheckInDate"));
		checkinElement.click();

		Thread.sleep(3000);

		List<WebElement> allDates = driver.findElements(By.className("DayPicker-Day"));
		allDates.get(5).click();

		Thread.sleep(3000);

		allDates.get(33).click();
		Thread.sleep(2000);

		WebElement searchButton = driver.findElement(By.className("js-HotelSearchBox__SearchButton"));
		searchButton.click();

		Thread.sleep(25000);
		WebElement theResult = driver.findElement(By.className("jfNqEs"));
		String hotelName = theResult.getText();
		System.out.println(hotelName);

	}

	@AfterTest
	public void posTest() {
	}

}
