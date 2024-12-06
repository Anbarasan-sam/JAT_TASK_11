package jat_Task_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingXpathToSwitchFrames {
static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		try {
			driver.get("http://the-internet.herokuapp.com/nested_frames");
			driver.manage().window().maximize();
			driver.switchTo().frame("frame-top");
			if(driver.findElements(By.tagName("frame")).size() == 3) {
				System.out.println("Verified that the top frame has THREE FRAMES");
			}else {
				System.out.println("Top frame not have three frame");
			}
			
			driver.switchTo().frame("frame-left");
			WebElement leftFrame = driver.findElement(By.xpath("//body"));
			if(leftFrame.getText().equals("LEFT")) {
				System.out.println("Verified that the left frame has the text :: LEFT");
			}else {
				System.out.println("The left frame text is not 'LEFT' ");
			}
			driver.switchTo().parentFrame();
			driver.switchTo().frame("frame-middle");
			WebElement middleFrame = driver.findElement(By.xpath("//body"));
			if(middleFrame.getText().equals("MIDDLE")) {
				System.out.println("Verified that the middle frame has the text :: MIDDLE");
			}else {
				System.out.println("The middle frame text is not MIDDLE");
			}
			driver.switchTo().parentFrame();
			driver.switchTo().frame("frame-right");
			WebElement rightFrame = driver.findElement(By.xpath("//body"));
			if(rightFrame.getText().equals("RIGHT")) {
				System.out.println("Verified that the right frame has the text :: RIGHT");
			}else {
				System.out.println("The right frame text is not RIGHT ");
			}
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frame-bottom");
			WebElement bottomFrame = driver.findElement(By.xpath("//body"));
			if(bottomFrame.getText().equals("BOTTOM")) {
				System.out.println("Verified that the bottom frame has the text :: BOTTOM");
			}else {
				System.out.println("The bottom frame text is not BOTTOM");
			}
			driver.switchTo().defaultContent();
			
			if(driver.getTitle().equals("Frames")) {
				System.out.println("Verified that the page title is 'Frames'");
			}else {
				System.out.println("Page title is not 'Frames'");
			}
			driver.getTitle();
			System.out.println("The tittle is :: " + driver.getTitle());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
			System.out.println("==============================================Closed the browser instance==============================================");
			
		}

	}

}
