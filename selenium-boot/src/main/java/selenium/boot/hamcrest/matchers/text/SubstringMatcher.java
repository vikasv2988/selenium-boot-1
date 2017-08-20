package selenium.boot.hamcrest.matchers.text;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@AllArgsConstructor( access = AccessLevel.PROTECTED )
abstract class SubstringMatcher extends TypeSafeMatcher<CharSequence>
{
    //region initialization and constructors section

    protected final CharSequence substring;

    //endregion

    @Override
    public boolean matchesSafely( CharSequence item )
    {
        return evalSubstringOf( item );
    }

    @Override
    public void describeMismatchSafely( CharSequence item, Description mismatchDescription )
    {
        mismatchDescription.appendText( "was \"" ).appendText( item.toString() ).appendText( "\"" );
    }

    protected abstract boolean evalSubstringOf( CharSequence string );

    @Override
    public void describeTo( Description description )
    {
        description.appendText( "a string " )
                .appendText( relationship() )
                .appendText( " " )
                .appendValue( substring );
    }

    protected abstract String relationship();
}
