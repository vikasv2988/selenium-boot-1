package selenium.boot.utils.dates.calc;


import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.text.ParseException;

/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@UtilityClass
public class CalculatorUtil
{
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * Creates a Date object given a string representation of it
     *
     * @param dateStr string (return today if string is null)
     *
     * @return today if string is null, a Date object representing the string
     * otherwise
     *
     * @throws IllegalArgumentException if the string cannot be parsed.
     */
    public static Date createDate( final String dateStr )
    {
        if( dateStr == null )
        {
            return createCalendar( null ).getTime();
        }
        return getCal( dateStr ).getTime();
    }

    /**
     * get a new Calendar based on the string date.
     *
     * @param dateStr the date string
     *
     * @return a new Calendar
     *
     * @throws IllegalArgumentException if the string cannot be parsed.
     */
    public static Calendar createCalendar( final String dateStr )
    {
        if( dateStr == null )
        {
            return blastTime( Calendar.getInstance() );
        }
        return getCal( dateStr );
    }

    // -----------------------------------------------------------------------
    //
    // ObjectLab, world leaders in the design and development of bespoke
    // applications for the securities financing markets.
    // www.ObjectLab.co.uk
    //
    // -----------------------------------------------------------------------

    public static Calendar getCal( final String dateStr )
    {
        try
        {
            final Date date = new SimpleDateFormat( DATE_PATTERN ).parse( dateStr );
            return getCal( date );
        }
        catch( final ParseException e )
        {
            throw new IllegalArgumentException( "\"" + dateStr + "\"" + " is an invalid date, the pattern is : " + DATE_PATTERN, e );
        }
    }

    /**
     * Converts a Set of Date objects to a Set of Calendar objects.
     *
     * @param dates
     *
     * @return the converted Set&lt;Calendar&gt;
     */
    public static Set<Calendar> toCalendarSet( final Set<Date> dates )
    {
        final Set<Calendar> calendars = new HashSet<>();
        for( final Date date : dates )
        {
            calendars.add( getCal( date ) );
        }
        return calendars;
    }

    /**
     * Get a Calendar object for a given Date representation.
     *
     * @param date
     *
     * @return the Calendar
     */
    public static Calendar getCal( final Date date )
    {
        if( date == null )
        {
            return null;
        }
        final Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return blastTime( cal );
    }

    /**
     * Removes set's all "time" fields to zero, leaving only the date portion of
     * the Calendar. The Calendar passe
     *
     * @param cal to Calendar object to blast, note, it will be modified
     *
     * @return the calendar object modified (same instance)
     */
    public static Calendar blastTime( final Calendar cal )
    {
        cal.set( Calendar.HOUR_OF_DAY, 0 );
        cal.set( Calendar.MINUTE, 0 );
        cal.set( Calendar.SECOND, 0 );
        cal.set( Calendar.MILLISECOND, 0 );
        return cal;
    }

    /**
     * Converts a Set of Date objects to a Set of Calendar objects.
     *
     * @param dates
     *
     * @return the converted Set&lt;Calendar&gt;
     */
    public static HolidayCalendar<Calendar> toHolidayCalendarSet( final HolidayCalendar<Date> dates )
    {
        final Set<Calendar> calendars = new HashSet<>();
        for( final Date date : dates.getHolidays() )
        {
            calendars.add( getCal( date ) );
        }
        final HolidayCalendar<Calendar> cal =
                new DefaultHolidayCalendar<>( calendars,
                                              getCal( dates.getEarlyBoundary() ),
                                              getCal( dates.getLateBoundary() )
                );
        return cal;
    }

    /**
     * Converts a Set of Calendar objects to a Set of Date objects
     *
     * @param calendars
     *
     * @return the converset Set&lt;Date&gt;
     */
    public static Set<Date> toDateSet( final Set<Calendar> calendars )
    {

        final Set<Date> dates = new HashSet<>();
        for( final Calendar calendar : calendars )
        {
            dates.add( calendar.getTime() );
        }
        return dates;
    }

    /**
     * Converts a {@code List) of Calendar objects to a {@code List) of dates
     *
     * @param dates
     *
     * @return the converted List&lt;Date&gt;
     */
    public static List<Date> toDateList( final List<Calendar> dates )
    {

        final List<Date> dateList = new ArrayList<>();
        for( final Calendar calendar : dates )
        {
            dateList.add( calendar.getTime() );
        }

        return dateList;
    }
}
