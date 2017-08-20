package selenium.boot.test;


import com.google.common.base.Throwables;
import lombok.AccessLevel;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.test.context.TestContextManager;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



/**
 * Abstract base test class which integrates the <em>Spring TestContext Framework</em>
 * with explicit {@link org.springframework.context.ApplicationContext} testing support in a <strong>TestNG</strong>
 * environment.
 * <p>
 * Concrete subclasses:
 * <ul>
 *     <li>Typically declare a class-level {@link org.springframework.test.context.ContextConfiguration
 *         &#064;ContextConfiguration} annotation to configure the
 *         {@linkplain org.springframework.context.ApplicationContext application context}
 *         {@linkplain org.springframework.test.context.ContextConfiguration#locations() resource locations}
 *         or {@linkplain org.springframework.test.context.ContextConfiguration#classes() annotated classes}.
 *         <em>If your test does not need to load an application context, you may choose to omit the
 *         {@code @ContextConfiguration} declaration and to configure the appropriate
 *         {@link org.springframework.test.context.TestExecutionListeners TestExecutionListeners} manually.</em>
 *     </li>
 *     <li>Must have constructors which either implicitly or explicitly delegate to {@code super();}.</li>
 * </ul>
 * <p>
 * The following {@link org.springframework.test.context.TestExecutionListeners TestExecutionListeners} are configured by default:
 * <p>
 * <ul>
 *     <li>{@link OverrideDirtiesContextBeforeModesTestExecutionListener}
 *     <li>{@link OverrideDependencyInjectionTestExecutionListener}
 *     <li>{@link org.springframework.test.context.support.DirtiesContextTestExecutionListener}
 * </ul>
 *
 * @author Sam Brannen
 * @author Juergen Hoeller
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see org.springframework.test.context.ContextConfiguration
 * @see org.springframework.test.context.TestExecutionListeners
 * @see OverrideDirtiesContextBeforeModesTestExecutionListener
 * @see OverrideDependencyInjectionTestExecutionListener
 * @see org.springframework.test.context.support.DirtiesContextTestExecutionListener
 * @see org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests
 * @since 1.0
 */
public class AbstractTestNgSpringContextTests implements IHookable, ApplicationContextAware
{
    //region initialization and constructors section

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    protected final Logger log = LoggerFactory.getLogger(  getClass().getName() );

    private final TestContextManager testContextManager;

    /**
     * The {@link ApplicationContext} that was injected into this test instance
     * via {@link #setApplicationContext(ApplicationContext)}.
     */
    @Nullable
    @Setter( AccessLevel.PUBLIC )
    protected ApplicationContext applicationContext;

    @Nullable
    private Throwable testException;


    /**
     * Construct a new AbstractTestNGTestContext instance and initialize
     * the internal {@link org.springframework.test.context.TestContextManager} for the current test class.
     */
    public AbstractTestNgSpringContextTests()
    {
        this.testContextManager = new TestContextManager( getClass() );
    }

    //endregion


    //region TestNG configuration methods

    //---------------------------------------------------------------------
    // TestNG configuration methods
    //---------------------------------------------------------------------

    @BeforeSuite( alwaysRun = false )
    public static void alwaysBeforeSuite() {}

    @BeforeSuite(
            enabled = true,
            alwaysRun = true
    )
    public final void springTestContextBeforeSuite( ITestContext testContext, XmlTest suiteXml ) throws Exception
    {
        try
        {
            System.out.println( "AbstractTestNGSpringContextTests.beforeSuite" );
        }
        catch( Exception e )
        {
            throw e;
        }
    }

    @BeforeTest(
            enabled = true,
            alwaysRun = true
    )
    public final void springTestContextBeforeTest( ITestContext testContext ) throws Exception
    {
        try
        {
            System.out.println( "AbstractTestNGSpringContextTests.springTestContextBeforeTest" );
        }
        catch( Exception e )
        {
            Throwables.throwIfInstanceOf( e, SkipException.class );
            throw e;
        }
    }

    @BeforeClass(
            alwaysRun = true,
            description = "Delegates to the configured TestContextManager to call #beforeTestClass() callbacks."
    )
    protected void springTestContextBeforeTestClass( ITestContext context ) throws Exception
    {

        try
        {
            this.testContextManager.beforeTestClass();// context );
        }
        catch( Exception e )
        {
            Throwables.throwIfInstanceOf( e, SkipException.class );
            throw e;
        }
    }

    @BeforeClass(
            alwaysRun = true,
            description = "Delegates to the configured TestContextManager to #prepareTestInstance(Object) prepare this test" +
                                  "instance prior to execution of any individual tests, for example for injecting dependencies, etc.",
            dependsOnMethods = "springTestContextBeforeTestClass"
    )
    protected void springTestContextPrepareTestInstance( ITestContext context ) throws Exception
    {
        try
        {
            this.testContextManager.prepareTestInstance( this );//, context );
        }
        catch( Exception e )
        {
            Throwables.throwIfInstanceOf( e, SkipException.class );
            throw e;
        }
    }

    @BeforeMethod(
            alwaysRun = true,
            description = "Delegates to the configured TestContextManager to #beforeTestMethod(Object, Method) pre-process " +
                                  "the test method before the actual test is executed."
    )
    protected void springTestContextBeforeTestMethod( ITestContext context, Method testMethod, Object[] parameters ) throws Exception
    {
        try
        {
            this.testContextManager.beforeTestMethod( this, testMethod );
        }
        catch( Exception e )
        {
            Throwables.throwIfInstanceOf( e, SkipException.class );
            throw e;
        }
    }

    /**
     * Delegates to the configured {@link TestContextManager} to
     * {@linkplain TestContextManager#afterTestMethod(Object, Method, Throwable)
     * post-process} the test method after the actual test has executed.
     *
     * @param testMethod the test method which has just been executed on the test instance
     *
     * @throws Exception allows all exceptions to propagate
     */
    @AfterMethod(
            alwaysRun = true,
            description = "Delegates to the configured TestContextManager to post-process methods.\n" +
                                  "the test method after the actual test has executed." )
    protected void springTestContextAfterTestMethod( Method testMethod ) throws Exception
    {
        try
        {
            System.out.println( "AbstractTestNGSpringContextTests.springTestContextAfterTestMethod" );
            // this.testContextManager.afterTestMethod( this, testMethod, this.testException );
        }
        finally
        {
            this.testException = null;
        }
    }

    /**
     * Delegates to the configured {@link TestContextManager} to call
     * {@linkplain TestContextManager#afterTestClass() 'after test class'} callbacks.
     *
     * @throws Exception if a registered TestExecutionListener throws an exception
     */
    @AfterClass( alwaysRun = true, description = " Delegates to the configured  TestContextManager to call after test class callbacks")
    protected void springTestContextAfterTestClass() throws Exception
    {
        this.testContextManager.afterTestClass();
    }


    //endregion






    //region Implementation of IHookable interface

    //---------------------------------------------------------------------
    // Implementation of IHookable interface
    //---------------------------------------------------------------------

    /**
     * Delegates to the {@linkplain IHookCallBack#runTestMethod(ITestResult) test method} in the supplied
     * {@code callback} to execute the actual test and then tracks the exception thrown during test execution, if any.
     *
     * @see org.testng.IHookable#run(IHookCallBack, ITestResult)
     */
    @SuppressWarnings( "ThrowableNotThrown" )
    @Override
    public void run( IHookCallBack callBack, ITestResult testResult )
    {
        Method testMethod = testResult.getMethod().getConstructorOrMethod().getMethod();
        boolean beforeCallbacksExecuted = false;

        try
        {
            this.testContextManager.beforeTestExecution( this, testMethod );
            beforeCallbacksExecuted = true;
        }
        catch( Throwable ex )
        {
            this.testException = ex;
        }

        if( beforeCallbacksExecuted )
        {
            callBack.runTestMethod( testResult );
            this.testException = getTestResultException( testResult );
        }

        try
        {
            this.testContextManager.afterTestExecution( this, testMethod, this.testException );
        }
        catch( Throwable ex )
        {
            if( this.testException == null )
            {
                this.testException = ex;
            }
        }

        if( this.testException != null )
        {
            throwAsUncheckedException( this.testException );
        }
    }

    //endregion


    private Throwable getTestResultException( ITestResult testResult )
    {
        Throwable testResultException = testResult.getThrowable();
        if( testResultException instanceof InvocationTargetException )
        {
            testResultException = testResultException.getCause();
        }
        return testResultException;
    }

    @Nullable
    private RuntimeException throwAsUncheckedException( Throwable t )
    {
        throwAs( t );

        // Appeasing the compiler: the following line will never be executed.
        return null;
    }

    @SuppressWarnings( "unchecked" )
    private <T extends Throwable> void throwAs( Throwable t ) throws T
    {
        throw ( T ) t;
    }
}
