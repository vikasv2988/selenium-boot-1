package selenium.boot.hamcrest.matchers.text.pattern;


import selenium.boot.hamcrest.matchers.text.pattern.ast.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@SuppressWarnings( "SameParameterValue" )
public abstract class Patterns
{

    public static PatternComponent anyCharacter()
    {
        return AnyCharacter.INSTANCE;
    }

    public static PatternComponent anyCharacterIn( String range )
    {
        return new CharacterInRange( range );
    }

    public static PatternComponent anyCharacterNotIn( String range )
    {
        return new CharacterNotInRange( range );
    }

    public static PatternComponent anyCharacterNotInCategory( String category )
    {
        return new CharacterNotInUnicodeCategory( category );
    }

    public static PatternComponent either( Object... alternatives )
    {
        return new Choice( toPatterns( alternatives ) );
    }

    public static PatternComponent[] toPatterns( Object... args )
    {
        PatternComponent[] patterns = new PatternComponent[ args.length ];
        for( int i = 0; i < patterns.length; i++ )
        {
            patterns[ i ] = toPattern( args[ i ] );
        }
        return patterns;
    }

    public static PatternComponent toPattern( Object object )
    {
        if( object instanceof PatternComponent )
        {
            return ( PatternComponent ) object;
        }
        else
        {
            return text( object.toString() );
        }
    }

    public static PatternComponent text( String text )
    {
        return new Literal( text );
    }

    public static PatternComponent optional( Object o )
    {
        return new Optional( toPattern( o ) );
    }

    public static PatternComponent oneOrMore( Object o )
    {
        return new OneOrMore( toPattern( o ) );
    }

    public static PatternComponent capture( String name, PatternComponent pattern )
    {
        return new CaptureGroup( name, pattern );
    }

    public static PatternComponent valueOf( String name )
    {
        return new GroupReference( name );
    }

    public static PatternComponent exactly( int requiredCount, Object o )
    {
        return new Exactly( requiredCount, toPattern( o ) );
    }

    public static PatternComponent from( int minimumCount,
                                         int maximumCount,
                                         Object o )
    {
        return new FromTo( minimumCount, maximumCount, toPattern( o ) );
    }

    public static SeparablePatternComponent listOf( Object element )
    {
        return new ListOf( toPattern( element ), toPattern( "," ) );
    }

    public static PatternComponent whitespace()
    {
        return zeroOrMore( anyCharacterInCategory( "Space" ) );
    }

    public static PatternComponent zeroOrMore( Object o )
    {
        return new ZeroOrMore( toPattern( o ) );
    }

    public static PatternComponent anyCharacterInCategory( String category )
    {
        return new CharacterInUnicodeCategory( category );
    }

    public static PatternComponent separatedBy( Object separator, Object... elements )
    {
        List<Object> separated = new ArrayList<>( elements.length * 2 - 1 );

        separated.add( elements[ 0 ] );
        for( int i = 1; i < elements.length; i++ )
        {
            separated.add( separator );
            separated.add( elements[ i ] );
        }

        return sequence( separated.toArray() );
    }

    public static PatternComponent sequence( Object... elements )
    {
        return new Sequence( toPatterns( elements ) );
    }

    public static PatternComponent caseInsensitive( Object o )
    {
        return new Flags( "i", toPattern( o ) );
    }

    public static PatternComponent caseSensitive( Object o )
    {
        return new Flags( "-i", toPattern( o ) );
    }
}
