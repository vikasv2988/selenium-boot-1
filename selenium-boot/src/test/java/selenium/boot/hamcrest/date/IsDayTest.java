package selenium.boot.hamcrest.date;

//@formatter:off

import org.springframework.util.StringUtils;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.DateMatcherTestUtils.addDateField;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsSameDay} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isToday()}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isTomorrow()}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isYesterday()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isToday()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isTomorrow()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isYesterday()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isToday()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isTomorrow()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isYesterday()}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isToday()}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isTomorrow()}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isYesterday()}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsSameDay
 * @see selenium.boot.hamcrest.DateMatchers#isYesterday()
 * @see selenium.boot.hamcrest.DateMatchers#isToday()
 * @see selenium.boot.hamcrest.DateMatchers#isTomorrow()
 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsSameDay, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01-04. isTomorrow for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "05-08. isToday for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "09-12. isYesterday for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers"
)
public class IsDayTest  extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the same day as (date|local-date|local-datetime|timezone-datetime) is [A-Za-z0-9:,.+ ]+" +
                    "\\s.*but: the (date|local-date|local-datetime|timezone-datetime) is [A-Za-z0-9:,.+ ]+.*";

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateToday() throws Exception
    {
        describeTestCase();
        String desc = getDescription( DateMatchers.isToday() );
        Assertion.assertThat( new Date(),
                              DateMatchers.isToday(),
                              "\"new Date()\" matches " + desc
        );
    }

    @Test(
            description = "Validates the \"isToday\" mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateNotToday()
    {
        describeTestCase();

        Date date = addDateField( new Date(), Calendar.DATE, 1 );
        String desc = getDescription( DateMatchers.isToday() );
        Assertion.assertThat( date,
                              DateMatchers.isToday(),
                              StringUtils.quote( date.toString() ) + " matches " + desc
        );
    }

    public void isDateYesterday() throws Exception
    {
        describeTestCase();

        Date date = addDateField( new Date(), Calendar.DATE, -1 );
        String desc = getDescription( DateMatchers.isYesterday() );
        Assertion.assertThat( date,
                              DateMatchers.isYesterday(),
                              StringUtils.quote( date.toString() ) + " matches " + desc
        );
    }

    public void isDateNotYesterday() throws Exception
    {
        describeTestCase();

        Date date = addDateField( new Date(), Calendar.DATE, 1 );
        String desc = getDescription( not( DateMatchers.isYesterday() ) );
        Assertion.assertThat( date,
                              not( DateMatchers.isYesterday() ),
                              StringUtils.quote( date.toString() ) + " matches " + desc
        );
    }

    public void isDateTomorrow() throws Exception
    {
        describeTestCase();

        Date date = addDateField( new Date(), Calendar.DATE, 1 );
        String desc = getDescription( DateMatchers.isTomorrow() );
        Assertion.assertThat( date,
                              DateMatchers.isTomorrow(),
                              StringUtils.quote( date.toString() ) + " matches " + desc
        );
    }

    public void isDateNotTomorrow() throws Exception
    {
        describeTestCase();

        Date date = addDateField( new Date(), Calendar.DATE, -1 );
        String desc = getDescription( not( DateMatchers.isTomorrow() ) );
        Assertion.assertThat( date,
                              not( DateMatchers.isTomorrow() ),
                              StringUtils.quote( date.toString() ) + " matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    @Test
    public void isLocalDateToday() throws Exception
    {
        describeTestCase();
        String desc = getDescription( LocalDateMatchers.isToday() );
        Assertion.assertThat( LocalDate.now(),
                              LocalDateMatchers.isToday(),
                              "\"LocalDate.now()\" matches " + desc
        );
    }

    @Test
    public void isLocalDateNotToday()
    {
        describeTestCase();

        LocalDate date = LocalDate.now().plusDays( 1 );
        String desc = getDescription( not( LocalDateMatchers.isToday() ) );
        Assertion.assertThat( date,
                              not( LocalDateMatchers.isToday() ),
                              "\"LocalDate.now().plusDays( 1 )\" matches " + desc
        );
    }

    @Test(
            description = "Validates the \"isToday\" mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateNotTodayMismatchMessage()
    {
        describeTestCase();

        LocalDate date = LocalDate.now().plusDays( 1 );
        String desc = getDescription( LocalDateMatchers.isToday() );
        Assertion.assertThat( date,
                              LocalDateMatchers.isToday(),
                              "\"LocalDate.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateYesterday() throws Exception
    {
        describeTestCase();

        LocalDate date = LocalDate.now().minusDays( 1 );
        String desc = getDescription( LocalDateMatchers.isYesterday() );
        Assertion.assertThat( date,
                              LocalDateMatchers.isYesterday(),
                              "\"LocalDate.now().minusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateNotYesterday() throws Exception
    {
        describeTestCase();

        LocalDate date = LocalDate.now().plusDays( 1 );
        String desc = getDescription( not( LocalDateMatchers.isYesterday() ) );
        Assertion.assertThat( date,
                              not( LocalDateMatchers.isYesterday() ),
                              "\"LocalDate.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateTomorrow() throws Exception
    {
        describeTestCase();

        LocalDate date = LocalDate.now().plusDays( 1 );
        String desc = getDescription( LocalDateMatchers.isTomorrow() );
        Assertion.assertThat( date,
                              LocalDateMatchers.isTomorrow(),
                              "\"LocalDate.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateNotTomorrow() throws Exception
    {
        describeTestCase();

        LocalDate date = LocalDate.now().minusDays( 1 );
        String desc = getDescription( not( LocalDateMatchers.isTomorrow() ) );
        Assertion.assertThat( date,
                              not( LocalDateMatchers.isTomorrow() ),
                              "\"LocalDate.now().minusDays( 1 )\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void isLocalDateTimeToday() throws Exception
    {
        describeTestCase();
        String desc = getDescription( LocalDateTimeMatchers.isToday() );
        Assertion.assertThat( LocalDateTime.now(),
                              LocalDateTimeMatchers.isToday(),
                              "\"LocalDateTime.now()\" matches " + desc
        );
    }

    @Test
    public void isLocalDateTimeNotToday()
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().plusDays( 1 );
        String desc = getDescription( not( LocalDateTimeMatchers.isToday() ) );
        Assertion.assertThat( date,
                              not( LocalDateTimeMatchers.isToday() ),
                              "\"LocalDate.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateTimeYesterday() throws Exception
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().minusDays( 1 );
        String desc = getDescription( LocalDateTimeMatchers.isYesterday() );
        Assertion.assertThat( date,
                              LocalDateTimeMatchers.isYesterday(),
                              "\"LocalDateTimeMatchers.now().minusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateTimeNotYesterday() throws Exception
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().plusDays( 1 );
        String desc = getDescription( not( LocalDateTimeMatchers.isYesterday() ) );
        Assertion.assertThat( date,
                              not( LocalDateTimeMatchers.isYesterday() ),
                              "\"LocalDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateTimeTomorrow() throws Exception
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().plusDays( 1 );
        String desc = getDescription( LocalDateMatchers.isTomorrow() );
        Assertion.assertThat( date,
                              LocalDateTimeMatchers.isTomorrow(),
                              "\"LocalDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isLocalDateTimeNotTomorrow() throws Exception
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().minusDays( 1 );
        String desc = getDescription( not( LocalDateTimeMatchers.isTomorrow() ) );
        Assertion.assertThat( date,
                              not( LocalDateTimeMatchers.isTomorrow() ),
                              "\"LocalDateTime.now().minusDays( 1 )\" matches " + desc
        );
    }

    @Test(
            description = "Validates the \"isTomorrow\" local-datetime mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeNotTomorrowMismatchMessage()
    {
        describeTestCase();

        LocalDateTime date = LocalDateTime.now().minusDays( 1 );;
        String desc = getDescription( LocalDateTimeMatchers.isTomorrow() );
        Assertion.assertThat( date,
                              LocalDateTimeMatchers.isTomorrow(),
                              "\"LocalDateTime.now().minusDays( 1 )\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    public void isZonedDateTimeToday() throws Exception
    {
        describeTestCase();
        String desc = getDescription( ZonedDateTimeMatchers.isToday() );
        Assertion.assertThat( ZonedDateTime.now(),
                              ZonedDateTimeMatchers.isToday(),
                              "\"ZonedDateTime.now()\" matches " + desc
        );
    }

    @Test
    public void isZonedDateTimeNotToday()
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().plusDays( 1 );
        String desc = getDescription( not( ZonedDateTimeMatchers.isToday() ) );
        Assertion.assertThat( date,
                              not( ZonedDateTimeMatchers.isToday() ),
                              "\"ZonedDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isZonedDateTimeYesterday() throws Exception
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().minusDays( 1 );
        String desc = getDescription( ZonedDateTimeMatchers.isYesterday() );
        Assertion.assertThat( date,
                              ZonedDateTimeMatchers.isYesterday(),
                              "\"ZonedDateTime.now().minusDays( 1 )\" matches " + desc
        );
    }

    public void isZonedDateTimeNotYesterday() throws Exception
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().plusDays( 1 );
        String desc = getDescription( not( ZonedDateTimeMatchers.isYesterday() ) );
        Assertion.assertThat( date,
                              not( ZonedDateTimeMatchers.isYesterday() ),
                              "\"ZonedDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    @Test(
            description = "Validates the \"isYesterday\" zoned-datetime mismatch error message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeNotYesterdayMismatchMessage()
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().plusDays( 1 );
        String desc = getDescription( ZonedDateTimeMatchers.isToday() );
        Assertion.assertThat( date,
                              ZonedDateTimeMatchers.isToday(),
                              "\"ZonedDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isZonedDateTimeTomorrow() throws Exception
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().plusDays( 1 );
        String desc = getDescription( ZonedDateTimeMatchers.isTomorrow() );
        Assertion.assertThat( date,
                              ZonedDateTimeMatchers.isTomorrow(),
                              "\"ZonedDateTime.now().plusDays( 1 )\" matches " + desc
        );
    }

    public void isZonedDateTimeNotTomorrow() throws Exception
    {
        describeTestCase();

        ZonedDateTime date = ZonedDateTime.now().minusDays( 1 );
        String desc = getDescription( not( ZonedDateTimeMatchers.isTomorrow() ) );
        Assertion.assertThat( date,
                              not( ZonedDateTimeMatchers.isTomorrow() ),
                              "\"ZonedDateTime.now().minusDays( 1 )\" matches " + desc
        );
    }

}
