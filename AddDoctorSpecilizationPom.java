package Admin_Module;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import com.HMS.HealthCare.GenericLabraries.ExcelUtility;
import com.HMS.HealthCare.GenericLabraries.FileUtility;
import com.HMS.HealthCare.GenericLabraries.JavaUtility;
import com.HMS.HealthCare.GenericLabraries.WebDriverUtility;
import com.HMS.ObjectRepository.AdminDashBoardPage;
import com.HMS.ObjectRepository.AdminLoginPage;
import com.HMS.ObjectRepository.AddDoctorSpecilizationPage;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNull;
import org.testng.Assert;
@Listeners(com.HMS.HealthCare.GenericLabraries.ListenersImplementationClass.class)
public class AddDoctorSpecilizationPom {
	public static void main(String[] args) throws Throwable {
		
		FileUtility pLib = new FileUtility();
	    ExcelUtility eLib = new ExcelUtility();
	  JavaUtility jLib = new JavaUtility();
   WebDriverUtility wLib = new WebDriverUtility();
	     
   String BROWSER = pLib.readDataFromPropertyFileAdmin("browser");
	String URL = pLib.readDataFromPropertyFileAdmin("url");
	String USERNAME = pLib.readDataFromPropertyFileAdmin("username");
	String PASSWORD = pLib.readDataFromPropertyFileAdmin("password");
	String value =eLib.readDataFromExcel("Sheet1",1,1);
	     
        
          

 		//launch browser
 		WebDriver driver = null;
 		if(BROWSER.equalsIgnoreCase("chrome"))
 		{                                                                                                              
 			driver = new ChromeDriver();
 		}
 		else if(BROWSER.equalsIgnoreCase("firefox"))
 		{
 			driver = new FirefoxDriver();    
 		}
 		else
 		{
 			System.out.println("invalid browser");
 		}
 		//maximize window
      wLib.maximiseWindow(driver);
 		
 		driver.get(URL);
 		//implicitly wait
 		
 		
 		//login to admin
		AdminLoginPage lp=new AdminLoginPage(driver);
		lp.adminLoginPage (USERNAME, PASSWORD);

		//add doctor
				AdminDashBoardPage ad=new AdminDashBoardPage(driver);
				ad.DoctorSpecilization();
				AddDoctorSpecilizationPage ap=new AddDoctorSpecilizationPage(driver);
				ap.doctorSpecilizationLinks(value);
		         ap.SubmitbuttonLinks();
		         
			//	wLib.acceptAlert(driver);
		         
		         
			
				ad.adminLink();
				
				ad.adminLogout();
	 	
			
 	
 	 
 	/*	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		driver.findElement(By.name("password")).sendKeys(PASSWORD);
 		driver.findElement(By.name("username")).sendKeys(USERNAME);
 		
 		
 		driver.findElement(By.name("submit")).click();
 		driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
 		driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
 		Thread.sleep(2000);
 		
 		driver.findElement(By.name("doctorspecilization")).sendKeys(value);
 		Thread.sleep(2000);
 		driver.findElement(By.xpath("//button[@name='submit']")).click();
 		
 		driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
 		driver.findElement(By.xpath("//span[text()=' Manage Doctors ']")).click();
	}*/
	}
}
