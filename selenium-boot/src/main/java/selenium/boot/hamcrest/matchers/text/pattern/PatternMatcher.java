package selenium.boot.hamcrest.matchers.text.pattern;


import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class PatternMatcher extends TypeSafeMatcher<String> implements PatternComponent
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private GroupNamespace groups = new GroupNamespace();

    private PatternComponent root;

    private Pattern pattern;

    public PatternMatcher( PatternComponent root )
    {
        this.root = root;
        this.pattern = compile( root, groups );
    }

    //endregion

    private static Pattern compile( PatternComponent root, GroupNamespace groups )
    {
        StringBuilder builder = new StringBuilder();
        root.buildRegex( builder, groups );
        return Pattern.compile( builder.toString() );
    }

    @Factory
    public static PatternMatcher matchesPattern( PatternComponent pattern )
    {
        return new PatternMatcher( pattern );
    }

    @Factory
    public static PatternMatcher matchesPattern( PatternMatcher pattern )
    {
        return pattern;
    }

    public void describeTo( Description description )
    {
        description.appendText( "a string matching " );
        description.appendValue( this.toString() );
    }

    public String toString()
    {
        return pattern.toString();
    }

    public boolean matchesSafely( String s )
    {
        return pattern.matcher( s ).matches();
    }

    public Parse parse( String input ) throws PatternMatchException
    {
        Matcher matcher = pattern.matcher( input );
        if( matcher.matches() )
        {
            return new Parse( groups, matcher );
        }
        else
        {
            throw new PatternMatchException( "did not match input: " + input );
        }
    }

    public void buildRegex( StringBuilder builder, GroupNamespace groups )
    {
        root.buildRegex( builder, groups );
    }
}
