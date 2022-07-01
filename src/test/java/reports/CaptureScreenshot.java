package reports;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {
	public static void CaptureScreenshots(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot tc=(TakesScreenshot)driver;
		File src=tc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./screenshots/"+ screenshotName + getDateTime() + ".png"));
		
	}
	
	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("MM-DD-YYYY-hh-mm-ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
