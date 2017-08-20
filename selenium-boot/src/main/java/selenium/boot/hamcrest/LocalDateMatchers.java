package selenium.boot.hamcrest;


import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import selenium.boot.hamcrest.matchers.date.*;
import selenium.boot.hamcrest.matchers.date.format.DatePartFormatter;
import selenium.boot.hamcrest.matchers.date.format.LocalDateFormatter;
import selenium.boot.hamcrest.matchers.date.wrapper.LocalDateWrapper;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;
import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.JUNE;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;



/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link java.time.LocalDate} instances
 *
 * @author Stewart Bissett
 */
public abstract class LocalDateMatchers
{

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, localDateAfter(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static Matcher<LocalDate> after( final int year,
                                            final Month month,
                                            final int dayOfMonth )
    {
        return after( LocalDate.of( year, month, dayOfMonth ) );
    }


    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, after(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> after( final LocalDate date )
    {
        return new IsAfter<>( new LocalDateWrapper( date ),
                              new LocalDateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, localDateBefore(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static Matcher<LocalDate> before( final int year,
                                             final Month month,
                                             final int dayOfMonth )
    {
        return before( LocalDate.of( year, month, dayOfMonth ) );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, before(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> before( final LocalDate date )
    {
        return new IsBefore<>( new LocalDateWrapper( date ),
                               new LocalDateFormatter()
        );
    }



    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isDay(2012, Month.JAN, 1))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month      the reference month against which the examined date is checked
     * @param year       the reference year against which the examined date is checked
     */
    public static Matcher<LocalDate> isDay( final int year,
                                            final Month month,
                                            final int dayOfMonth )
    {
        return sameDay( LocalDate.of( year, month, dayOfMonth ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDay(LocalDate.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameDay( final LocalDate date )
    {
        return new IsSameDay<>( new LocalDateWrapper( date ),
                                new LocalDateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSameOrBefore(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year  the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day   the day of the month against which the examined date is checked
     */
    @Factory
    public static Matcher<LocalDate> sameOrBefore( final int year,
                                                   final Month month,
                                                   final int day )
    {
        return sameOrBefore( LocalDate.of( year, month, day ) );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSameOrBefore(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameOrBefore( final LocalDate date )
    {
        return new IsSameOrBefore<>( new LocalDateWrapper( date ),
                                     new LocalDateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSameOrAfter(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year  the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day   the day of the month against which the examined date is checked
     */
    public static Matcher<LocalDate> sameOrAfter( final int year,
                                                  final Month month,
                                                  final int day )
    {
        return sameOrAfter( LocalDate.of( year, month, day ) );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSameOrAfter(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameOrAfter( final LocalDate date )
    {
        return new IsSameOrAfter<>( new LocalDateWrapper( date ),
                                    new LocalDateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMonth(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameMonthOfYear( final LocalDate date )
    {
        return isMonth( date.getMonth() );
    }

    /**
     * Creates a matcher that matches when the examined date is in the expected month
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMonth(Month.AUGUST));
     * </pre>
     */
    public static Matcher<LocalDate> isMonth( final Month month )
    {
        return new IsMonth<>( month, t -> t );
    }


    /**
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameYear(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameYear( final LocalDate date )
    {
        return isYear( date.getYear() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same year as the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameYear(2013))
     * </pre>
     *
     * @param year the reference year against which the examined date is checked
     */
    public static Matcher<LocalDate> isYear( final int year )
    {
        return new IsYear<>( year, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is within a given period of the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, within(5, TimeUnit.DAYS, 2012, Months.MAY, 12));
     * </pre>
     *
     * @param period     the timeunit interval the examined date should be with
     * @param unit       the timeunit to define the length of the period
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayofMonth the day of the month against which the examined date is checked
     */
    public static Matcher<LocalDate> within( final long period,
                                             final ChronoUnit unit,
                                             final int year,
                                             final Month month,
                                             final int dayofMonth )
    {
        return within( period, unit, LocalDate.of( year, month, dayofMonth ) );
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, within(10, TimeUnit.DAYS, Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> within( final long period, final ChronoUnit unit, final LocalDate date )
    {
        return new IsWithin<>( period, unit, new LocalDateWrapper( date ), new LocalDateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDayOfMonth(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameDayOfMonth( final LocalDateTime date )
    {
        return isDayOfMonth( date.getDayOfMonth() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected day of the month
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isDayOfMonth(4))
     * </pre>
     *
     * @param dayOfMonth the expected day of the month
     */
    public static Matcher<LocalDate> isDayOfMonth( final int dayOfMonth )
    {
        return new IsDayOfMonth<>( dayOfMonth, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is yesterday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isToday());
     * </pre>
     */
    public static Matcher<LocalDate> isYesterday()
    {
        return sameDay( LocalDate.now().plusDays( -1 ) );
    }

    /**
     * Creates a matcher that matches when the examined date is today
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isToday());
     * </pre>
     */
    public static Matcher<LocalDate> isToday()
    {
        return sameDay( LocalDate.now() );
    }

    /**
     * Creates a matcher that matches when the examined date is tomorrow
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isTomorrow());
     * </pre>
     */
    public static Matcher<LocalDate> isTomorrow()
    {
        return sameDay( LocalDate.now().plusDays( 1 ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDayOfWeek(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<LocalDate> sameDayOfWeek( final LocalDate date )
    {
        return isDayOfWeek( DayOfWeek.from( date ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on a monday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static Matcher<LocalDate> isDayOfWeek( final DayOfWeek... dayOfWeek )
    {
        return new IsDayOfWeek<>( Arrays.asList( dayOfWeek ), t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is on a monday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMonday());
     * </pre>
     */
    public static Matcher<LocalDate> isMonday()
    {
        return isDayOfWeek( MONDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a tuesday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isTuesday());
     * </pre>
     */
    public static Matcher<LocalDate> isTuesday()
    {
        return isDayOfWeek( TUESDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a wednesday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isWednesday());
     * </pre>
     */
    public static Matcher<LocalDate> isWednesday()
    {
        return isDayOfWeek( WEDNESDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a thursday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isThursday());
     * </pre>
     */
    public static Matcher<LocalDate> isThursday()
    {
        return isDayOfWeek( THURSDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a friday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isFriday());
     * </pre>
     */
    public static Matcher<LocalDate> isFriday()
    {
        return isDayOfWeek( FRIDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a saturday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSaturday());
     * </pre>
     */
    public static Matcher<LocalDate> isSaturday()
    {
        return isDayOfWeek( SATURDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a sunday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSunday());
     * </pre>
     */
    public static Matcher<LocalDate> isSunday()
    {
        return isDayOfWeek( SUNDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a weekday
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isWeekday());
     * </pre>
     */
    public static Matcher<LocalDate> isWeekday()
    {
        return isDayOfWeek( MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on a weekend
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isWeekend());
     * </pre>
     */
    public static Matcher<LocalDate> isWeekend()
    {
        return isDayOfWeek( SATURDAY, SUNDAY );
    }

    /**
     * Creates a matcher that matches when the examined date is on the first day of the month
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isFirstDayOfMonth());
     * </pre>
     */
    public static Matcher<LocalDate> isFirstDayOfMonth()
    {
        return new IsMinimum<>( ChronoField.DAY_OF_MONTH, t -> t,
                                new DatePartFormatter(),
                                () -> "the date is the first day of the month"
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMaximumDayOfMonth(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static Matcher<LocalDate> isMinimum( final ChronoField field )
    {
        return new IsMinimum<>( field, t -> t, new DatePartFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the first day of the month
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isFirstDayOfMonth());
     * </pre>
     */
    public static Matcher<LocalDate> isLastDayOfMonth()
    {
        return new IsMaximum<>( ChronoField.DAY_OF_MONTH, t -> t,
                                new DatePartFormatter(),
                                () -> "the date is the last day of the month"
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its
     * period
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static Matcher<LocalDate> isMaximum( final ChronoField field )
    {
        return new IsMaximum<>( field, t -> t, new DatePartFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is in January
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isJanuary());
     * </pre>
     */
    public static Matcher<LocalDate> isJanuary()
    {
        return isMonth( JANUARY );
    }

    /**
     * Creates a matcher that matches when the examined date is in February
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isFebruary());
     * </pre>
     */
    public static Matcher<LocalDate> isFebruary()
    {
        return isMonth( FEBRUARY );
    }

    /**
     * Creates a matcher that matches when the examined date is in March
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMarch());
     * </pre>
     */
    public static Matcher<LocalDate> isMarch()
    {
        return isMonth( MARCH );
    }

    /**
     * Creates a matcher that matches when the examined date is in April
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isApril());
     * </pre>
     */
    public static Matcher<LocalDate> isApril()
    {
        return isMonth( APRIL );
    }

    /**
     * Creates a matcher that matches when the examined date is in May
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMay());
     * </pre>
     */
    public static Matcher<LocalDate> isMay()
    {
        return isMonth( MAY );
    }

    /**
     * Creates a matcher that matches when the examined date is in June
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isJune());
     * </pre>
     */
    public static Matcher<LocalDate> isJune()
    {
        return isMonth( JUNE );
    }

    /**
     * Creates a matcher that matches when the examined date is in July
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isJuly());
     * </pre>
     */
    public static Matcher<LocalDate> isJuly()
    {
        return isMonth( JULY );
    }

    /**
     * Creates a matcher that matches when the examined date is in August
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isAugust());
     * </pre>
     */
    public static Matcher<LocalDate> isAugust()
    {
        return isMonth( AUGUST );
    }

    /**
     * Creates a matcher that matches when the examined date is in September
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSeptember());
     * </pre>
     */
    public static Matcher<LocalDate> isSeptember()
    {
        return isMonth( SEPTEMBER );
    }

    /**
     * Creates a matcher that matches when the examined date is in October
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isOctober());
     * </pre>
     */
    public static Matcher<LocalDate> isOctober()
    {
        return isMonth( OCTOBER );
    }

    /**
     * Creates a matcher that matches when the examined date is in November
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isNovember());
     * </pre>
     */
    public static Matcher<LocalDate> isNovember()
    {
        return isMonth( NOVEMBER );
    }

    /**
     * Creates a matcher that matches when the examined date is in December
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isDecember());
     * </pre>
     */
    public static Matcher<LocalDate> isDecember()
    {
        return isMonth( DECEMBER );
    }

    /**
     * Creates a matcher that matches when the examined date is a leap year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isLeapYear());
     * </pre>
     */
    public static Matcher<LocalDate> isLeapYear()
    {
        return new IsLeapYear<>( t -> t, new LocalDateFormatter() );
    }
}
