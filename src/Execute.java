
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Execute {
    public void executeKeywords(ArrayList<TestCase> allTestCases)
    {
        for (TestCase test : allTestCases) {
            for (KeywordStructure key: test.getKeywords()) {
                try {
                    Class<?> className = Class.forName("KeywordsImplementation");
                    Object objKeywordImplementation = className.newInstance();

                    //invoke with argument only if input data or verification data present
                    if(key.getInputData().isEmpty())
                    {
                        Method methodName = className.getMethod(key.getKeyword());
                        methodName.invoke(objKeywordImplementation);
                    }
                    else
                    {
                        Method methodName = className.getMethod(key.getKeyword(), String.class);
                        methodName.invoke(objKeywordImplementation, key.getInputData());
                    }
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
