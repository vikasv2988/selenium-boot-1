package selenium.boot.hamcrest.matchers.date.wrapper;


import selenium.boot.hamcrest.matchers.date.TemporalWrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalWrapper} which wraps a
 * {@link java.time.LocalDateTime} instance
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.TemporalUnit
 * @see java.time.temporal.ChronoUnit
 * @see selenium.boot.hamcrest.matchers.date.TemporalWrapper
 * @see java.time.Month
 * @see java.time.ZonedDateTime
 * @see java.time.ZoneId
 * @see selenium.boot.hamcrest.matchers.date.IsAfter
 * @see selenium.boot.hamcrest.matchers.date.IsBefore
 * @see selenium.boot.hamcrest.matchers.date.IsSame
 * @since 1.0
 */
public class LocalDateTimeWrapper implements TemporalWrapper<LocalDateTime>
{

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final LocalDateTime wrapped;

    private final TemporalUnit accuracy;

    public LocalDateTimeWrapper( final Date date )
    {
        wrapped = date.toInstant().atZone( ZoneId.systemDefault() ).toLocalDateTime();
        accuracy = ChronoUnit.MILLIS;
    }

    public LocalDateTimeWrapper( final LocalDateTime date )
    {
        wrapped = date;
        accuracy = ChronoUnit.NANOS;
    }

    public LocalDateTimeWrapper( final int year, final Month month, final int dayOfMonth )
    {
        wrapped = LocalDateTime.of( LocalDate.of( year, month, dayOfMonth ), LocalTime.NOON );
        accuracy = ChronoUnit.DAYS;
    }

    public LocalDateTimeWrapper( final int year,
                                 final Month month,
                                 final int dayOfMonth,
                                 final int hour,
                                 final int minute,
                                 final int second )
    {
        wrapped = LocalDateTime.of( year, month, dayOfMonth, hour, minute, second );
        accuracy = ChronoUnit.SECONDS;
    }

    public LocalDateTimeWrapper( final int year,
                                 final Month month,
                                 final int dayOfMonth,
                                 final int hour,
                                 final int minute,
                                 final int second,
                                 final int nanos )
    {
        wrapped = LocalDateTime.of( year, month, dayOfMonth, hour, minute, second, nanos );
        accuracy = ChronoUnit.NANOS;
    }

    //endregion


    @Override
    public long difference( final LocalDateTime other, final ChronoUnit unit )
    {
        return Math.abs( wrapped.truncatedTo( accuracy )
                                 .until( other, unit )
        );
    }

    @Override
    public boolean isAfter( final LocalDateTime other )
    {
        return wrapped.truncatedTo( accuracy )
                       .isAfter( other.truncatedTo( accuracy )
                       );
    }

    @Override
    public boolean isBefore( final LocalDateTime other )
    {
        return wrapped.truncatedTo( accuracy )
                       .isBefore( other.truncatedTo( accuracy )
                       );
    }

    @Override
    public boolean isSame( final LocalDateTime other )
    {
        return wrapped.truncatedTo( accuracy )
                       .isEqual( other.truncatedTo( accuracy )
                       );
    }

    @Override
    public boolean isSameDay( final LocalDateTime other )
    {
        return wrapped.truncatedTo( ChronoUnit.DAYS )
                       .isEqual( other.truncatedTo( ChronoUnit.DAYS ) );
    }

    @Override
    public LocalDateTime unwrap()
    {
        return wrapped;
    }

}
