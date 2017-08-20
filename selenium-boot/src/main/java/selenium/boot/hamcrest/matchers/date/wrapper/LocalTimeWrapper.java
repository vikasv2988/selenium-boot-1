package selenium.boot.hamcrest.matchers.date.wrapper;


import selenium.boot.hamcrest.matchers.date.TemporalWrapper;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalWrapper}
 * which wraps a {@link java.time.LocalTime} instance
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.TemporalUnit
 * @see java.time.temporal.ChronoUnit
 * @see selenium.boot.hamcrest.matchers.date.TemporalWrapper
 * @see selenium.boot.hamcrest.matchers.date.IsAfter
 * @see selenium.boot.hamcrest.matchers.date.IsBefore
 * @see selenium.boot.hamcrest.matchers.date.IsSame
 * @since 1.0
 */
public class LocalTimeWrapper implements TemporalWrapper<LocalTime>
{

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final LocalTime wrapped;

    public LocalTimeWrapper( final LocalTime date )
    {
        wrapped = date;
    }

    public LocalTimeWrapper( final int hour,
                             final int minute,
                             final int second )
    {
        wrapped = LocalTime.of( hour, minute, second );
    }

    //endregion

    @Override
    public long difference( final LocalTime other, final ChronoUnit unit )
    {
        return Math.abs( wrapped.until( other, unit ) );
    }

    @Override
    public boolean isAfter( final LocalTime other )
    {
        return wrapped.isAfter( other );
    }

    @Override
    public boolean isBefore( final LocalTime other )
    {
        return wrapped.isBefore( other );
    }

    @Override
    public boolean isSame( final LocalTime other )
    {
        return wrapped.equals( other );
    }

    @Override
    public boolean isSameDay( final LocalTime other )
    {
        throw new UnsupportedOperationException( "IsSameDay comparison is invalid on LocalTime" );
    }

    @Override
    public LocalTime unwrap()
    {
        return wrapped;
    }

}
