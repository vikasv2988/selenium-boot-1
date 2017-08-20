package selenium.boot.hamcrest;


import de.vandermeer.asciitable.v2.V2_AsciiTable;
import de.vandermeer.asciitable.v2.render.V2_AsciiTableRenderer;
import de.vandermeer.asciitable.v2.render.V2_TableRenderer;
import de.vandermeer.asciitable.v2.render.WidthFixedColumns;
import de.vandermeer.asciitable.v2.themes.V2_E_TableThemes;
import org.hamcrest.Matcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.collections.Maps;

import java.util.Map;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class SoftMatcherAssert extends AbstractAssertion
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( SoftMatcherAssert.class );

    private final Map<AssertionError, MatcherAssertEvent<?>> errors = Maps.newLinkedHashMap();

    private SoftMatcherAssert() {}

    public static SoftMatcherAssert start()
    {
        return new SoftMatcherAssert();
    }

    //endregion

    public <T> void assertThat( T actual, Matcher<? super T> matcher )
    {
        assertThat( actual, matcher, getDescription( matcher ) );
    }

    public <T> void assertThat( T actual, Matcher<? super T> matcher, String reason )
    {
        doAssert( createEvent( actual, matcher, reason ) );
    }

    @Override
    protected void doAssert( MatcherAssertEvent<?> event )
    {
        onBeforeAssert( event );
        try
        {
            event.doAssert();
            onAssertSuccess( event );
        }
        catch( AssertionError ex )
        {
            onAssertFailure( event, ex );
            errors.put( ex, event );
        }
        finally
        {
            onAfterAssert( event );
        }
    }

    public void assertAll()
    {
        if( !errors.isEmpty() )
        {
            V2_AsciiTable tbl = new V2_AsciiTable( 1 );
            tbl.addRule();
            StringBuilder sb = new StringBuilder( "The following asserts failed:" );
            boolean first = true;
            for( Map.Entry<AssertionError, MatcherAssertEvent<?>> ae : errors.entrySet() )
            {
                tbl.addRow( ae.getValue().getMessage(), ae.getKey().getMessage() );
                tbl.addRule();
            }
            V2_TableRenderer renderer = new V2_AsciiTableRenderer();
            renderer.setWidth( new WidthFixedColumns().add( 60 ).add( 100 ) )
                    .setTheme( V2_E_TableThemes.PLAIN_7BIT_STRONG.get() );

            throw new AssertionError( "\"The following asserts failed:\n" + renderer.render( tbl ).toString() );
        }
    }
}
