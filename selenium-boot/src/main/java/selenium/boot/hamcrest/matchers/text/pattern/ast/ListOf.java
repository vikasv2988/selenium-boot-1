package selenium.boot.hamcrest.matchers.text.pattern.ast;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.SeparablePatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;

import static selenium.boot.hamcrest.matchers.text.pattern.Patterns.optional;
import static selenium.boot.hamcrest.matchers.text.pattern.Patterns.sequence;
import static selenium.boot.hamcrest.matchers.text.pattern.Patterns.toPattern;
import static selenium.boot.hamcrest.matchers.text.pattern.Patterns.zeroOrMore;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class ListOf implements SeparablePatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final PatternComponent element;

    private final PatternComponent separator;

    //endregion


    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        optional( sequence( element, zeroOrMore( sequence( separator, element ) ) ) )
                .buildRegex( builder, groups );
    }

    public PatternComponent separatedBy( Object separator )
    {
        return new ListOf( element, toPattern( separator ) );
    }
}
