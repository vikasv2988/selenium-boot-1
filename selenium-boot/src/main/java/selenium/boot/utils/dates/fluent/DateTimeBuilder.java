package selenium.boot.utils.dates.fluent;


import lombok.AllArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;



/**
 * Builder of {@link java.util.Date} objects.
 * This class is intended to be used internally to the builder classes
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.util.Calendar
 * @see java.util.TimeZone
 * @since 1.0
 */
@AllArgsConstructor
public class DateTimeBuilder
{
    //region initialization and constructors section

    private int date, month, year;

    //endregion

    /**
     * Return a {@link java.util.Date} instance at the specified hour
     *
     * @param hour the hour of the day
     */
    public Date at( final int hour )
    {
        return at( hour, 0, 0, 0, TimeZone.getDefault() );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour, minute, second and millisecond in the timezone adjusted to current timezone
     *
     * @param hour  the hour of the day
     * @param min   the minute of the hour
     * @param sec   the second of the minute
     * @param milli the millsecond of the second
     * @param tz    the timezone to use
     */
    public Date at( final int hour, final int min, final int sec, final int milli, final TimeZone tz )
    {
        final Calendar calendar = Calendar.getInstance();
        calendar.setLenient( false );
        calendar.setTimeZone( tz );
        checkAndSet( calendar, Calendar.YEAR, "Year", year );
        checkAndSet( calendar, Calendar.MONTH, "Month", month );
        checkAndSet( calendar, Calendar.DATE, "Date", date );
        checkAndSet( calendar, Calendar.HOUR_OF_DAY, "Hour", hour );
        checkAndSet( calendar, Calendar.MINUTE, "Minute", min );
        checkAndSet( calendar, Calendar.SECOND, "Seconds", sec );
        checkAndSet( calendar, Calendar.MILLISECOND, "Milliseconds", milli );
        return calendar.getTime();
    }

    private void checkAndSet( final Calendar calendar,
                              final int dateField,
                              final String label,
                              final int value )
    {
        int minValue = calendar.getActualMinimum( dateField ), maxValue = calendar.getActualMaximum( dateField );
        if( minValue > value || value > maxValue )
        {
            throw new IllegalArgumentException( label + " must be between " + minValue + " and " + maxValue + " inclusive" );
        }
        calendar.set( dateField, value );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour in the timezone adjusted to current timezone
     *
     * @param hour the hour of the day
     * @param tz   the timezone to use
     */
    public Date at( final int hour, final TimeZone tz )
    {
        return at( hour, 0, 0, 0, tz );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour and minute
     *
     * @param hour the hour of the day
     * @param min  the minute of the hour
     */
    public Date at( final int hour, final int min )
    {
        return at( hour, min, 0, 0, TimeZone.getDefault() );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour and minute in the timezone adjusted to current timezone
     *
     * @param hour the hour of the day
     * @param min  the minute of the hour
     * @param tz   the timezone to use
     */
    public Date at( final int hour,
                    final int min,
                    final TimeZone tz )
    {
        return at( hour, min, 0, 0, tz );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour, minute, and second
     *
     * @param hour the hour of the day
     * @param min  the minute of the hour
     * @param sec  the second of the minute
     */
    public Date at( final int hour,
                    final int min,
                    final int sec )
    {
        return at( hour, min, sec, 0, TimeZone.getDefault() );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour, minute, and second in the timezone adjusted to current timezone
     *
     * @param hour the hour of the day
     * @param min  the minute of the hour
     * @param sec  the second of the minute
     * @param tz   the timezone to use
     */
    public Date at( final int hour,
                    final int min,
                    final int sec,
                    final TimeZone tz )
    {
        return at( hour, min, sec, 0, tz );
    }

    /**
     * Return a {@link java.util.Date} instance at the specified hour, minute, second and a millisecond
     *
     * @param hour  the hour of the day
     * @param min   the minute of the hour
     * @param sec   the second of the minute
     * @param milli the millisecond of the second
     */
    public Date at( final int hour,
                    final int min,
                    final int sec,
                    final int milli )
    {
        return at( hour, min, sec, milli, TimeZone.getDefault() );
    }
}
