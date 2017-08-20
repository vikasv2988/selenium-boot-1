package selenium.boot.hamcrest.matchers.text.pattern;

/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public interface SeparablePatternComponent extends PatternComponent
{
    PatternComponent separatedBy( Object separator );
}
