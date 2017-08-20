package selenium.boot.hamcrest;


import org.hamcrest.Matcher;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
interface MatcherAssertEvent<T>
{
    String getMessage();

    void doAssert();

    T getActual();

    Matcher<? super T> getMatcher();
}
