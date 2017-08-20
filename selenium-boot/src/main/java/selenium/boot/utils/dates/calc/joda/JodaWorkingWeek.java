package selenium.boot.utils.dates.calc.joda;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.boot.utils.dates.calc.WorkingWeek;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@NoArgsConstructor( access = AccessLevel.PUBLIC )
public class JodaWorkingWeek extends WorkingWeek
{
    //region initialization and constructors section

    public static final JodaWorkingWeek DEFAULT = new JodaWorkingWeek();

    public static final JodaWorkingWeek ARAB_DEFAULT = new JodaWorkingWeek( WorkingWeek.ARABIC_WEEK );

    private static final Logger log = LoggerFactory.getLogger( JodaWorkingWeek.class );

    private static final int MAX_WEEKDAY_INDEX = 7;

    public JodaWorkingWeek( final WorkingWeek ww )
    {
        this( ww.getWorkingDays() );
    }

    protected JodaWorkingWeek( final byte workingDays )
    {
        super( workingDays );
    }

    //endregion

    public static int jodaToCalendarDayConstant( final LocalDate date )
    {
        return jodaToCalendarDayConstant( date.getDayOfWeek() );
    }

    public boolean isWorkingDay( final LocalDate date )
    {
        final int dayOfWeek = jodaToCalendarDayConstant( date.getDayOfWeek() );
        return isWorkingDayFromCalendar( dayOfWeek );
    }

    /**
     * Return a new JodaWorkingWeek if the status for the given day has changed.
     *
     * @param working        true if working day
     * @param givenDayOfWeek e.g. DateTimeConstants.MONDAY, DateTimeConstants.TUESDAY, etc
     */
    public JodaWorkingWeek withWorkingDayFromDateTimeConstant( final boolean working, final int givenDayOfWeek )
    {
        final int dayOfWeek = jodaToCalendarDayConstant( givenDayOfWeek );
        return new JodaWorkingWeek( super.withWorkingDayFromCalendar( working, dayOfWeek ) );
    }

    public static int jodaToCalendarDayConstant( final int givenDayOfWeek )
    {
        final int dayOfWeek = givenDayOfWeek + 1;
        return dayOfWeek <= MAX_WEEKDAY_INDEX ? dayOfWeek : dayOfWeek % MAX_WEEKDAY_INDEX;
    }

    public boolean isWorkingDayFromDateTimeConstant( final int dayOfWeek )
    {
        return isWorkingDayFromCalendar( jodaToCalendarDayConstant( dayOfWeek ) );
    }
}
