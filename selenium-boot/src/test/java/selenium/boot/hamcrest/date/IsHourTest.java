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
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsHour} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isHour(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalTimeMatchers#isHour(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isHour(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isHour(int)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsHour
 * @see selenium.boot.hamcrest.DateMatchers#isHour(int)
 * @see selenium.boot.hamcrest.LocalTimeMatchers#isHour(int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#isHour(int)
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#isHour(int)
 * @since 1.0
 */
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsHour, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01. DateMatchers#isHour\n" +
                              "02. LocalTimeMatchers#isHour\n" +
                              "03. LocalDateTimeMatchers#isHour\n" +
                              "04. ZonedDateTimeMatchers#isHour"
)
public class IsHourTest extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the date has the hour [0-9]{1,2}\\s.*but: the date has the hour [0-9]{1,2}.*";


    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------


    public void isDateHour()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isHour( 12 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isHour( 12 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    public void isNotDateHour()
    {
        describeTestCase();

        String desc = getDescription( not( DateMatchers.isHour( 11 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              not( DateMatchers.isHour( 11 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Validates the isHour() mismatch message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isNotDateHourMismatchMessage()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isHour( 11 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isHour( 11 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeHour()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.isHour( 12 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.isHour( 12 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    public void isNotLocalDateTimeHour()
    {
        describeTestCase();

        String desc = getDescription( not( LocalDateTimeMatchers.isHour( 11 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              not( LocalDateTimeMatchers.isHour( 11 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    public void isLocalTimeHour()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.isHour( 12 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.isHour( 12 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    public void isNotLocalTimeHour()
    {
        describeTestCase();

        String desc = getDescription( not( LocalTimeMatchers.isHour( 11 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              not( LocalTimeMatchers.isHour( 11 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    public void isZonedDateTimeHour()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.isHour( 12 ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isHour( 12 ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    public void isNotZonedDateTimeHour()
    {
        describeTestCase();

        String desc = getDescription( not( ZonedDateTimeMatchers.isHour( 11 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isHour( 11 ) ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

}
