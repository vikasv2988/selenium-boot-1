package selenium.boot.hamcrest.date;

//@formatter:off

import com.google.common.collect.Lists;
import org.hamcrest.Matcher;
import org.springframework.util.StringUtils;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;
import selenium.boot.hamcrest.LocalDateMatchers;
import selenium.boot.hamcrest.LocalDateTimeMatchers;
import selenium.boot.hamcrest.ZonedDateTimeMatchers;

import java.lang.reflect.Method;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.Dates.*;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsDayOfWeek} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isDayOfWeek(java.time.DayOfWeek...)}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isWeekday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isWeekend()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isMonday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isTuesday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isWednesday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isThursday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isFriday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isSaturday()}</li>
 * <li>{@link selenium.boot.hamcrest.DateMatchers#isSunday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isDayOfWeek(java.time.DayOfWeek...)}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isWeekday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isWeekend()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isMonday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isTuesday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isWednesday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isThursday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isFriday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isSaturday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isSunday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isDayOfWeek(java.time.DayOfWeek...)}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isWeekday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isWeekend()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isMonday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isTuesday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isWednesday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isThursday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isFriday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isSaturday()}</li>
 * <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isSunday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isDayOfWeek(java.time.DayOfWeek...)}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isWeekday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isWeekend()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isMonday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isTuesday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isWednesday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isThursday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isFriday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isSaturday()}</li>
 * <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isSunday()}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsDayOfWeek
 * @see selenium.boot.hamcrest.DateMatchers#isDayOfWeek(java.time.DayOfWeek...)
 * @see selenium.boot.hamcrest.DateMatchers#isWeekday()
 * @see selenium.boot.hamcrest.DateMatchers#isWeekend()
 * @see selenium.boot.hamcrest.DateMatchers#isMonday()
 * @see selenium.boot.hamcrest.DateMatchers#isTuesday()
 * @see selenium.boot.hamcrest.DateMatchers#isWednesday()
 * @see selenium.boot.hamcrest.DateMatchers#isThursday()
 * @see selenium.boot.hamcrest.DateMatchers#isFriday()
 * @see selenium.boot.hamcrest.DateMatchers#isSaturday()
 * @see selenium.boot.hamcrest.DateMatchers#isSunday()
 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsDayOfWeek, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01-04 isDayOfWeek for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "06-08 isWeekend for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "09-12 isMonday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "13-16 isTuesday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "17-20 isWednesday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "21-24 isThursday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "25-28 isFriday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "29-32 isSaturday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "33-36 isSaturday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers\n" +
                              "37-40 isWeekday for ZonedDateTimeMatchers,LocalTimeMatchers,LocalDateTimeMatchers and DateMatchers"
)
public class IsDayOfWeekTest extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the (date|local-date|local-datetime) is [A-Z, ]+\\s.*but: the (date|local-date|local-datetime) is [A-Z]+.*";


    //region TestNG Management methods ( @Before, @After, @DataProvider )

    //---------------------------------------------------------------------
    // TestNG Management methods ( @Before, @After, @DataProvider )
    //---------------------------------------------------------------------

    @DataProvider( name = "date-dp" )
    public Object[][] getDates( Method m )
    {
        final Date JAN2 = JAN_02_2012_11AM_AS_DATE;
        final Date JAN3 = JAN_03_2012_11AM_AS_DATE;
        final Date JAN4 = JAN_04_2012_11AM_AS_DATE;
        final Date JAN5 = JAN_05_2012_11AM_AS_DATE;
        final Date JAN6 = JAN_06_2012_11AM_AS_DATE;
        final Date JAN7 = JAN_07_2012_11AM_AS_DATE;
        final Date JAN8 = JAN_08_2012_11AM_AS_DATE;

        List<Object[]> data = Lists.newArrayList();
        switch( m.getName() )
        {
            case "isOrIsNotDateWeekdays":
                data.add( new Object[] { JAN2, DateMatchers.isDayOfWeek( DayOfWeek.MONDAY ) } );
                data.add( new Object[] { JAN3, DateMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) } );
                data.add( new Object[] { JAN4, DateMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) } );
                data.add( new Object[] { JAN5, DateMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) } );
                data.add( new Object[] { JAN6, DateMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) } );
                data.add( new Object[] { JAN7, DateMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) } );
                data.add( new Object[] { JAN8, DateMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) } );
                data.add( new Object[] { JAN2, not( DateMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) ) } );
                data.add( new Object[] { JAN3, not( DateMatchers.isDayOfWeek( DayOfWeek.MONDAY ) ) } );
                data.add( new Object[] { JAN4, not( DateMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) ) } );
                data.add( new Object[] { JAN5, not( DateMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) ) } );
                data.add( new Object[] { JAN6, not( DateMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) ) } );
                data.add( new Object[] { JAN7, not( DateMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) ) } );
                data.add( new Object[] { JAN8, not( DateMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) ) } );
                break;
            case "isNotDateWeekdaysMismatchMessage":
                data.add( new Object[] { JAN2, DateMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) } );
                data.add( new Object[] { JAN3, DateMatchers.isDayOfWeek( DayOfWeek.MONDAY ) } );
                data.add( new Object[] { JAN4, DateMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) } );
                data.add( new Object[] { JAN5, DateMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) } );
                data.add( new Object[] { JAN6, DateMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) } );
                data.add( new Object[] { JAN7, DateMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) } );
                data.add( new Object[] { JAN8, DateMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) } );
                break;
            case "isOrIsNotDateWeekday":
                data.add( new Object[] { JAN2, DateMatchers.isWeekday() } );
                data.add( new Object[] { JAN3, DateMatchers.isWeekday() } );
                data.add( new Object[] { JAN4, DateMatchers.isWeekday() } );
                data.add( new Object[] { JAN5, DateMatchers.isWeekday() } );
                data.add( new Object[] { JAN6, DateMatchers.isWeekday() } );
                data.add( new Object[] { JAN7, not( DateMatchers.isWeekday() ) } );
                data.add( new Object[] { JAN8, not( DateMatchers.isWeekday() ) } );
                break;
            case "isOrIsNotDateWeekend":
                data.add( new Object[] { JAN2, not( DateMatchers.isWeekend() ) } );
                data.add( new Object[] { JAN3, not( DateMatchers.isWeekend() ) } );
                data.add( new Object[] { JAN4, not( DateMatchers.isWeekend() ) } );
                data.add( new Object[] { JAN5, not( DateMatchers.isWeekend() ) } );
                data.add( new Object[] { JAN6, not( DateMatchers.isWeekend() ) } );
                data.add( new Object[] { JAN7, DateMatchers.isWeekend() } );
                data.add( new Object[] { JAN8, DateMatchers.isWeekend() } );
                break;
            case "isOrIsNotDateOfWeek":
                data.add( new Object[] { JAN2, DateMatchers.isMonday() } );
                data.add( new Object[] { JAN3, DateMatchers.isTuesday() } );
                data.add( new Object[] { JAN4, DateMatchers.isWednesday() } );
                data.add( new Object[] { JAN5, DateMatchers.isThursday() } );
                data.add( new Object[] { JAN6, DateMatchers.isFriday() } );
                data.add( new Object[] { JAN7, DateMatchers.isSaturday() } );
                data.add( new Object[] { JAN8, DateMatchers.isSunday() } );
                data.add( new Object[] { JAN8, not( DateMatchers.isMonday() ) } );
                data.add( new Object[] { JAN2, not( DateMatchers.isTuesday() ) } );
                data.add( new Object[] { JAN3, not( DateMatchers.isWednesday() ) } );
                data.add( new Object[] { JAN4, not( DateMatchers.isThursday() ) } );
                data.add( new Object[] { JAN5, not( DateMatchers.isFriday() ) } );
                data.add( new Object[] { JAN6, not( DateMatchers.isSaturday() ) } );
                data.add( new Object[] { JAN7, not( DateMatchers.isSunday() ) } );
                break;
        }

        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "local-date-dp" )
    public Object[][] getLocalDates( Method m )
    {
        List<Object[]> data = Lists.newArrayList();
        final LocalDate AUG3 = AUG_03_2015;
        final LocalDate AUG4 = AUG_04_2015;
        final LocalDate AUG5 = AUG_05_2015;
        final LocalDate AUG6 = AUG_06_2015;
        final LocalDate AUG7 = AUG_07_2015;
        final LocalDate AUG8 = AUG_08_2015;
        final LocalDate AUG9 = AUG_09_2015;

        switch( m.getName() )
        {
            case "isOrIsNotLocalDateWeekdays":
                data.add( new Object[] { AUG3, LocalDateMatchers.isDayOfWeek( DayOfWeek.MONDAY ) } );
                data.add( new Object[] { AUG4, LocalDateMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) } );
                data.add( new Object[] { AUG5, LocalDateMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) } );
                data.add( new Object[] { AUG6, LocalDateMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) } );
                data.add( new Object[] { AUG7, LocalDateMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) } );
                data.add( new Object[] { AUG8, LocalDateMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) } );
                data.add( new Object[] { AUG9, LocalDateMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) } );
                data.add( new Object[] { AUG3, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) ) } );
                data.add( new Object[] { AUG4, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.MONDAY ) ) } );
                data.add( new Object[] { AUG5, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) ) } );
                data.add( new Object[] { AUG6, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) ) } );
                data.add( new Object[] { AUG7, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) ) } );
                data.add( new Object[] { AUG8, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) ) } );
                data.add( new Object[] { AUG9, not( LocalDateMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) ) } );
                break;
            case "isOrIsNotLocalDateWeekday":
                data.add( new Object[] { AUG3, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG4, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG5, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG6, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG7, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG8, not( LocalDateMatchers.isWeekday() ) } );
                data.add( new Object[] { AUG9, not( LocalDateMatchers.isWeekday() ) } );
                break;
            case "isOrIsNotLocalDateWeekdayMismatchMessage":
                data.add( new Object[] { AUG8, LocalDateMatchers.isWeekday() } );
                data.add( new Object[] { AUG9, LocalDateMatchers.isWeekday() } );
                break;
            case "isOrIsNotLocalDateWeekend":
                data.add( new Object[] { AUG3, not( LocalDateMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG4, not( LocalDateMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG5, not( LocalDateMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG6, not( LocalDateMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG7, not( LocalDateMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG8, LocalDateMatchers.isWeekend() } );
                data.add( new Object[] { AUG9, LocalDateMatchers.isWeekend() } );
                break;
            case "isOrIsNotLocalDateOfWeek":
                data.add( new Object[] { AUG3, LocalDateMatchers.isMonday() } );
                data.add( new Object[] { AUG4, LocalDateMatchers.isTuesday() } );
                data.add( new Object[] { AUG5, LocalDateMatchers.isWednesday() } );
                data.add( new Object[] { AUG6, LocalDateMatchers.isThursday() } );
                data.add( new Object[] { AUG7, LocalDateMatchers.isFriday() } );
                data.add( new Object[] { AUG8, LocalDateMatchers.isSaturday() } );
                data.add( new Object[] { AUG9, LocalDateMatchers.isSunday() } );
                data.add( new Object[] { AUG9, not( LocalDateMatchers.isMonday() ) } );
                data.add( new Object[] { AUG3, not( LocalDateMatchers.isTuesday() ) } );
                data.add( new Object[] { AUG4, not( LocalDateMatchers.isWednesday() ) } );
                data.add( new Object[] { AUG5, not( LocalDateMatchers.isThursday() ) } );
                data.add( new Object[] { AUG6, not( LocalDateMatchers.isFriday() ) } );
                data.add( new Object[] { AUG7, not( LocalDateMatchers.isSaturday() ) } );
                data.add( new Object[] { AUG8, not( LocalDateMatchers.isSunday() ) } );
                break;
        }
        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "local-datetime-dp" )
    public Object[][] getLocalDateTimes( Method m )
    {
        List<Object[]> data = Lists.newArrayList();
        final LocalDateTime AUG3 = AUG_03_2015_NOON;
        final LocalDateTime AUG4 = AUG_04_2015_NOON;
        final LocalDateTime AUG5 = AUG_05_2015_NOON;
        final LocalDateTime AUG6 = AUG_06_2015_NOON;
        final LocalDateTime AUG7 = AUG_07_2015_NOON;
        final LocalDateTime AUG8 = AUG_08_2015_NOON;
        final LocalDateTime AUG9 = AUG_09_2015_NOON;

        switch( m.getName() )
        {
            case "isOrIsNotLocalDateTimeWeekdays":
                data.add( new Object[] { AUG3, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.MONDAY ) } );
                data.add( new Object[] { AUG4, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) } );
                data.add( new Object[] { AUG5, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) } );
                data.add( new Object[] { AUG6, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) } );
                data.add( new Object[] { AUG7, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) } );
                data.add( new Object[] { AUG8, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) } );
                data.add( new Object[] { AUG9, LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) } );
                data.add( new Object[] { AUG3, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) ) } );
                data.add( new Object[] { AUG4, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.MONDAY ) ) } );
                data.add( new Object[] { AUG5, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) ) } );
                data.add( new Object[] { AUG6, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) ) } );
                data.add( new Object[] { AUG7, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) ) } );
                data.add( new Object[] { AUG8, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) ) } );
                data.add( new Object[] { AUG9, not( LocalDateTimeMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) ) } );
                break;
            case "isOrIsNotLocalDateTimeWeekday":
                data.add( new Object[] { AUG3, LocalDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG4, LocalDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG5, LocalDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG6, LocalDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG7, LocalDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG8, not( LocalDateTimeMatchers.isWeekday() ) } );
                data.add( new Object[] { AUG9, not( LocalDateTimeMatchers.isWeekday() ) } );
                break;
            case "isOrIsNotLocalDateTimeWeekend":
                data.add( new Object[] { AUG3, not( LocalDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG4, not( LocalDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG5, not( LocalDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG6, not( LocalDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG7, not( LocalDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG8, LocalDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG9, LocalDateTimeMatchers.isWeekend() } );
                break;
            case "isOrIsNotLocalDateTimeWeekendMismatchMessage":
                data.add( new Object[] { AUG3, LocalDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG4, LocalDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG5, LocalDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG6, LocalDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG7, LocalDateTimeMatchers.isWeekend() } );
                break;
            case "isOrIsNotLocalDateTimeOfWeek":
                data.add( new Object[] { AUG3, LocalDateTimeMatchers.isMonday() } );
                data.add( new Object[] { AUG4, LocalDateTimeMatchers.isTuesday() } );
                data.add( new Object[] { AUG5, LocalDateTimeMatchers.isWednesday() } );
                data.add( new Object[] { AUG6, LocalDateTimeMatchers.isThursday() } );
                data.add( new Object[] { AUG7, LocalDateTimeMatchers.isFriday() } );
                data.add( new Object[] { AUG8, LocalDateTimeMatchers.isSaturday() } );
                data.add( new Object[] { AUG9, LocalDateTimeMatchers.isSunday() } );
                data.add( new Object[] { AUG9, not( LocalDateTimeMatchers.isMonday() ) } );
                data.add( new Object[] { AUG3, not( LocalDateTimeMatchers.isTuesday() ) } );
                data.add( new Object[] { AUG4, not( LocalDateTimeMatchers.isWednesday() ) } );
                data.add( new Object[] { AUG5, not( LocalDateTimeMatchers.isThursday() ) } );
                data.add( new Object[] { AUG6, not( LocalDateTimeMatchers.isFriday() ) } );
                data.add( new Object[] { AUG7, not( LocalDateTimeMatchers.isSaturday() ) } );
                data.add( new Object[] { AUG8, not( LocalDateTimeMatchers.isSunday() ) } );
                break;
        }
        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "zoned-datetime-dp" )
    public Object[][] getZonedDateTimes( Method m )
    {
        List<Object[]> data = Lists.newArrayList();
        final ZonedDateTime AUG3 = AUG_03_2015_NOON_UTC;
        final ZonedDateTime AUG4 = AUG_04_2015_NOON_UTC;
        final ZonedDateTime AUG5 = AUG_05_2015_NOON_UTC;
        final ZonedDateTime AUG6 = AUG_06_2015_NOON_UTC;
        final ZonedDateTime AUG7 = AUG_07_2015_NOON_UTC;
        final ZonedDateTime AUG8 = AUG_08_2015_NOON_UTC;
        final ZonedDateTime AUG9 = AUG_09_2015_NOON_UTC;

        switch( m.getName() )
        {
            case "isOrIsNotZonedDateTimeWeekdays":
                data.add( new Object[] { AUG3, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.MONDAY ) } );
                data.add( new Object[] { AUG4, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) } );
                data.add( new Object[] { AUG5, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) } );
                data.add( new Object[] { AUG6, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) } );
                data.add( new Object[] { AUG7, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) } );
                data.add( new Object[] { AUG8, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) } );
                data.add( new Object[] { AUG9, ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) } );
                data.add( new Object[] { AUG3, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.SUNDAY ) ) } );
                data.add( new Object[] { AUG4, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.MONDAY ) ) } );
                data.add( new Object[] { AUG5, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.TUESDAY ) ) } );
                data.add( new Object[] { AUG6, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.WEDNESDAY ) ) } );
                data.add( new Object[] { AUG7, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.THURSDAY ) ) } );
                data.add( new Object[] { AUG8, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.FRIDAY ) ) } );
                data.add( new Object[] { AUG9, not( ZonedDateTimeMatchers.isDayOfWeek( DayOfWeek.SATURDAY ) ) } );
                break;
            case "isOrIsNotZonedDateTimeWeekday":
                data.add( new Object[] { AUG3, ZonedDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG4, ZonedDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG5, ZonedDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG6, ZonedDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG7, ZonedDateTimeMatchers.isWeekday() } );
                data.add( new Object[] { AUG8, not( ZonedDateTimeMatchers.isWeekday() ) } );
                data.add( new Object[] { AUG9, not( ZonedDateTimeMatchers.isWeekday() ) } );
                break;
            case "isOrIsNotZonedDateTimeWeekend":
                data.add( new Object[] { AUG3, not( ZonedDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG4, not( ZonedDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG5, not( ZonedDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG6, not( ZonedDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG7, not( ZonedDateTimeMatchers.isWeekend() ) } );
                data.add( new Object[] { AUG8, ZonedDateTimeMatchers.isWeekend() } );
                data.add( new Object[] { AUG9, ZonedDateTimeMatchers.isWeekend() } );
                break;
            case "isOrIsNotZonedDateTimeOfWeek":
                data.add( new Object[] { AUG3, ZonedDateTimeMatchers.isMonday() } );
                data.add( new Object[] { AUG4, ZonedDateTimeMatchers.isTuesday() } );
                data.add( new Object[] { AUG5, ZonedDateTimeMatchers.isWednesday() } );
                data.add( new Object[] { AUG6, ZonedDateTimeMatchers.isThursday() } );
                data.add( new Object[] { AUG7, ZonedDateTimeMatchers.isFriday() } );
                data.add( new Object[] { AUG8, ZonedDateTimeMatchers.isSaturday() } );
                data.add( new Object[] { AUG9, ZonedDateTimeMatchers.isSunday() } );
                data.add( new Object[] { AUG9, not( ZonedDateTimeMatchers.isMonday() ) } );
                data.add( new Object[] { AUG3, not( ZonedDateTimeMatchers.isTuesday() ) } );
                data.add( new Object[] { AUG4, not( ZonedDateTimeMatchers.isWednesday() ) } );
                data.add( new Object[] { AUG5, not( ZonedDateTimeMatchers.isThursday() ) } );
                data.add( new Object[] { AUG6, not( ZonedDateTimeMatchers.isFriday() ) } );
                data.add( new Object[] { AUG7, not( ZonedDateTimeMatchers.isSaturday() ) } );
                data.add( new Object[] { AUG8, not( ZonedDateTimeMatchers.isSunday() ) } );
                break;
            case "isOrIsNotZonedDateTimeOfWeekMismatchMessage":
                data.add( new Object[] { AUG9, ZonedDateTimeMatchers.isMonday() } );
                data.add( new Object[] { AUG3, ZonedDateTimeMatchers.isTuesday() } );
                data.add( new Object[] { AUG4, ZonedDateTimeMatchers.isWednesday() } );
                data.add( new Object[] { AUG5, ZonedDateTimeMatchers.isThursday() } );
                data.add( new Object[] { AUG6, ZonedDateTimeMatchers.isFriday() } );
                data.add( new Object[] { AUG7, ZonedDateTimeMatchers.isSaturday() } );
                data.add( new Object[] { AUG8, ZonedDateTimeMatchers.isSunday() } );
                break;

        }
        return data.toArray( new Object[ data.size() ][] );
    }

    //endregion


    //region Date Matchers Tests

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a date is/is not a a specific weekday",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateWeekdays( Date date,
                                       Matcher<Date> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a date is/is not weekday day",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateWeekday( Date date,
                                      Matcher<Date> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates the \"isDayOfWeek\" mismatch error message",
            dataProvider = "date-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isNotDateWeekdaysMismatchMessage( Date date,
                                                  Matcher<Date> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a date is/is not a weekend day",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateWeekend( Date date,
                                      Matcher<Date> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a date is/is not a specific day of week",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateOfWeek( Date date,
                                     Matcher<Date> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    //endregion


    //region LocalDate Matchers Tests

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-date is/is not a specific weekday day",
            dataProvider = "local-date-dp"
    )
    public void isOrIsNotLocalDateWeekdays( LocalDate date,
                                            Matcher<LocalDate> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-date is/is not a weekday day",
            dataProvider = "local-date-dp"
    )
    public void isOrIsNotLocalDateWeekday( LocalDate date,
                                           Matcher<LocalDate> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates the \"isWeekday\" mismatch error message",
            dataProvider = "local-date-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotLocalDateWeekdayMismatchMessage( LocalDate date,
                                                          Matcher<LocalDate> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-date is/is not a weekend day",
            dataProvider = "local-date-dp"
    )
    public void isOrIsNotLocalDateWeekend( LocalDate date,
                                           Matcher<LocalDate> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-date is/is not a specific day of week",
            dataProvider = "date-dp"
    )
    public void isOrIsNotLocalDateOfWeek( LocalDate date,

                                          Matcher<LocalDate> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    //endregion


    //region LocalDateTime Matchers Tests

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a specific weekday day",
            dataProvider = "local-datetime-dp"
    )
    public void isOrIsNotLocalDateTimeWeekdays( LocalDateTime date,
                                                Matcher<LocalDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a weekday day",
            dataProvider = "local-datetime-dp"
    )
    public void isOrIsNotLocalDateTimeWeekday( LocalDateTime date, Matcher<LocalDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a weekend day",
            dataProvider = "local-datetime-dp"
    )
    public void isOrIsNotLocalDateTimeWeekend( LocalDateTime date, Matcher<LocalDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates the \"isWeekend\" mismatch error message",
            dataProvider = "local-datetime-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotLocalDateTimeWeekendMismatchMessage( LocalDateTime date,
                                                              Matcher<LocalDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a specific day of week",
            dataProvider = "date-dp"
    )
    public void isOrIsNotLocalDateTimeOfWeek( LocalDateTime date,
                                              Matcher<LocalDateTime> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }


    //endregion


    //region ZonedDateTime Matchers Tests

    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a zoned-datetime day is/is not a specific weekday day",
            dataProvider = "zoned-datetime-dp"
    )
    public void isOrIsNotZonedDateTimeWeekdays( ZonedDateTime date,
                                                Matcher<ZonedDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a zoned-datetime day is/is not a weekday day",
            dataProvider = "zoned-datetime-dp"
    )
    public void isOrIsNotZonedDateTimeWeekday( ZonedDateTime date,
                                               Matcher<ZonedDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a zoned-datetime day is/is not a weekend day",
            dataProvider = "zoned-datetime-dp"
    )
    public void isOrIsNotZonedDateTimeWeekend( ZonedDateTime date,
                                               Matcher<ZonedDateTime> matcher ) throws Exception
    {
        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a zoned-datetime is/is not a specific day of week",
            dataProvider = "date-dp"
    )
    public void isOrIsNotZonedDateTimeOfWeek( ZonedDateTime date,
                                              Matcher<ZonedDateTime> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates the \"isMonday\", \"isTuesday\", \"isWednesday\", \"isThursday\"" +
                                  "\"isFriday\", \"isSaturday\" and \"isSunday\" mismatch error message",
            dataProvider = "date-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotZonedDateTimeOfWeekMismatchMessage( ZonedDateTime date,
                                                             Matcher<ZonedDateTime> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    //endregion
}
