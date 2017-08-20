package selenium.boot.hamcrest;


import org.hamcrest.Matcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class Assertion extends AbstractAssertion
{
    public static <T> void assertThat( T actual, Matcher<? super T> matcher )
    {
        assertThat( actual, matcher, getDescription( matcher ) );
    }

    public static <T> void assertThat( T actual, Matcher<? super T> matcher, String reason )
    {
        Assertion assertion = new Assertion();
        assertion.doAssert( assertion.createEvent( actual, matcher, reason ) );
    }
}
