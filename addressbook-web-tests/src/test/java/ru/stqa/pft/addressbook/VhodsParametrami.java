package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class VhodsParametrami {
  private WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testVhodsParametrami() throws Exception {
    wd.get("http://front.kubiq.do.neoflex.ru/auth");
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys("iz001");
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div")).click();
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys("123");
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]")).click();
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]/div[3]/button/span")).click();
    wd.findElement(By.id("calculator")).click();
    Thread.sleep(1000);//задержка на отрисовку и выполнение
    wd.findElement(By.xpath("//div[text()='Автокредит']")).click();//если не написан однозначный идентификатор, но есть текст в классе div
    Thread.sleep(1000);
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).click();//если идентификатор в классе input
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).clear();
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).sendKeys("2017");
    Thread.sleep(1000);
    wd.findElement(By.xpath("//input[@name='carPrice']")).click();
    wd.findElement(By.xpath("//input[@name='carPrice']")).clear();
    wd.findElement(By.xpath("//input[@name='carPrice']")).sendKeys("200 000");
    Thread.sleep(1000);
    wd.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/form/div/div/div/div/div/div/div/div[3]/div/button/span")).click();
    wd.findElement(By.xpath("//img[@alt='Exit button']")).click();
    Thread.sleep(1000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
