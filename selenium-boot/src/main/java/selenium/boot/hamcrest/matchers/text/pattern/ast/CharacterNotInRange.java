package selenium.boot.hamcrest.matchers.text.pattern.ast;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class CharacterNotInRange implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final String range;

    //endregion

    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        builder.append( "[^" )
                .append( range )
                .append( "]" );
    }
}
