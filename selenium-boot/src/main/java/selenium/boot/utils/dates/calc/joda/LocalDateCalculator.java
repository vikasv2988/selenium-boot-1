package selenium.boot.utils.dates.calc.joda;


import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.boot.utils.dates.calc.AbstractDateCalculator;
import selenium.boot.utils.dates.calc.DateCalculator;
import selenium.boot.utils.dates.calc.DefaultHolidayCalendar;
import selenium.boot.utils.dates.calc.HolidayCalendar;
import selenium.boot.utils.dates.calc.HolidayHandler;
import selenium.boot.utils.dates.calc.WorkingWeek;

import java.util.Collections;


/**
 * This class is used via the DateCalculator interface, it enables the handling
 * of different HolidayHandler, if no HolidayHandler is defined, the calendar
 * will NOT move a date, even if it falls on a holiday or weekend.
 *
 * @author Benoit Xhenseval
 * 
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class LocalDateCalculator extends AbstractDateCalculator<LocalDate>
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( LocalDateCalculator.class );

    private JodaWorkingWeek workingWeek = JodaWorkingWeek.DEFAULT;

    public LocalDateCalculator()
    {
        this( null, null, new DefaultHolidayCalendar<>( Collections.emptySet() ), null );
    }

    public LocalDateCalculator( final String name,
                                final LocalDate startDate,
                                final HolidayCalendar<LocalDate> holidayCalendar,
                                final HolidayHandler<LocalDate> holidayHandler )
    {
        super( name, holidayCalendar, holidayHandler );
        if( startDate != null )
        {
            setStartDate( startDate );
        }
    }


    //endregion

    /**
     * Set the working week.
     *
     * @param week the JodaWorkingWeek
     *
     * @throws java.lang.IllegalArgumentException if the week is not a JodaWorkingWeek.
     */
    public DateCalculator<LocalDate> setWorkingWeek( final WorkingWeek week )
    {
        if( week instanceof JodaWorkingWeek )
        {
            workingWeek = ( JodaWorkingWeek ) week;
            return this;
        }
        throw new IllegalArgumentException( "Please give an instance of JodaWorkingWeek" );
    }

    /**
     * is the date a non-working day according to the WorkingWeek?
     */
    public boolean isWeekend( final LocalDate date )
    {
        assert workingWeek != null;
        return !workingWeek.isWorkingDay( date );
    }

    public DateCalculator<LocalDate> moveByDays( final int days )
    {
        setCurrentIncrement( days );

        setCurrentBusinessDate( getCurrentBusinessDate().plusDays( days ) );

        if( getHolidayHandler() != null )
        {
            setCurrentBusinessDate( getHolidayHandler().moveCurrentDate( this ) );
        }

        return this;
    }

    @Override
    public DateCalculator<LocalDate> moveByMonths( final int months )
    {
        setCurrentIncrement( months );
        setCurrentBusinessDate( getCurrentBusinessDate().plusMonths( months ) );

        if( getHolidayHandler() != null )
        {
            setCurrentBusinessDate( getHolidayHandler().moveCurrentDate( this ) );
        }

        return this;
    }

    @Override
    protected DateCalculator<LocalDate> createNewCalculator( final String name, final LocalDate startDate,
                                                             final HolidayCalendar<LocalDate> holidays,
                                                             final HolidayHandler<LocalDate> handler )
    {
        return new LocalDateCalculator( name, startDate, holidays, handler );
    }

    @Override
    protected LocalDate getToday()
    {
        return LocalDate.now();
    }

    @Override
    protected LocalDate compareDate( final LocalDate date1,
                                     final LocalDate date2,
                                     final boolean returnEarliest )
    {
        if( date1 == null || date2 == null )
        {
            return null;
        }
        if( returnEarliest )
        {
            return date1.isAfter( date2 ) ? date2 : date1;
        }
        else
        {
            return date2.isAfter( date1 ) ? date2 : date1;
        }
    }

    @Override
    protected void checkBoundary( final LocalDate date )
    {
        final LocalDate early = getHolidayCalendar().getEarlyBoundary();
        if( early != null && early.isAfter( date ) )
        {
            throw new IndexOutOfBoundsException( date + " is before the early boundary " + early );
        }

        final LocalDate late = getHolidayCalendar().getLateBoundary();
        if( late != null && late.isBefore( date ) )
        {
            throw new IndexOutOfBoundsException( date + " is after the late boundary " + late );
        }
    }

    @Override
    protected LocalDate clone( final LocalDate date )
    {
        return date;
    }
}
