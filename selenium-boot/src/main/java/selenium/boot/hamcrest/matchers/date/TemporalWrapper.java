package selenium.boot.hamcrest.matchers.date;


import java.time.temporal.ChronoUnit;



/**
 * Wrapper which wraps a temporal time so it can support the operations required by the matchers
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoUnit
 * @since 2.0
 */
public interface TemporalWrapper<T>
{
    /**
     * @param other a temporal to test against
     *
     * @return {@code true} if this temporal is after the other
     */
    boolean isAfter( final T other );

    /**
     * @param other a temporal to test against
     *
     * @return {@code true} if this temporal is after the other
     */
    boolean isBefore( final T other );

    /**
     * @param other a temporal to test against
     *
     * @return {@code true} if this temporal is after the other
     */
    boolean isSame( final T other );

    /**
     * @param other a temporal to test against
     *
     * @return {@code true} if this temporal is after the other
     */
    boolean isSameDay( final T other );

    /**
     * @return a the wrapped value
     */
    T unwrap();

    /**
     * return the difference in units between this time and the other time in the given units
     */
    long difference( final T other, final ChronoUnit unit );
}
