package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties properties;
    @BeforeMethod
    public void launchBrowser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeSuite
    public void loadConfigFile() throws IOException {
        File fp= new File("src/main/resources/config.properties");
        FileInputStream f= new FileInputStream(fp);
        properties= new Properties();
        properties.load(f);
    }
}
