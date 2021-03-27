
public class KeywordStructure {
    String keyword;
    String inputData;
    String verifyData;

    KeywordStructure()
    {
    }

    KeywordStructure(String keyword, String inputData, String verifyData) {
        this.keyword = keyword;
        this.inputData = inputData;
        this.verifyData = verifyData;
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
        if(!splitValue[2].isEmpty())
            verifyData = splitValue[2];
    }
}
