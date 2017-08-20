package selenium.boot.utils.dates.calc;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;



/**
 *  * This is an immutable holiday calendar, once given to a DateCalculator, a HolidayCalendar cannot be
 * modified, it will throw {@link UnsupportedOperationException}.
 *
 * @author Benoit Xhenseval
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class ImmutableHolidayCalendar<E> implements HolidayCalendar<E>
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( ImmutableHolidayCalendar.class );

    private final HolidayCalendar<E> delegate;

    public ImmutableHolidayCalendar( final HolidayCalendar<E> delegate )
    {
        super();
        this.delegate = delegate;
    }

    //endregion

    /**
     * @return the set of holidays
     *
     * @see HolidayCalendar#getHolidays()
     */
    public Set<E> getHolidays()
    {
        return delegate.getHolidays();
    }

    /**
     * @return the early (start) boundary of the holiday range
     *
     * @see HolidayCalendar#getEarlyBoundary()
     */
    public E getEarlyBoundary()
    {
        return delegate.getEarlyBoundary();
    }

    /**
     * @return the late (end) boundary of the holiday range
     *
     * @see HolidayCalendar#getLateBoundary()
     */
    public E getLateBoundary()
    {
        return delegate.getLateBoundary();
    }

    /**
     * @param holidays
     *
     * @throws UnsupportedOperationException You cannot modify the holidays, you need to use a new HolidayCalendar.;
     * @see HolidayCalendar#setHolidays(java.util.Set)
     */
    public HolidayCalendar<E> setHolidays( final Set<E> holidays )
    {
        throw new UnsupportedOperationException( "You cannot modify the holidays, you need to use a new HolidayCalendar." );
    }

    /**
     * @param earlyBoundary
     *
     * @throws UnsupportedOperationException You cannot modify the early boundary, you need to use a new HolidayCalendar.
     * @see HolidayCalendar#setEarlyBoundary(java.lang.Object)
     */
    public HolidayCalendar<E> setEarlyBoundary( final E earlyBoundary )
    {
        throw new UnsupportedOperationException( "You cannot modify the early boundary, you need to use a new HolidayCalendar." );
    }

    /**
     * @param lateBoundary
     *
     * @throws UnsupportedOperationException You cannot modify the late boundary, you need to use a new HolidayCalendar.
     * @see HolidayCalendar#setLateBoundary(java.lang.Object)
     */
    public HolidayCalendar<E> setLateBoundary( final E lateBoundary )
    {
        throw new UnsupportedOperationException( "You cannot modify the late boundary, you need to use a new HolidayCalendar." );
    }

    /**
     * @param date
     *
     * @return
     *
     * @see HolidayCalendar#isHoliday(java.lang.Object)
     */
    public boolean isHoliday( final E date )
    {
        return delegate.isHoliday( date );
    }
}
