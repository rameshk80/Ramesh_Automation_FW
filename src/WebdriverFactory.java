
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverFactory extends Main{

    WebElement currentElement;

    public WebdriverFactory() {
        config = new Configuration();
        config.initializeConfiguration();
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

    public void quit()
    {
        this.driver.quit();
    }
}
