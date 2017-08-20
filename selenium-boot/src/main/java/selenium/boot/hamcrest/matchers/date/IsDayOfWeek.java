package selenium.boot.hamcrest.matchers.date;


import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.util.Collections;
import java.util.List;
import java.util.Set;



/**
 * A matcher that tests that the examined date is on the same day of the week as the reference date
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField#DAY_OF_MONTH
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsDayOfWeek<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final Set<DayOfWeek> daysOfWeeks = Sets.newHashSet();

    private final String description;
    
    private final TemporalAdapter<T> adapter;

    public IsDayOfWeek( final List<DayOfWeek> daysOfWeek, final TemporalAdapter<T> accessor )
    {
        this.daysOfWeeks.addAll( daysOfWeek );
        this.description = describeDaysOfWeek( daysOfWeek );
        this.adapter = accessor;
    }

    public IsDayOfWeek( final DayOfWeek dayOfWeek, final TemporalAdapter<T> accessor )
    {
        this( Collections.singletonList( dayOfWeek ), accessor );
    }

    //endregion

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDescription )
    {
        DayOfWeek actualValue = DayOfWeek.of( this.adapter.asTemporal( actual ).get( ChronoField.DAY_OF_WEEK ) );
        if( this.daysOfWeeks.contains( actualValue ) )
        {
            return true;
        }
        else
        {
            mismatchDescription.appendText( "the " )
                    .appendText( DateCommons.getDescriptionMessage( adapter ) )
                    .appendText( actualValue.name() );

            return false;
        }
    }

    @Override
    public void describeTo( final Description description )
    {
        description.appendText( "the " )
                .appendText( DateCommons.getDescriptionMessage( adapter ) )
                .appendText( this.description );
    }

    private String describeDaysOfWeek( final List<DayOfWeek> daysOfWeek )
    {
        StringBuilder buffer = new StringBuilder();
        String separator = "";
        for( int i = 0; i < daysOfWeek.size(); ++i )
        {
            buffer.append( separator ).append( daysOfWeek.get( i ).name() );
            separator = i == daysOfWeek.size() - 2 ? " or " : ", ";
        }
        return buffer.toString();
    }

}
