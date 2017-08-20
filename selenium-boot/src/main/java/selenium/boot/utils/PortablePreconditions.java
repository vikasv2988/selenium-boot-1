package selenium.boot.utils;


import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;



/**
 * Assertion utility class with static convenience methods that help a method or constructor check whether it was invoked correctly.
 * and also that assists in validating arguments.
 * Useful for identifying programmer errors early and clearly at runtime.
 * <p>
 * For example, if the contract of a public method states it does not allow {@code null} arguments,
 * {@code PortablePreconditions} can be used to validate that contract.
 * Doing this clearly indicates a contract violation when it occurs and protects the class's invariants.
 * <p>
 * Typically used to validate method arguments rather than configuration properties,
 * to check for cases that are usually programmer errors rather than configuration errors.
 * In contrast to configuration initialization code, there is usually no point in falling back to defaults in such methods.
 * <p>
 * If an argument value is deemed invalid, an {@link IllegalArgumentException} is thrown (typically).
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see com.google.common.base.Preconditions
 * @see org.apache.commons.lang3.Validate
 * @since 1.0
 */
@UtilityClass
public class PortablePreconditions
{
    //region Google guava wrapper extension implementations IllegalStateException

    //---------------------------------------------------------------------
    // Google guava wrapper extension implementations IllegalStateException
    //---------------------------------------------------------------------

    /**
     * Ensures the truth of an expression involving the state of the calling instance
     *
     * @param name      of the parameter or expression
     * @param condition itself
     *
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void checkState( final String name, final boolean condition )
    {
        if( !condition )
        {
            throw new IllegalStateException( "Condition '" + name + "' is invalid!" );
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param name                 of parameter or expression
     * @param condition            a boolean expression
     * @param errorMessageTemplate a template for the exception message should the check fail.
     *                             The message is formed by replacing each {@code %s} placeholder in the template with an argument.
     *                             These are matched by position - the first {@code %s} gets {@code errorMessageArgs[0]}, etc.
     *                             Unmatched arguments will be appended to the formatted message in square braces.
     *                             Unmatched placeholders will be left as-is.
     * @param errorMessageArgs     the arguments to be substituted into the message template. Arguments
     *                             are converted to strings using {@link String#valueOf(Object)}.
     *
     * @throws IllegalStateException if {@code expression} is false
     * @throws NullPointerException  if the check fails and either {@code errorMessageTemplate} or
     *                               {@code errorMessageArgs} is null (don't let this happen)
     */
    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object... errorMessageArgs )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, errorMessageArgs ) );
            throw new IllegalStateException( msg );
        }
    }

    /**
     * Substitutes each {@code %s} in {@code template} with an argument.
     * These are matched by position: the first {@code %s} gets {@code args[0]}, etc.
     * If there are more arguments than placeholders, the unmatched arguments will be appended to the end of the formatted message in square braces.
     *
     * @param template a non-null string containing 0 or more {@code %s} placeholders.
     * @param args     the arguments to be substituted into the message template.
     *                 Arguments are converted to strings using {@link String#valueOf(Object)}. Arguments can be null.
     */
    static String format( String template, Object... args )
    {
        template = String.valueOf( template ); // null -> "null"

        /* start substituting the arguments into the '%s' placeholders */
        StringBuilder builder = new StringBuilder( template.length() + 16 * args.length );
        int templateStart = 0;
        int i = 0;
        while( i < args.length )
        {
            int placeholderStart = template.indexOf( "%s", templateStart );
            if( placeholderStart == -1 )
            {
                break;
            }

            builder.append( template, templateStart, placeholderStart );
            builder.append( args[ i++ ] );
            templateStart = placeholderStart + 2;
        }
        builder.append( template, templateStart, template.length() );

        if( i < args.length )
        {
            builder.append( " [ " );
            builder.append( args[ i++ ] );
            while( i < args.length )
            {
                builder.append( ", " );
                builder.append( args[ i++ ] );
            }
            builder.append( " ]" );
        }

        return builder.toString();
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   char p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   int p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   long p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   boolean p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   float p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   double p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }

    public static void checkState( String name,
                                   boolean condition,
                                   String errorMessageTemplate,
                                   Object p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalStateException( msg );
        }
    }


    //endregion


    //region Google guava wrapper extension implementations IllegalArgumentException

    //---------------------------------------------------------------------
    // Google guava wrapper extension implementations IllegalArgumentException
    //---------------------------------------------------------------------

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s",
                                 name, format( errorMessageTemplate, p1 )
            );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, char p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, char p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, int p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, long p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, boolean p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, float p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, double p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, int p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, long p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, boolean p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, float p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, double p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    public static void checkArgument( String name, boolean condition, String errorMessageTemplate, Object p1, Object p2 )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, p1, p2 ) );
            throw new IllegalArgumentException( msg );
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param name                 of the argument
     * @param condition            a boolean expression
     * @param errorMessageTemplate a template for the exception message should the check fail.
     *                             The message is formed by replacing each {@code %s} placeholder in the template with an argument.
     * @param errorMessageArgs     the arguments to be substituted into the message template.
     *
     * @throws IllegalArgumentException if {@code expression} is false
     * @throws NullPointerException     if the check fails and either {@code errorMessageTemplate} or
     *                                  {@code errorMessageArgs} is null (don't let this happen)
     */
    public static void checkArgument( String name,
                                      boolean condition,
                                      String errorMessageTemplate,
                                      Object... errorMessageArgs )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, errorMessageArgs ) );
            throw new IllegalArgumentException( msg );
        }
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param name                 of the reference.
     * @param reference            an object reference
     * @param errorMessageTemplate a template for the exception message should the check fail.
     * @param errorMessageArgs     the arguments to be substituted into the message template.
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T checkNotNull( String name,
                                      @Nullable T reference,
                                      String errorMessageTemplate,
                                      Object... errorMessageArgs )
    {
        if( reference == null )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, format( errorMessageTemplate, errorMessageArgs ) );
            throw new NullPointerException( msg );

        }
        return reference;
    }

    /**
     * Assert that this parameter is null.
     *
     * @param name      of parameter
     * @param parameter itself
     */
    public static void checkNullMandatory( final String name, @Nullable  final Object parameter )
    {
        if( parameter != null )
        {
            throw new IllegalArgumentException( "Parameter named '" + name + "' should be null!" );
        }
    }


    //endregion


    //region Google guava wrapper extension implementations NullPointerException

    //---------------------------------------------------------------------
    // Google guava wrapper extension implementations NullPointerException
    //---------------------------------------------------------------------

    /**
     * Assert that this parameter is null.
     *
     * @param name      of parameter
     * @param parameter itself
     */
    public static void checkNullMandatory( final String name, final Object parameter, String message )
    {
        if( parameter != null )
        {
            throw new IllegalArgumentException( "Parameter named '" + name + "' should be null!. reason: " + message );
        }
    }

    /**
     * Assert that this parameter is not null, as also each item of the array is not null.
     *
     * @param <T>        parameter type
     * @param names      of parameters
     * @param parameters itself
     */
    @SafeVarargs
    public static <T> void checkEachParameterNotNull( final String[] names, final T... parameters )
    {
        checkArgument( "parameters != null", parameters != null, "provided array of parameters is null" );
        checkArgument( "names != null", names != null, "provided array of names is null" );

        if( parameters != null && names != null )
        {
            checkArgument( "parameters.length > 0", parameters.length > 0 );
            checkArgument( "names.length > 0", names.length > 0 );
            checkState( "names.length != parameters.length", names.length != parameters.length, "arrays sizes are not equal." );

            for( int i = 0; i < names.length; i++ )
            {
                checkNotNull( names[ i ], parameters[ i ] );
            }
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param name         of the argument
     * @param condition    a boolean expression
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     *                     string using {@link String#valueOf(Object)}
     *
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument( final String name, boolean condition, String errorMessage )
    {
        if( !condition )
        {
            String msg = format( "Argument [%s] is invalid;  details -> %s", name, defaultIfEmpty( errorMessage, "N/A" ) );
            throw new IllegalArgumentException( msg );
        }
    }

    /**
     * Ensures the truth of an expression involving one or more parameters to the calling method.
     *
     * @param name      of the argument
     * @param condition a boolean expression
     *
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument( final String name, final boolean condition )
    {
        if( !condition )
        {
            throw new IllegalArgumentException( "Argument '" + name + "' is invalid!" );
        }
    }

    /**
     * Ensures the truth of an expression involving the state of the calling instance, but not
     * involving any parameters to the calling method.
     *
     * @param name         of parameter or expression
     * @param condition    a boolean condition
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     *                     string using {@link String#valueOf(Object)}
     *
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void checkState( final String name, boolean condition, String errorMessage )
    {
        if( !condition )
        {
            String msg = format( "Condition [%s] is invalid;  details -> %s", name, defaultIfEmpty( errorMessage, "N/A" ) );
            throw new IllegalStateException( msg );
        }
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param name      of the reference.
     * @param reference an object reference
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T checkNotNull( String name, T reference )
    {
        if( reference == null )
        {
            throw new NullPointerException( "Parameter named '" + name + "' should be not null!" );
        }
        return reference;
    }

    /**
     * Assert that the given text does not contain the given substring.
     * <pre class="code">Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");</pre>
     *
     * @param textToSearch the text to search
     * @param substring    the substring to find within the text
     * @param message      the exception message to use if the assertion fails
     *
     * @throws IllegalArgumentException if the text contains the substring
     */
    public static void checkDoesNotContain( final String name, String textToSearch, String substring, String message )
    {
        if( StringUtils.hasLength( textToSearch ) && StringUtils.hasLength( substring ) &&
                    textToSearch.contains( substring ) )
        {
            String msg = String.format( "The argument name '%s' should not contain the test: '%s'. details -> %s", name, textToSearch, message );
            throw new IllegalArgumentException( msg );
        }
    }

    //endregion


    //region Google guava wrapper extension implementations IndexOutOfBoundsException

    //---------------------------------------------------------------------
    // Google guava wrapper extension implementations IndexOutOfBoundsException
    //---------------------------------------------------------------------

    /**
     * Ensures that {@code index} specifies a valid <i>element</i> in an array, list or string of size {@code size}.
     * An element index may range from zero, inclusive, to {@code size}, exclusive.
     *
     * @param index a user-supplied index identifying an element of an array, list or string
     * @param size  the size of that array, list or string
     *
     * @return the value of {@code index}
     *
     * @throws IndexOutOfBoundsException if {@code index} is negative or is not less than {@code size}
     * @throws IllegalArgumentException  if {@code size} is negative
     */
    public static int checkElementIndex( int index, int size )
    {
        return checkElementIndex( index, size, "index" );
    }

    /**
     * Ensures that {@code index} specifies a valid <i>element</i> in an array, list or string of size {@code size}.
     * An element index may range from zero, inclusive, to {@code size}, exclusive.
     *
     * @param index a user-supplied index identifying an element of an array, list or string
     * @param size  the size of that array, list or string
     * @param desc  the text to use to describe this index in an error message
     *
     * @return the value of {@code index}
     *
     * @throws IndexOutOfBoundsException if {@code index} is negative or is not less than {@code size}
     * @throws IllegalArgumentException  if {@code size} is negative
     */
    public static int checkElementIndex( int index, int size, String desc )
    {
        if( index >= 0 && index < size )
        {
            return index;
        }
        else
        {
            throw new IndexOutOfBoundsException( badElementIndex( index, size, desc ) );
        }
    }

    private static String badElementIndex( int index, int size, String desc )
    {
        if( index < 0 )
        {
            return PortablePreconditions.format( "%s <%s> must not be negative", desc, index );
        }
        else if( size < 0 )
        {
            throw new IllegalArgumentException( "negative size: " + size );
        }
        else
        {
            return PortablePreconditions.format( "%s; <%s> must be less than size <%s>", desc, index, size );
        }
    }

    /**
     * Ensures that {@code index} specifies a valid <i>position</i> in an array, list or string of size {@code size}.
     * A position index may range from zero to {@code size}, inclusive.
     *
     * @param index a user-supplied index identifying a position in an array, list or string
     * @param size  the size of that array, list or string
     *
     * @return the value of {@code index}
     *
     * @throws IndexOutOfBoundsException if {@code index} is negative or is greater than {@code size}
     * @throws IllegalArgumentException  if {@code size} is negative
     */
    public static int checkPositionIndex( int index, int size )
    {
        return checkPositionIndex( index, size, "index" );
    }

    /**
     * Ensures that {@code index} specifies a valid <i>position</i> in an array, list or string of size {@code size}.
     * A position index may range from zero to {@code size}, inclusive.
     *
     * @param index a user-supplied index identifying a position in an array, list or string
     * @param size  the size of that array, list or string
     * @param desc  the text to use to describe this index in an error message
     *
     * @return the value of {@code index}
     *
     * @throws IndexOutOfBoundsException if {@code index} is negative or is greater than {@code size}
     * @throws IllegalArgumentException  if {@code size} is negative
     */
    public static int checkPositionIndex( int index, int size, String desc )
    {
        if( index >= 0 && index <= size )
        {
            return index;
        }
        else
        {
            throw new IndexOutOfBoundsException( badPositionIndex( index, size, desc ) );
        }
    }

    private static String badPositionIndex( int index, int size, String desc )
    {
        if( index < 0 )
        {
            return PortablePreconditions.format( "%s (%s) must not be negative", desc, index );
        }
        else if( size < 0 )
        {
            throw new IllegalArgumentException( "negative size: " + size );
        }
        else
        {
            return PortablePreconditions.format( "%s (%s) must not be greater than size (%s)", desc, index, size );
        }
    }

    /**
     * Ensures that {@code start} and {@code end} specify a valid <i>positions</i> in an array, list
     * or string of size {@code size}, and are in order.
     * A position index may range from zero to {@code size}, inclusive.
     *
     * @param start a user-supplied index identifying a starting position in an array, list or string
     * @param end   a user-supplied index identifying a ending position in an array, list or string
     * @param size  the size of that array, list or string
     *
     * @throws IndexOutOfBoundsException if either index is negative or is greater than {@code size},
     *                                   or if {@code end} is less than {@code start}
     * @throws IllegalArgumentException  if {@code size} is negative
     */
    public static void checkPositionIndexes( int start, int end, int size )
    {
        if( start < 0 || end < start || end > size )
        {
            throw new IndexOutOfBoundsException( badPositionIndexes( start, end, size ) );
        }
    }

    private static String badPositionIndexes( int start, int end, int size )
    {
        return start >= 0 && start <= size
                       ? ( end >= 0 && end <= size
                                   ? PortablePreconditions.format( "end index (%s) must not be less than start index (%s)", end, start )
                                   : badPositionIndex( end, size, "end index" ) )
                       : badPositionIndex( start, size, "start index" );
    }

    public static String checkHasLength( final String name, String text )
    {
        if( !StringUtils.hasLength( text ) )
        {
            throw new IllegalArgumentException( "String argument named: '" + name + "' should have length > 0!;" );
        }

        return text;
    }

    //endregion


    //region NotEmpty validations throws IllegalArgumentException

    //---------------------------------------------------------------------
    // NotEmpty validations throws IllegalArgumentException
    //---------------------------------------------------------------------

    /**
     * Assert that the given String contains valid text content; that is, it must not be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">Assert.hasText(name, "'name' must not be empty");</pre>
     *
     * @param name    the argument name.
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     *
     * @return the validated text (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the text does not contain valid text content
     * @see org.springframework.util.StringUtils#hasText(String)
     * @see org.springframework.util.StringUtils#hasText(CharSequence)
     */
    public static String checkHasText( final String name, String text, String message )
    {
        if( !StringUtils.hasText( text ) )
        {
            throw new IllegalArgumentException( "String argument named: '" + name + "' should have text;  details -> %s" + message );
        }

        return text;
    }

    /**
     * Assert that a Map contains entries; that is, it must not be {@code null} and must contain at least one entry.
     * <pre class="code">Assert.notEmpty(map, "Map must contain entries");</pre>
     *
     * @param name    the argument name.
     * @param map     the map to check
     * @param message an optional user message
     *
     * @return the validated map (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the collection is {@code null} or contains no elements
     */
    public static Map<?, ?> checkNotEmpty( String name, Map<?, ?> map, String message )
    {
        if( map == null || CollectionUtils.isEmpty( map ) )
        {
            throw new IllegalArgumentException( String.format( "Map argument name '%s' should not be empty;  details -> %s", name, message ) );
        }

        return map;
    }

    /**
     * Assert that a collection contains elements; that is, it must not be {@code null} and must contain at least one element.
     * <p>
     * <pre class="code">Assert.notEmpty(collection, "Collection must contain elements");</pre>
     *
     * @param name       the argument name
     * @param collection the collection to check
     * @param message    the exception message to use if the assertion fails
     *
     * @return the validated collection (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the collection is {@code null} or contains no elements
     */
    public static <T extends Collection<?>> T checkNotEmpty( final String name, final T collection, String message )
    {
        if( collection == null || CollectionUtils.isEmpty( collection ) )
        {
            throw new IllegalArgumentException( String.format( "Collection argument name '%s' should not be empty;  details -> %s", name, message ) );
        }

        return collection;
    }

    public static <T extends Collection<?>> T checkNotEmpty( final String name, final T collection )
    {
        if( collection == null || CollectionUtils.isEmpty( collection ) )
        {
            throw new IllegalArgumentException( String.format( "Collection argument name '%s' should not be empty.", name ) );
        }

        return collection;
    }

    /**
     * Assert that this parameter is not empty. It will test for null and also the size of this array.
     *
     * @param <T>     type of the array
     * @param name    of parameter
     * @param array   the array to test
     * @param message an optional additional info message.
     *
     * @return the validated collection (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the array is {@code null} or contains no elements
     */
    public static <T> T[] checkNotEmpty( final String name, T[] array, String message )
    {
        if( array == null || ObjectUtils.isEmpty( array ) )
        {
            throw new IllegalArgumentException( String.format( "argument name '%s' should not be empty. ;  details -> %s", name, message ) );
        }

        return array;
    }

    /**
     * Assert that this parameter is not empty. It will test for null and also the size of this array.
     *
     * @param <T>   type of the array
     * @param name  of parameter
     * @param array the array to test
     *
     * @return the validated collection (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the array is {@code null} or contains no elements
     */
    public static <T> T[] checkNotEmpty( final String name, T[] array )
    {
        if( array == null || ObjectUtils.isEmpty( array ) )
        {
            throw new IllegalArgumentException( String.format( "argument name '%s' should not be empty;", name ) );
        }

        return array;
    }

    /**
     * Asserts that a specific map contains the queried key
     *
     * @param name of parameter
     * @param key  the value to which the specified key is mapped
     * @param map  the Map to be evaluated
     * @param <K>  the type of keys maintained by this map
     * @param <V>  the type of mapped values
     *
     * @return the key's value
     *
     * @since 2.0
     */
    public static <K, V> V checkMapKey( final String name, K key, Map<K, V> map )
    {
        final String DEFAULT_MAP_NO_KEY_EX_MESSAGE = "The validated key [%s] does not exist on the map parameter: [%s] ";

        if( map.containsKey( key ) )
        {
            return map.get( key );
        }

        throw new IllegalArgumentException( format( DEFAULT_MAP_NO_KEY_EX_MESSAGE, key, name ) );
    }

    /**
     * Assert that the given String is not empty; that is,
     * it must not be {@code null} and not the empty String.
     * <pre class="code">Assert.hasLength(name, "Name must not be empty");</pre>
     *
     * @param text    the String to check
     * @param message the exception message to use if the assertion fails
     *
     * @return the validated text (never {@code null} method for chaining)
     *
     * @throws IllegalArgumentException if the text is empty
     * @see org.springframework.util.StringUtils#hasLength
     */
    public static String checkHasLength( final String name, String text, String message )
    {
        if( !StringUtils.hasLength( text ) )
        {
            throw new IllegalArgumentException( "String argument named: '" + name + "' should have length > 0!;  details -> " + message );
        }

        return text;
    }

    /**
     * Asserts that the given String has valid text content;
     * that is, it must not be {@code null} and must contain at least one non-whitespace character.
     *
     * @param name      of parameter
     * @param parameter itself
     *
     * @throws IllegalArgumentException if the text does not contain valid text content
     * @see org.springframework.util.StringUtils#hasText(String)
     * @see org.springframework.util.StringUtils#hasText(CharSequence)
     * @since 2.0
     */
    public static void checkHasText( String name, String parameter )
    {
        if( !StringUtils.hasText( parameter ) )
        {
            throw new IllegalArgumentException( "Parameter named '" + name + "' has no text!" );
        }
    }

    /**
     * Verifies that {@code superType.isAssignableFrom(subType)} is {@code true}.
     *
     * @param superType the super type to check
     * @param subType   the sub type to check
     *
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static void checkIsAssignable( Class<?> superType, Class<?> subType )
    {
        checkIsAssignable( superType, subType, "" );
    }

    //endregion


    //region IsAssignable and instanceOf validations

    //---------------------------------------------------------------------
    // IsAssignable and instanceOf validations
    //---------------------------------------------------------------------

    /**
     * Verifies that {@code superType.isAssignableFrom(subType)} is {@code true}.
     *
     * @param superType the super type to check against
     * @param subType   the sub type to check
     * @param message   a message which will be prepended to provide further context.
     *                  If it is empty or ends in ":" or ";" or "," or ".", a full exception message will be appended.
     *                  If it ends in a space, the name of the offending sub type will be appended.
     *                  In any other case, a ":" with a space and the name of the offending sub type will be appended.
     *
     * @throws IllegalArgumentException if the classes are not assignable
     */
    @SuppressWarnings( "SameParameterValue" )
    public static void checkIsAssignable( Class<?> superType, Class<?> subType, String message )
    {
        superType = checkNotNull( "superType", superType, "Super type to check against must not be null" );
        if( subType == null || !superType.isAssignableFrom( subType ) )
        {
            assignableCheckFailed( superType, subType, message );
        }
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param name         of the reference.
     * @param reference    an object reference
     * @param errorMessage the exception message to use if the check fails; will be converted to a
     *                     string using {@link String#valueOf(Object)}
     *
     * @return the non-null reference that was validated
     *
     * @throws NullPointerException if {@code reference} is null
     */
    public static <T> T checkNotNull( String name, T reference, String errorMessage )
    {
        if( reference == null )
        {
            String msg = format( "Parameter named '" + name + "' should be not null;  details -> %s",
                                 name, defaultIfEmpty( errorMessage, "N/A" )
            );
            throw new IllegalArgumentException( msg );
        }

        return reference;
    }

    private static void assignableCheckFailed( Class<?> superType, Class<?> subType, String msg )
    {
        String result = "";
        boolean defaultMessage = true;
        if( StringUtils.hasLength( msg ) )
        {
            if( endsWithSeparator( msg ) )
            {
                result = msg + " ";
            }
            else
            {
                result = messageWithTypeName( msg, subType );
                defaultMessage = false;
            }
        }
        if( defaultMessage )
        {
            result = result + ( subType + " is not assignable to " + superType );
        }

        throw new IllegalArgumentException( result );
    }

    private static boolean endsWithSeparator( String msg )
    {
        msg = checkNotNull( "msg", msg );
        return ( msg.endsWith( ":" ) || msg.endsWith( ";" ) || msg.endsWith( "," ) || msg.endsWith( "." ) );
    }

    private static String messageWithTypeName( String msg, Object typeName )
    {
        msg = checkNotNull( "msg", msg );
        return msg + ( msg.endsWith( " " ) ? "" : ": " ) + typeName;
    }

    public static void checkIsInstanceOf( Class<?> type, Object obj )
    {
        checkIsInstanceOf( type, obj, "" );
    }

    //endregion

    public static void checkIsInstanceOf( Class<?> type, Object obj, String message )
    {
        checkNotNull( "type", type );
        if( !type.isInstance( obj ) )
        {
            instanceCheckFailed( type, obj, message );
        }
    }

    private static void instanceCheckFailed( Class<?> type, Object obj, String msg )
    {
        String className = obj != null ? obj.getClass().getName() : "null";
        String result = "";
        boolean defaultMessage = true;
        if( StringUtils.hasLength( msg ) )
        {
            if( endsWithSeparator( msg ) )
            {
                result = msg + " ";
            }
            else
            {
                result = messageWithTypeName( msg, className );
                defaultMessage = false;
            }
        }

        if( defaultMessage )
        {
            result = result + "Object of class [" + className + "] must be an instance of " + type;
        }

        throw new IllegalArgumentException( result );
    }

    //endregion
}
