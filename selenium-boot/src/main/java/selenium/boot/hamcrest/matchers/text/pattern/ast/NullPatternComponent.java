package selenium.boot.hamcrest.matchers.text.pattern.ast;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class NullPatternComponent implements PatternComponent
{
    public static final PatternComponent INSTANCE = new NullPatternComponent();

    public void buildRegex( StringBuilder builder, GroupNamespace groups ) { /* no-op */ }
}
