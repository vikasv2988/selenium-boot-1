package selenium.boot.utils.dates.calc;


import lombok.AccessLevel;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class DefaultHolidayCalendar<E extends Serializable> implements HolidayCalendar<E>
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( DefaultHolidayCalendar.class );

    /**
     * Changed to a Map of String to E, given the JODA issue
     * http://joda-interest.219941.n2.nabble.com/LocalDate-equals-method-bug-td7572429.html
     *
     * @since 1.4.0
     */
    private Map<String, E> holidays;

    @Getter( AccessLevel.PUBLIC )
    private E earlyBoundary;

    @Getter( AccessLevel.PUBLIC )
    private E lateBoundary;

    public DefaultHolidayCalendar()
    {
        super();
        holidays = Collections.emptyMap();
    }

    public DefaultHolidayCalendar( final Set<E> holidays, final E earlyBoundary, final E lateBoundary )
    {
        super();
        setHolidays( holidays );

        this.earlyBoundary = earlyBoundary;
        this.lateBoundary = lateBoundary;
    }

    public DefaultHolidayCalendar( final Set<E> holidays )
    {
        super();
        setHolidays( holidays );
    }

    //endregion

    @Override
    public Set<E> getHolidays()
    {
        return new HashSet<E>( holidays.values() );
    }

    @Override
    public HolidayCalendar<E> setEarlyBoundary( final E earlyBoundary )
    {
        this.earlyBoundary = earlyBoundary;
        return this;
    }

    @Override
    public final HolidayCalendar<E> setHolidays( final Set<E> holidays )
    {

        if( holidays == null )
        {
            this.holidays = Collections.emptyMap();
            return this;
        }

        final Map<String, E> newSet = new TreeMap<String, E>();
        for( final E e : holidays )
        {
            newSet.put( toString( e ), e );
        }
        this.holidays = Collections.unmodifiableMap( newSet );
        return this;
    }

    @Override
    public HolidayCalendar<E> setLateBoundary( final E lateBoundary )
    {
        this.lateBoundary = lateBoundary;
        return this;
    }

    @Override
    public boolean isHoliday( final E date )
    {
        return holidays.containsKey( toString( date ) );
    }

    private String toString( final E date )
    {
        if( date instanceof Calendar )
        {
            return new SimpleDateFormat( "yyyy-MM-dd" ).format( ( ( Calendar ) date ).getTime() );
        }
        else if( date instanceof Date )
        {
            return new SimpleDateFormat( "yyyy-MM-dd" ).format( date );
        }

        return date != null ? date.toString() : "";
    }
}
