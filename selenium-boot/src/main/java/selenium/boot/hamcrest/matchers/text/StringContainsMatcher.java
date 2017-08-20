package selenium.boot.hamcrest.matchers.text;


import org.hamcrest.Factory;
import org.hamcrest.Matcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class StringContainsMatcher extends SubstringMatcher
{
    //region initialization and constructors section

    private final boolean ignoreCase;

    public StringContainsMatcher( CharSequence substring, boolean ignoreCase )
    {
        super( substring );
        this.ignoreCase = ignoreCase;
    }

    //endregion

    /**
     * Creates a matcher that matches if the examined {@link String} contains the specified
     * {@link String} anywhere.
     * <p/>
     * For example:
     * <pre>assertThat("myStringOfNote", containsString("ring"))</pre>
     *
     * @param substring the substring that the returned matcher will expect to find within any examined string
     */
    @Factory
    public static Matcher<CharSequence> containsString( CharSequence substring, boolean ignoreCase )
    {
        return new StringContainsMatcher( substring, ignoreCase );
    }

    @Override
    protected boolean evalSubstringOf( CharSequence s )
    {
        if( ignoreCase )
        {
            return s.toString().toLowerCase().contains( substring.toString().toLowerCase() );
        }

        return s.toString().contains( substring.toString() );
    }

    @Override
    protected String relationship()
    {
        return ignoreCase ? "containing ignoring case " : "containing case sensitive ";
    }
}
