package selenium.boot.hamcrest.matchers.text.pattern.ast;


import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class PatternModifier implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private PatternComponent pattern;

    protected PatternModifier( PatternComponent pattern )
    {
        this.pattern = pattern;
    }

    //endregion

    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        builder.append( "(?:" );
        pattern.buildRegex( builder, groups );
        builder.append( ")" );
        appendModifier( builder );
    }

    protected abstract void appendModifier( StringBuilder builder );
}
