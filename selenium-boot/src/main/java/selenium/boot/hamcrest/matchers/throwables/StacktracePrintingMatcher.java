package selenium.boot.hamcrest.matchers.throwables;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.io.PrintWriter;
import java.io.StringWriter;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see <a href='https://github.com/hamcrest/hamcrest-junit/blob/master/src/main/java/org/hamcrest/junit/internal/StacktracePrintingMatcher.java'></a>
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public class StacktracePrintingMatcher<T extends Throwable> extends TypeSafeMatcher<T>
{
    private final Matcher<T> throwableMatcher;



    @Factory
    public static <T extends Throwable> Matcher<T> isThrowable( Matcher<T> throwableMatcher )
    {
        return new StacktracePrintingMatcher<T>( throwableMatcher );
    }

    @Factory
    public static <T extends Exception> Matcher<T> isException( Matcher<T> exceptionMatcher )
    {
        return new StacktracePrintingMatcher<T>( exceptionMatcher );
    }

    @Override
    public void describeTo( Description description )
    {
        throwableMatcher.describeTo( description );
    }

    @Override
    protected boolean matchesSafely( T item )
    {
        return throwableMatcher.matches( item );
    }

    @Override
    protected void describeMismatchSafely( T item, Description description )
    {
        throwableMatcher.describeMismatch( item, description );
        description.appendText( "\nStacktrace was: " );
        description.appendText( readStacktrace( item ) );
    }

    private String readStacktrace( Throwable throwable )
    {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace( new PrintWriter( stringWriter ) );
        return stringWriter.toString();
    }
}
