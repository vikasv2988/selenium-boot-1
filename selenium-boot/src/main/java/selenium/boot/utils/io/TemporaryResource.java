package selenium.boot.utils.io;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;

import java.io.File;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public abstract class TemporaryResource extends FileSystemResource
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( TemporaryResource.class );

    protected TemporaryResource( File file )
    {
        super( file );
    }

    protected TemporaryResource( String path )
    {
        super( path );
    }

    //endregion

    /**
     * Override to set up your specific external resource.
     *
     * @throws Throwable if setup fails (which will disable {@code after}
     */
    protected void before() throws Throwable { /* no-op */ }

    /**
     * Override to tear down your specific external resource.
     *
     * @throws Throwable if tear-down fails
     */
    protected void after() throws Throwable { /* no-op */ }
}
