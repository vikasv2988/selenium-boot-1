package selenium.boot.hamcrest.date.utils;


import java.util.Calendar;
import java.util.Date;



/**
 * Utility class for manipulating dates
 *
 * @author Stewart Bissett
 */
public abstract class DateMatcherTestUtils
{

    public static Date addDateField( final Date date, final int field, final int duration )
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        cal.add( field, duration );
        return cal.getTime();
    }
}
