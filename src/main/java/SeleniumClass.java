import base.BaseClass;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class SeleniumClass  extends BaseClass {
    @Test
    public void LaunchOrangeCRM() throws IOException {
        driver.get(properties.getProperty("url"));
        driver.findElement(By.id("txtUsername")).sendKeys(properties.getProperty("user"));
        driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
        driver.findElement(By.id("btnLogin")).click();
        Actions act= new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"))).perform();
        act.moveToElement(driver.findElement(By.xpath("//a[@id='menu_pim_Configuration']"))).perform();
        driver.findElement(By.id("menu_pim_viewReportingMethods")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='recordsListDiv']//h1")).getText(),"Reporting Methods");
        driver.quit();
    }

   // @Test
    void draganddrop()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Drag and Drop']")).click();
        Actions act=new Actions(driver);
        //act.clickAndHold(driver.findElement(By.xpath("//div[@id='column-a']"))).moveToElement(driver.findElement(By.xpath("//div[@id='column-b']"))).release().build().perform();
        act.dragAndDrop(driver.findElement(By.xpath("//div[@id='column-a']")), driver.findElement(By.xpath("//div[@id='column-b']"))).build().perform();
        driver.quit();


    }



}
