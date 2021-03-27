
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Properties;

public class Main {
    protected static Configuration config;
    protected static WebDriver driver;
    protected static Properties properties;
    private static WebdriverFactory objDriverFactory;
    protected static Execute execute = new Execute();

    public static void main(String[] args) throws InterruptedException {
        properties = new Properties();
        config = new Configuration();
        config.initializeConfiguration();

        ExcelFileAccess file = new ExcelFileAccess();
        ArrayList<TestCase> allTestCases = file.readAllTestCases();
        execute.executeKeywords(allTestCases);

        objDriverFactory = new WebdriverFactory();
        objDriverFactory.initializeWebdriver();

        objDriverFactory.navigateTo();
        Thread.sleep(4000);
        objDriverFactory.quit();
    }
}
