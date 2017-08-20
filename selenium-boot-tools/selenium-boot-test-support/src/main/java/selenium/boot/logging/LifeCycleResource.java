package selenium.boot.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public abstract class LifeCycleResource
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( LifeCycleResource.class );

    public LifeCycleResource()
    {
        super();
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
     * @throws Throwable if teardown fails
     */
    protected void after() throws Throwable { /* no-op */ }

}
