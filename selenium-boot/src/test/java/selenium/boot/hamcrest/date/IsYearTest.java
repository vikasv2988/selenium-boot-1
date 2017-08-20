package selenium.boot.hamcrest.date;


import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON_AS_DATE;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2016;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2016_AS_DATE;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2016_NOON;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2016_NOON_UTC;


//@formatter:off


/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsYear} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isYear(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isYear(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isYear(int)}</li>
 *     <li> {@link selenium.boot.hamcrest.DateMatchers#isYear(int)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsYear
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#isYear(int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#isYear(int)
 * @see selenium.boot.hamcrest.LocalDateMatchers#isYear(int)
 * @see selenium.boot.hamcrest.DateMatchers#isYear(int)
 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsYear, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01. ZonedDateTimeMatchers#isYear\n" +
                              "02. LocalDateTimeMatchers#isYear\n" +
                              "03. LocalDateMatchers#isYear\n" +
                              "04. DateMatchers#isYear"
)
public class IsYearTest extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the date is in the year [0-9]{4}\\s.*but: the date has the year [0-9]{4}.*";

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isYear( 2016 ) );
        Assertion.assertThat( AUG_04_2016_AS_DATE,
                              DateMatchers.isYear( 2016 ),
                              "\"AUG_04_2016_AS_DATE\" matches " + desc
        );
    }

    public void isNotDateYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( DateMatchers.isYear( 2016 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              not( DateMatchers.isYear( 2016 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Testing isYear() mismatch message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isNotDateYearMessage() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isYear( 2016 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isYear( 2016 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    public void isLocalDateYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.isYear( 2016 ) );
        Assertion.assertThat( AUG_04_2016,
                              LocalDateMatchers.isYear( 2016 ),
                              "\"AUG_04_2016\" matches " + desc
        );
    }

    public void isNotLocalDateYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalDateMatchers.isYear( 2016 ) ) );
        Assertion.assertThat( AUG_04_2015,
                              not( LocalDateMatchers.isYear( 2016 ) ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.isYear( 2016 ) );
        Assertion.assertThat( AUG_04_2016_NOON,
                              LocalDateTimeMatchers.isYear( 2016 ),
                              "\"AUG_04_2016_NOON\" matches " + desc
        );
    }

    public void isNotLocalDateTimeYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( LocalDateTimeMatchers.isYear( 2016 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              not( LocalDateTimeMatchers.isYear( 2016 ) ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    public void isZonedDateTimeYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.isYear( 2016 ) );
        Assertion.assertThat( AUG_04_2016_NOON_UTC,
                              ZonedDateTimeMatchers.isYear( 2016 ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    public void isNotZonedDateTimeYear() throws Exception
    {
        describeTestCase();

        String desc = getDescription( not( ZonedDateTimeMatchers.isYear( 2016 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isYear( 2016 ) ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }
}
