package springframework.context.scheeduling.concurrent;


/**
 * A no-op Runnable implementation.
 *
 * @author Rick Evans
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class NoOpRunnable implements Runnable
{
    @Override
    public void run()
    {
        System.out.println( "NoOpRunnable is running" );
        System.out.println( "NoOpRunnable thread name: " + Thread.currentThread().getName()  );
    }
}
