package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Alert q;
	public static TakesScreenshot ts;
	public static JavascriptExecutor js;
	
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
}
	
	public static void launchUrl(String url) {
		driver.get(url);
}
	
	public static void getTitle() {
		String text1 = driver.getTitle();
        System.out.println(text1);
	}
	
	public static void currentUrl() {
		String text2 = driver.getCurrentUrl();
        System.out.println(text2);
	}
	public static void userName(WebElement textElement, String text) {
		textElement.sendKeys(text);
}
	public static void passWord(WebElement textElement, String text) {
		textElement.sendKeys(text);
}
	public static void buttonClick(WebElement buttonElement) {
		buttonElement.click();
}
	public static void closeCurrentPage() {
		driver.close();
}
	public static void quitCurrentPage() {
		driver.quit();
}
	public static void getValue(WebElement text) {
		String text3 = text.getAttribute("value");
              System.out.println(text3);
}
	public static void getText(WebElement text) {
		text.getText();
}
	public static void mouseMovement() {
		a = new Actions(driver);
}
	public static void dragAndDrop(WebElement drag,WebElement drop) {
		Actions a = new Actions(driver); 
		a.dragAndDrop(drag, drop).perform();
}
	
	public static void takeScreenshot(String dest) throws Throwable {
		ts = (TakesScreenshot)driver;
		File defaultFilesPath = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(dest);
		FileUtils.copyFile(defaultFilesPath, destination);
	}
	public static void simpleAlert() {
		q = driver.switchTo().alert();
		q.accept();
}
	public static void confirmAlert() {
		q = driver.switchTo().alert();
        q.accept();
}
	public static void promptAlert(String text) {
		q = driver.switchTo().alert();
		q.sendKeys(text);
        q.accept();
}
	public static void sendKeysJs(String Entertext,WebElement text) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',Entertext)",text );
}
	public static void clickJs(WebElement button) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",button );
}
	public static void getTextJs(WebElement getValue) {
		js = (JavascriptExecutor)driver;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value')",getValue );
               String value = (String) executeScript;
               System.out.println(value);
}
	public static void mouseScroll(String ViewPoint,WebElement Scroll) {
		if (ViewPoint.equals("true")) {
			js.executeScript("arguments[0].scrollIntoview(true)",Scroll);
		}
		else {
			js.executeScript("arguments[0].scrollIntoview(false)",Scroll);
		}
}
	public static void windowsHandles(int windIndex) {
		Set<String> windowHandles = driver.getWindowHandles();
		List <String> l = new LinkedList<String>();
		      l.addAll(windowHandles);
		      String wind = l.get(windIndex);
		      driver.switchTo().window(wind);
}
	public static void readAllData(String fileName,String sheetName) throws IOException {
		File f = new File("C:\\Users\\Bharath\\eclipse-workspace\\Maven_Projects\\excel\\"+fileName+ ".xlsx");
          
		FileInputStream fs = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fs);
		
		Sheet mySheet = w.getSheet(sheetName);
		for (int i = 0; i <mySheet.getPhysicalNumberOfRows(); i++) {
			Row row = mySheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				System.out.println(cell);
}
}
	}

	public static void readAllDatas(String fileName,String sheetName) throws IOException {
		File f = new File("C:\\Users\\Bharath\\eclipse-workspace\\Maven_Projects\\excel\\"+fileName+".xlsx");
		FileInputStream fs = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fs);
		Sheet sheet1 = w.getSheet(sheetName);
		for (int i = 0; i < sheet1.getPhysicalNumberOfRows(); i++) {
			Row row1 = sheet1.getRow(i);
		

     		for (int j = 0; j < row1.getPhysicalNumberOfCells(); j++) {
			Cell cell1 = row1.getCell(j);
			int cellType1 = cell1.getCellType();
			
			
			if (cellType1==1) {
		String value = cell1.getStringCellValue();
		System.out.println(value);
			}		
		else if (DateUtil.isCellDateFormatted(cell1)) {
			Date dd = cell1.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			
			String format = sim.format(dd);
			System.out.println(format);
		}
			
		else {
			double d = cell1.getNumericCellValue();
			   long l = (long)d;
			   String valueOf = String.valueOf(l);
			   System.out.println(valueOf);
		}
			
		}

		}
	}
	
public static void createExcelFile(String fileName,String sheetName,String data,int createRow,int createCell) throws IOException {
	File f = new File("C:\\Users\\Bharath\\eclipse-workspace\\Maven_Projects\\excel\\"+fileName+".xlsx");
	FileInputStream fs = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fs);
	Sheet sheet1 = w.getSheet(sheetName);
	
	Row row = sheet1.getRow(createRow);
	Cell cell = row.getCell(createCell);

	cell.setCellValue(data);
	
	FileOutputStream fis = new FileOutputStream(f);
	w.write(fis);
	System.out.println("done....");
}
public static void createRow(String fileName,String sheetName,int createRow,int createCell,String data) throws IOException {
	File f = new File("C:\\Users\\Bharath\\eclipse-workspace\\Maven_Projects\\excel\\"+fileName+".xlsx");
	FileInputStream fs = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fs);
	Sheet sheet1 = w.getSheet(sheetName);
	

	Row row = sheet1.getRow(createRow);
	Cell cell = row.getCell(createCell);

	cell.setCellValue(data);
	
	FileOutputStream fis = new FileOutputStream(f);
	w.write(fis);
	System.out.println("done....");
}
public static void createCell(String fileName,String sheetName,int createRow,int createCell,String data) throws IOException {
	File f = new File("C:\\Users\\Bharath\\eclipse-workspace\\Maven_Projects\\excel\\"+fileName+".xlsx");
	FileInputStream fs = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fs);
	Sheet sheet1 = w.getSheet(sheetName);
	

	Row row = sheet1.getRow(createRow);
	Cell cell = row.getCell(createCell);

	cell.setCellValue(data);
	
	FileOutputStream fis = new FileOutputStream(f);
	w.write(fis);
	System.out.println("done....");
	
}



public static void jdbcConnection() {
	
try {
	Class.forName("oracle.jdbc.driver.Ora cleDriver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}




	

