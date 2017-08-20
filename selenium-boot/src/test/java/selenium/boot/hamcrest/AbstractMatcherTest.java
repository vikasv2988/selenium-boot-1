package selenium.boot.hamcrest;


import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.Reporter;

import java.util.Map;
import java.util.regex.Pattern;



/**
 * An abstract library test for Hamcrest matchers tests.
 * since checkpoints cannot be used while validating matchers.
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see MatcherAssetLifeCycle
 * @see MatcherAssertEvent
 * @see #doAssert(MatcherAssertEvent)
 * @since 2.0
 */
@NoArgsConstructor( access = AccessLevel.PROTECTED )
public abstract class
AbstractMatcherTest implements MatcherAssetLifeCycle
{
    //region initialization and constructors section

    protected final Logger log = LoggerFactory.getLogger( getClass().getName() );

    protected static final Object ARGUMENT_IGNORED = new Object();

    protected static final Object ANY_NON_NULL_ARGUMENT = new Object();

    private final Map<AssertionError, MatcherAssertEvent<?>> errors = Maps.newLinkedHashMap();

    //endregion



    //region Assert collections

    //---------------------------------------------------------------------
    // Assert collections
    //---------------------------------------------------------------------


    protected <T> void assertMatches( T arg, Matcher<T> matcher )
    {
        assertMatches( arg, matcher, getDescription( matcher ) );
    }

    protected <T> void assertMatches( T arg, Matcher<T> matcher, String message )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert<T>( matcher, arg, message )
        {

            @Override
            public void doAssert()
            {
                Assert.assertTrue( matcher.matches( arg ), message );
            }
        } );
    }

    protected <T> void assertDoesNotMatch( T arg, Matcher<? super T> matcher )
    {
        assertDoesNotMatch( arg, matcher, "Unexpected match" );
    }

    @SuppressWarnings( "unchecked" )
    protected  <T> void assertDoesNotMatch( T arg, Matcher<? super T> matcher, String message )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert<T>( ( Matcher<T> ) matcher, arg, message )
        {
            @Override
            public void doAssert()
            {
                Assert.assertFalse( matcher.matches( arg ), message );
            }
        } );
    }

    /**
     * validates a description
     * @param expected
     * @param matcher
     */
    public static void assertDescription( String expected, Matcher<?> matcher )
    {
        Description description = new StringDescription();
        description.appendDescriptionOf( matcher );
        Assert.assertEquals( "Expected description", expected, description.toString() );
    }

    @SuppressWarnings( "unchecked" )
    protected <T> void assertMismatchDescription( T arg, Matcher<? super T> matcher, String expected )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert<T>( ( Matcher<T> ) matcher, arg, expected )
        {
            @Override
            public void doAssert()
            {
                Assert.assertFalse( matcher.matches( arg ), "Precondition: Matcher should not match item." );
                Assert.assertEquals( expected, getMismatchDescription( matcher, arg ), "Expected mismatch description" );
            }
        } );
    }

    @SuppressWarnings( "unchecked" )
    protected <T> void assertMismatchDescription( T arg, Matcher<? super T> matcher, Pattern expected )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert<T>( ( Matcher<T> ) matcher, arg, expected.pattern() )
        {
            @Override
            public void doAssert()
            {
                Assert.assertFalse( matcher.matches( arg ), "Precondition: Matcher should not match item." );
                Assert.assertTrue( expected.matcher( getMismatchDescription( matcher, arg ) ).matches(), "Expected mismatch description pattern" );
            }
        } );
    }

    @SuppressWarnings( "unchecked" )
    void assertDescription( Matcher<?> matcher, String expected )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert( matcher, null, expected )
        {
            @Override
            public void doAssert()
            {
                Description description = new StringDescription();
                description.appendDescriptionOf( matcher );
                Assert.assertEquals( expected, description.toString().trim(), "Expected description" );
            }
        } );
    }

    @SuppressWarnings( "unchecked" )
    void assertNullSafe( Matcher<?> matcher )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert( matcher, null, null )
        {
            @Override
            public void doAssert()
            {
                try
                {
                    matcher.matches( null );
                }
                catch( Exception e )
                {
                    Assert.fail( "Matcher was not null safe" );
                }
            }
        } );
    }

    @SuppressWarnings( "unchecked" )
    void assertUnknownTypeSafe( Matcher<?> matcher )
    {
        doAssert( new AbstractMatcherTest.SimpleAssert( matcher, null, null )
        {
            @Override
            public void doAssert()
            {
                try
                {
                    matcher.matches( new AbstractMatcherTest.UnknownType() );
                }
                catch( Exception e )
                {
                    Assert.fail("Matcher was not unknown type safe, because: " + e );
                }
            }
        } );
    }

    //endregion

    public void testIsNullSafe()
    {
        // should not throw a NullPointerException
        //createMatcher().matches( null );
    }

    public void testCopesWithUnknownTypes()
    {
        // should not throw ClassCastException
        //createMatcher().matches( new UnknownType() );
    }


    protected void describeTestCase()
    {
        ITestNGMethod iTestNGMethod = Reporter.getCurrentTestResult().getMethod();
        log.info( "Executing test : \n|-- name: {}\n|-- description: {} ",
                  iTestNGMethod.getQualifiedName(), iTestNGMethod.getDescription()
        );

    }



    //region Implementation of IMatcherAssetLifeCycle interface

    //---------------------------------------------------------------------
    // Implementation of IMatcherAssetLifeCycle interface
    //---------------------------------------------------------------------

    @Override
    public void onBeforeAssert( MatcherAssertEvent<?> ac )
    {
        log.info( "executing [ {} ]", ac.getMessage() );
    }

    @Override
    public void executeAssert( MatcherAssertEvent<?> assertCommand )
    {
        assertCommand.doAssert();
    }

    @Override
    public void onAssertSuccess( MatcherAssertEvent<?> ac )
    {
        log.info( "[ " + ac.getMessage() + " ] success: '" + getDescription( ac.getMatcher() ) + "'" );
    }

    @Override
    public void onAssertFailure( MatcherAssertEvent<?> ac, AssertionError ex )
    {
        log.error( "[ " + ac.getMessage() + " ] failed because: '" + getMismatchDescription( ac.getMatcher(), ac.getActual() ) + "'" );
    }

    @Override
    public void onAfterAssert( MatcherAssertEvent<?> assertCommand )
    {
        System.out.println( "\n" );
    }

    /**
     * assertion life cycle
     *
     * @param assertCommand the assertion command that includes assertion and test information
     */
    protected void doAssert( MatcherAssertEvent<?> assertCommand )
    {
        onBeforeAssert( assertCommand );
        try
        {
            executeAssert( assertCommand );
            onAssertSuccess( assertCommand );
        }
        catch( AssertionError ex )
        {
            onAssertFailure( assertCommand, ex );
            //errors.put( ex, assertCommand );
        }
        finally
        {
            onAfterAssert( assertCommand );
        }
    }

    @Deprecated
    protected void assertAll()
    {
        if( ! errors.isEmpty() )
        {
            int i = 1;
            StringBuilder sb = new StringBuilder( "The following <" )
                                       .append( errors.size() )
                                       .append( "> " )
                                       .append( "assertions failed:" );
            boolean first = true;
            for( Map.Entry<AssertionError, MatcherAssertEvent<?>> ae : errors.entrySet() )
            {
                if( first )
                {
                    first = false;
                }
                else
                {
                    sb.append( "," );
                }

                sb.append( "\n" ).append( i ++ ).append( ".\t" );
                sb.append( ae.getKey().getMessage() );
            }

            errors.clear();
            throw new AssertionError( sb.toString() );
        }
    }

    //endregion


    protected String getDescription( Matcher<?> matcher )
    {
        Description description = new StringDescription();
        matcher.describeTo( description );
        String full = description.toString().trim();
        return StringUtils.abbreviate( full, 60 );
    }

    protected <T> String getMismatchDescription( Matcher<?> matcher, T arg )
    {
        Description description = new StringDescription();
        matcher.describeMismatch( arg, description );
        return description.toString().trim();
    }


    //region Implementation of inner class SimpleAssert

    //---------------------------------------------------------------------
    // Implementation of inner class SimpleAssert
    //---------------------------------------------------------------------

    @AllArgsConstructor
    @Getter( AccessLevel.PUBLIC )
    abstract private class SimpleAssert<T> implements MatcherAssertEvent<T>
    {
        private final Matcher<T> matcher;

        private final T actual;

        private final String message;

        @Override
        abstract public void doAssert();
    }

    //endregion

    @SuppressWarnings("WeakerAccess")
    public static class UnknownType { /* empty */ }

}
