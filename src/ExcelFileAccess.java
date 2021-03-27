
import java.io.*;
import java.util.ArrayList;

public class ExcelFileAccess extends Main{
    ArrayList<TestCase> allTestCases = new ArrayList<TestCase>();

    public ArrayList<TestCase> readAllTestCases()
    {
        FileInputStream inputFile;
        String lineOfString;
        try {
            BufferedReader reader = new BufferedReader( new FileReader(config.getInputFile()));
            reader.readLine(); // read the first line and skip it since it's header row

            while((lineOfString = reader.readLine()) != null)
            {
                String[] fullString = lineOfString.split(",");
                if(fullString != null)
                {
                    TestCase newTestCase = new TestCase();
                    newTestCase.setValue(fullString);
                    allTestCases.add(newTestCase);
                    if(config.getLogLevel() == Log.DETAIL) {
                        System.out.println(newTestCase.toString());
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allTestCases;
    }
}
