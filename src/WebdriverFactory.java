
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

enum WAIT
{
    SHORTWAIT(5),
    NORMALWAIT(10),
    LONGWAIT(20),
}

public class WebdriverFactory extends Main{

    WebElement currentElement;
    WAIT waitTime;

    public WebdriverFactory() {
        config = new Configuration();
        config.initializeConfiguration();
        waitTime = WAIT.NORMALWAIT;
    }

    public void initializeWebdriver()
    {
        if(config.getBrowser_name().equalsIgnoreCase ("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver", properties.getProperty("FIREFOX_DRIVER_PATH"));
            this.driver = new FirefoxDriver();
        }
        else if(config.getBrowser_name().equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", properties.getProperty("CHROME_DRIVER_PATH"));
            this.driver = new ChromeDriver();
        }
    }
    public void launchApplication()
    {
        this.driver.get(config.getApplication_url());
    }

    public void navigateTo() {
        this.driver.get(config.getApplication_url());
    }
    public void navigateTo(String url)
    {
        this.driver.get(url);
    }

    public void findElement(String element) {
        this.driver.findElement(By.id(element));
    }

    public void findElementById(String element) {
        currentElement =  this.driver.findElement(By.id(element));
    }

    public void sendValue(String value){
        this.currentElement.sendKeys(value);
        currentElement = null;
    }

    /*
        All wait related functions
     */
    public void implicitWait()
    {
        this.driver.manage().timeouts().implicitlyWait(waitTime.ordinal(), TimeUnit.SECONDS);
    }

    public void clearImplicitWait() {
        this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void explicitWait(){

    }

    public void waitForElementDisplay(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, waitTime.ordinal());
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, waitTime.ordinal());
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToDisappear(By locator){}
    public void waitForPageToBeLoaded(By locator){}


    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed() ? true : false;
    }

    public boolean isElementClickable(By locator) {
        waitForElementClickable(locator);
        return driver.findElement(locator).isDisplayed() ? true : false;
    }

    /*
        Click the given locator without waiting
     */
    public void click(By locator) {
        driver.findElement(locator).click();
    }

    /*
        Wait for the locator to be clickable and click the given locator which is bit safer
     */
    public void clickSafe(By locator) {
        waitForElementClickable(locator);
        driver.findElement(locator).click();
    }

    /*
        Element appearance
     */
    public void isElementPresent(By locator){}
    public void isElementSelected(By locator){}


    public void quit()
    {
        this.driver.quit();
    }
}
