package selenium.boot.hamcrest;


import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
abstract class AbstractAssertion //implements MatcherAssetLifeCycle
{
    //region initialization and constructors section

    private final Logger log = LoggerFactory.getLogger( getClass().getName() );

    //endregion


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
            throw ex;
        }
        finally
        {
            onAfterAssert( assertCommand );
        }
    }

    public static String getDescription( Matcher<?> matcher )
    {
        Description description = new StringDescription();
        matcher.describeTo( description );
        String full = description.toString().trim();
        return StringUtils.abbreviate( full, 60 );
    }

    private <T> String getMismatchDescription( Matcher<?> matcher, T arg )
    {
        Description description = new StringDescription();
        matcher.describeMismatch( arg, description );
        return description.toString().trim();
    }

    <T> MatcherAssertEvent<T> createEvent( T actual, Matcher<? super T> matcher, String reason )
    {
        return new SimpleMatcherAssert<T>( actual, matcher, reason )
        {

            @Override
            public void doAssert()
            {
                if( !matcher.matches( actual ) )
                {
                    Description description = new StringDescription();
                    description.appendText( reason )
                            .appendText( "\nExpected: " )
                            .appendDescriptionOf( matcher )
                            .appendText( "\n     but: " );
                    matcher.describeMismatch( actual, description );
                    throw new AssertionError( description.toString() );
                }
            }
        };
    }


    //region Implementation of IMatcherAssetLifeCycle interface

    //---------------------------------------------------------------------
    // Implementation of IMatcherAssetLifeCycle interface
    //---------------------------------------------------------------------

    void onBeforeAssert( MatcherAssertEvent<?> ac )
    {
        log.info( "executing [ {} ]", ac.getMessage() );
    }

    void executeAssert( MatcherAssertEvent<?> assertCommand )
    {
        assertCommand.doAssert();
    }

    void onAssertSuccess( MatcherAssertEvent<?> ac )
    {
        log.info( "[ " + ac.getMessage() + " ] success: '" + getDescription( ac.getMatcher() ) + "'" );
    }

    void onAssertFailure( MatcherAssertEvent<?> ac, AssertionError ex )
    {
        log.error( "[ " + ac.getMessage() + " ] failed because: '" + getMismatchDescription( ac.getMatcher(), ac.getActual() ) + "'" );
    }

    void onAfterAssert( MatcherAssertEvent<?> assertCommand )
    {
        System.out.println( "\n" );
    }

    //endregion

    //region Implementation of MatcherAssertEvent interface

    //---------------------------------------------------------------------
    // Implementation of MatcherAssertEvent interface
    //---------------------------------------------------------------------

    abstract static class SimpleMatcherAssert<T> implements MatcherAssertEvent<T>
    {
        private final T actual;

        private final String message;

        private Matcher<? super T> matcher;

        SimpleMatcherAssert( @Nullable T actual, Matcher<? super T> matcher, String message )
        {
            this.actual = actual;
            this.matcher = matcher;
            this.message = message;
        }

        @Override
        public String getMessage()
        {
            return message;
        }

        @Override
        abstract public void doAssert();

        @Override
        public T getActual()
        {
            return actual;
        }

        @Override
        public Matcher<? super T> getMatcher()
        {
            return matcher;
        }
    }
}
