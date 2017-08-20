package selenium.boot.hamcrest.matchers.date;


import java.time.temporal.Temporal;



/**
 * Adapter which can convert a value to a {@link java.time.temporal.Temporal}
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@FunctionalInterface
public interface TemporalAdapter<T>
{
    /**
     * @param source the source value to convert
     *
     * @return the value as a {@link java.time.temporal.Temporal}
     */
    Temporal asTemporal( final T source );
}
