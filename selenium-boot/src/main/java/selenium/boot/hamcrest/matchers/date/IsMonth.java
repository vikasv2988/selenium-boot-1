package selenium.boot.hamcrest.matchers.date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;



/**
 * A matcher that tests that the examined date is on the same month of the year as the reference date
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField#MONTH_OF_YEAR
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsMonth<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final Month expectedMonth;

    private final TemporalAdapter<T> adapter;

    //endregion

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDescription )
    {
        Month actualMonth = Month.of( this.adapter.asTemporal( actual ).get( ChronoField.MONTH_OF_YEAR ) );
        if( !this.expectedMonth.equals( actualMonth ) )
        {
            mismatchDescription.appendText( "the month " )
                    .appendText( DateCommons.getDescriptionMessage( adapter ) )
                    .appendText( "in " )
                    .appendText( describeMonth( actualMonth ) );

            return false;
        }
        else
        {
            return true;
        }
    }

    private String describeMonth( final Month m )
    {
        return m.getDisplayName( TextStyle.FULL, Locale.getDefault() );
    }

    @Override
    public void describeTo( final Description description )
    {
        description.appendText( "the month " )
                .appendText( DateCommons.getDescriptionMessage( adapter ) )
                .appendText( "in " )
                .appendText( describeMonth( this.expectedMonth ) );
    }
}
