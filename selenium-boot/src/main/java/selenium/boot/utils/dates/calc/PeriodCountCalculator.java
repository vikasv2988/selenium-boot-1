package selenium.boot.utils.dates.calc;


/**
 * Interface that defines a financial market way of calculating difference in
 * days, month (or part of) and year (or part of).
 *
 * @author Benoit Xhenseval
 *
 * @param <E>
 *            a representation of a date, typically JDK: Date, Calendar;
 *            Joda:LocalDate, YearMonthDay
 *            
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface PeriodCountCalculator<E>
{
    int YEAR_360 = 360;

    int MONTHS_IN_YEAR = 12;

    double YEAR_365_0 = 365.0;

    double YEAR_360_0 = 360.0;

    int MONTH_31_DAYS = 31;

    int MONTH_30_DAYS = 30;

    /**
     * This calculates the number of days between 2 dates, it follows the given
     * basis which means that the result could vary between the same 2 dates if the basis is different.
     *
     * @param start the start date
     * @param end   the end date
     * @param basis the basis to use
     *
     * @return number of days between end and start.
     */
    int dayDiff( final E start, final E end, PeriodCountBasis basis );

    /**
     * This calculates the number of months (or fraction) between 2 dates, it
     * follows the given basis which means that the result could vary between the same 2 dates if the basis is different.
     *
     * @param start the start date
     * @param end   the end date
     * @param basis the basis to use
     *
     * @return number of months between end and start.
     */
    double monthDiff( final E start, final E end, PeriodCountBasis basis );

    /**
     * This calculates the number of years (or fraction) between 2 dates, it
     * follows the given basis which means that the result could vary between the same 2 dates if the basis is different.
     *
     * @param start the start date
     * @param end   the end date
     * @param basis the basis to use
     *
     * @return number of months between end and start.
     */
    double yearDiff( final E start, final E end, PeriodCountBasis basis );
}
