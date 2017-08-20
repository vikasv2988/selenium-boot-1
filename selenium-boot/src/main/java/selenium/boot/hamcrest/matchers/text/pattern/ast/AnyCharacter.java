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
public class AnyCharacter implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    public static final AnyCharacter INSTANCE = new AnyCharacter();

    //endregion


    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        builder.append( "." );
    }
}
