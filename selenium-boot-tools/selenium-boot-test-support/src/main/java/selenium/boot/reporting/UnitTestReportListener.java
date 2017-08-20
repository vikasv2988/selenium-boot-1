package selenium.boot.reporting;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class UnitTestReportListener implements IReporter
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( UnitTestReportListener.class );

    public UnitTestReportListener()
    {
        super();
    }

    //endregion


    /**
     * Generate a report for the given suites into the specified output directory.
     *
     * @param xmlSuites
     * @param suites
     * @param outputDirectory
     */
    @Override
    public void generateReport( List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory )
    {

    }
}
