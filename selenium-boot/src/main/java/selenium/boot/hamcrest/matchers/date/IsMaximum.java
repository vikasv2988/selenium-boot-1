package selenium.boot.hamcrest.matchers.date;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import selenium.boot.hamcrest.matchers.date.format.DatePartFormatter;

import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.function.Supplier;



/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.TemporalAdapter
 * @see java.util.function.Supplier
 * @see java.time.temporal.ChronoField
 * @see DatePartFormatter
 * @since 1.0
 */
public class IsMaximum<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final ChronoField datePart;

    private final TemporalAdapter<T> adapter;

    private final DatePartFormatter formatter;

    private final Supplier<String> descriptionSupplier;

    public IsMaximum( final ChronoField datePart, final TemporalAdapter<T> adapter, final DatePartFormatter formatter )
    {
        this( datePart, adapter, formatter, () -> "the date is the maximum value for " + formatter.describe( datePart ) );
    }

    public IsMaximum( final ChronoField datePart,
                      final TemporalAdapter<T> adapter,
                      final DatePartFormatter formatter,
                      final Supplier<String> descriptionSupplier )
    {
        this.datePart = datePart;
        this.adapter = adapter;
        this.formatter = formatter;
        this.descriptionSupplier = descriptionSupplier;
    }

    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDesc )
    {
        long actualValue = this.datePart.getFrom( this.adapter.asTemporal( actual ) );
        ValueRange range = this.datePart.rangeRefinedBy( this.adapter.asTemporal( actual ) );
        if( range.getMaximum() != actualValue )
        {
            mismatchDesc.appendText( "date is the " + actualValue
                                             + " "
                                             + this.formatter.describe( this.datePart )
                                             + " instead of "
                                             + range.getMinimum()
                                             + " "
                                             + this.formatter.describe( this.datePart ) );
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
        description.appendText( this.descriptionSupplier.get() );
    }
}
