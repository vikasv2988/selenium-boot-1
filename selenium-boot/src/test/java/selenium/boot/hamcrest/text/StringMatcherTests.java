package selenium.boot.hamcrest.text;


import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.CoreMatchers;
import selenium.boot.hamcrest.matchers.text.pattern.Parse;
import selenium.boot.hamcrest.matchers.text.pattern.PatternComponent;
import selenium.boot.hamcrest.matchers.text.pattern.PatternMatchException;
import selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher;
import selenium.boot.hamcrest.matchers.text.pattern.Patterns;

import static selenium.boot.hamcrest.CoreMatchers.equalTo;
import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher.matchesPattern;
import static selenium.boot.hamcrest.matchers.text.pattern.Patterns.*;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@NoArgsConstructor
public class StringMatcherTests extends AbstractMatcherTest
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( StringMatcherTests.class.getName() );

    PatternMatcher scopedMatcher = new PatternMatcher( sequence(
            capture( "xs", oneOrMore( text( "x" ) ) ),
            capture( "inside", sequence(
                    capture( "xs", oneOrMore( text( "X" ) ) ),
                    valueOf( "xs" ) ) ), valueOf( "xs" ) ) );

    //endregion


    //region Tests

    //---------------------------------------------------------------------
    // Tests
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using plain text."
    )
    public void matchesPlainText() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( Patterns.text( "text" ) );

        String description = getDescription( matchesPattern( matcher ) );
        assertMatches( "text", matchesPattern( matcher )
                , "\"text\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "xxxtextxxx", not( matchesPattern( matcher ) )
                , "\"xxxtextxxx\" matches " + description
        );

        assertMatches( "tex", not( matchesPattern( matcher ) )
                , "\"tex\" matches " + description
        );
        assertMatches( "blah", not( matchesPattern( matcher ) )
                , "\"blah\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using special characters."
    )
    public void matchesPlainTextContainingSpecialRegexCharacters() throws Exception
    {
        describeTestCase();

        Matcher<String> matcher = matchesPattern( new PatternMatcher( text( "*star*" ) ) );
        String description = getDescription( matcher );
        assertMatches( "*star*", matcher, "\"*star*\" matches " + description );

        matcher = matchesPattern( new PatternMatcher( text( "-" ) ) );
        description = getDescription( matcher );
        assertMatches( "-", matcher, "\"-\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using test sequences."
    )
    public void matchesSequenceOfText() throws Exception
    {

        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( sequence( "hello", " ", "world" ) );
        String description = getDescription( matcher );
        assertMatches( "hello world", matchesPattern( matcher )
                , "\"hello world\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using either alternatives."
    )
    public void matchesAlternatives() throws Exception
    {

        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( either( text( "hello" ), text( "world" ) ) );
        String description = getDescription( matcher );

        assertMatches( "hello", matchesPattern( matcher )
                , "\"hello\" matches " + description
        );
        assertMatches( "world", matchesPattern( matcher )
                , "\"world\" matches " + description
        );
        assertMatches( "hello world", not( matchesPattern( matcher ) )
                , "\"hello world\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using optionals."
    )
    public void matchesOptionalPattern() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( sequence( text( "hello" ), optional( text( " world" ) ) ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "hello", matchesPattern( matcher )
                , "\"hello\" matches " + description
        );
        assertMatches( "hello world", matchesPattern( matcher )
                , "\"hello world\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( " world", not( matchesPattern( matcher ) )
                , "\" world\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using none or more matches."
    )
    public void matchesRepetitionZeroOrMoreTimes() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( zeroOrMore( text( "x" ) ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "", matchesPattern( matcher )
                , "\"\" matches " + description
        );
        assertMatches( "x", matchesPattern( matcher )
                , "\"x\" matches " + description
        );
        assertMatches( "xxx", matchesPattern( matcher )
                , "\"xxx\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( " xx", not( matchesPattern( matcher ) )
                , "\" xx\" matches " + description
        );
        assertMatches( "x x", not( matchesPattern( matcher ) )
                , "\"x x\" matches " + description
        );
        assertMatches( "xx ", not( matchesPattern( matcher ) )
                , "\"xx \" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using one or more matches."
    )
    public void matchesRepetitionOneOrMoreTimes() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( oneOrMore( text( "x" ) ) );

        String description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "", not( matchesPattern( matcher ) ),
                       "\"\" matches " + description
        );
        assertMatches( " xx", not( matchesPattern( matcher ) ),
                       "\" xx\" matches " + description
        );
        assertMatches( "x x", not( matchesPattern( matcher ) ),
                       "\"x x\" matches " + description
        );
        assertMatches( "xx ", not( matchesPattern( matcher ) ),
                       "\"xx \" matches " + description
        );

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( "x", matchesPattern( matcher ),
                       "\"x\" matches " + description
        );
        assertMatches( "xxx", matchesPattern( matcher ),
                       "\"xxx\" matches " + description
        );


        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using any character."
    )
    public void testCanMatchAnyCharacter() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( sequence( text( "x" ), anyCharacter(), text( "y" ) ) );

        String description = getDescription( matchesPattern( matcher ) );
        assertMatches( "x.y", matchesPattern( matcher ),
                       "\"x.y\" matches " + description
        );
        assertMatches( "xzy", matchesPattern( matcher ),
                       "\"xzy\" matches " + description
        );
        assertMatches( "xy", not( matchesPattern( matcher ) ),
                       "\"xy\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching groups."
    )
    public void testCapturesMatchedGroups() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher(
                sequence( capture( "xs", oneOrMore( text( "x" ) ) ), capture( "ys", oneOrMore( text( "y" ) ) ) ) );

        Parse parse;

        parse = matcher.parse( "xxxyyy" );

        Matcher<String> parsed = CoreMatchers.is( parse.get( "xs" ) );
        String description = getDescription( parsed );
        assertMatches( "xxx", parsed, "\"XXX\" matches " + description );

        parsed = CoreMatchers.is( parse.get( "ys" ) );
        description = getDescription( parsed );
        assertMatches( "yyy", parsed, "\"yyy\" matches " + description );



        parse = matcher.parse( "xxyyyyyy" );
        parsed = CoreMatchers.is( parse.get( "xs" ) );
        description = getDescription( parsed );
        assertMatches( "xx", parsed, "\"xx\" matches " + description );

        parsed = CoreMatchers.is( parse.get( "ys" ) );
        description = getDescription( parsed );
        assertMatches( "yyyyyy", parsed, "\"yyyyyy\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class fails.",
            expectedExceptions = { PatternMatchException.class }
    )
    public void testFailsIfDoesNotMatchParseInput() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( text( "expected input" ) );
        matcher.parse( "input that doesn't match" );
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using " +
                                  "content references to matching groups."
    )
    public void testCanReferToContentOfMatchedGroups() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher =
                new PatternMatcher( sequence( capture( "first", oneOrMore( text( "x" ) ) ),
                                              text( "-" ), valueOf( "first" ) )
        );

        String description = getDescription( matchesPattern( matcher ) );
        assertMatches( "x-x", matchesPattern( matcher ),
                       "\"x-x\" matches " + description
        );
        assertMatches( "xx-xx", matchesPattern( matcher ),
                       "\"xx-xx\" matches " + description
        );

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( "x-xx", not( matchesPattern( matcher ) ),
                       "\"x-xx\" matches " + description
        );
        assertMatches( "xx-x", not( matchesPattern( matcher ) ),
                       "\"xx-x\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class using " +
                                  "references to lexical scoped groups."
    )
    public void testReferencesToGroupsAreLexicallyScoped() throws Exception
    {
        describeTestCase();

        String description = getDescription( matchesPattern( this.scopedMatcher ) );
        assertMatches( "xxXXXXxx", matchesPattern( this.scopedMatcher ),
                       "\"xxXXXXxx\" matches " + description
        );
        assertMatches( "xXXx", matchesPattern( this.scopedMatcher ),
                       "\"xXXx\" matches " + description
        );

        description = getDescription( not( matchesPattern( this.scopedMatcher ) ) );
        assertMatches( "xXxx", not( matchesPattern( this.scopedMatcher ) ),
                       "\"xXxx\" matches " + description
        );
        assertMatches( "xXXX", not( matchesPattern( this.scopedMatcher ) ),
                       "\"xXXX\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching paths"
    )
    public void testNamesInInnerScopesCanBeQueriedUsingDottedPathNotation() throws Exception
    {
        describeTestCase();

        Parse parse = scopedMatcher.parse( "xxXXXXXXxx" );

        Matcher<String> parsed = CoreMatchers.is( parse.get( "xs" ) );
        String description = getDescription( parsed );
        assertMatches( "xx", parsed,"\"xx\" matches " + description );

        parsed = CoreMatchers.is( parse.get( "inside.xs" ) );
        description = getDescription( parsed );
        assertMatches( "XXX", parsed,"\"XXX\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching dotted paths"
    )
    public void testCanReferToValuesOfGroupsInInnerScopesUsingDottedPathNotation() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher(
                sequence( capture( "xs", oneOrMore( text( "x" ) ) ),
                          capture( "inside", sequence(
                                  capture( "xs", oneOrMore( text( "X" ) ) ),
                                  valueOf( "xs" ) ) ),
                          valueOf( "xs" ),
                          valueOf( "inside.xs" ) )
        );

        String description = getDescription( matchesPattern( matcher ) );
        assertMatches( "xXXXXxXX", matchesPattern( matcher ),"\"xXXXXxXX\" matches " + description );
        assertMatches( "xxXXxxX", matchesPattern( matcher ),"\"xxXXxxX\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching " +
                                  "other patterns e.g. email address."
    )
    public void testCanDefinePatternsInTermsOfExistingPatterns() throws Exception
    {
        describeTestCase();

        PatternMatcher emailAddressMatcher = new PatternMatcher(
                sequence( capture( "user", oneOrMore( anyCharacter() ) ), "@",
                          capture( "host", oneOrMore( anyCharacter() ) ) )
        );
        String description = getDescription( matchesPattern( emailAddressMatcher ) );
        assertMatches( "mailto:npryce@users.sf.net", matchesPattern( emailAddressMatcher ),
                       "\"mailto:npryce@users.sf.net\" matches " + description
        );


        PatternMatcher mailToURLMatcher = new PatternMatcher(
                sequence( capture( "scheme", text( "mailto" ) ), ":",
                          capture( "email", emailAddressMatcher ) )
        );

        description = getDescription( matchesPattern( mailToURLMatcher ) );
        assertMatches( "mailto:npryce@users.sf.net", matchesPattern( mailToURLMatcher ),
                       "\"mailto:npryce@users.sf.net\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching any character in a string"
    )
    public void matchesCharacterInList()
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( anyCharacterIn( "0123456789" ) );
        String description = getDescription( matchesPattern( matcher ) );

        for( int i = 0; i < 9; i++ )
        {
            String input = String.valueOf( i );
            assertMatches( input, matchesPattern( matcher ),
                           "\"" + input + "\" matches " + description
            );
        }

        assertDoesNotMatch( "X", matchesPattern( matcher ), "\"X\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching a calculated character range."
    )
    public void matchesCharacterRange() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( anyCharacterIn( "0-9" ) );
        String description = getDescription( matchesPattern( matcher ) );

        for( int i = 0; i < 9; i++ )
        {
            String input = String.valueOf( i );
            assertMatches( input, matchesPattern( matcher ),
                           "\"" + input + "\" matches " + description
            );
        }

        assertDoesNotMatch( "X", matchesPattern( matcher ), "\"X\" matches " + description );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "not matching all characters on a calculated character range."
    )
    public void matchesCharacterNotInRange() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( anyCharacterNotIn( "0-9" ) );
        String description = getDescription( not( matchesPattern( matcher ) ) );

        for( int i = 0; i < 9; i++ )
        {
            String input = String.valueOf( i );
            assertMatches( input, not( matchesPattern( matcher ) ),
                           "\"" + input + "\" matches " + description
            );
        }

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( "X", matchesPattern( matcher ),
                       "\"X\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching unicode characters."
    )
    public void matchesCharactersInUnicodeCategories() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( anyCharacterInCategory( "Lu" ) );

        String description = getDescription( matchesPattern( matcher ) );
        assertMatches( "A", matchesPattern( matcher ),
                       "\"A\" matches " + description
        );
        assertMatches( "B", matchesPattern( matcher ),
                       "\"B\" matches " + description
        );


        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "a", not( matchesPattern( matcher ) ),
                       "\"a\" matches " + description
        );
        assertMatches( "b", not( matchesPattern( matcher ) ),
                       "\"b\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class NOT matching unicode characters."
    )
    public void matchesCharactersNotInUnicodeCategories() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( anyCharacterNotInCategory( "Lu" ) );

        assertMatches( "A", not( matchesPattern( matcher ) ) );
        assertMatches( "a", matchesPattern( matcher ) );
        assertMatches( "B", not( matchesPattern( matcher ) ) );
        assertMatches( "b", matchesPattern( matcher ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching exactly number of repetitions."
    )
    public void matchesExactlyTheSpecifiedNumberOfRepetitions() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( exactly( 3, "x" ) );
        String description = getDescription( not( matchesPattern( matcher ) ) );

        assertMatches( "xx", not( matchesPattern( matcher ) ),
                       "\"xx\" matches " + description
        );
        assertMatches( "xxxx", not( matchesPattern( matcher ) ),
                       "\"xxxx\" matches " + description
        );

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( "xxx", matchesPattern( matcher ),
                       "\"xxx\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching a range of allowable repetitions."
    )
    public void matchesARangeOfAllowableRepetitions() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( from( 3, 5, "x" ) );

        String description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "xx", not( matchesPattern( matcher ) ),
                       "\"xx\" matches " + description
        );

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( "xxx", matchesPattern( matcher ),
                       "\"xxx\" matches " + description
        );
        assertMatches( "xxxx", matchesPattern( matcher ),
                       "\"xxxx\" matches " + description
        );
        assertMatches( "xxxxx", matchesPattern( matcher ),
                       "\"xxxxx\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "xxxxxx", not( matchesPattern( matcher ) ),
                       "\"xxxxxx\" matches " + description
        );
        
        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching a list of string."
    )
    public void matchesAListOfMatchedThings() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( listOf( "x" ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "", matchesPattern( matcher ),
                       "\"\" matches " + description
        );
        assertMatches( "x", matchesPattern( matcher ),
                       "\"x\" matches " + description
        );
        assertMatches( "x,x", matchesPattern( matcher ),
                       "\"x,x\" matches " + description
        );
        assertMatches( "x,x,x,x,x", matchesPattern( matcher ),
                       "\"x,x,x,x,x\" matches " + description
        );

        description = getDescription( matchesPattern( matcher ) );
        assertMatches( ",", not( matchesPattern( matcher ) ),
                       "\",\" matches " + description
        );
        assertMatches( "x,x,x,", not( matchesPattern( matcher ) ),
                       "\"x,x,x,\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching a list with specific separator."
    )
    public void matchesAListWithSpecificSeparator() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( listOf( "x" ).separatedBy( ":" ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "", matchesPattern( matcher ),
                       "\"\" matches " + description
        );
        assertMatches( "x", matchesPattern( matcher ),
                       "\"x\" matches " + description
        );
        assertMatches( "x:x", matchesPattern( matcher ),
                       "\"x:x\" matches " + description
        );
        assertMatches( "x:x:x:x:x", matchesPattern( matcher ),
                       "\"x:x:x:x:x\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "x,x,x", not( matchesPattern( matcher ) ),
                       "\"x,x,x\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching whitespace"
    )
    public void matchesWhitespace() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( sequence( "a", whitespace(), "z" ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "az", matchesPattern( matcher ),
                       "\"az\" matches " + description
        );
        assertMatches( "a z", matchesPattern( matcher ),
                       "\"a z\" matches " + description
        );
        assertMatches( "a \t z", matchesPattern( matcher ),
                       "\"a \t z\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching a sequence " +
                                  "separated by a pattern."
    )
    public void matchesSequenceSeparatedByPattern() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( separatedBy( ",", "a", "b", "c" ) );
        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "a,b,c", matchesPattern( matcher ),
                       "\"a,b,c\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class matching case-sensitive " +
                                  "characters/strings."
    )
    public void canControlCaseSensitivity() throws Exception
    {
        describeTestCase();

        PatternMatcher matcher = new PatternMatcher( sequence( "a", caseInsensitive(
                sequence( "b", caseSensitive( "c" ) ) ) )
        );

        String description = getDescription( matchesPattern( matcher ) );

        assertMatches( "abc", matchesPattern( matcher ),
                       "\"abc\" matches " + description
        );
        assertMatches( "aBc", matchesPattern( matcher ),
                       "\"aBc\" matches " + description
        );

        description = getDescription( not( matchesPattern( matcher ) ) );
        assertMatches( "aBC", not( matchesPattern( matcher ) ),
                       "\"aBC\" matches " + description );

        assertAll();
    }

    //endregion


    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.PatternMatcher class " +
                                  "matching different types of ranges."
    )
    public void miscRangesTest() throws Exception
    {

        describeTestCase();

        PatternComponent month =
                either( "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" );
        PatternComponent digit = anyCharacterInCategory( "Digit" );
        PatternComponent date =
                separatedBy( whitespace(),
                             capture( "day", exactly( 2, digit ) ),
                             capture( "month", caseInsensitive( month ) ),
                             capture( "year", exactly( 4, digit ) )
                );
        PatternMatcher dateRange =
                new PatternMatcher( separatedBy( whitespace(),
                                                 capture( "from", date ),
                                                 "-",
                                                 capture( "to", date )
                ) );

        String input = "31 Dec 2003 - 16 aug 2008";
        Parse parse = dateRange.parse( input );

        String description = getDescription( equalTo( "31 Dec 2003" ) );
        assertMatches( parse.get( "from" ), equalTo( "31 Dec 2003" ),
                       "\"parse.get( \"from\" )\" matches " + description
        );

        description = getDescription( equalTo( "16 aug 2008" ) );
        assertMatches( parse.get( "to" ), equalTo( "16 aug 2008" ),
                       "\"parse.get( \"to\" )\" matches " + description
        );

        description = getDescription( equalTo( "31" ) );
        assertMatches( parse.get( "from.day" ), equalTo( "31" ),
                       "\"parse.get( \"from.day\" )\" matches " + description
        );

        description = getDescription( equalTo( "Dec" ) );
        assertMatches( parse.get( "from.month" ), equalTo( "Dec" ),
                       "\"parse.get( \"from.month\" )\" matches " + description
        );

        description = getDescription( equalTo( "2003" ) );
        assertMatches( parse.get( "from.year" ), equalTo( "2003" ),
                       "\"parse.get( \"from.year\" )\" matches " + description
        );

        description = getDescription( equalTo( "16" ) );
        assertMatches( parse.get( "to.day" ), equalTo( "16" ),
                       "\"parse.get( \"to.day\" )\" matches " + description
        );

        description = getDescription( equalTo( "aug" ) );
        assertMatches( parse.get( "to.month" ), equalTo( "aug" ),
                       "\"parse.get( \"to.month\" )\" matches " + description
        );

        description = getDescription( equalTo( "2008" ) );
        assertMatches( parse.get( "to.year" ), equalTo( "2008" ),
                       "\"parse.get( \"to.year\" )\" matches " + description
        );

        assertMatches( input, dateRange );
        String badInput = "31 12 2003 - 16 08 2008";
        assertMatches( badInput, not( dateRange ) );

        assertAll();
    }

}
