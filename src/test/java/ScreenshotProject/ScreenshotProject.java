package ScreenshotProject;

import com.google.common.io.Files;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotProject {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Zehra/Desktop/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
    }
    @Test
    public void screenshotTest(){
        //ss almak icin method
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File image=screenshot.getScreenshotAs(OutputType.FILE);
        try{
            Files.move(image,new File("screenshotimage/amazon.png"));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }


    }
}
