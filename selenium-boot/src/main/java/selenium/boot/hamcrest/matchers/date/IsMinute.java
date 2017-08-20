package selenium.boot.hamcrest.matchers.date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.time.temporal.ChronoField;



/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField#MINUTE_OF_HOUR
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsMinute<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final int expected;

    private final TemporalAdapter<T> adapter;

    //endregion


    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDescription )
    {
        int actualMinute = adapter.asTemporal( actual ).get( ChronoField.MINUTE_OF_HOUR );
        if( expected != actualMinute )
        {
            mismatchDescription.appendText( "the " )
                    .appendText( DateCommons.getDescriptionMessage( adapter ) )
                    .appendText( "has the minute " )
                    .appendText( Integer.toString( actualMinute ) );

            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public void describeTo( final Description description )
    {
        description.appendText( "the " )
                .appendText( DateCommons.getDescriptionMessage( adapter ) )
                .appendText( "has the minute " )
                .appendText( Integer.toString( expected ) );
    }
}
