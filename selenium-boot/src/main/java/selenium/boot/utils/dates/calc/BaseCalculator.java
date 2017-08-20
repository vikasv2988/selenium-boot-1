package selenium.boot.utils.dates.calc;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see <a href='https://github.com/Appendium/objectlabkit/blob/master/datecalc-common/src/main/java/net/objectlab/kit/datecalc/common/BaseCalculator.java'></a>
 * @since 2.0
 */
public interface BaseCalculator<E> extends NonWorkingDayChecker<E>
{
    /**
     * Gives the current business date held by the calculator.
     *
     * @return a date.
     */
    E getCurrentBusinessDate();

    /**
     * @return the current increment in the calculator, this is used by the handler.
     */
    int getCurrentIncrement();
}
