package selenium.boot.logging;


/**
 * Represents one or more actions to be taken at runtime in the course of running a test suite.
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class Statement
{
    /**
     * Run the action, throwing a {@code Throwable} if anything goes wrong.
     */
    public abstract void evaluate() throws Throwable;
}
