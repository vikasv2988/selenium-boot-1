package selenium.boot.utils.dates.calc;


/**
 *  * This will be called to determine whether the date should be moved according
 * to the special algorithm used.
 *
 * @author Benoit Xhenseval
 *
 * @param <E>
 *            a representation of a date, typically JDK: Date, Calendar;
 *            Joda:LocalDate, YearMonthDay
 *
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface HolidayHandler<E>
{ /**
 * If the current date of the give calculator is a non-working day, it will
 * be moved according to the algorithm implemented.
 *
 * @param calculator
 *            the calculator
 * @return the date which may have moved.
 */
E moveCurrentDate(BaseCalculator<E> calculator);

    /**
     * For a given date, adjust it if required but using the logic across Month/etc for calc
     *
     * @param startDate
     * @param increment
     * @param checker
     *
     * @return
     */
    E adjustDate( E startDate, int increment, NonWorkingDayChecker<E> checker );

    /**
     * Give the type name for this algorithm.
     *
     * @return algorithm name.
     */
    String getType();

}
