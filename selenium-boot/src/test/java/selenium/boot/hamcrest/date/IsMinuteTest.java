package selenium.boot.hamcrest.date;



import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.LocalTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;

import java.time.LocalTime;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON_AS_DATE;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON_UTC;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsMinute} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isMinute(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalTimeMatchers#isMinute(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isMinute(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isMinute(int)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsMinute
 * @see selenium.boot.hamcrest.DateMatchers#isMinute(int)
 * @see selenium.boot.hamcrest.LocalTimeMatchers#isMinute(int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#isMinute(int)
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#isMinute(int)
 * @since 1.0
 */
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsMinute, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01. DateMatchers#isMinute\n" +
                              "02. LocalTimeMatchers#isMinute\n" +
                              "03. LocalDateTimeMatchers#isMinute\n" +
                              "04. ZonedDateTimeMatchers#isMinute"
)
public class IsMinuteTest extends AbstractMatcherTest
{

    private static final String ASSERTION_PATTERN =
            ".*Expected: the date has the minute [0-9]{1,2}\\s.*but: the date has the minute [0-9]{1,2}.*";


    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isMinute( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isMinute( 0 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    public void isDateNotMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( DateMatchers.isMinute( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              not( DateMatchers.isMinute( 1 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Validates the isMinute() mismatch message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateNotMinuteMismatchMessage() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isMinute( 1 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isMinute( 1 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.isMinute( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.isMinute( 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    public void isLocalDateTimeNotMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalDateTimeMatchers.isMinute( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              not( LocalDateTimeMatchers.isMinute( 1 ) ) ,
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    public void isLocalTimeMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.isMinute( 0 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.isMinute( 0 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    public void isNotLocalTimeMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalTimeMatchers.isMinute( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              not( LocalTimeMatchers.isMinute( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    public void isZonedDateTimeMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.isMinute( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isMinute( 0 ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    public void isNotZonedDateTimeMinute() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( ZonedDateTimeMatchers.isMinute( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isMinute( 1 ) ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }
}
