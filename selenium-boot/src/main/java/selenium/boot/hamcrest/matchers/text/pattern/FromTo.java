package selenium.boot.hamcrest.matchers.text.pattern;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class FromTo implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private int minimumNumber;

    private int maximumNumber;

    private PatternComponent repeatedPattern;

    //endregion

    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        repeatedPattern.buildRegex( builder, groups );
        builder.append( "{" );
        builder.append( minimumNumber );
        builder.append( "," );
        builder.append( maximumNumber );
        builder.append( "}" );

    }
}
