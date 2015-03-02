package george.cw4.meeting;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Squall on 03/01/2015.
 */
public class DateUtil {

    public static GregorianCalendar currentDate()
    {
        return new GregorianCalendar();
    }

    public static boolean isLaterDate(GregorianCalendar d1, GregorianCalendar d2)
    {
        if (d1.compareTo(d2) == 1 || d1.compareTo(d2) == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static String printDatePretty(Calendar date)
    {
        String year = "" + date.get(Calendar.YEAR);
        String month = "" + date.get(Calendar.MONTH);
        String day = "" + date.get(Calendar.DAY_OF_MONTH);
        String hour = "" + date.get(Calendar.HOUR_OF_DAY);
        String minute = "" + date.get(Calendar.MINUTE);
        return (year + "-" + month + "-" + day + " " + hour + ":" + minute);
    }
}
