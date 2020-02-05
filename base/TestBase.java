package com.stackcare.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.stackcare.util.Testutil;

public class TestBase {
	Testutil util ;

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		util= new Testutil();
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\com\\stackcare\\config\\config.properties");
		prop.load(ip);

	}

	public void initialization() {
		
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/latestdriver/chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("D:\\StackCare_Maven\\StackCareTest\\latestdriver\\chromedriver.exe"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("urlofapp1"));
			
		}
		
	}
}










/*<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>6.11</version>
<scope>test</scope>
</dependency>
*/
