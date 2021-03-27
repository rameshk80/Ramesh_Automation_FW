
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebdriverFactory extends Main{

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

    public void navigateTo()
    {
        this.driver.get(config.getApplication_url());
    }
    public void navigateTo(String url)
    {
        this.driver.get(url);
    }

    public void quit()
    {
        this.driver.quit();
    }
}
