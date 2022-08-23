package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.time.Duration;

public class App {

    WebDriver driver;

    String BASE_URL = "https://tr.linkedin.com/";

    By singUpLocator = By.cssSelector("a[class='nav__button-secondary btn-md btn-secondary-emphasis']");
    By usernameLocator = By.cssSelector("input[id='username']");
    By passwordLocator = By.cssSelector("input[id='password']");
    By submitLocator = By.cssSelector("button[type='submit']");
    By messageLocator = By.xpath("(//a[@class='message-anywhere-button pvs-profile-actions__action artdeco-button '])[2]");
    By textBoxLocator = By.cssSelector("div[role='textbox']");
    By sendLocator = By.cssSelector("button[type='submit']");


    public App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    public void signUp(String username, String password){
        driver.findElement(singUpLocator).click();
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitLocator).click();
    }

    public void navigateToProfile(String profilName){
        driver.navigate().to(BASE_URL.concat(profilName));

    }

    public void messageButton(String message){
        waitFor(messageLocator);
        driver.findElement(messageLocator).click();
        waitFor(textBoxLocator);
        driver.findElement(textBoxLocator).sendKeys(message);
        waitFor(sendLocator);
        driver.findElement(sendLocator).click();

    }






    private void waitFor(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }







}
