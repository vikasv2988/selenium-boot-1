package selenium.boot.hamcrest.matchers.text.pattern;


import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public interface PatternComponent
{
    void buildRegex( StringBuilder builder, GroupNamespace groups );
}
