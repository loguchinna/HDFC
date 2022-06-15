package org.test.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// 1.1st way for Browser Launch
	public static void chromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}


	// 2.URL Launch
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	// 3.Time management AND Window maximize

	public static void impWait(int sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	// 4.SendKeys

	public static void sendKeys(WebElement a, String input) {
		a.sendKeys(input);

	}

	// 5.Click
	public static void click(WebElement a) {
		a.click();

	}

	// 6.Get Current URL

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 7.Get Title
	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 8.Get Text
	public static String getText(WebElement a) {
		String text = a.getText();
		return text;

	}

	// 9.Get Attribute("innerText")

	public static String getAttributeText(WebElement a) {
		String attText = a.getAttribute("innerText");
		return attText;

	}
	// 10.Get Attribute("value")

	public static String getAttribute(WebElement a) {
		String attValue = a.getAttribute("value");
		return attValue;

	}

	// 11.Quit
	public static void quit() {
		driver.quit();

	}

	// 12.Navigate to

	public static void navigateto(String url) {

		driver.navigate().to(url);

	}

	// 13.forward
	public static void forward() {
		driver.navigate().forward();

	}

	// 14.Backward
	public static void backward() {
		driver.navigate().back();
	}

	// 15.Refresh
	public static void refresh() {
		driver.navigate().refresh();

	}

	// 16.clear
	public static void clear(WebElement a) {

		a.clear();

	}

	// 17.isEnabled
	public static boolean isEnabled(WebElement a) {
		boolean enabled = a.isEnabled();
		return enabled;
	}

	// 18.isDisplayed
	public static boolean isDisplayed(WebElement a) {
		boolean displayed = a.isDisplayed();
		return displayed;

	}

	// 19.isSelected
	public static boolean isSelected(WebElement a) {
		boolean selected = a.isSelected();
		return selected;

	}

	// 20.ScreenShots

	public static void getScreenshotAs(String filename) throws Throwable {
		TakesScreenshot screen = (TakesScreenshot) driver;

		File screenshot = screen.getScreenshotAs(OutputType.FILE);
		// Date x=new Date();
		// int seconds = x.getSeconds();
		System.currentTimeMillis();
		String l = System.getProperty("user.dir");
		File designationLocation = new File(l + "\\src\\test\\resources\\" + filename + ".png");
		FileUtils.copyFile(screenshot, designationLocation);

	}

	// 21.Move to Element
	public static void moveToElement(WebElement a) {
		Actions act = new Actions(driver);
		act.moveToElement(a).perform();

	}

	// 22.Drag and Drop
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions act = new Actions(driver);
		act.dragAndDrop(from, to).perform();

	}

	// 23.Action Click
	public static void actionClick(WebElement a) {
		Actions act = new Actions(driver);
		act.click(a).perform();

	}

	// 24.Click&Hold--->MoveTo--->Release
	public static void clickMoveRelease(WebElement from, WebElement to) {
		Actions act = new Actions(driver);
		act.clickAndHold(from).moveToElement(to).release().perform();

	}

	// 25.Click&Hold --->Release

	public static void clickAndRelease(WebElement from, WebElement to) {
		Actions act = new Actions(driver);
		act.clickAndHold(from).release(to).perform();

	}

	// 26.DoubleClick
	public static void doubleClick(WebElement a) {
		Actions act = new Actions(driver);
		act.doubleClick(a).perform();

	}

	// 27.Triple Click
	public static void tripleClick(WebElement a) {
		Actions act = new Actions(driver);
		act.doubleClick(a).click(a).perform();

	}

	// 28.context click
	public static void contextClick(WebElement a) {
		Actions act = new Actions(driver);
		act.contextClick(a).perform();

	}

	// 29.Alert ----> Accept
	public static void accept() {
		Alert alt = driver.switchTo().alert();
		alt.accept();

	}

	// 30.Alert ----> Dismiss
	public static void dismiss() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();

	}

	// 31.Alert ----> Promt alert Accept
	public static void promtAlertAccept(String input) {
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(input);
		alt.accept();

	}

	// 32.Alert ----> Promt Alert Dismiss
	public static void promtAlertDismiss() {
		Alert alt = driver.switchTo().alert();
		alt.dismiss();

	}

	// 33.Select By INDEX
	public static void selectByIndex(WebElement a, int index) {
		Select sel = new Select(a);
		sel.selectByIndex(index);

	}

	// 34.Select BY Value
	public static void selectByValue(WebElement a, String value) {
		Select sel = new Select(a);
		sel.selectByValue(value);

	}

	// 35.Select By VisibleText
	public static void selectByvisibleText(WebElement a, String text) {
		Select sel = new Select(a);
		sel.selectByVisibleText(text);

	}

	// 36.DeSelect By Index
	public static void deselectByIndex(WebElement a, int index) {
		Select sel = new Select(a);
		sel.deselectByIndex(index);

	}

	// 37.DeSelect By Value
	public static void deselectBYValue(WebElement a, String value) {
		Select sel = new Select(a);
		sel.deselectByValue(value);

	}

	// 38.DeSelect By Text
	public static void deselectByVisibleText(WebElement a, String text) {
		Select sel = new Select(a);
		sel.deselectByVisibleText(text);

	}

	// 39.DeSelect All
	public static void deselectAll(WebElement a) {
		Select sel = new Select(a);
		sel.deselectAll();

	}

	// 40.Is possible to select Multiple option
	public static boolean isMultiple(WebElement a) {
		Select sel = new Select(a);
		boolean multiple = sel.isMultiple();
		return multiple;

	}

	// 41.Get All the options in drop down
	public static String getOptions(WebElement a) {
		Select sel = new Select(a);

		List<WebElement> options = sel.getOptions();
		String text = null;
		for (WebElement x : options) {
			text = x.getText();

		}
		return text;

	}

	// 42.Get First Selected option

	public static String getFirstSelectedOption(WebElement a) {
		Select sel = new Select(a);
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}

	// 43.Get All Selected Options
	public static void getAllSelectedOptions(WebElement a) {
		Select sel = new Select(a);
		List<WebElement> allSelectedOptions = sel.getAllSelectedOptions();

		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement we = allSelectedOptions.get(i);
			String text = we.getText();
		}

	}

	// 44.Frame By Index
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);

	}

	// 45.Frame By id
	public static void frameById(String id) {
		driver.switchTo().frame(id);

	}

	// 46.Frame By Index
	public static void frameByWebElement(WebElement a) {

		driver.switchTo().frame(a);

	}

	// 47.defaultcontent
	public static void defaultContent() {
		driver.switchTo().defaultContent();

	}

	// 48.parentFrame
	public static void parentFrame() {
		driver.switchTo().parentFrame();

	}

	// 49.JavaScript---> set
	public static void setexecuteScript(String text, WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "'", a);

	}

	// 50.JavaScript----> Get
	public static String getexecuteScript(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", a);
		String data = (String) executeScript;
		return data;

	}

	// 51.Javascript-----> Scroll Down
	public static void scrollDown(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('true')", a);

	}

	// 52.Javascript-----> Scroll up
	public static void scrollUp(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView('false')", a);

	}

	// 53.WindowHandles
	public static void windowHandles(int index) {
		Set<String> allwindows = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(allwindows);
		driver.switchTo().window(li.get(index));

	}

	// 54.WebTable

	// 55.BrowserLaunch switch case
	public static void webdriver(String a) {
		switch (a) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			break;

		default:

			break;
		}

	}
	
	
	//56.Facebook input data given by excelsheet
	public static String getExcelData(String filename, String sheetname,int x,int y) throws IOException 
	{	
	
	File location =new File("C:\\Users\\logan\\eclipse-workspace\\MavenTrail\\src\\test\\resources\\"+filename+".xlsx");
	
	FileInputStream input = new FileInputStream(location);
	
	Workbook wb=new XSSFWorkbook(input);
	
	Sheet sheet = wb.getSheet(sheetname);
	
	Row row = sheet.getRow(x);
	Cell cell = row.getCell(y);
	
	//int rowcount = sheet.getPhysicalNumberOfRows();
	//int cellcount = row.getPhysicalNumberOfCells();
	
	int type = cell.getCellType();

	String value;
	if(type==1)
	{
		 value = cell.getStringCellValue();
		
	}
    	else  
    	{
    		
    		if(DateUtil.isCellDateFormatted(cell))
    		{
    			Date datecell = cell.getDateCellValue();
    			SimpleDateFormat s=new SimpleDateFormat("DD-MMMM-YYYY");
    			 value = s.format(datecell);
    		
    		}
    		
    		else 
    		{
    			double numericvalue = cell.getNumericCellValue();
    			long number= (long) numericvalue;
    			 value = String.valueOf(number);
    		
    		}    
    		
    	}
	return value;
	}
	
	
	
	//57.thread.sleep
	
	public static  long sleep(long x) throws InterruptedException {
		Thread.sleep(x);
		return x;
		

	}
	
	//58.GetPhysicalNumberOfRows
	
	public static  int getPhysicalNumberOfRows(String filename,String sheetname) throws IOException {
        File location = new File("C:\\Users\\logan\\eclipse-workspace\\MavenTrail\\src\\test\\resources\\"+filename+".xlsx");
		
		FileInputStream input = new FileInputStream(location);
		
		Workbook w= new XSSFWorkbook(input);
		
		Sheet sheet = w.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		return rowcount;

	}
	
	
	//59.GetPhysicalNumberOfCells
	public static int getPhysicalNumberOfCells(String filename,String sheetname,int rowindex) throws IOException {
		 File location = new File("C:\\Users\\logan\\eclipse-workspace\\MavenTrail\\src\\test\\resources\\"+filename+".xlsx");
			
			FileInputStream input = new FileInputStream(location);
			
			Workbook w= new XSSFWorkbook(input);
			
			Sheet sheet = w.getSheet(sheetname);
			Row row = sheet.getRow(rowindex);
			
			int cellcount = row.getPhysicalNumberOfCells();
			return cellcount;
	}
	
	//60.Gender For Facebook
	
	public static void switchGenderForFb(String gender) {
		
	

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


