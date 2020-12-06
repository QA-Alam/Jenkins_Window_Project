package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zoopla.uk.baseclass.SuperClass;

public class Utility extends SuperClass {

	public static void waitForElement(WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		
	}
	
	public static String getScreenShot(WebDriver driver, String name) throws IOException {
		String date = new  SimpleDateFormat("MM.dd.yyyy-hh.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "/ScreenShots/" + name + date +".png";
		File obj = new File(destination);
		FileUtils.copyFile(source, obj);
		return destination;		
	}
	@SuppressWarnings("resource")
	public static ArrayList<String> readExcelData(int cloNo) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\alamm\\git\\Selenium_Automation\\Selenium_Automation\\PMCTestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("testData");
		Iterator<Row> rowiterator = sheet.iterator();
		rowiterator.next();
		
		ArrayList<String> list = new ArrayList<String>();
		while (rowiterator.hasNext()) {
			list.add(rowiterator.next().getCell(cloNo).getStringCellValue());
		}
		System.out.println("List ::: " + list);
        return list;
	}
}
