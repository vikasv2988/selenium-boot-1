package selenium.boot.hamcrest.matchers.date.format;


import selenium.boot.hamcrest.matchers.date.TemporalFormatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalFormatter} that can format a {@link java.time.LocalDateTime}
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class LocalDateTimeFormatter implements TemporalFormatter<LocalDateTime>
{

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern( "EEE, dd MMM yyyy hh:mm:ss.SSS a" );

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern( "EEE, dd MMM yyyy" );

    @Override
    public String describe( final LocalDateTime temporal )
    {
        return temporal.format( DATE_TIME_FORMAT );
    }

    @Override
    public String describeDate( final LocalDateTime temporal )
    {
        return temporal.format( DATE_FORMAT );
    }
}
