package selenium.boot.hamcrest.matchers.throwables;


import org.hamcrest.Factory;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class ThrowableCauseMatcher extends FeatureMatcher<Throwable, Throwable>
{
    private ThrowableCauseMatcher( Matcher<? super Throwable> causeMatcher )
    {
        super( causeMatcher, "exception with cause", "cause" );
    }

    @Factory
    public static Matcher<Throwable> hasCause( final Matcher<? super Throwable> matcher )
    {
        return new ThrowableCauseMatcher( matcher );
    }

    @Override
    protected Throwable featureValueOf( Throwable actual )
    {
        return actual.getCause();
    }
}
