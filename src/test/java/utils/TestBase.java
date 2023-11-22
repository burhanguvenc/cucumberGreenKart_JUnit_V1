package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {

		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String url = prop.getProperty("QAUrl");
		String browsertest = prop.getProperty("browser");

		if (driver == null) {
			if (browsertest.equalsIgnoreCase("chrome")) 
			{
				driver = new ChromeDriver();
			} else if (browsertest.equalsIgnoreCase("firefox")) 
			{
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);

		}
		return driver;

	}

}
