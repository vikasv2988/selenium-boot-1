package selenium.boot.utils.dates.calc;


import java.util.Set;



/**
 * A Holiday Calendar not only defines a set of holiday dates but an early and
 * late boundary for these dates, e.g. putting the holidays for 2006 in a set
 * with limits of 1 Jan 2006 and 31 Dec 2006 means that 2006 is covered, not
 * that 31 Dec is a holiday itself.
 *
 * @author Benoit Xhenseval
 * @since 1.1.0
 *
 * @param <E>
 *            a representation of a date, typically JDK: Date, Calendar;
 *            Joda:LocalDate, YearMonthDay
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface HolidayCalendar<E> extends ReadOnlyHolidayCalendar<E>
{
    /**
     * Takes a copy of the holidays and store it in an immutable set.
     */
    HolidayCalendar<E> setHolidays( final Set<E> holidays );

    /**
     * Sets the earliest date (must be &lt;= first date in holiday set)
     *
     * @param earlyBoundary
     */
    HolidayCalendar<E> setEarlyBoundary( final E earlyBoundary );

    /**
     * Sets the latest date (must be &lt;= first date in holiday set)
     *
     * @param lateBoundary
     */
    HolidayCalendar<E> setLateBoundary( final E lateBoundary );

    /**
     * Check if a date is a holiday.
     *
     * @param date
     *
     * @return true if the given date is in the holiday set.
     */
    boolean isHoliday( final E date );
}
