package springframework.context.scheeduling.concurrent;


import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.util.StringUtils;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.SoftMatcherAssert;
import selenium.boot.hamcrest.StringMatchers;
import selenium.boot.logging.LogOutputCapture;

import java.util.concurrent.TimeUnit;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class ConcurrentTaskExecutorTests extends AbstractMatcherTest
{
    //region initialization and constructors section

    private Logger log = LoggerFactory.getLogger( ConcurrentTaskExecutorTests.class );

    private LogOutputCapture output;

    public ConcurrentTaskExecutorTests()
    {
        super();
    }

    //endregion


    @Test(
            description = "Validates a ConcurrentTaskExecutor execution output log"
    )
    public void zeroArgCtorResultsInDefaultTaskExecutorBeingUsed() throws Exception
    {
        SoftMatcherAssert softAssert = SoftMatcherAssert.start();
        output = new LogOutputCapture();
        String logOut = "";
        try
        {
            this.output.captureOutput();
            ConcurrentTaskExecutor executor = new ConcurrentTaskExecutor();
            executor.execute( new NoOpRunnable() );
        }
        finally
        {
            for( int i = 0; i < 5; i++ )
            {
                logOut = this.output.getOutput().trim();
                if( StringUtils.hasLength( logOut ) ) break;
                Uninterruptibles.sleepUninterruptibly( 200, TimeUnit.MILLISECONDS );
            }

            logOut = this.output.getOutput().trim();
            this.output.releaseOutput();
        }

        String desc = getDescription( StringMatchers.containsString( "NoOpRunnable is running" ) );
        softAssert.assertThat( logOut,
                               StringMatchers.containsString( "NoOpRunnable is running" ),
                              "\"logOut\" matches " + desc
        );

        desc = getDescription( StringMatchers.containsString( "pool-1-thread-1" ) );
        softAssert.assertThat( logOut,
                               StringMatchers.containsString( "pool-1-thread-1" ),
                               "\"logOut\" matches " + desc
        );

        softAssert.assertAll();
    }

    @Test
    public void passingNullExecutorToCtorResultsInDefaultTaskExecutorBeingUsed() throws Exception
    {
        ConcurrentTaskExecutor executor = new ConcurrentTaskExecutor( null );
        executor.execute( new NoOpRunnable() );
    }

    @Test
    public void passingNullExecutorToSetterResultsInDefaultTaskExecutorBeingUsed() throws Exception
    {
        ConcurrentTaskExecutor executor = new ConcurrentTaskExecutor();
        executor.setConcurrentExecutor( null );
        executor.execute( new NoOpRunnable() );
    }
}
