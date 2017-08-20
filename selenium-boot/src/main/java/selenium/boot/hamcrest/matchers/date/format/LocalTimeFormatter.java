package selenium.boot.hamcrest.matchers.date.format;


import selenium.boot.hamcrest.matchers.date.TemporalFormatter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalFormatter} that can format a {@link java.time.LocalTime}
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class LocalTimeFormatter implements TemporalFormatter<LocalTime>
{

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern( "hh:mm:ss a" );

    @Override
    public String describe( final LocalTime temporal )
    {
        return temporal.format( DATE_TIME_FORMAT );
    }

    @Override
    public String describeDate( final LocalTime temporal )
    {
        throw new UnsupportedOperationException( "describeDate is not supported against LocalTime" );
    }
}
