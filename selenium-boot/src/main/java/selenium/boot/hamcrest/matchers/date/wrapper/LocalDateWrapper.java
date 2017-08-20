package selenium.boot.hamcrest.matchers.date.wrapper;


import selenium.boot.hamcrest.matchers.date.TemporalWrapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;



/**
 * Implementation of a {@link selenium.boot.hamcrest.matchers.date.TemporalWrapper}
 * which wraps a {@link java.time.LocalDate} instance
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
public class LocalDateWrapper implements TemporalWrapper<LocalDate>
{

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final LocalDate wrapped;

    public LocalDateWrapper( final Date date )
    {
        this.wrapped = date.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
    }

    public LocalDateWrapper( final LocalDate date )
    {
        this.wrapped = date;
    }

    //endregion

    @Override
    public boolean isAfter( LocalDate other )
    {
        return wrapped.isAfter( other );
    }

    @Override
    public boolean isBefore( LocalDate other )
    {
        return wrapped.isBefore( other );
    }

    @Override
    public boolean isSame( LocalDate other )
    {
        return wrapped.isEqual( other );
    }

    @Override
    public boolean isSameDay( LocalDate other )
    {
        return wrapped.isEqual( other );
    }

    @Override
    public LocalDate unwrap()
    {
        return wrapped;
    }

    @Override
    public long difference( LocalDate other, ChronoUnit unit )
    {
        return Math.abs( wrapped.until( other, unit ) );
    }

    @Override
    public String toString()
    {
        return wrapped.toString();
    }

}
