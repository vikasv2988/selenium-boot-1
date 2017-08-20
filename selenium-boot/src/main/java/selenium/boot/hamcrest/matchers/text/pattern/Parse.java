package selenium.boot.hamcrest.matchers.text.pattern;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;

import java.util.regex.MatchResult;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class Parse
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final GroupNamespace groups;

    private final MatchResult result;

    //endregion

    public String get( String name )
    {
        int groupIndex = groups.resolve( name );
        return result.group( groupIndex );
    }
}
