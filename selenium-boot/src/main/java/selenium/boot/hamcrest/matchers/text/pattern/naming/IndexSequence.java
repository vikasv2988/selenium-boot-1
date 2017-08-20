package selenium.boot.hamcrest.matchers.text.pattern.naming;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class IndexSequence
{
    private int next = 0;

    public int next()
    {
        return next++;
    }
}
