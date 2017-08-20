package selenium.boot.hamcrest.matchers.date.format;


import selenium.boot.hamcrest.matchers.date.TemporalFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalFormatter} to describe {@link java.util.Date} instances
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class DateFormatter implements TemporalFormatter<Date>
{

    private static final String DATE_TIME_FORMAT = "EEE, dd MMM yyyy hh:mm:ss.SSS a";

    private static final String DATE_FORMAT = "EEE, dd MMM yyyy";

    @Override
    public String describe( final Date temporal )
    {
        return new SimpleDateFormat( DATE_TIME_FORMAT ).format( temporal );
    }

    @Override
    public String describeDate( final Date temporal )
    {
        return new SimpleDateFormat( DATE_FORMAT ).format( temporal );
    }
}
