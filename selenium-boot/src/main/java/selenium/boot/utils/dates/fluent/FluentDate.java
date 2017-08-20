package selenium.boot.utils.dates.fluent;


import lombok.experimental.UtilityClass;

import java.util.Calendar;
import java.util.Date;



/**
 * A static factory for creating instances of {@link java.util.Date} instances using a
 * readable fluent syntax. All dates are created at midday. To create
 * {@link java.util.Date} instances for a specific time use {@link selenium.boot.utils.date.fluent.FluentDateTime}.
 * </p>
 * For example:
 * <pre>
 * Date myBirthday = Dates.AUG(9, 1975)
 * </pre>
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@UtilityClass
public class FluentDate
{
    /**
     * Create a {@link java.util.Date} instance for midday on the given date in January in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date JAN( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.JANUARY, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in February
     * in the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date FEB( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.FEBRUARY, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in March in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date MAR( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.MARCH, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in April in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date APR( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.APRIL, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in May in the
     * given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date MAY( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.MAY, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in June in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date JUN( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.JUNE, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in July in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date JUL( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.JULY, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in August in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date AUG( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.AUGUST, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in September
     * in the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date SEP( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.SEPTEMBER, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in October in
     * the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date OCT( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.OCTOBER, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in November
     * in the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date NOV( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.NOVEMBER, year ).at( 12, 0, 0 );
    }

    /**
     * Create a {@link java.util.Date} instance for midday on the given date in December
     * in the given year
     *
     * @param date the day of the month.
     * @param year the year.
     */
    public static Date DEC( final int date, final int year )
    {
        return new DateTimeBuilder( date, Calendar.DECEMBER, year ).at( 12, 0, 0 );
    }
}
