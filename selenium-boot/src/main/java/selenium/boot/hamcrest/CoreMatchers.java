package selenium.boot.hamcrest;


import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
@UtilityClass
public class CoreMatchers
{
    /**
     * A shortcut to the frequently used {@code is(equalTo(x))}.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(smelly))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(equalTo(smelly)))</pre>
     */
    public static <T> Matcher<T> is( T value )
    {
        return Is.is( value );
    }

    /**
     * Decorates another Matcher, retaining its behaviour, but allowing tests to be slightly more expressive.
     * <p/>
     * For example:
     * <pre>assertThat(cheese, is(equalTo(smelly)))</pre>
     * instead of:
     * <pre>assertThat(cheese, equalTo(smelly))</pre>
     */
    public static <T> Matcher<T> is( Matcher<T> matcher )
    {
        return Is.is( matcher );
    }

    /**
     * A shortcut to the frequently used {@code is(instanceOf(SomeClass.class))}.
     * <p>
     * For example:
     * <pre>assertThat(cheese, isA(Cheddar.class))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(instanceOf(Cheddar.class)))</pre>
     */
    public static <T> Matcher<T> isA( Class<T> type )
    {
        return Is.isA( type );
    }

    /**
     * Creates a matcher that matches when the examined object is an instance of the specified {@code type},
     * as determined by calling the {@link java.lang.Class#isInstance(Object)} method on that type, passing the the examined object.
     * <p>
     * The created matcher assumes no relationship between specified type and the examined object.</p>
     * <p>
     * For example:
     * <pre>assertThat(new Canoe(), instanceOf(Paddlable.class));</pre>
     */
    public static <T> Matcher<T> instanceOf( Class<?> type )
    {
        return IsInstanceOf.instanceOf( type );
    }

    /**
     * Creates a matcher that wraps an existing matcher, but inverts the logic by which it will match.
     * <p>
     * For example:
     * <pre>assertThat(cheese, is(not(equalTo(smelly))))</pre>
     *
     * @param matcher the matcher whose sense should be inverted
     */
    public static <T> Matcher<T> not( Matcher<T> matcher )
    {
        return IsNot.not( matcher );
    }

    /**
     * A shortcut to the frequently used {@code not(equalTo(x))}.
     * <p>
     * For example:
     * <pre>assertThat(cheese, is(not(smelly)))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(not(equalTo(smelly))))</pre>
     *
     * @param value the value that any examined object should <b>not</b> equal
     */
    public static <T> Matcher<T> not( T value )
    {
        return IsNot.not( value );
    }

    /**
     * A shortcut to the frequently used {@code not(nullValue(X.class)).
     * Accepts a single dummy argument to facilitate type inference.}.
     * For example:
     * <pre>assertThat(cheese, is(notNullValue(X.class)))</pre>
     * instead of:
     * <pre>assertThat(cheese, is(not(nullValue(X.class))))</pre>
     *
     * @param type dummy parameter used to infer the generic type of the returned matcher
     */
    public static <T> Matcher<T> notNullValue( Class<T> type )
    {
        return IsNull.notNullValue( type );
    }

    /**
     * Creates a matcher that matches if examined object is {@code null}.
     * For example:
     * <pre>assertThat(cheese, is(nullValue())</pre>
     */
    public static Matcher<Object> nullValue()
    {
        return IsNull.nullValue();
    }

    /**
     * Creates a matcher that matches if examined object is {@code null}.
     * Accepts a single dummy argument to facilitate type inference.
     * For example:
     * <pre>assertThat(cheese, is(nullValue(Cheese.class))</pre>
     *
     * @param type dummy parameter used to infer the generic type of the returned matcher
     */
    public static <T> Matcher<T> nullValue( Class<T> type )
    {
        return IsNull.nullValue( type );
    }

    /**
     * Creates a matcher that matches when the examined object is logically equal to the specified {@code operand},
     * as determined by calling the {@link java.lang.Object#equals} method on the <b>examined</b> object.
     * <p>
     * If the specified operand is {@code null} then the created matcher will only match if
     * the examined object's {@code equals} method returns {@code true} when passed a
     * {@code null} ( which would be a violation of the {@code equals} contract ), unless the
     * examined object itself is {@code null}, in which case the matcher will return a positive match.
     * <p>
     * The created matcher provides a special behaviour when examining {@code Array}s, whereby
     * it will match if both the operand and the examined object are arrays of the same length and
     * contain items that are equal to each other (according to the above rules) <b>in the same indexes</b>.
     * <p/>
     * For example:
     * <pre>
     * assertThat("foo", equalTo("foo"));
     * assertThat(new String[] {"foo", "bar"}, equalTo(new String[] {"foo", "bar"}));
     * </pre>
     */
    public static <T> Matcher<T> equalTo( T operand )
    {
        return IsEqual.equalTo( operand );
    }

}
