package selenium.boot.hamcrest.date;

//@formatter:off

import com.google.common.collect.Lists;
import org.hamcrest.Matcher;
import org.springframework.util.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_01_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_01_2015_NOON;import static selenium.boot.hamcrest.date.utils.Dates.AUG_01_2015_NOON_AS_DATE;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_02_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_03_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2016_AS_DATE;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_31_2015;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_31_2015_NOON;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_31_2015_NOON_AS_DATE;import static selenium.boot.hamcrest.date.utils.Dates.AUG_31_2015_NOON_UTC;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsDayOfMonth} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isDayOfMonth(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isFirstDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isLastDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isDayOfMonth(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isFirstDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isLastDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isDayOfMonth(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isLastDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isFirstDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isDayOfMonth(int)}</li>
 *     <li {@link selenium.boot.hamcrest.DateMatchers#isFirstDayOfMonth()}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isLastDayOfMonth()}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsDayOfMonth
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#isDayOfMonth(int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#isDayOfMonth(int)
 * @see selenium.boot.hamcrest.LocalDateMatchers#isDayOfMonth(int)
 * @see selenium.boot.hamcrest.DateMatchers#isDayOfMonth(int)
 * @see selenium.boot.hamcrest.DateMatchers#isFirstDayOfMonth()
 * @see selenium.boot.hamcrest.DateMatchers#isLastDayOfMonth()
 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.isDayOfMonth, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01-04. isDayOfMonth for ZonedDateTimeMatchers,LocalDateTimeMatchers,LocalDateMatchers and DateMatchers\n" +
                              "05-08. isFirstDayOfMonth for ZonedDateTimeMatchers,LocalDateTimeMatchers,LocalDateMatchers and DateMatchers\n" +
                              "09-12.isLastDayOfMonth for ZonedDateTimeMatchers,LocalDateTimeMatchers,LocalDateMatchers and DateMatchers"
)
public class IsDayOfMonthTest extends AbstractMatcherTest
{

    private static final String ASSERTION_PATTERN =
            ".*Expected: the date is on the \\d{1,2}(st|nd|rd|th) day of the month" +
                    "\\s.*but: the date is on the \\d{1,2}(st|nd|rd|th) day of the month.*";

    private static final String ASSERTION_PATTERN_FIRST =
            ".*Expected: the date is the first day of the month" +
                    "\\s.*but: date is the \\d+ day of month instead of \\d+ day of month.*";

    private static final String ASSERTION_PATTERN_LAST =
            ".*Expected: the date is the last day of the month" +
                    "\\s.*but: date is the \\d+ day of month instead of \\d+ day of month.*";

    //region TestNG Management methods ( @Before, @After, @DataProvider )

    //---------------------------------------------------------------------
    // TestNG Management methods ( @Before, @After, @DataProvider )
    //---------------------------------------------------------------------

    @DataProvider( name = "date-dp" )
    public Object[][] getDates( Method m )
    {
        List<Object[]> data = Lists.newArrayList();

        data.add( new Object[] { AUG_01_2015, LocalDateMatchers.isDayOfMonth( 2 ) } );
        data.add( new Object[] { AUG_02_2015, LocalDateMatchers.isDayOfMonth( 10 ) } );
        data.add( new Object[] { AUG_03_2015, LocalDateMatchers.isDayOfMonth( 13 ) } );
        data.add( new Object[] { AUG_04_2015, LocalDateMatchers.isDayOfMonth( 11 ) } );
        data.add( new Object[] { AUG_31_2015, LocalDateMatchers.isDayOfMonth( 25 ) } );

        return data.toArray( new Object[ data.size() ][] );
    }

    //endregion


    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------


    public void isDateDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.isDayOfMonth( 4 ) );
        Assertion.assertThat( AUG_04_2016_AS_DATE,
                              DateMatchers.isDayOfMonth( 4 ),
                              "\"AUG_04_2016_AS_DATE\" matches " + desc
        );
    }


    public void iDateNotDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( DateMatchers.isDayOfMonth( 1 ) ) );
        Assertion.assertThat( AUG_04_2016_AS_DATE,
                              not( DateMatchers.isDayOfMonth( 1 ) ),
                              "\"AUG_04_2016_AS_DATE\" matches " + desc
        );
    }

    @Test
    public void isDateFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.isFirstDayOfMonth() );
        Assertion.assertThat( AUG_01_2015_NOON_AS_DATE,
                              DateMatchers.isFirstDayOfMonth(),
                              "\"AUG_01_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test
    public void isDateNotFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( DateMatchers.isFirstDayOfMonth() ) );
        Assertion.assertThat( AUG_31_2015_NOON_AS_DATE,
                              not( DateMatchers.isFirstDayOfMonth() ),
                              "\"AUG_31_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Validates the \"isFirstDayOfMonth\" mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN_FIRST
    )
    public void isDateNotFirstDayOfMonthMismatchMessage() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.isFirstDayOfMonth() );
        Assertion.assertThat( AUG_31_2015_NOON_AS_DATE,
                              DateMatchers.isFirstDayOfMonth(),
                              "\"AUG_31_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test
    public void isDateLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.isLastDayOfMonth() );
        Assertion.assertThat( AUG_31_2015_NOON_AS_DATE,
                              DateMatchers.isLastDayOfMonth(),
                              "\"AUG_31_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test
    public void isDateNotLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( DateMatchers.isLastDayOfMonth() ) );
        Assertion.assertThat( AUG_01_2015_NOON_AS_DATE,
                              not( DateMatchers.isLastDayOfMonth() ),
                              "\"AUG_01_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------


    public void isLocalDateDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.isDayOfMonth( 1 ) );
        Assertion.assertThat( AUG_01_2015,
                              LocalDateMatchers.isDayOfMonth( 1 ),
                              "\"AUG_01_2015\" matches " + desc
        );
    }

    public void isLocalDateNotDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateMatchers.isDayOfMonth( 1 ) ) );
        Assertion.assertThat( AUG_31_2015,
                              not( LocalDateMatchers.isDayOfMonth( 1 ) ),
                              "\"AUG_01_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            dataProvider = "date-dp",
            skipFailedInvocations = false,
            description = "Validates a local-date day of month not 1st day of august; throws AssertionError.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateNotDayOfMonthMismatchMessage( LocalDate date, Matcher<LocalDate> matcher ) throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test
    public void isLocalDateFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.isFirstDayOfMonth() );
        Assertion.assertThat( AUG_01_2015,
                              LocalDateMatchers.isFirstDayOfMonth(),
                              "\"AUG_01_2015\" matches " + desc
        );
    }

    @Test
    public void isLocalDateNotFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateMatchers.isFirstDayOfMonth() ) );
        Assertion.assertThat( AUG_31_2015,
                              not( LocalDateMatchers.isFirstDayOfMonth() ),
                              "\"AUG_31_2015\" matches " + desc
        );
    }


    @Test
    public void isLocalDateLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.isLastDayOfMonth() );
        Assertion.assertThat( AUG_31_2015,
                              LocalDateMatchers.isLastDayOfMonth(),
                              "\"AUG_31_2015\" matches " + desc
        );
    }

    @Test
    public void isLocalDateNotLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateMatchers.isLastDayOfMonth() ) );
        Assertion.assertThat( AUG_01_2015,
                              not( LocalDateMatchers.isLastDayOfMonth() ),
                              "\"AUG_01_2015\" matches " + desc
        );
    }

    @Test (
            description = "Validates the \"isLastDayOfMonth\" mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN_LAST
    )
    public void isLocalDateNotLastDayOfMonthMismatchMessage() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.isLastDayOfMonth() );
        Assertion.assertThat( AUG_01_2015,
                              LocalDateMatchers.isLastDayOfMonth(),
                              "\"AUG_01_2015\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.isDayOfMonth( 31 ) );
        Assertion.assertThat( AUG_31_2015_NOON,
                              LocalDateTimeMatchers.isDayOfMonth( 31 ),
                              "\"AUG_31_2015_NOON\" matches " + desc
        );
    }


    public void isNotLocalDateTimeDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateTimeMatchers.isDayOfMonth( 1 ) ) );
        Assertion.assertThat( AUG_31_2015_NOON,
                              not( LocalDateTimeMatchers.isDayOfMonth( 1 ) ),
                              "\"AUG_31_2015_NOON\" matches " + desc
        );
    }

    @Test
    public void isLocalDateTimeFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.isFirstDayOfMonth() );
        Assertion.assertThat( AUG_01_2015_NOON,
                              LocalDateTimeMatchers.isFirstDayOfMonth(),
                              "\"AUG_01_2015_NOON\" matches " + desc
        );
    }

    @Test
    public void isLocalDateTimeNotFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateTimeMatchers.isFirstDayOfMonth() ) );
        Assertion.assertThat( AUG_31_2015_NOON,
                              not( LocalDateTimeMatchers.isFirstDayOfMonth() ),
                              "\"AUG_31_2015_NOON\" matches " + desc
        );
    }

    @Test
    public void isLocalDateTimeLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.isLastDayOfMonth() );
        Assertion.assertThat( AUG_31_2015_NOON,
                              LocalDateTimeMatchers.isLastDayOfMonth(),
                              "\"AUG_31_2015_NOON\" matches " + desc
        );
    }

    @Test
    public void isLocalDateTimeNotLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( LocalDateTimeMatchers.isLastDayOfMonth() ) );
        Assertion.assertThat( AUG_01_2015_NOON,
                              not( LocalDateTimeMatchers.isLastDayOfMonth() ),
                              "\"AUG_01_2015_NOON\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------


    public void isZonedDateTimeDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.isDayOfMonth( 1 ) );
        Assertion.assertThat( AUG_01_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isDayOfMonth( 1 ),
                              "\"AUG_01_2015_NOON_UTC\" matches " + desc
        );
    }


    public void isNotZonedDateTimeDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( ZonedDateTimeMatchers.isDayOfMonth( 31 ) ) );
        Assertion.assertThat( AUG_01_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isDayOfMonth( 31 ) ),
                              "\"AUG_01_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test
    public void isZonedDateTimeFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.isFirstDayOfMonth() );
        Assertion.assertThat( AUG_01_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isFirstDayOfMonth(),
                              "\"AUG_01_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test
    public void isZonedDateTimeNotFirstDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( ZonedDateTimeMatchers.isFirstDayOfMonth() ) );
        Assertion.assertThat( AUG_31_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isFirstDayOfMonth() ),
                              "\"AUG_31_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test
    public void isZonedlDateTimeLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.isLastDayOfMonth() );
        Assertion.assertThat( AUG_31_2015_NOON_UTC,
                              ZonedDateTimeMatchers.isLastDayOfMonth(),
                              "\"AUG_31_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test
    public void isZonedDateTimeNotLastDayOfMonth() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( not( ZonedDateTimeMatchers.isLastDayOfMonth() ) );
        Assertion.assertThat( AUG_01_2015_NOON_UTC,
                              not( ZonedDateTimeMatchers.isLastDayOfMonth() ),
                              "\"AUG_01_2015_NOON_UTC\" matches " + desc
        );
    }

}
