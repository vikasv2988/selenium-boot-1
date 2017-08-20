package selenium.boot.hamcrest.matchers.date;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.time.temporal.ChronoUnit;



/**
 * A matcher that tests that the examined date is within a defined period of the reference date
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see java.time.temporal.ChronoField
 * @see selenium.boot.hamcrest.matchers.date.TemporalWrapper
 * @see selenium.boot.hamcrest.matchers.date.TemporalFormatter
 * @since 1.0
 */
public class IsWithin<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final long period;

    private final ChronoUnit unit;

    private final TemporalWrapper<T> expected;

    private final TemporalFormatter<T> describer;

    public IsWithin( final long period, final ChronoUnit unit, final TemporalWrapper<T> expected, final TemporalFormatter<T> describer )
    {
        this.period = period;
        this.unit = unit;
        this.expected = expected;
        this.describer = describer;
    }

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDesc )
    {
        long actualDuration = this.expected.difference( actual, this.unit );
        if( actualDuration > this.period )
        {
            mismatchDesc.appendText( "the date is " + this.describer.describe( actual )
                                             + " and "
                                             + actualDuration
                                             + " "
                                             + describeUnit()
                                             + " different" );
            return false;
        }
        else
        {
            return true;
        }
    }

    private String describeUnit()
    {
        return this.unit.toString().toLowerCase();
    }

    @Override
    public void describeTo( final Description description )
    {
        description.appendText( "the date is within " +
                                        this.period + " " +
                                        describeUnit() + " of " +
                                        this.describer.describe( this.expected.unwrap() ) );
    }

}
