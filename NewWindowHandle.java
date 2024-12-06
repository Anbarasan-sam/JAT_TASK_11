package jat_Task_11;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class NewWindowHandle {
	static WebDriver driver;
	public static void main(String[] args) {
		 driver = new ChromeDriver();
		try {
			driver.get("https://the-internet.herokuapp.com/windows");
			WebElement clickButton = driver.findElement(By.linkText("Click Here"));
			clickButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			String mainWindowHandles = driver.getWindowHandle();
			Set<String> windowHandles = driver.getWindowHandles();
			String newWindowHandle = null;
			for(String handle : windowHandles) {
				if(!handle.equals(mainWindowHandles)) {
					newWindowHandle = handle;
					break;
				}
			}
				driver.getTitle();
				 driver.switchTo().window(newWindowHandle);
				 if (driver.getPageSource().contains("New Window")) {
		                System.out.println("Verified that 'New Window' is present.");
		            } else {
		                System.out.println("Text 'New Window' not found.");
		            }			
				 driver.close();
				 driver.switchTo().window(mainWindowHandles);
				 if (driver.getTitle().contains("The Internet")) {
		                System.out.println("Verified that the original window is active.");
		            } else {
		                System.out.println("Original window not active.");
		            }
			}		
		finally {
			driver.quit();
			System.out.println("==============================================Closed the browser instance==============================================");
		}
	}
	public static void waitForFixTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
