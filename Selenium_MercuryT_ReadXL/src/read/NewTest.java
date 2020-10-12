package read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\selenium cjc jar files\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@BeforeTest
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeClass
	public void openUrl()
	
	{
		driver.get("http://www.newtours.demoaut.com/");
	}
	@Test
		public void logincheck() throws IOException
		{
			File src=new File("E:\\selenium cjc jar files\\Newtour.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheetAt(0);
			
			int rown=sheet1.getLastRowNum();
			System.out.println(rown);
			
			for(int i=0; i<rown; i++)
			{
				String s=sheet1.getRow(i).getCell(0).getStringCellValue();
				System.out.println(s);
				
				String s1=sheet1.getRow(i).getCell(1).getStringCellValue();
				System.out.println(s1);
				
				driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(s);
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(s1);
				driver.findElement(By.xpath("//input[@name='login']")).click();
				driver.findElement(By.partialLinkText("SIGN-OFF")).click();
				quit;
			}
		}
	}
 

