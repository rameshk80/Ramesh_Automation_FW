
import java.util.ArrayList;
import java.util.List;

public class TestCase {
    String TestCaseName;
    String ExecuteMode;
    String Browser;
    List<KeywordStructure> Keywords = new ArrayList<KeywordStructure>();

    public String getTestCaseName() { return TestCaseName; }
    public void setTestCaseName(String testCaseName) { TestCaseName = testCaseName; }

    public String getExecuteMode() { return ExecuteMode; }
    public void setExecuteMode(String executeMode) { ExecuteMode = executeMode; }

    public String getBrowser() { return Browser; }
    public void setBrowser(String browser) { Browser = browser; }

    public List<KeywordStructure> getKeywords() { return Keywords; }
    public void setKeywords(List<KeywordStructure> keywords) { Keywords = keywords; }

    TestCase() {
    }

    public TestCase(String testCaseName, String executeMode, String browser, List<KeywordStructure> keywords) {
        TestCaseName = testCaseName;
        ExecuteMode = executeMode;
        Browser = browser;
        this.Keywords = keywords;
    }

    @Override
    public String toString() {
        return "TestCases{" +
                "TestCaseName='" + TestCaseName + '\'' +
                ", ExecuteMode='" + ExecuteMode + '\'' +
                ", Browser='" + Browser + '\'' +
                ", keywords=" + Keywords +
                '}';
    }

    public void setValue(String[] fullString) {
        byte i = 3;
        try {
            this.TestCaseName = fullString[0];
            this.ExecuteMode = fullString[1];
            this.Browser = fullString[2];
            while (i <= fullString.length - 1) {
                this.Keywords.add(new KeywordStructure().assignValue(fullString[i]));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


class KeywordStructure {
    String keyword;
    String inputData;

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getInputData() { return inputData; }
    public void setInputData(String inputData) { this.inputData = inputData; }

    KeywordStructure() { }

    KeywordStructure(String keyword, String inputData) {
        this.keyword = keyword;
        this.inputData = inputData;
    }

    /*
        Keyword structure is combined 3 values
        1. The actual keyword - we will be implementing the keyword in keyword.java
        2. optional input data - the value which user want to enter in a field or select
        3. The value user want to verity the presence in the page.
    */
    public KeywordStructure assignValue(String s) {
        String[] splitValue = s.split(":");
        if(!splitValue[0].isEmpty())
            keyword = splitValue[0];
        if(!splitValue[1].isEmpty())
            inputData = splitValue[1];

        return this;
    }
}
