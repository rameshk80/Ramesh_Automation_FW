
import java.util.ArrayList;
import java.util.List;

public class TestCase {
    String TestCaseName;
    String ExecuteMode;
    String Browser;
    List<KeywordStructure> Keywords = new ArrayList<KeywordStructure>();

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
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
