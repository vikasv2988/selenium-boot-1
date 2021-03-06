package selenium.boot.hamcrest.matchers.date;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;



/**
 * A matcher that tests that the examined date is before the reference date
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.TemporalWrapper
 * @see selenium.boot.hamcrest.matchers.date.TemporalFormatter
 * @see selenium.boot.hamcrest.matchers.date.IsSame
 * @see selenium.boot.hamcrest.matchers.date.IsSameOrAfter
 * @see selenium.boot.hamcrest.matchers.date.IsSameOrBefore
 * @see selenium.boot.hamcrest.matchers.date.IsAfter
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class IsBefore<T> extends TypeSafeDiagnosingMatcher<T>
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final TemporalWrapper<T> expected;

    private final TemporalFormatter<T> describer;

    //endregion
    
    @Override
    protected boolean matchesSafely( final T actual, final Description mismatchDescription )
    {
        if( this.expected.isSame( actual ) || this.expected.isBefore( actual ) )
        {
            mismatchDescription.appendText( "the " )
                    .appendText( DateCommons.getDescriptionMessage( expected ) )
                    .appendText( describer.describe( actual ) );

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
        description.appendText( "a " )
                .appendText( DateCommons.getDescriptionMessage( expected ) )
                .appendText( "before " )
                .appendText( this.describer.describe( this.expected.unwrap() ) );
    }
}
