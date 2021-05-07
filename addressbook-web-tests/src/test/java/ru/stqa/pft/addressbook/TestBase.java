package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase
{
  protected WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception
  {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://front.kubiq.do.neoflex.ru/auth");
    vhodvkk("iz001", "123");
  }

  private void vhodvkk(String username, String pass) {
    wd.findElement(By.id("login")).click();
    wd.findElement(By.id("login")).clear();
    wd.findElement(By.id("login")).sendKeys(username);
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div")).click();
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys(pass);
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]")).click();
    wd.findElement(By.xpath("//div[@id='root']/div[2]/div/div/div/div[2]/div[3]/button/span")).click();
  }

  protected void knopkapodboracredita() {
    wd.findElement(By.xpath("//div[@id='root']/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/form/div/div/div/div/div/div/div/div[3]/div/button/span")).click();
  }

  protected void vvodstoimostiavto(Vvodimiedanniesumm vvodimiedanniesumm) throws InterruptedException {
    wd.findElement(By.xpath("//input[@name='carPrice']")).click();
    wd.findElement(By.xpath("//input[@name='carPrice']")).clear();
    wd.findElement(By.xpath("//input[@name='carPrice']")).sendKeys(vvodimiedanniesumm.getRubli());
    Thread.sleep(1000);
  }

  protected void vvodgodaavto(Vvodimiedanniegoda vvodimiedanniegoda) throws InterruptedException {
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).click();//если идентификатор в классе input
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).clear();
    wd.findElement(By.xpath("//input[@name='carProductionDate']")).sendKeys(vvodimiedanniegoda.getGod());
    Thread.sleep(1000);
  }

  protected void perehodvavtocredit() throws InterruptedException {
    wd.findElement(By.id("calculator")).click();
    Thread.sleep(1000);//задержка на отрисовку и выполнение
    wd.findElement(By.xpath("//div[text()='Автокредит']")).click();//если не написан однозначный идентификатор, но есть текст в классе div
    Thread.sleep(1000);
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception
  {
    vihodizkk();
    Thread.sleep(1000);
    wd.quit();
  }

  public void vihodizkk() {
    wd.findElement(By.xpath("//img[@alt='Exit button']")).click();
  }

  public void refinansirovanie(Refinansirovanie refinansirovanie) //заполение поля рефинансирования в автокредите
  {
    wd.findElement(By.id("93cfc6c2-cc5c-46bb-aaac-0c3495d4bda5")).click();
    wd.findElement(By.id("93cfc6c2-cc5c-46bb-aaac-0c3495d4bda5")).clear();
    wd.findElement(By.id("93cfc6c2-cc5c-46bb-aaac-0c3495d4bda5")).sendKeys(refinansirovanie.getSummarefinans());
  }

  public void traidin(String summatridin) //заполнение поля трейдин в автокредите
  {
    wd.findElement(By.id("7d21512c-11ff-4b2e-a3aa-d4ee4399784c")).click();
    wd.findElement(By.id("7d21512c-11ff-4b2e-a3aa-d4ee4399784c")).clear();
    wd.findElement(By.id("7d21512c-11ff-4b2e-a3aa-d4ee4399784c")).sendKeys(summatridin);
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
}
