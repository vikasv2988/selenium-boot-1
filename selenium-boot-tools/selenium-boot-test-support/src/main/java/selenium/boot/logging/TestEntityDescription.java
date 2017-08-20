package selenium.boot.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class TestEntityDescription
{
    //region initialization and constructors section

    /**
     * Describes a Runner which runs no tests
     */
    public static final TestEntityDescription EMPTY = new TestEntityDescription( null, "No Tests" );

    /**
     * Describes a step in the test-running mechanism that goes so wrong no
     * other description can be used (for example, an exception thrown from a Runner's constructor
     */
    public static final TestEntityDescription TEST_MECHANISM = new TestEntityDescription( null, "Test mechanism" );

    private static final Logger log = LoggerFactory.getLogger( TestEntityDescription.class );

    private static final Pattern METHOD_AND_CLASS_NAME_PATTERN = Pattern.compile( "([\\s\\S]*)\\((.*)\\)" );

    private final Collection<TestEntityDescription> fChildren = new ConcurrentLinkedQueue<TestEntityDescription>();

    private final String fDisplayName;

    private final Serializable fUniqueId;

    private final Annotation[] fAnnotations;

    private volatile /* write-once */ Class<?> fTestClass;

    private TestEntityDescription( Class<?> clazz, String displayName, Annotation... annotations )
    {
        this( clazz, displayName, displayName, annotations );
    }

    private TestEntityDescription( Class<?> testClass, String displayName, Serializable uniqueId, Annotation... annotations )
    {
        if( ( displayName == null ) || ( displayName.length() == 0 ) )
        {
            throw new IllegalArgumentException( "The display name must not be empty." );
        }
        if( ( uniqueId == null ) )
        {
            throw new IllegalArgumentException( "The unique id must not be null." );
        }
        this.fTestClass = testClass;
        this.fDisplayName = displayName;
        this.fUniqueId = uniqueId;
        this.fAnnotations = annotations;
    }

    /**
     * Create a {@code TestEntityDescription} named {@code name}.
     * Generally, you will add children to this {@code TestEntityDescription}.
     *
     * @param name        the name of the {@code TestEntityDescription}
     * @param annotations meta-data about the test, for downstream interpreters
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createSuiteDescription( String name, Annotation... annotations )
    {
        return new TestEntityDescription( null, name, annotations );
    }

    /**
     * Create a {@code TestEntityDescription} named {@code name}.
     * Generally, you will add children to this {@code TestEntityDescription}.
     *
     * @param name        the name of the {@code TestEntityDescription}
     * @param uniqueId    an arbitrary object used to define uniqueness (in {@link #equals(Object)}
     * @param annotations meta-data about the test, for downstream interpreters
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createSuiteDescription( String name, Serializable uniqueId, Annotation... annotations )
    {
        return new TestEntityDescription( null, name, uniqueId, annotations );
    }

    /**
     * Create a {@code TestEntityDescription} of a single test named {@code name} in the 'class' named {@code className}.
     * Generally, this will be a leaf {@code TestEntityDescription}.
     * This method is a better choice than
     * {@linkplain #createTestDescription(Class, String, java.lang.annotation.Annotation...)} for test runners whose test cases are not
     * defined in an actual Java {@code Class}.
     *
     * @param className   the class name of the test
     * @param name        the name of the test (a method name for test annotated with {@link org.testng.annotations.Test})
     * @param annotations meta-data about the test, for downstream interpreters
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createTestDescription( String className, String name, Annotation... annotations )
    {
        return new TestEntityDescription( null, formatDisplayName( name, className ), annotations );
    }

    private static String formatDisplayName( String name, String className )
    {
        return String.format( "%s(%s)", name, className );
    }

    /**
     * Create a {@code TestEntityDescription} of a single test named {@code name} in the class {@code clazz}.
     * Generally, this will be a leaf {@code TestEntityDescription}.
     *
     * @param clazz       the class of the test
     * @param name        the name of the test (a method name for test annotated with {@link org.testng.annotations.Test})
     * @param annotations meta-data about the test, for downstream interpreters
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createTestDescription( Class<?> clazz, String name, Annotation... annotations )
    {
        return new TestEntityDescription( clazz, formatDisplayName( name, clazz.getName() ), annotations );
    }

    /**
     * Create a {@code TestEntityDescription} of a single test named {@code name} in the class {@code clazz}.
     * Generally, this will be a leaf {@code TestEntityDescription}.
     *
     * @param clazz the class of the test
     * @param name  the name of the test (a method name for test annotated with {@link org.testng.annotations.Test})
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createTestDescription( Class<?> clazz, String name )
    {
        return new TestEntityDescription( clazz, formatDisplayName( name, clazz.getName() ) );
    }

    /**
     * Create a {@code TestEntityDescription} of a single test named {@code name} in the class {@code clazz}.
     * Generally, this will be a leaf {@code TestEntityDescription}.
     *
     * @param name the name of the test (a method name for test annotated with {@link org.testng.annotations.Test})
     *
     * @return a {@code TestEntityDescription} named {@code name}
     */
    public static TestEntityDescription createTestDescription( String className, String name, Serializable uniqueId )
    {
        return new TestEntityDescription( null, formatDisplayName( name, className ), uniqueId );
    }

    /**
     * Create a {@code TestEntityDescription} named after {@code testClass}
     *
     * @param testClass A {@link Class} containing tests
     *
     * @return a {@code TestEntityDescription} of {@code testClass}
     */
    public static TestEntityDescription createSuiteDescription( Class<?> testClass )
    {
        return new TestEntityDescription( testClass, testClass.getName(), testClass.getAnnotations() );
    }

    /**
     * Create a {@code TestEntityDescription} named after {@code testClass}
     *
     * @param testClass   A not null {@link Class} containing tests
     * @param annotations meta-data about the test, for downstream interpreters
     *
     * @return a {@code TestEntityDescription} of {@code testClass}
     */
    public static TestEntityDescription createSuiteDescription( Class<?> testClass, Annotation... annotations )
    {
        return new TestEntityDescription( testClass, testClass.getName(), annotations );
    }

    /**
     * Add {@code TestEntityDescription} as a child of the receiver.
     *
     * @param description the soon-to-be child.
     */
    public void addChild( TestEntityDescription description )
    {
        fChildren.add( description );
    }

    /**
     * Gets the copy of the children of this {@code TestEntityDescription}.
     * Returns an empty list if there are no children.
     */
    public ArrayList<TestEntityDescription> getChildren()
    {
        return new ArrayList<TestEntityDescription>( fChildren );
    }

    /**
     * @return {@code true} if the receiver is a suite
     */
    public boolean isSuite()
    {
        return !isTest();
    }

    /**
     * @return {@code true} if the receiver is an atomic test
     */
    public boolean isTest()
    {
        return fChildren.isEmpty();
    }

    /**
     * @return the total number of atomic tests in the receiver
     */
    public int testCount()
    {
        if( isTest() )
        {
            return 1;
        }
        int result = 0;
        for( TestEntityDescription child : fChildren )
        {
            result += child.testCount();
        }
        return result;
    }

    @Override
    public int hashCode()
    {
        return fUniqueId.hashCode();
    }

    @Override
    public boolean equals( Object obj )
    {
        if( !( obj instanceof TestEntityDescription ) )
        {
            return false;
        }
        TestEntityDescription d = ( TestEntityDescription ) obj;
        return fUniqueId.equals( d.fUniqueId );
    }

    @Override
    public String toString()
    {
        return getDisplayName();
    }

    /**
     * @return true if this is a description of a Runner that runs no tests
     */
    public boolean isEmpty()
    {
        return equals( EMPTY );
    }

    /**
     * @return a copy of this description, with no children (on the assumption that some of the
     * children will be added back)
     */
    public TestEntityDescription childlessCopy()
    {
        return new TestEntityDescription( fTestClass, fDisplayName, fAnnotations );
    }

    /**
     * @return the annotation of type annotationType that is attached to this description node,
     * or null if none exists
     */
    public <T extends Annotation> T getAnnotation( Class<T> annotationType )
    {
        for( Annotation each : fAnnotations )
        {
            if( each.annotationType().equals( annotationType ) )
            {
                return annotationType.cast( each );
            }
        }
        return null;
    }

    /**
     * @return all of the annotations attached to this description node
     */
    public Collection<Annotation> getAnnotations()
    {
        return Arrays.asList( fAnnotations );
    }

    /**
     * @return If this describes a method invocation,
     * the class of the test instance.
     */
    public Class<?> getTestClass()
    {
        if( fTestClass != null )
        {
            return fTestClass;
        }
        String name = getClassName();
        if( name == null )
        {
            return null;
        }
        try
        {
            fTestClass = Class.forName( name, false, getClass().getClassLoader() );
            return fTestClass;
        }
        catch( ClassNotFoundException e )
        {
            return null;
        }
    }

    /**
     * @return If this describes a method invocation,
     * the name of the class of the test instance
     */
    public String getClassName()
    {
        return fTestClass != null ? fTestClass.getName() : methodAndClassNamePatternGroupOrDefault( 2, toString() );
    }

    /**
     * @return If this describes a method invocation,
     * the name of the method (or null if not)
     */
    public String getMethodName()
    {
        return methodAndClassNamePatternGroupOrDefault( 1, null );
    }

    private String methodAndClassNamePatternGroupOrDefault( int group,
                                                            String defaultString )
    {
        Matcher matcher = METHOD_AND_CLASS_NAME_PATTERN.matcher( toString() );
        return matcher.matches() ? matcher.group( group ) : defaultString;
    }

    /**
     * @return a user-understandable label
     */
    public String getDisplayName()
    {
        return fDisplayName;
    }
}
