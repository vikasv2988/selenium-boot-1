package selenium.boot.hamcrest.matchers.date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.time.temporal.ChronoField;



/**
 * A matcher that tests that the examined date is on the specified month
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField#DAY_OF_MONTH
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsDayOfMonth<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private static final String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };

    private final int expected;

    private final TemporalAdapter<T> adapter;

    //endregion

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDescription )
    {
        int actualValue = this.adapter.asTemporal( actual ).get( ChronoField.DAY_OF_MONTH );
        if( this.expected == actualValue )
        {
            return true;
        }
        else
        {
            mismatchDescription.appendText( "the " )
                    .appendText( DateCommons.getDescriptionMessage( adapter ) )
                    .appendText( " on the " )
                    .appendText( getSuffix( actualValue ) )
                    .appendText( " day of the month" );

            return false;
        }
    }

    @Override
    public void describeTo( final Description description )
    {
        description.appendText( "the " )
                .appendText( DateCommons.getDescriptionMessage( adapter ) )
                .appendText( " on the " )
                .appendText( getSuffix( this.expected ) )
                .appendText( " day of the month" );
    }

    static String getSuffix( int num )
    {
        switch( num % 100 )
        {
            case 11:
            case 12:
            case 13:
                return num + "th";
            default:
                return num + suffixes[ num % 10 ];
        }
    }

    static String getSuffix( long num )
    {
        Long l = num;
        switch( l.intValue() % 100 )
        {
            case 11:
            case 12:
            case 13:
                return num + "th";
            default:
                return num + suffixes[ l.intValue() % 10 ];
        }
    }
}
