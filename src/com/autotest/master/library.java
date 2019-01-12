package com.autotest.master;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class library {
static WebDriver driver;
static FileInputStream fis;
static Properties pr;
String res;
String res1;
public static void open(String url) throws IOException{
fis=new FileInputStream("C:\\Users\\shravan\\Desktop\\workbench\\autotest\\src\\com\\autotest\\properties\\rep.property");
pr=new Properties();
pr.load(fis);
driver=new FirefoxDriver();
driver.get(url);
driver.manage().window().maximize();
}
public static void login(String id,String psw) throws Throwable{
	driver.findElement(By.xpath(pr.getProperty("logbtn"))).click();
	driver.findElement(By.xpath(pr.getProperty("eid"))).sendKeys(id);
	driver.findElement(By.xpath(pr.getProperty("epswd"))).sendKeys(psw);
	driver.findElement(By.xpath(pr.getProperty("logsbmt"))).click();
	Thread.sleep(3000);
}
public static void crtlst(String list) throws Throwable{
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"))).build().perform();

	driver.findElement(By.xpath(pr.getProperty("crtlist"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("listnam"))).sendKeys(list);
	driver.findElement(By.xpath(pr.getProperty("public"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("crtlsbmt"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("adlist"))).click();
	Thread.sleep(3000);
	}
public String addlist(String clist) throws Throwable{
		driver.findElement(By.xpath(pr.getProperty("inputlist"))).sendKeys(clist);
		Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("inputlstsbmt"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("inputlist"))).clear();
	return res;
	
}
public String accountaddr() throws Throwable {
	Actions act1=new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"))).build().perform();
	driver.findElement(By.xpath(pr.getProperty("youracount"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(pr.getProperty("enteraddr"))).click();
	driver.findElement(By.xpath(pr.getProperty("addaddr"))).click();
	driver.findElement(By.xpath(pr.getProperty("country"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("india"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("fulname"))).sendKeys("shravankare");
	Thread.sleep(2000);
	driver.findElement(By.xpath(pr.getProperty("phonenum"))).sendKeys("4568524598");
	Thread.sleep(2000);
	driver.findElement(By.xpath(pr.getProperty("pincode"))).sendKeys("505209");
	Thread.sleep(2000);
	driver.findElement(By.xpath(pr.getProperty("streetaddr"))).sendKeys("staddr");
	Thread.sleep(2000);
	driver.findElement(By.xpath(pr.getProperty("city"))).sendKeys("godavarikhani");
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("state"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("telangana"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("addsubmt"))).click();
	Thread.sleep(2000);
	
	return res1;
}
public static void signout() throws Throwable{
	Actions act2=new Actions(driver);
	act2.moveToElement(driver.findElement(By.xpath(".//*[@id='nav-link-accountList']"))).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pr.getProperty("signout"))).click();
	driver.close();
}
}
