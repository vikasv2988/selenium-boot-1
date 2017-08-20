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


//@formatter:off


/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsSecond} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isSecond(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalTimeMatchers#isSecond(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isSecond(int)}</li>
 *     <li> {@link selenium.boot.hamcrest.DateMatchers#isSecond(int)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsSecond
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#isSecond(int)
 * @see selenium.boot.hamcrest.LocalTimeMatchers#isSecond(int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#isSecond(int)
 * @see selenium.boot.hamcrest.DateMatchers#isSecond(int)
 * @since 1.0
 */
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsSecond, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01. ZonedDateTimeMatchers#isSecond\n" +
                              "02. LocalTimeMatchers#isSecond\n" +
                              "03. LocalDateTimeMatchers#isSecond\n" +
                              "04. DateMatchers#isSecond"
)
public class IsSecondTest extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the date has the second [0-9]{1,2}\\s.*but: the date has the second [0-9]{1,2}.*";


    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isSecond( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isSecond( 0 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    public void isNotDateSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( DateMatchers.isSecond( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              not( DateMatchers.isSecond( 1 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Testing isSecond() mismatch message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isNotDateYearMismatchMessage() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isSecond( 1 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isSecond( 1 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.isSecond( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.isSecond( 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    public void isNotLocalDateTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalDateTimeMatchers.isSecond( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              not( LocalDateTimeMatchers.isSecond( 1 ) ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    public void isLocalTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.isSecond( 0 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.isSecond( 0 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    public void isNotLocalTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalTimeMatchers.isSecond( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              not( LocalTimeMatchers.isSecond( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    public void isZonedLocalDateTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.isSecond( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isSecond( 0 ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    public void isNotZonedLocalDateTimeSecond() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( ZonedDateTimeMatchers.isSecond( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isSecond( 1 ) ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }
}
