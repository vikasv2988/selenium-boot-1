package selenium.boot.hamcrest.matchers.date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static java.time.temporal.TemporalQueries.localDate;



/**
 * A matcher that tests that the examined date is a leap year
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.TemporalAdapter
 * @see java.util.function.Supplier
 * @see java.time.temporal.ChronoField
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsLeapYear<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final TemporalAdapter<T> adapter;

    private final TemporalFormatter<T> formatter;

    //endregion

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDesc )
    {
        if( !this.adapter.asTemporal( actual ).query( localDate() ).isLeapYear() )
        {
            mismatchDesc.appendText( "the date " + this.formatter.describe( actual ) + " is not a leap year" );
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
        description.appendText( "a leap year" );
    }
}
