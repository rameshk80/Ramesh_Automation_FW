
public class KeywordsImplementation extends Main {
    public void Login(String username)
    {
        objDriverFactory.findElementById("identifierId");
        objDriverFactory.sendValue(username);
        System.out.println("Login: username is " + username);
    }
    public void VerifyLoginSuccess()
    {
        System.out.println("VerifyLoginSuccess");
    }
}
