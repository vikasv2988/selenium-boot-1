package selenium.boot.hamcrest.date;


import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.LocalTimeMatchers;import selenium.boot.hamcrest.ZonedDateTimeMatchers;import selenium.boot.hamcrest.date.utils.ZoneIds;

import java.time.LocalTime;
import java.time.Month;

import static java.time.Month.AUGUST;
import static selenium.boot.hamcrest.date.utils.Dates.*;

/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsAfter} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#after(int, java.time.Month, int, int, int, int, int, java.time.ZoneId)}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#after(java.time.ZonedDateTime)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#after(java.time.LocalDateTime)} </li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#after(int, java.time.Month, int, int, int, int)} /li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#after(java.time.LocalDate)} </li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#after(int, java.time.Month, int)}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#after(java.time.LocalDate)}</li>
 *     <li {@link selenium.boot.hamcrest.DateMatchers#after(int, java.time.Month, int, int, int, int)}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#after(java.util.Date)}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#after(int, java.time.Month, int)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsDayOfMonth
 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsAfter, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01-04. after for ZonedDateTimeMatchers,LocalDateTimeMatchers,LocalDateMatchers and DateMatchers\n" +
                              "05-08. after with values for ZonedDateTimeMatchers,LocalDateTimeMatchers,LocalDateMatchers and DateMatchers"
)
public class IsAfterTests extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: a (date|time|local-date|timezone-datetime|local-datetime) after [A-Za-z0-9:,.+ \\-]+"
                    +"\\s.*but: the (date|time|local-date|timezone-datetime|local-datetime) is [A-Za-z0-9:,.+ \\-]+.*";

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateAfterEarlierDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.after( JUN_15_2012_11AM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.after( JUN_15_2012_11AM_AS_DATE ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than a later java.date; throws AssertionError",
            expectedExceptions = { AssertionError.class },
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterLaterDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.after( JUN_15_2012_11PM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.after( JUN_15_2012_11PM_AS_DATE ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter the same a java.date. throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterSameDate() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JUN_15_2012_11PM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.after( JUN_15_2012_11PM_AS_DATE ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than the same java.date with different time-zone."
    )
    public void isDateAfterSameDateDifferentTimeZone() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JAN_01_2012_11AM_GMT_AS_DATE ) );
        Assertion.assertThat( JAN_01_2012_11AM_PST_AS_DATE,
                              DateMatchers.after( JAN_01_2012_11AM_GMT_AS_DATE ),
                              "\"JAN_01_2012_11AM_PST_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than a later same java.date with different time-zone; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterLaterSameDateDifferentTimeZone() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JAN_01_2012_11AM_PST_AS_DATE ) );
        Assertion.assertThat( JAN_01_2012_11AM_GMT_AS_DATE,
                              DateMatchers.after( JAN_01_2012_11AM_PST_AS_DATE ),
                              "\"JAN_01_2012_11AM_GMT_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than an earlier local-date."
    )
    public void isDateAfterEarlierLocalDate() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JUN_14_2012 ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.after( JUN_14_2012 ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates java.date IsAfter than a later local-date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterLaterLocalDate() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JUN_16_2012 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.after( JUN_16_2012 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than the same local-date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterSameLocalDate() throws Exception
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( JUN_15_2012 ) );
        Assertion.assertThat( JUN_15_2012_AS_DATE,
                              DateMatchers.after( JUN_15_2012 ),
                              "\"JUN_15_2012_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than an earlier date with values: year,month and day"
    )
    public void isDateAfterEarlierDateValues()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 14 ) );
        Assertion.assertThat( JUN_15_2012_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 14 ),
                              "\"JUN_15_2012_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than a later java.date with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterLaterDateValues()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 16 ) );
        Assertion.assertThat( JUN_15_2012_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 16 ),
                              "\"JUN_15_2012_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than the same java.date with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterSameDateValues()
    {
        describeTestCase();
        
        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 15 ) );
        Assertion.assertThat( JUN_15_2012_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 15 ),
                              "\"JUN_15_2012_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than an earlier java.date with values: year,month,day,hour,minute and second"
    )
    public void isDateAfterEarlierDateTime()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 15, 10, 59, 59 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 15 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsAfter than a later java.date "
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterLaterDateTime()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 15, 11, 0, 1 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 15 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates java.date IsAfter than the same java.date "
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateAfterSameDateTime()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.after( 2012, Month.JUNE, 15, 11, 0, 0 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.after( 2012, Month.JUNE, 15 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than an earlier local-date"
    )
    public void isLocalDateAfterEarlierLocalDate()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( AUG_03_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( AUG_03_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than a later local-date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateAfterLaterLocalDate()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( AUG_05_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( AUG_05_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than the same local-date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateAfterSameLocalDate()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( AUG_04_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( AUG_04_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than an earlier local-date with values: year,month and day"
    )
    public void isLocalDateAfterEarlierDay()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( 2015, AUGUST, 3 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( 2015, AUGUST, 3 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than a later local-date "
                                  + "with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateAfterLaterDay()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( 2015, AUGUST, 5 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( 2015, AUGUST, 5 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-date IsAfter than the same local-date "
                                  + "with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateAfterLaterSameDay()
    {
        describeTestCase();

        String desc = getDescription( LocalDateMatchers.after( 2015, AUGUST, 4 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.after( 2015, AUGUST, 4 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than an earlier local-datetime"
    )
    public void isLocalDateTimeAfterEarlierLocalDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( AUG_04_2015_1159 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( AUG_04_2015_1159 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than a later local-datetime; throws AssertionError.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeAfterLaterLocalDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( AUG_04_2015_1201 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( AUG_04_2015_1201 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than the same local-datetime; throws AssertionError.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeAfterSameLocalDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( AUG_04_2015_NOON ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( AUG_04_2015_NOON ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than an earlier local-datetime "
                                  + "with values: year,month,day,hour,minute and second"
    )
    public void isLocalDateTimeAfterEarlierDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( 2015, AUGUST, 4, 11, 59, 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( 2015, AUGUST, 4, 11, 59, 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than a later local-datetime "
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeAfterLaterDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 1 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 1 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-datetime IsAfter than the same local-datetime"
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeAfterLaterSameDateTime()
    {
        describeTestCase();

        String desc = getDescription( LocalDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than an earlier zoned-datetime"
    )
    public void isZonedDateTimeAfterEarlierZonedDateTime()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.after( AUG_04_2015_11AM_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( AUG_04_2015_11AM_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later zoned-datetime; throws AssertionError.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterLaterZonedDateTime()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.after( AUG_04_2015_01PM_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( AUG_04_2015_01PM_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than the same zoned-datetime; throws AssertionError.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterSameZonedDateTime()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.after( AUG_04_2015_NOON_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( AUG_04_2015_NOON_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later zoned-datetime on an early time-zone."
    )
    public void isZonedDateTimeAfterZonedDateTimeEarlierZone()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.after( AUG_04_2015_NOON_CET ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( AUG_04_2015_NOON_CET ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later zoned-datetime on a later time-zone.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterZonedDateTimeLaterZone()
    {
        describeTestCase();

        String desc = getDescription( ZonedDateTimeMatchers.after( AUG_04_2015_NOON_EST ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( AUG_04_2015_NOON_EST ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than an earlier datetime "
                                  + "with values: year,month,day,hour,minute,second and TZ"
    )
    public void isZonedDateTimeAfterEarlierDateTime()
    {
        describeTestCase();

        String desc = getDescription(
                ZonedDateTimeMatchers.after( 2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( 2015,
                                                           AUGUST,
                                                           4,
                                                           11,
                                                           59,
                                                           0,
                                                           0,
                                                           ZoneIds.UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );

    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later datetime"
                                  + "with values: year,month,day,hour,minute,second and TZ; throws an AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterLaterDateTime()
    {
        describeTestCase();

        String desc = getDescription(
                ZonedDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( 2015,
                                                           AUGUST,
                                                           4,
                                                           12,
                                                           0,
                                                           1,
                                                           0,
                                                           ZoneIds.UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than the same datetime"
                                  + "with values: year,month,day,hour,minute,second and TZ; throws an AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterLaterSameDateTime()
    {
        describeTestCase();

        String desc = getDescription(
                ZonedDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( 2015, AUGUST,
                                                           4,
                                                           12,
                                                           0,
                                                           0,
                                                           0,
                                                           ZoneIds.UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later datetime on early timezone "
                                  + "with values: year,month,day,hour,minute,second and TZ"
    )
    public void isZonedDateTimeAfterDateTimeEarlierZone()
    {
        describeTestCase();

        String desc = getDescription(
                ZonedDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( 2015,
                                                           AUGUST,
                                                           4,
                                                           12,
                                                           0,
                                                           0,
                                                           0,
                                                           ZoneIds.CET ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned-datetime IsAfter than a later datetime using on later timezone "
                                  + "with values: year,month,day,hour,minute,second and TZ; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeAfterDateTimeLaterZone()
    {
        describeTestCase();

        String desc = getDescription(
                ZonedDateTimeMatchers.after( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.after( 2015,
                                                           AUGUST,
                                                           4,
                                                           12,
                                                           0,
                                                           0,
                                                           0,
                                                           ZoneIds.EST ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than an earlier local-time."
    )
    public void isLocalTimeAfterEarlierLocalTime()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.after( LocalTime.NOON.minusSeconds( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( LocalTime.NOON.minusSeconds( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than the same local-time; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeAfterSameLocalTime()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.after( LocalTime.NOON ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( LocalTime.NOON ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than a later local-time; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeAfterLaterLocalTime()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.after( LocalTime.NOON.plusSeconds( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( LocalTime.NOON.plusSeconds( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than an earlier local-time with values: Hour,Minute and Second"
    )
    public void isLocalTimeAfterEarlierTime()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.after( 11, 59, 59 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( 11, 59, 59 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than the same local-time "
                                  + "with values: Hour,Minute and Second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeAfterSameTime()
    {
        describeTestCase();

        String desc = getDescription( LocalTimeMatchers.after( 12, 0, 0 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( 12, 0, 0 ),
                              "\"LocalTime.NOON\" matches " + desc
        );

    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsAfter than a later local-time "
                                  + "with values: Hour,Minute and Second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeAfterLaterTime()
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.after( 12, 0, 1 ) );

        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.after( 12, 0, 1 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }
}
