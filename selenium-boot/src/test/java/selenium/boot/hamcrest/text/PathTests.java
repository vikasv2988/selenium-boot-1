package selenium.boot.hamcrest.text;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.matchers.text.pattern.naming.Path;

import static selenium.boot.hamcrest.CoreMatchers.equalTo;
import static selenium.boot.hamcrest.CoreMatchers.is;
import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.CoreMatchers.nullValue;



public class PathTests extends AbstractMatcherTest
{
    private static final Logger log = LoggerFactory.getLogger( GroupNamespaceTests.class.getName() );


    //region Tests

    //---------------------------------------------------------------------
    // Tests
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path comparisons."
    )
    public void testCanBeComparedForEquality()
    {
        describeTestCase();

        assertMatches( new Path( "a", "b" ), equalTo( new Path( "a", "b" ) ) );
        assertDoesNotMatch( new Path( "a", "b" ), equalTo( new Path( "a" ) ) );
        assertDoesNotMatch( new Path( "a", "b" ), equalTo( new Path( "a", "b", "c" ) ) );
        assertMatches( new Path( "a", "b" ), not( equalTo( new Path( "x", "y" ) ) ) );
        assertDoesNotMatch( new Path( "a", "b" ), nullValue() );
        assertMatches( new Path(), equalTo( new Path() ) );
        assertMatches( new Path( "a", "b" ), equalTo( new Path( "x", "a", "b" ).tail() ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path length comparisons."
    )
    public void testReturnsLengthAndComponents()
    {
        describeTestCase();

        Path abc = new Path( "a", "b", "c" );
        assertMatches( abc.size(), is( equalTo( 3 ) ) );
        assertMatches( abc.component( 0 ), equalTo( "a" ) );
        assertMatches( abc.component( 1 ), equalTo( "b" )  );
        assertMatches( abc.component( 2 ), equalTo( "c" )  );

        Path xy = new Path( "x", "y" );
        assertMatches( xy.size(), is( equalTo( 2 ) ) );
        assertMatches( xy.component( 0 ), equalTo( "x" ) );
        assertMatches( xy.component( 1 ),equalTo( "y" )   );
        assertMatches( new Path().size(), is( equalTo( 0 ) ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path heads check."
    )
    public void testReturnsHead()
    {
        describeTestCase();

        assertMatches( new Path( "a", "b", "c", "d" ).head(), equalTo( "a" ) );
        assertMatches( new Path( "x", "y", "z" ).head(), equalTo( "x" ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path tail check."
    )
    public void testReturnsTail()
    {
        describeTestCase();

        assertMatches( new Path( "a", "b", "c", "d" ).tail(),
                       equalTo( new Path( "b", "c", "d" ) )
        );
        assertMatches( new Path( "x", "y", "z" ).tail(),
                       equalTo( new Path( "y", "z" ) )
        );
        assertMatches( new Path( "a" ).tail(),
                       equalTo( new Path() ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path parsing check."
    )
    public void testParsesPathFromDottedNotation()
    {
        describeTestCase();

        assertMatches( Path.parse( "a" ), equalTo( new Path( "a" ) ) );
        assertMatches( Path.parse( "a.b.c" ), equalTo( new Path( "a", "b", "c" ) ) );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.Path toString check."
    )
    public void testReturnsDottedPathNotationFromToString()
    {
        describeTestCase();

        assertMatches( new Path( "a" ).toString(), equalTo( "a" ) );
        assertMatches( new Path( "a", "b", "c" ).toString(), equalTo( "a.b.c" ) );

        assertAll();
    }


    //endregion
}
