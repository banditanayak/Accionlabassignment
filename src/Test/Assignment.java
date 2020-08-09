package Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Assignment {
	//private static final String FileUtils = null;
	WebDriver driver;
		
	@BeforeTest
	public void FirstTest() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bandita\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		String baseURL ="https://Familiar.Lsac.org";
		driver.get(baseURL);
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
			
			
	}
	
	
	@Test
	public void ClickOnDiscoverLaw() throws WebDriverException, IOException
	{
		driver.findElement(By.xpath("//*[@id=\"block-lsac-main-menu\"]/ul/li[1]/a")).click();
		System.out.println(driver.getTitle());
		
		
		//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                String fileWithPath="C:\\Users\\Bandita\\eclipse-workspace\\TestNG_Assignment\\Screenshot";
                File DestFile=new File(fileWithPath);

                //Copy file at destination
                
                FileUtils.copyFile(SrcFile, DestFile);
				
			
		
			}
		
		@AfterTest
		public void Final()
		
		{
		
		driver.close();
		
		}
	}		

		

	
	


