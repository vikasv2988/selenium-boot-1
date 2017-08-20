package selenium.boot.hamcrest.matchers.date.format;


import java.time.temporal.ChronoField;
import java.util.stream.Stream;

import static java.util.Locale.getDefault;
import static java.util.stream.Collectors.joining;



/**
 * Return a human readable description of a date part
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField
 * @since 1.0
 */
public class DatePartFormatter
{

    private static final String SPLIT_ON_UPPERCASE_REGEX = "(?=[A-Z])";

    /**
     * Return a human readable description of a date field
     *
     * @param field the field to describe
     *
     * @return the human readable description
     */
    public String describe( final ChronoField field )
    {
        switch( field )
        {
            default:
                return Stream.of( field.getDisplayName( getDefault() ).split( SPLIT_ON_UPPERCASE_REGEX ) )
                               .map( String:: toLowerCase )
                               .collect( joining( " " ) );
        }
    }

}
