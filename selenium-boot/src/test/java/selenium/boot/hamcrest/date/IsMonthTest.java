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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.Dates.*;
import static selenium.boot.hamcrest.date.utils.Dates.APR_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.DEC_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.FEB_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.JUL_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.JUN_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.MAR_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.MAY_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.NOV_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.OCT_01_2015_NOON_UTC;
import static selenium.boot.hamcrest.date.utils.Dates.SEP_04_2015_NOON_UTC;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsMonth} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isMonth(java.time.Month)}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isJanuary()}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isFebruary()}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateMatchers#isMonth(java.time.Month)}</li>
 *     <li>{@link selenium.boot.hamcrest.LocalDateTimeMatchers#isMonth(java.time.Month)}</li>
 *     <li>{@link selenium.boot.hamcrest.ZonedDateTimeMatchers#isMonth(java.time.Month)} </li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsMonth
 * @see selenium.boot.hamcrest.DateMatchers#isMonth(java.time.Month)
 * @see selenium.boot.hamcrest.DateMatchers#isJanuary()
 * @see selenium.boot.hamcrest.DateMatchers#isFebruary()
 * @see selenium.boot.hamcrest.DateMatchers#isMarch()
 * @see selenium.boot.hamcrest.DateMatchers#isApril()
 * @see selenium.boot.hamcrest.DateMatchers#isMay()
 * @see selenium.boot.hamcrest.DateMatchers#isJune()
 * @see selenium.boot.hamcrest.DateMatchers#isJuly()
 * @see selenium.boot.hamcrest.DateMatchers#isAugust()
 * @see selenium.boot.hamcrest.DateMatchers#isSeptember()
 * @see selenium.boot.hamcrest.DateMatchers#isOctober()
 * @see selenium.boot.hamcrest.DateMatchers#isNovember()
 * @see selenium.boot.hamcrest.DateMatchers#isDecember()

 * @since 1.0
 */
@SuppressWarnings( "DefaultAnnotationParam" )
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.IsMonth, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01-04. isMonth for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers" +
                              "05-08. isJanuary for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "08-11. isFebruary for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "12-15. isMarch for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "16-19. isApril for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "20-24. isMay for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "25-28. isJune for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "29-32. isJuly for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "33-36. isAugust for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "37-40. isSeptember for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "41-44. isOctober for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "45-48. isNovember for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers\n" +
                              "49-52. isDecember for DateMatchers,LocalDateMatchers,LocalDateTimeMatchers and ZonedDateTimeMatchers"
)
public class IsMonthTest extends AbstractMatcherTest
{
    private static final String ASSERTION_PATTERN =
            ".*Expected: the month (date|local-date|local-datetime|zoned-datetime) is in [A-Za-z]+" +
                    "\\s.*but: the month (date|local-date|local-datetime|zoned-datetime) is in [A-Za-z]+.*";

    //region TestNG Management methods ( @Before, @After, @DataProvider )

    //---------------------------------------------------------------------
    // TestNG Management methods ( @Before, @After, @DataProvider )
    //---------------------------------------------------------------------

    @DataProvider( name = "date-dp" )
    public Object[][] getDates( Method m )
    {
        final Date JAN = JAN_01_2015_NOON_AS_DATE;
        final Date FEB = FEB_01_2012_11AM_AS_DATE;
        final Date MAR = MAR_01_2012_11AM_AS_DATE;
        final Date APR = APR_01_2012_11AM_AS_DATE;
        final Date MAY = MAY_01_2012_11AM_AS_DATE;
        final Date JUN = JUN_01_2012_11AM_AS_DATE;
        final Date JUL = JUL_01_2012_11AM_AS_DATE;
        final Date AUG = AUG_04_2015_NOON_AS_DATE;
        final Date SEP = SEP_01_2012_11AM_AS_DATE;
        final Date OCT = OCT_01_2012_11AM_AS_DATE;
        final Date NOV = NOV_01_2012_11AM_AS_DATE;
        final Date DEC = DEC_01_2012_11AM_AS_DATE;

        List<Object[]> data = Lists.newArrayList();
        switch( m.getName() )
        {
            case "isOrIsNotDateMonth":
                data.add( new Object[] { JAN, DateMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { FEB, DateMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { MAR, DateMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { APR, DateMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { MAY, DateMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { JUN, DateMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUL, DateMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { AUG, DateMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { SEP, DateMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { OCT, DateMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { NOV, DateMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { DEC, DateMatchers.isMonth( Month.DECEMBER ) } );
                data.add( new Object[] { DEC, not( DateMatchers.isMonth( Month.JANUARY ) ) } );
                data.add( new Object[] { JAN, not( DateMatchers.isMonth( Month.FEBRUARY ) ) } );
                data.add( new Object[] { FEB, not( DateMatchers.isMonth( Month.MARCH ) ) } );
                data.add( new Object[] { MAR, not( DateMatchers.isMonth( Month.APRIL ) ) } );
                data.add( new Object[] { APR, not( DateMatchers.isMonth( Month.MAY ) ) } );
                data.add( new Object[] { MAY, not( DateMatchers.isMonth( Month.JUNE ) ) } );
                data.add( new Object[] { JUN, not( DateMatchers.isMonth( Month.JULY ) ) } );
                data.add( new Object[] { JUL, not( DateMatchers.isMonth( Month.AUGUST ) ) } );
                data.add( new Object[] { AUG, not( DateMatchers.isMonth( Month.SEPTEMBER ) ) } );
                data.add( new Object[] { SEP, not( DateMatchers.isMonth( Month.OCTOBER ) ) } );
                data.add( new Object[] { OCT, not( DateMatchers.isMonth( Month.NOVEMBER ) ) } );
                data.add( new Object[] { NOV, not( DateMatchers.isMonth( Month.DECEMBER ) ) } );
                break;
            case "isOrIsNotDateMonthMismatchMessage":
                data.add( new Object[] { DEC, DateMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { JAN, DateMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { FEB, DateMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { MAR, DateMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { APR, DateMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { MAY, DateMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUN, DateMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { JUL, DateMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { AUG, DateMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { SEP, DateMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { OCT, DateMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { NOV, DateMatchers.isMonth( Month.DECEMBER ) } );
                break;
            case "isOrIsNotDateOfMonth":
                data.add( new Object[] { JAN, DateMatchers.isJanuary() } );
                data.add( new Object[] { FEB, DateMatchers.isFebruary() } );
                data.add( new Object[] { MAR, DateMatchers.isMarch() } );
                data.add( new Object[] { APR, DateMatchers.isApril() } );
                data.add( new Object[] { MAY, DateMatchers.isMay() } );
                data.add( new Object[] { JUN, DateMatchers.isJune() } );
                data.add( new Object[] { JUL, DateMatchers.isJuly() } );
                data.add( new Object[] { AUG, DateMatchers.isAugust() } );
                data.add( new Object[] { SEP, DateMatchers.isSeptember() } );
                data.add( new Object[] { OCT, DateMatchers.isOctober() } );
                data.add( new Object[] { NOV, DateMatchers.isNovember() } );
                data.add( new Object[] { DEC, DateMatchers.isDecember() } );
                data.add( new Object[] { DEC, not( DateMatchers.isJanuary() ) } );
                data.add( new Object[] { JAN, not( DateMatchers.isFebruary() ) } );
                data.add( new Object[] { FEB, not( DateMatchers.isMarch() ) } );
                data.add( new Object[] { MAR, not( DateMatchers.isApril() ) } );
                data.add( new Object[] { APR, not( DateMatchers.isMay() ) } );
                data.add( new Object[] { MAY, not( DateMatchers.isJune() ) } );
                data.add( new Object[] { JUN, not( DateMatchers.isJuly() ) } );
                data.add( new Object[] { JUL, not( DateMatchers.isAugust() ) } );
                data.add( new Object[] { AUG, not( DateMatchers.isSeptember() ) } );
                data.add( new Object[] { SEP, not( DateMatchers.isOctober() ) } );
                data.add( new Object[] { OCT, not( DateMatchers.isNovember() ) } );
                data.add( new Object[] { NOV, not( DateMatchers.isDecember() ) } );
                break;
        }

        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "local-date-dp" )
    public Object[][] getLocLDates( Method m )
    {
        final LocalDate JAN = JAN_01_2015;
        final LocalDate FEB = FEB_01_2015;
        final LocalDate MAR = MAR_01_2015;
        final LocalDate APR = APR_01_2015;
        final LocalDate MAY = MAY_01_2015;
        final LocalDate JUN = JUN_01_2015;
        final LocalDate JUL = JUL_01_2015;
        final LocalDate AUG = AUG_01_2015;
        final LocalDate SEP = SEP_04_2015;
        final LocalDate OCT = OCT_01_2015;
        final LocalDate NOV = NOV_01_2015;
        final LocalDate DEC = DEC_01_2015;

        List<Object[]> data = Lists.newArrayList();
        switch( m.getName() )
        {
            case "isOrIsNotLocalDateMonth":
                data.add( new Object[] { JAN, LocalDateMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { FEB, LocalDateMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { MAR, LocalDateMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { APR, LocalDateMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { MAY, LocalDateMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { JUN, LocalDateMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUL, LocalDateMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { AUG, LocalDateMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { SEP, LocalDateMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { OCT, LocalDateMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { NOV, LocalDateMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { DEC, LocalDateMatchers.isMonth( Month.DECEMBER ) } );
                data.add( new Object[] { DEC, not( LocalDateMatchers.isMonth( Month.JANUARY ) ) } );
                data.add( new Object[] { JAN, not( LocalDateMatchers.isMonth( Month.FEBRUARY ) ) } );
                data.add( new Object[] { FEB, not( LocalDateMatchers.isMonth( Month.MARCH ) ) } );
                data.add( new Object[] { MAR, not( LocalDateMatchers.isMonth( Month.APRIL ) ) } );
                data.add( new Object[] { APR, not( LocalDateMatchers.isMonth( Month.MAY ) ) } );
                data.add( new Object[] { MAY, not( LocalDateMatchers.isMonth( Month.JUNE ) ) } );
                data.add( new Object[] { JUN, not( LocalDateMatchers.isMonth( Month.JULY ) ) } );
                data.add( new Object[] { JUL, not( LocalDateMatchers.isMonth( Month.AUGUST ) ) } );
                data.add( new Object[] { AUG, not( LocalDateMatchers.isMonth( Month.SEPTEMBER ) ) } );
                data.add( new Object[] { SEP, not( LocalDateMatchers.isMonth( Month.OCTOBER ) ) } );
                data.add( new Object[] { OCT, not( LocalDateMatchers.isMonth( Month.NOVEMBER ) ) } );
                data.add( new Object[] { NOV, not( LocalDateMatchers.isMonth( Month.DECEMBER ) ) } );
                break;
            case "isOrIsNotLocalDateMonthMismatchMessage":
                data.add( new Object[] { DEC, LocalDateMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { JAN, LocalDateMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { FEB, LocalDateMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { MAR, LocalDateMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { APR, LocalDateMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { MAY, LocalDateMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUN, LocalDateMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { JUL, LocalDateMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { AUG, LocalDateMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { SEP, LocalDateMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { OCT, LocalDateMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { NOV, LocalDateMatchers.isMonth( Month.DECEMBER ) } );
                break;
            case "isOrIsNotLocalDateOfMonth":
                data.add( new Object[] { JAN, LocalDateMatchers.isJanuary() } );
                data.add( new Object[] { FEB, LocalDateMatchers.isFebruary() } );
                data.add( new Object[] { MAR, LocalDateMatchers.isMarch() } );
                data.add( new Object[] { APR, LocalDateMatchers.isApril() } );
                data.add( new Object[] { MAY, LocalDateMatchers.isMay() } );
                data.add( new Object[] { JUN, LocalDateMatchers.isJune() } );
                data.add( new Object[] { JUL, LocalDateMatchers.isJuly() } );
                data.add( new Object[] { AUG, LocalDateMatchers.isAugust() } );
                data.add( new Object[] { SEP, LocalDateMatchers.isSeptember() } );
                data.add( new Object[] { OCT, LocalDateMatchers.isOctober() } );
                data.add( new Object[] { NOV, LocalDateMatchers.isNovember() } );
                data.add( new Object[] { DEC, LocalDateMatchers.isDecember() } );
                data.add( new Object[] { DEC, not( LocalDateMatchers.isJanuary() ) } );
                data.add( new Object[] { JAN, not( LocalDateMatchers.isFebruary() ) } );
                data.add( new Object[] { FEB, not( LocalDateMatchers.isMarch() ) } );
                data.add( new Object[] { MAR, not( LocalDateMatchers.isApril() ) } );
                data.add( new Object[] { APR, not( LocalDateMatchers.isMay() ) } );
                data.add( new Object[] { MAY, not( LocalDateMatchers.isJune() ) } );
                data.add( new Object[] { JUN, not( LocalDateMatchers.isJuly() ) } );
                data.add( new Object[] { JUL, not( LocalDateMatchers.isAugust() ) } );
                data.add( new Object[] { AUG, not( LocalDateMatchers.isSeptember() ) } );
                data.add( new Object[] { SEP, not( LocalDateMatchers.isOctober() ) } );
                data.add( new Object[] { OCT, not( LocalDateMatchers.isNovember() ) } );
                data.add( new Object[] { NOV, not( LocalDateMatchers.isDecember() ) } );
                break;
        }

        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "local-datetime-dp" )
    public Object[][] getLocalDateTimes( Method m )
    {
        final LocalDateTime JAN = JAN_01_2015_NOON;
        final LocalDateTime FEB = FEB_01_2015_NOON;;
        final LocalDateTime MAR = MAR_01_2015_NOON;
        final LocalDateTime APR = APR_01_2015_NOON;
        final LocalDateTime MAY = MAY_01_2015_NOON;
        final LocalDateTime JUN = JUN_01_2015_NOON;
        final LocalDateTime JUL = JUL_01_2015_NOON;
        final LocalDateTime AUG = AUG_01_2015_NOON;
        final LocalDateTime SEP = SEP_04_2015_NOON;
        final LocalDateTime OCT = OCT_01_2015_NOON;
        final LocalDateTime NOV = NOV_01_2015_NOON;
        final LocalDateTime DEC = DEC_01_2015_NOON;

        List<Object[]> data = Lists.newArrayList();
        switch( m.getName() )
        {
            case "isOrIsNotLocalDateTimeMonth":
                data.add( new Object[] { JAN, LocalDateTimeMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { FEB, LocalDateTimeMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { MAR, LocalDateTimeMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { APR, LocalDateTimeMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { MAY, LocalDateTimeMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { JUN, LocalDateTimeMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUL, LocalDateTimeMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { AUG, LocalDateTimeMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { SEP, LocalDateTimeMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { OCT, LocalDateTimeMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { NOV, LocalDateTimeMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { DEC, LocalDateTimeMatchers.isMonth( Month.DECEMBER ) } );
                data.add( new Object[] { DEC, not( LocalDateTimeMatchers.isMonth( Month.JANUARY ) ) } );
                data.add( new Object[] { JAN, not( LocalDateTimeMatchers.isMonth( Month.FEBRUARY ) ) } );
                data.add( new Object[] { FEB, not( LocalDateTimeMatchers.isMonth( Month.MARCH ) ) } );
                data.add( new Object[] { MAR, not( LocalDateTimeMatchers.isMonth( Month.APRIL ) ) } );
                data.add( new Object[] { APR, not( LocalDateTimeMatchers.isMonth( Month.MAY ) ) } );
                data.add( new Object[] { MAY, not( LocalDateTimeMatchers.isMonth( Month.JUNE ) ) } );
                data.add( new Object[] { JUN, not( LocalDateTimeMatchers.isMonth( Month.JULY ) ) } );
                data.add( new Object[] { JUL, not( LocalDateTimeMatchers.isMonth( Month.AUGUST ) ) } );
                data.add( new Object[] { AUG, not( LocalDateTimeMatchers.isMonth( Month.SEPTEMBER ) ) } );
                data.add( new Object[] { SEP, not( LocalDateTimeMatchers.isMonth( Month.OCTOBER ) ) } );
                data.add( new Object[] { OCT, not( LocalDateTimeMatchers.isMonth( Month.NOVEMBER ) ) } );
                data.add( new Object[] { NOV, not( LocalDateTimeMatchers.isMonth( Month.DECEMBER ) ) } );
                break;
            case "isOrIsNotLocalDateTimeMonthMismatchMessage":
                data.add( new Object[] { DEC, LocalDateTimeMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { JAN, LocalDateTimeMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { FEB, LocalDateTimeMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { MAR, LocalDateTimeMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { APR, LocalDateTimeMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { MAY, LocalDateTimeMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUN, LocalDateTimeMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { JUL, LocalDateTimeMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { AUG, LocalDateTimeMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { SEP, LocalDateTimeMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { OCT, LocalDateTimeMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { NOV, LocalDateTimeMatchers.isMonth( Month.DECEMBER ) } );
                break;
            case "isOrIsNotLocalDateTimeOfMonth":
                data.add( new Object[] { JAN, LocalDateTimeMatchers.isJanuary() } );
                data.add( new Object[] { FEB, LocalDateTimeMatchers.isFebruary() } );
                data.add( new Object[] { MAR, LocalDateTimeMatchers.isMarch() } );
                data.add( new Object[] { APR, LocalDateTimeMatchers.isApril() } );
                data.add( new Object[] { MAY, LocalDateTimeMatchers.isMay() } );
                data.add( new Object[] { JUN, LocalDateTimeMatchers.isJune() } );
                data.add( new Object[] { JUL, LocalDateTimeMatchers.isJuly() } );
                data.add( new Object[] { AUG, LocalDateTimeMatchers.isAugust() } );
                data.add( new Object[] { SEP, LocalDateTimeMatchers.isSeptember() } );
                data.add( new Object[] { OCT, LocalDateTimeMatchers.isOctober() } );
                data.add( new Object[] { NOV, LocalDateTimeMatchers.isNovember() } );
                data.add( new Object[] { DEC, LocalDateTimeMatchers.isDecember() } );
                data.add( new Object[] { DEC, not( LocalDateTimeMatchers.isJanuary() ) } );
                data.add( new Object[] { JAN, not( LocalDateTimeMatchers.isFebruary() ) } );
                data.add( new Object[] { FEB, not( LocalDateTimeMatchers.isMarch() ) } );
                data.add( new Object[] { MAR, not( LocalDateTimeMatchers.isApril() ) } );
                data.add( new Object[] { APR, not( LocalDateTimeMatchers.isMay() ) } );
                data.add( new Object[] { MAY, not( LocalDateTimeMatchers.isJune() ) } );
                data.add( new Object[] { JUN, not( LocalDateTimeMatchers.isJuly() ) } );
                data.add( new Object[] { JUL, not( LocalDateTimeMatchers.isAugust() ) } );
                data.add( new Object[] { AUG, not( LocalDateTimeMatchers.isSeptember() ) } );
                data.add( new Object[] { SEP, not( LocalDateTimeMatchers.isOctober() ) } );
                data.add( new Object[] { OCT, not( LocalDateTimeMatchers.isNovember() ) } );
                data.add( new Object[] { NOV, not( LocalDateTimeMatchers.isDecember() ) } );
                break;
        }

        return data.toArray( new Object[ data.size() ][] );
    }

    @DataProvider( name = "zoned-datetime-dp" )
    public Object[][] getZonedDateTimes( Method m )
    {
        final ZonedDateTime JAN = JAN_01_2015_NOON_UTC;
        final ZonedDateTime FEB = FEB_01_2015_NOON_UTC;
        final ZonedDateTime MAR = MAR_01_2015_NOON_UTC;
        final ZonedDateTime APR = APR_01_2015_NOON_UTC;
        final ZonedDateTime MAY = MAY_01_2015_NOON_UTC;
        final ZonedDateTime JUN = JUN_01_2015_NOON_UTC;
        final ZonedDateTime JUL = JUL_01_2015_NOON_UTC;
        final ZonedDateTime AUG = AUG_04_2015_NOON_UTC;
        final ZonedDateTime SEP = SEP_04_2015_NOON_UTC;
        final ZonedDateTime OCT = OCT_01_2015_NOON_UTC;
        final ZonedDateTime NOV = NOV_01_2015_NOON_UTC;
        final ZonedDateTime DEC = DEC_01_2015_NOON_UTC;

        List<Object[]> data = Lists.newArrayList();
        switch( m.getName() )
        {
            case "isOrIsNotZonedDateTimeMonth":
                data.add( new Object[] { JAN, ZonedDateTimeMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { FEB, ZonedDateTimeMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { MAR, ZonedDateTimeMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { APR, ZonedDateTimeMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { MAY, ZonedDateTimeMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { JUN, ZonedDateTimeMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUL, ZonedDateTimeMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { AUG, ZonedDateTimeMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { SEP, ZonedDateTimeMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { OCT, ZonedDateTimeMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { NOV, ZonedDateTimeMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { DEC, ZonedDateTimeMatchers.isMonth( Month.DECEMBER ) } );
                data.add( new Object[] { DEC, not( ZonedDateTimeMatchers.isMonth( Month.JANUARY ) ) } );
                data.add( new Object[] { JAN, not( ZonedDateTimeMatchers.isMonth( Month.FEBRUARY ) ) } );
                data.add( new Object[] { FEB, not( ZonedDateTimeMatchers.isMonth( Month.MARCH ) ) } );
                data.add( new Object[] { MAR, not( ZonedDateTimeMatchers.isMonth( Month.APRIL ) ) } );
                data.add( new Object[] { APR, not( ZonedDateTimeMatchers.isMonth( Month.MAY ) ) } );
                data.add( new Object[] { MAY, not( ZonedDateTimeMatchers.isMonth( Month.JUNE ) ) } );
                data.add( new Object[] { JUN, not( ZonedDateTimeMatchers.isMonth( Month.JULY ) ) } );
                data.add( new Object[] { JUL, not( ZonedDateTimeMatchers.isMonth( Month.AUGUST ) ) } );
                data.add( new Object[] { AUG, not( ZonedDateTimeMatchers.isMonth( Month.SEPTEMBER ) ) } );
                data.add( new Object[] { SEP, not( ZonedDateTimeMatchers.isMonth( Month.OCTOBER ) ) } );
                data.add( new Object[] { OCT, not( ZonedDateTimeMatchers.isMonth( Month.NOVEMBER ) ) } );
                data.add( new Object[] { NOV, not( ZonedDateTimeMatchers.isMonth( Month.DECEMBER ) ) } );
                break;
            case "isOrIsNotZonedDateTimeMonthMismatchMessage":
                data.add( new Object[] { DEC, ZonedDateTimeMatchers.isMonth( Month.JANUARY ) } );
                data.add( new Object[] { JAN, ZonedDateTimeMatchers.isMonth( Month.FEBRUARY ) } );
                data.add( new Object[] { FEB, ZonedDateTimeMatchers.isMonth( Month.MARCH ) } );
                data.add( new Object[] { MAR, ZonedDateTimeMatchers.isMonth( Month.APRIL ) } );
                data.add( new Object[] { APR, ZonedDateTimeMatchers.isMonth( Month.MAY ) } );
                data.add( new Object[] { MAY, ZonedDateTimeMatchers.isMonth( Month.JUNE ) } );
                data.add( new Object[] { JUN, ZonedDateTimeMatchers.isMonth( Month.JULY ) } );
                data.add( new Object[] { JUL, ZonedDateTimeMatchers.isMonth( Month.AUGUST ) } );
                data.add( new Object[] { AUG, ZonedDateTimeMatchers.isMonth( Month.SEPTEMBER ) } );
                data.add( new Object[] { SEP, ZonedDateTimeMatchers.isMonth( Month.OCTOBER ) } );
                data.add( new Object[] { OCT, ZonedDateTimeMatchers.isMonth( Month.NOVEMBER ) } );
                data.add( new Object[] { NOV, ZonedDateTimeMatchers.isMonth( Month.DECEMBER ) } );
                break;
            case "isOrIsNotZonedDateTimeOfMonth":
                data.add( new Object[] { JAN, ZonedDateTimeMatchers.isJanuary() } );
                data.add( new Object[] { FEB, ZonedDateTimeMatchers.isFebruary() } );
                data.add( new Object[] { MAR, ZonedDateTimeMatchers.isMarch() } );
                data.add( new Object[] { APR, ZonedDateTimeMatchers.isApril() } );
                data.add( new Object[] { MAY, ZonedDateTimeMatchers.isMay() } );
                data.add( new Object[] { JUN, ZonedDateTimeMatchers.isJune() } );
                data.add( new Object[] { JUL, ZonedDateTimeMatchers.isJuly() } );
                data.add( new Object[] { AUG, ZonedDateTimeMatchers.isAugust() } );
                data.add( new Object[] { SEP, ZonedDateTimeMatchers.isSeptember() } );
                data.add( new Object[] { OCT, ZonedDateTimeMatchers.isOctober() } );
                data.add( new Object[] { NOV, ZonedDateTimeMatchers.isNovember() } );
                data.add( new Object[] { DEC, ZonedDateTimeMatchers.isDecember() } );
                data.add( new Object[] { DEC, not( ZonedDateTimeMatchers.isJanuary() ) } );
                data.add( new Object[] { JAN, not( ZonedDateTimeMatchers.isFebruary() ) } );
                data.add( new Object[] { FEB, not( ZonedDateTimeMatchers.isMarch() ) } );
                data.add( new Object[] { MAR, not( ZonedDateTimeMatchers.isApril() ) } );
                data.add( new Object[] { APR, not( ZonedDateTimeMatchers.isMay() ) } );
                data.add( new Object[] { MAY, not( ZonedDateTimeMatchers.isJune() ) } );
                data.add( new Object[] { JUN, not( ZonedDateTimeMatchers.isJuly() ) } );
                data.add( new Object[] { JUL, not( ZonedDateTimeMatchers.isAugust() ) } );
                data.add( new Object[] { AUG, not( ZonedDateTimeMatchers.isSeptember() ) } );
                data.add( new Object[] { SEP, not( ZonedDateTimeMatchers.isOctober() ) } );
                data.add( new Object[] { OCT, not( ZonedDateTimeMatchers.isNovember() ) } );
                data.add( new Object[] { NOV, not( ZonedDateTimeMatchers.isDecember() ) } );
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
            description = "Validates that a date is/is not a a specific month",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateMonth( Date date,
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
            description = "Validates that a date is/is not a a specific month",
            dataProvider = "date-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotDateMonthMismatchMessage( Date date,
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
            description = "Validates that a date is/is not a a specific day of month",
            dataProvider = "date-dp"
    )
    public void isOrIsNotDateOfMonth( Date date,
                                      Matcher<Date> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-date is/is not a a specific month",
            dataProvider = "local-date-dp"
    )
    public void isOrIsNotLocalDateMonth( LocalDate date,
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
            description = "Validates that a local-date is/is not a a specific month",
            dataProvider = "local-date-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotLocalDateMonthMismatchMessage( LocalDate date,
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
            description = "Validates that a local-date is/is not a a specific day of month",
            dataProvider = "local-date-dp"
    )
    public void isOrIsNotLocalDateOfMonth( LocalDate date,
                                           Matcher<LocalDate> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a a specific month",
            dataProvider = "local-datetime-dp"
    )
    public void isOrIsNotLocalDateTimeMonth( LocalDateTime date,
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
            description = "Validates that a local-datetime is/is not a a specific month",
            dataProvider = "local-datetime-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotLocalDateTimeMonthMismatchMessage( LocalDateTime date,
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
            enabled = true
            ,
            skipFailedInvocations = false,
            description = "Validates that a local-datetime is/is not a a specific day of month",
            dataProvider = "local-datetime-dp"
    )
    public void isOrIsNotLocalDateTimeOfMonth( LocalDateTime date,
                                               Matcher<LocalDateTime> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }


    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    @Test(
            enabled = true,
            skipFailedInvocations = false,
            description = "Validates that a zoned-datetime is/is not a a specific month",
            dataProvider = "zoned-datetime-dp"
    )
    public void isOrIsNotZonedDateTimeMonth( ZonedDateTime date,
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
            description = "Validates that a zoned-datetime is/is not a a specific month",
            dataProvider = "zoned-datetime-dp",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isOrIsNotZonedDateTimeMonthMismatchMessage( ZonedDateTime date,
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
            description = "Validates that a zoned-datetime is/is not a a specific day of month",
            dataProvider = "zoned-datetime-dp"
    )
    public void isOrIsNotZonedDateTimeOfMonth( ZonedDateTime date,
                                               Matcher<ZonedDateTime> matcher ) throws Exception
    {

        if( Reporter.getCurrentTestResult().getMethod().getCurrentInvocationCount() == 0 )
        {
            describeTestCase();
        }
        String desc = Assertion.getDescription( matcher );
        Assertion.assertThat( date, matcher, StringUtils.quote( date.toString() ) + " matches " + desc );
    }
}
