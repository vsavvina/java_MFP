package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class VhodvKK {
  private WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login("iz001", "123");
  }

  private void login(String username, String pass)
  {
    wd.get("http://front.kubiq.do.neoflex.ru/auth");
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys(username);
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]")).click();
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys(pass);
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div")).click();
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]/div[3]/button/span")).click();
  }

  @Test
  public void testVhodvKK() throws Exception
  {

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception
  {
    exfromkk();
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  private void exfromkk()
  {
    wd.findElement(By.xpath("//img[@alt='Exit button']")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
