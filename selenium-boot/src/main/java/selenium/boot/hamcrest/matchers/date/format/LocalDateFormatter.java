package selenium.boot.hamcrest.matchers.date.format;


import selenium.boot.hamcrest.matchers.date.TemporalFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalFormatter} that can format a {@link java.time.LocalDate}
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class LocalDateFormatter implements TemporalFormatter<LocalDate>
{

    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern( "EEE, dd MMM yyyy" );

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern( "EEE, dd MMM yyyy" );

    @Override
    public String describe( final LocalDate temporal )
    {
        return temporal.format( DATE_TIME_FORMAT );
    }

    @Override
    public String describeDate( final LocalDate temporal )
    {
        return temporal.format( DATE_FORMAT );
    }

}
