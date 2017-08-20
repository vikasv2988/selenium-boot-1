package selenium.boot.hamcrest;


import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;
import org.hamcrest.internal.ReflectiveTypeFinder;
import selenium.boot.hamcrest.matchers.text.StringContainsMatcher;



/**
 * Convenience util for matching strings
 * most of the methods uses {@link java.lang.CharSequence} instance to allow for easy interopability between
 * String, StringBuffer, StringBuilder, CharBuffer, etc .
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see org.hamcrest.Matcher
 * @see selenium.boot.hamcrest.matchers.text.StringEqualsMatcher
 * @see selenium.boot.hamcrest.matchers.text.StringContainsMatcher
 * @since 1.0
 */
@UtilityClass
public class StringMatchers
{
    private static final ReflectiveTypeFinder TYPE_FINDER =
            new ReflectiveTypeFinder( "matchesSafely", 1, 0 );


    /**
     * Creates a matcher that matches if the examined {@link String} contains the specified
     * {@link java.lang.String} anywhere, case sensitive.
     * <p/>
     * For example:
     * <pre>assertThat("myStringOfNote", containsString("ring"))</pre>
     *
     * @param substring the substring that the returned matcher will expect to find within any examined string
     * @see #containsStringIgnoringCase(CharSequence)
     */
    public static Matcher<CharSequence> containsString( CharSequence substring )
    {
        return StringContainsMatcher.containsString( substring, false );
    }

    /**
     * Creates a matcher that matches if the examined {@link java.lang.String} contains the specified
     * {@link java.lang.String} anywhere, ignoring case.
     * <p/>
     * For example:
     * <pre>assertThat("myStringOfNote", containsString("ring"))</pre>
     *
     * @param substring the substring that the returned matcher will expect to find within any examined string
     * @see #containsString(CharSequence)
     */
    public static Matcher<CharSequence> containsStringIgnoringCase( CharSequence substring )
    {
        return StringContainsMatcher.containsString( substring, true );
    }
}
