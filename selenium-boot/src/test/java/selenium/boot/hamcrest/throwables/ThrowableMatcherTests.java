package selenium.boot.hamcrest.throwables;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;

import static selenium.boot.hamcrest.CoreMatchers.equalTo;
import static selenium.boot.hamcrest.CoreMatchers.instanceOf;
import static selenium.boot.hamcrest.CoreMatchers.is;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class ThrowableMatcherTests extends AbstractMatcherTest
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( ThrowableMatcherTests.class );

    //endregion


    @Test
    public void assertThatIncludesDescriptionOfTestedValueInErrorMessage()
    {
        describeTestCase();

        String expected = "expected";
        String actual = "actual";

        String expectedMessage = "identifier\nExpected: \"expected\"\n     but: was \"actual\"";

        try
        {
            assertMatches( actual, equalTo( expected ), "identifier" );
        }
        catch( AssertionError e )
        {
            String description = getDescription( equalTo( expectedMessage ) );
            assertMatches( e.getMessage(), equalTo( expectedMessage ), "\"e.getMessage()\" matches " + description );
        }

        assertAll();
    }


    @Test
    public void assertThatIncludesAdvancedMismatch()
    {

        describeTestCase();

        String expectedMessage = "identifier\nExpected: is an instance of java.lang.Integer\n     but: \"actual\" is a java.lang.String";

        try
        {
            assertMatches( "actual", is( instanceOf( Integer.class ) ), "identifier" );
        }
        catch( AssertionError e )
        {
            String description = getDescription( equalTo( expectedMessage ) );
            assertMatches( e.getMessage(), equalTo( expectedMessage ), "\"e.getMessage()\" matches " + description  );
        }

        assertAll();
    }
}
