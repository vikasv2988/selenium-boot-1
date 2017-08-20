package selenium.boot.utils.dates.calc;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface NonWorkingDayChecker<E>
{
    /**
     * Is the given date a non working day, i.e. either a "weekend" or a holiday?
     *
     * @return true if the given date is non-working.
     */
    boolean isNonWorkingDay(E date);
}
