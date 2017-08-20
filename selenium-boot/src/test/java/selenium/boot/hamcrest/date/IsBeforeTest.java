package selenium.boot.hamcrest.date;



import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.LocalTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;
import selenium.boot.hamcrest.date.utils.ZoneIds;

import java.time.LocalTime;
import java.time.Month;

import static selenium.boot.hamcrest.date.utils.Dates.*;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsBefore}
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsBefore
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#before(java.time.ZonedDateTime)
 * @see selenium.boot.hamcrest.ZonedDateTimeMatchers#before(int, java.time.Month, int, int, int, int, int, java.time.ZoneId)
 * @see selenium.boot.hamcrest.LocalTimeMatchers#before(java.time.LocalTime)
 * @see selenium.boot.hamcrest.LocalTimeMatchers#before(int, int, int)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#before(java.time.LocalDateTime)
 * @see selenium.boot.hamcrest.LocalDateTimeMatchers#before(int, java.time.Month, int, int, int, int)
 * @see selenium.boot.hamcrest.LocalDateMatchers#before(java.time.LocalDate)
 * @see selenium.boot.hamcrest.LocalDateMatchers#before(int, java.time.Month, int)
 * @see selenium.boot.hamcrest.DateMatchers#before(int, java.time.Month, int)
 * @see selenium.boot.hamcrest.DateMatchers#before(java.time.LocalDate)
 * @see DateMatchers#before(int, java.time.Month, int, int, int, int)
 * @see selenium.boot.hamcrest.DateMatchers#before(java.util.Date)
 * @since 1.0
 */
@SuppressWarnings( { "deprecation", "DefaultAnnotationParam" } )
public class IsBeforeTest extends AbstractMatcherTest
{

    private static final String ASSERTION_PATTERN =
            ".*Expected: a (date|time|local-date|timezone-datetime|local-datetime) is before [A-Za-z0-9:,.+ \\-]+"
                    +"\\s.*but: the (date|time|local-date|timezone-datetime|local-datetime) is [A-Za-z0-9:,.+ \\-]+.*";

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than a later java.date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterDate() throws Exception
    {

        describeTestCase();
        String desc = Assertion.getDescription( DateMatchers.before( JUN_15_2012_11AM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( JUN_15_2012_11AM_AS_DATE ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );

    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than an earlier java.date."
    )
    public void isDateBeforeEarlierDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JUN_15_2012_11PM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.before( JUN_15_2012_11PM_AS_DATE ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same java.date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterSameDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JUN_15_2012_11PM_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( JUN_15_2012_11PM_AS_DATE ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than a later java.date with different time-zone; throw AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterSameDateDifferentTimeZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JAN_01_2012_11AM_GMT_AS_DATE ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( JAN_01_2012_11AM_GMT_AS_DATE ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same java.date with different time-zone"
    )
    public void isDateBeforeSameDateDifferentTimeZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JAN_01_2012_11AM_PST_AS_DATE ) );
        Assertion.assertThat( JAN_01_2012_11AM_GMT_AS_DATE,
                              DateMatchers.before( JAN_01_2012_11AM_PST_AS_DATE ),
                              "\"JAN_01_2012_11AM_GMT_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than a later local.date",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterLocalDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JUN_14_2012 ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( JUN_14_2012 ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than an earlier local.date."
    )
    public void isDateBeforeEarlierLocalDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JUN_16_2012 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.before( JUN_16_2012 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same local.date",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterSameLocalDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( JUN_15_2012 ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( JUN_15_2012 ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than a later java.date with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterDateValues() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 14 ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 14 ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than an earlier java.date with values: year,month and day"
    )
    public void isDateBeforeEarlierDateValues() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 16 ) );
        Assertion.assertThat( JUN_15_2012_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 16 ),
                              "\"JUN_15_2012_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same java.date with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterSameDateValues() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 15 ) );
        Assertion.assertThat( JUN_15_2012_11PM_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 15 ),
                              "\"JUN_15_2012_11PM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same java.date "
                                  + "with values: year,month,day.hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN

    )
    public void isDateBeforeLaterDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 15, 10, 59, 59 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 15, 10, 59, 59 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than an earlier java.date "
                                  + "with values: year,month,day.hour,minute and second"
    )
    public void isDateBeforeEarlierDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 15, 11, 0, 1 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 15, 11, 0, 1 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a java.date IsBefore than the same java.date "
                                  + "with values: year,month,day.hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateBeforeLaterSameDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( DateMatchers.before( 2012, Month.JUNE, 15, 11, 0, 0 ) );
        Assertion.assertThat( JUN_15_2012_11AM_AS_DATE,
                              DateMatchers.before( 2012, Month.JUNE, 15, 11, 0, 0 ),
                              "\"JUN_15_2012_11AM_AS_DATE\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------


    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than a later local.date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateBeforeLaterLocalDate() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( AUG_03_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( AUG_03_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than an earlier local.date"
    )
    public void isLocalDateBeforeEarlierLocalDate()  throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( AUG_05_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( AUG_05_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than same local.date; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateBeforeLaterSameLocalDate()  throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( AUG_04_2015 ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( AUG_04_2015 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than a later local.date "
                                  + "with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateBeforeLaterDay() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( 2015, Month.AUGUST, 3  ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( 2015, Month.AUGUST, 3 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than an earlier local.date "
                                  + "with values: year,month and day"
    )
    public void isLocalDateBeforeEarlierDay() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( 2015, Month.AUGUST, 5  ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( 2015, Month.AUGUST, 5 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.date IsBefore than the same local.date "
                                  + "with values: year,month and day; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateBeforeSameDay() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateMatchers.before( 2015, Month.AUGUST, 4  ) );
        Assertion.assertThat( AUG_04_2015,
                              LocalDateMatchers.before( 2015, Month.AUGUST, 4 ),
                              "\"AUG_04_2015\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than a later local.datetime; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeBeforeLaterLocalDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( AUG_04_2015_1159 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( AUG_04_2015_1159 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than an earlier local.datetime"
    )
    public void isLocalDateTimeBeforeEarlierLocalDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( AUG_04_2015_1201 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( AUG_04_2015_1201 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than the same local.datetime; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeBeforeLaterSameLocalDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( AUG_04_2015_NOON ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( AUG_04_2015_NOON ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than a later local.datetime "
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeBeforeLaterDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 11, 59, 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 11, 59, 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than a later local.datetime "
                                  + "with values: year,month,day,hour,minute and second"
    )
    public void isLocalDateTimeBeforeEarlierDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 1 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 1 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local.datetime IsBefore than a later local.datetime "
                                  + "with values: year,month,day,hour,minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalDateTimeBeforeSameDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON,
                              LocalDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0 ),
                              "\"AUG_04_2015_NOON\" matches " + desc
        );
    }


    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than a later zoned.datetime throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeLaterZonedDateTime() throws Exception
    {

        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.before( AUG_04_2015_11AM_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( AUG_04_2015_11AM_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than an earlier zoned.datetime"
    )
    public void isZonedDateTimeBeforeEarlierZonedDateTime() throws Exception
    {

        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.before( AUG_04_2015_01PM_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( AUG_04_2015_01PM_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than an earlier zoned.datetime; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeLaterSameZonedDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.before( AUG_04_2015_NOON_UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( AUG_04_2015_NOON_UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than the same zoned.datetime on earlier time-zone; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeZonedDateTimeEarlierZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.before( AUG_04_2015_NOON_CET ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( AUG_04_2015_NOON_CET ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than the same zoned.datetime on later time-zone"
    )
    public void isZonedDateTimeBeforeZonedDateTimeLaterZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( ZonedDateTimeMatchers.before( AUG_04_2015_NOON_EST ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( AUG_04_2015_NOON_EST ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than a later datetime "
                 + "using values year,month,day,hour,minute,second and time-zone; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeLaterDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription(
                ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( 2015,
                                                            Month.AUGUST,
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
            description = "Validates a zoned.datetime IsBefore than an earlier datetime "
                                  + "using values year,month,day,hour,minute,second and time-zone"
    )
    public void isZonedDateTimeBeforeEarlierDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription(
                ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than the same datetime "
                                  + "using values year,month,day,hour,minute,second and time-zone; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeSameDateTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription(
                ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers. before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than a datetime on early time zone "
                                  + "using values year,month,day,hour,minute,second and time-zone; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isZonedDateTimeBeforeDateTimeEarlierZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription(
                ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a zoned.datetime IsBefore than a datetime on later time zone "
                                  + "using values year,month,day,hour,minute,second and time-zone"
    )
    public void isZonedDateTimeBeforeDateTimeLaterZone() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription(
                ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST ) );
        Assertion.assertThat( AUG_04_2015_NOON_UTC,
                              ZonedDateTimeMatchers.before( 2015, Month.AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST ),
                              "\"AUG_04_2015_NOON_UTC\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than early local-time; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeBeforeEarlierLocalTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( LocalTime.NOON.minusSeconds( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( LocalTime.NOON.minusSeconds( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than the same local-time throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeBeforeSameLocalTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( LocalTime.NOON.minusSeconds( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( LocalTime.NOON.minusSeconds( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than a later local-time."
    )
    public void isLocalTimeBeforeLaterLocalTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( LocalTime.NOON.plusSeconds( 1 ) ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( LocalTime.NOON.plusSeconds( 1 ) ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than the an earlier local-time, using values hour.minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeBeforeEarlierTime() throws Exception
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( 11, 59, 59 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( 11, 59, 59 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than the same local-time, using values hour.minute and second; throws AssertionError",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isLocalTimeBeforeSameTime()
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( 12, 0, 0 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( 12, 0, 0 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }

    @Test(
            enabled = true,
            description = "Validates a local-time IsBefore than a later local-time, using values hour.minute and second"
    )
    public void isLocalTimeBeforeLaterTime()
    {
        describeTestCase();

        String desc = Assertion.getDescription( LocalTimeMatchers.before( 12, 0, 1 ) );
        Assertion.assertThat( LocalTime.NOON,
                              LocalTimeMatchers.before( 12, 0, 1 ),
                              "\"LocalTime.NOON\" matches " + desc
        );
    }
}
