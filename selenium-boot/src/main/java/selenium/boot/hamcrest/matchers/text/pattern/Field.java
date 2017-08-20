package selenium.boot.hamcrest.matchers.text.pattern;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.ast.CaptureGroup;
import selenium.boot.hamcrest.matchers.text.pattern.ast.Literal;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@NoArgsConstructor( access = AccessLevel.PUBLIC )
public class Field implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    @Getter( AccessLevel.PUBLIC )
    private String name;
    
    private PatternComponent sequence;

    public Field( String name, PatternComponent pattern )
    {
        this.name = name;
        Object[] args = new Object[] { "\"", new CaptureGroup( name, pattern ), new Literal( "\"" ) };
        this.sequence = Patterns.sequence( args );
    }

    //endregion

    @Override
    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        sequence.buildRegex( builder, groups );
    }
}
