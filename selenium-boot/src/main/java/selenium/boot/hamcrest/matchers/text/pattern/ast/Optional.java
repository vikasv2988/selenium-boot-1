package selenium.boot.hamcrest.matchers.text.pattern.ast;


import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class Optional extends PatternModifier implements PatternComponent
{
    public Optional( PatternComponent pattern )
    {
        super( pattern );
    }

    @Override
    protected void appendModifier( StringBuilder builder )
    {
        builder.append( "?" );
    }
}
