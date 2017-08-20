package selenium.boot.utils.dates.calc;


import java.io.Serializable;
import java.util.Set;



/**
 * A Holiday Calendar not only defines a set of holiday dates but an early and
 * late boundary for these dates, e.g. putting the holidays for 2006 in a set
 * with limits of 1 Jan 2006 and 31 Dec 2006 means that 2006 is covered, not
 * that 31 Dec is a holiday itself.
 *
 * @author Benoit Xhenseval
 * @since 1.4.0
 *
 * @param <E>
 *            a representation of a date, typically JDK: Date, Calendar;
 *            Joda:LocalDate, YearMonthDay
 *            
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface ReadOnlyHolidayCalendar<E> extends Serializable
{
    /**
     * @return an immutable copy of the holiday set.
     */
    Set<E> getHolidays();

    /**
     * @return E the earliest date covered by this holiday calendar.
     */
    E getEarlyBoundary();

    /**
     * @return E the latest date covered by this holiday calendar.
     */
    E getLateBoundary();
}
