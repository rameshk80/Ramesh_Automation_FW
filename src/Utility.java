
import java.util.Calendar;
import java.util.Date;

public class Utility {
    public static Date getCurrentTime()
    {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
}
