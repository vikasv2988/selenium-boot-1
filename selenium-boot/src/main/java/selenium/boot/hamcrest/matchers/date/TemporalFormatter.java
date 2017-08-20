package selenium.boot.hamcrest.matchers.date;


/**
 * Return the description of a temporal value
 *
 * @param <T> The temporal type
 *
 * @author Stewart Bissett
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public interface TemporalFormatter<T>
{

    /**
     * @param temporal the temporal value to describe
     *
     * @return a pretty description of the temporal value as a date
     */
    String describe( T temporal );

    /**
     * @param unwrap the temporal value to describe
     *
     * @return a pretty description of the date portion of the temporal
     */
    String describeDate( T unwrap );
}
