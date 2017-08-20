package selenium.boot.hamcrest.text;


import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace;
import selenium.boot.hamcrest.matchers.text.pattern.naming.Path;

import static selenium.boot.hamcrest.CoreMatchers.is;



public class GroupNamespaceTests extends AbstractMatcherTest
{

    private static final Logger log = LoggerFactory.getLogger( GroupNamespaceTests.class.getName() );

    private GroupNamespace groupNamespace = new GroupNamespace();

    //region Tests

    //---------------------------------------------------------------------
    // Tests
    //---------------------------------------------------------------------
    
    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "binds indices to allocated indices starting from 1"
    )
    public void testBindsIndicesToNamesAllocatingIndicesFromOne() throws Exception
    {
        describeTestCase();
        this.groupNamespace = new GroupNamespace();
        this.groupNamespace.create( "a" );
        this.groupNamespace.create( "b" );

        Matcher<Integer> matcher = is( groupNamespace.resolve( "a" ) );
        String description = getDescription( matcher );
        assertMatches( 1, matcher, "\"1\" matches " + description );

        matcher = is( groupNamespace.resolve( "b" ) );
        description = getDescription( matcher );
        assertMatches( 2, matcher, "\"2\" matches " + description );

        assertAll();
    }


    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "throws IllegalArgumentException since name was not bound.",
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "name 'not bound' not bound"
    )
    public void testThrowsIllegalArgumentExceptionIfNameNotBound() throws Exception
    {
        describeTestCase();
        this.groupNamespace.resolve( "not bound" );
    }

    @Test(
            enabled = true,
            dependsOnMethods = { "testBindsIndicesToNamesAllocatingIndicesFromOne" },
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "throws IllegalArgumentException because of duplicate bound name.",
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "duplicate name 'a'"
    )

    public void testThrowsIllegalArgumentExceptionIfDuplicateNameBound() throws Exception
    {
        describeTestCase();
        this.groupNamespace.create( "a" );
    }


    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "looks for a name in parent environment if not found locally"
    )
    public void testLooksForNameInParentEnvironmentIfNotFoundLocally() throws Exception
    {
        describeTestCase();

        groupNamespace = new GroupNamespace();
        this.groupNamespace.create( "a" );
        GroupNamespace b = this.groupNamespace.create( "b" );

        Matcher<Integer> matcher = is( b.resolve( "a" ) );
        String description = getDescription( matcher );
        assertMatches( this.groupNamespace.resolve( "a" ), matcher,
                       "\"groupNamespace resolve('a')\" matches " + description
        );

        assertAll();
    }

    @Test(
            enabled = true,
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "allocates indices and resolve paths within child environment"
    )
    public void testAllocatesIndicesForAndResolvesPathsWithinChildEnvironments() throws Exception
    {
        describeTestCase();

        this.groupNamespace = new GroupNamespace();
        GroupNamespace a = this.groupNamespace.create( "a" );
        a.create( "x" );
        a.create( "y" );
        GroupNamespace b = this.groupNamespace.create( "b" );
        b.create( "x" );
        b.create( "y" );

        assertMatches( 2, is( this.groupNamespace.resolve( new Path( "a", "x" ) ) ) );
        assertMatches( 3, is( this.groupNamespace.resolve( new Path( "a", "y" ) ) ) );
        assertMatches( 5, is( this.groupNamespace.resolve( new Path( "b", "x" ) ) ) );
        assertMatches( 6, is( this.groupNamespace.resolve( new Path( "b", "y" ) ) ) );
        assertMatches( this.groupNamespace.resolve( new Path( "b", "y" ) ),
                       is(  a.resolve( new Path( "b", "y" ) ) ) );

        assertAll();
    }

    @Test(
            enabled = true,
            dependsOnMethods = { "testBindsIndicesToNamesAllocatingIndicesFromOne",
                                 "testThrowsIllegalArgumentExceptionIfDuplicateNameBound" },
            description = "Validates selenium.boot.hamcrest.matchers.text.pattern.naming.GroupNamespace " +
                                  "throws IllegalArgumentException because bounds were not created.",
            expectedExceptions = { IllegalArgumentException.class },
            expectedExceptionsMessageRegExp = "name 'b' not bound"
    )
    public void testThrowsIllegalArgumentExceptionIfMiddleOfPathNotBound() throws Exception
    {
        groupNamespace = new GroupNamespace();
        this.groupNamespace.create( "a" );
        this.groupNamespace.resolve( new Path( "a", "b", "c" ) );
    }

    //endregion
}
