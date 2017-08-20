package selenium.boot.hamcrest.matchers.text.pattern.ast;


import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class Sequence implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final PatternComponent[] elements;

    public Sequence( PatternComponent[] alternatives )
    {
        this.elements = alternatives.clone();
    }

    //endregion


    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        for( PatternComponent element : elements )
        {
            element.buildRegex( builder, groups );
        }
    }
}
