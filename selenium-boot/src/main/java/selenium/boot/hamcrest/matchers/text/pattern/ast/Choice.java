package selenium.boot.hamcrest.matchers.text.pattern.ast;


import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class Choice implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final PatternComponent[] alternatives;

    public Choice( PatternComponent[] alternatives )
    {
        this.alternatives = alternatives.clone();
    }

    //endregion


    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        builder.append( "(?:" );
        boolean needsSeparator = false;
        for( PatternComponent alternative : alternatives )
        {
            if( needsSeparator )
            {
                builder.append( "|" );
            }
            else
            {
                needsSeparator = true;
            }

            alternative.buildRegex( builder, groups );
        }
        builder.append( ")" );
    }
}
