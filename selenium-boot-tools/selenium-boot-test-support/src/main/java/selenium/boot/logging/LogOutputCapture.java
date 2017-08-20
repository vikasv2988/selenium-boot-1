package selenium.boot.logging;


import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;



/**
 * class to capture output from System.out and System.err.
 * 
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@NoArgsConstructor
public class LogOutputCapture
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------
    private static final Logger log = LoggerFactory.getLogger( LogOutputCapture.class );

    private CaptureOutputStream captureOut;

    private CaptureOutputStream captureErr;

    private ByteArrayOutputStream copy;


    //endregion


//    public Statement apply( final Statement base )
//    {
//        return new Statement()
//        {
//            @Override
//            public void evaluate() throws Throwable
//            {
//                captureOutput();
//                try
//                {
//
//                    base.evaluate();
//                }
//                finally
//                {
//                    try
//                    {
//                        System.out.println( "LogOutputCapture.evaluate" );
////                        if( !LogOutputCapture.this.matchers.isEmpty() )
////                        {
////                            String output = LogOutputCapture.this.toString();
////                            Assert.assertThat( output, allOf( LogOutputCapture.this.matchers ) );
////                        }
//                    }
//                    finally
//                    {
//                        releaseOutput();
//                    }
//                }
//            }
//        };
//    }

    public void captureOutput()
    {
        // FIXME AnsiOutput.setEnabled(Enabled.NEVER);
        this.copy = new ByteArrayOutputStream();
        this.captureOut = new CaptureOutputStream( System.out, this.copy );
        this.captureErr = new CaptureOutputStream( System.err, this.copy );

        System.setOut( new PrintStream( this.captureOut ) );
        System.setErr( new PrintStream( this.captureErr ) );
    }

    public void releaseOutput()
    {
        // FIXME AnsiOutput.setEnabled(Enabled.DETECT);
        System.setOut( this.captureOut.getOriginal() );
        System.setErr( this.captureErr.getOriginal() );

        this.copy = null;
    }

    public void flush()
    {
        try
        {
            this.captureOut.flush();
            this.captureErr.flush();
        }
        catch( IOException ex )
        {
            // ignore
        }
    }

    public String getOutput()
    {
        flush();
        return this.copy.toString();
    }


    //region Implementation of inner class CaptureOutputStream

    //---------------------------------------------------------------------
    // Implementation of inner class CaptureOutputStream
    //---------------------------------------------------------------------


    private static class CaptureOutputStream extends OutputStream
    {

        private final PrintStream original;

        private final OutputStream copy;

        CaptureOutputStream( PrintStream original, OutputStream copy )
        {
            this.original = original;
            this.copy = copy;
        }

        @Override
        public void write( int b ) throws IOException
        {
            this.copy.write( b );
            this.original.write( b );
            this.original.flush();
        }

        @Override
        public void write( byte[] b ) throws IOException
        {
            write( b, 0, b.length );
        }

        @Override
        public void write( byte[] b, int off, int len ) throws IOException
        {
            this.copy.write( b, off, len );
            this.original.write( b, off, len );
        }

        public PrintStream getOriginal()
        {
            return this.original;
        }

        @Override
        public void flush() throws IOException
        {
            this.copy.flush();
            this.original.flush();
        }

    }

    //endregion
}
