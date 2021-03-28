
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
enum Log
{
    NONE,
    BRIEF,
    DETAIL,
}

enum ReportSetting
{
    NONE,
    REPORT,
    SCREENSHOT,
}

public class Configuration extends Main{
    private String browser_name;
    private String driver_path;
    private String application_url;
    private String inputFile;

    Log logLevel;
    ReportSetting report;

    //Default setting
    Configuration() {
        browser_name = "Firefox";
        driver_path = "/Users/rasandesh/Code/Drivers/geckodriver";
        application_url = "https://www.google.com";
        properties = new Properties();
        logLevel = Log.BRIEF;
        report = ReportSetting.REPORT;
    }
    public void initializeConfiguration() {
        try
        {
            System.out.println(System.getProperty("user.dir"));
            properties.load(new FileInputStream("./src/config.properties"));
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("config.properties file not found");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        this.browser_name = properties.getProperty("BROWSER_NAME");
        this.application_url = properties.getProperty("URL");
        this.inputFile = properties.getProperty("INPUT_FILE");
        setLogLevel(properties.getProperty("logLevel"));
    }

    public String getInputFile() { return inputFile; }
    public void setInputFile(String inputFile) { this.inputFile = inputFile; }

    public String getBrowser_name() {
        return browser_name;
    }
    public void setBrowser_name(String browser_name) {
        this.browser_name = browser_name;
    }

    public String getDriver_path() {
        return driver_path;
    }
    public void setDriver_path(String driver_path) {
        this.driver_path = driver_path;
    }

    public String getApplication_url() {
        return application_url;
    }
    public void setApplication_url(String application_url) {
        this.application_url = application_url;
    }

    public Log getLogLevel() { return logLevel; }
    public void setLogLevel(Log logLevel) { this.logLevel = logLevel; }
    public void setLogLevel(String logLevel) {
        if(logLevel.equalsIgnoreCase("NONE")) {
            this.logLevel = Log.NONE;
        }
        else if(logLevel.equalsIgnoreCase("BRIEF")) {
            this.logLevel = Log.BRIEF;
        }
        else if(logLevel.equalsIgnoreCase("DETAIL")) {
            this.logLevel = Log.DETAIL;
        }
    }

    public ReportSetting getReport() { return report; }
    public void setReport(ReportSetting report) { this.report = report; }

}