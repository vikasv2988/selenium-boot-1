package selenium.boot.hamcrest.matchers.throwables;


import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class ThrowableMessageMatcher extends FeatureMatcher<Throwable,String>
{
    private ThrowableMessageMatcher( Matcher<? super String> subMatcher )
    {
        super( subMatcher, "exception with message", "message" );
    }

    @Factory
    public static Matcher<Throwable> hasMessage( final Matcher<? super String> matcher )
    {
        return new ThrowableMessageMatcher( matcher );
    }

    @Override
    protected String featureValueOf( Throwable actual )
    {
        return actual.getMessage();
    }
}
