package selenium.boot.hamcrest;


import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import selenium.boot.hamcrest.matchers.date.*;
import selenium.boot.hamcrest.matchers.date.format.DatePartFormatter;
import selenium.boot.hamcrest.matchers.date.format.ZonedDateTimeFormatter;
import selenium.boot.hamcrest.matchers.date.wrapper.ZonedDateTimeWrapper;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

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
import static java.util.Arrays.asList;



/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link java.time.ZonedDateTime} instances
 *
 * @author Stewart Bissett
 */
public abstract class ZonedDateTimeMatchers
{

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, after(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> after( final ZonedDateTime date )
    {
        return new IsAfter<>( new ZonedDateTimeWrapper( date ),
                              new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, after(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day
     * @param minute     the minute of the hour
     * @param second     the second of the minute
     * @param nanos      the nanos of the second
     */
    public static Matcher<ZonedDateTime> after( final int year,
                                                final Month month,
                                                final int dayOfMonth,
                                                final int hour,
                                                final int minute,
                                                final int second,
                                                final int nanos,
                                                final ZoneId tz )
    {
        return new IsAfter<>( new ZonedDateTimeWrapper( year,
                                                        month,
                                                        dayOfMonth,
                                                        hour,
                                                        minute,
                                                        second,
                                                        nanos,
                                                        tz
        ), new ZonedDateTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, before(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> before( final ZonedDateTime date )
    {
        return new IsBefore<>( new ZonedDateTimeWrapper( date ),
                               new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is before the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myDate, before(2012, Month.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day
     * @param minute     the minute of the hour
     * @param second     the second of the minute
     * @param nanos      the nanoseconds of the second
     */
    public static Matcher<ZonedDateTime> before( final int year,
                                                 final Month month,
                                                 final int dayOfMonth,
                                                 final int hour,
                                                 final int minute,
                                                 final int second,
                                                 final int nanos,
                                                 final ZoneId tz )
    {
        return new IsBefore<>( new ZonedDateTimeWrapper( year,
                                                         month,
                                                         dayOfMonth,
                                                         hour,
                                                         minute,
                                                         second,
                                                         nanos,
                                                         tz
        ), new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDay(2012, Month.JAN, 1, ZoneId.systemDefault()))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month      the reference month against which the examined date is checked
     * @param year       the reference year against which the examined date is checked
     * @param tz         the reference time zone
     */
    public static Matcher<ZonedDateTime> isDay( final int year,
                                                final Month month,
                                                final int dayOfMonth,
                                                final ZoneId tz )
    {
        return new IsSameDay<>( new ZonedDateTimeWrapper( year,
                                                          month,
                                                          dayOfMonth,
                                                          tz
        ), new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameInstant(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameInstant( final ZonedDateTime date )
    {
        return new IsSame<>( new ZonedDateTimeWrapper( date ),
                             new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same specified instance down to the second
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameInstant(2012, Month.JAN, 1, 3, 15, 0))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month      the reference month against which the examined date is checked
     * @param year       the reference year against which the examined date is checked
     * @param hour       the hour of the day
     * @param minute     the minute of the hour
     * @param second     the second of the minute
     * @param nanos      the nanosecond of the second
     * @param tz         the timezone
     */
    public static Matcher<ZonedDateTime> isInstant( final int year,
                                                    final Month month,
                                                    final int dayOfMonth,
                                                    final int hour,
                                                    final int minute,
                                                    final int second,
                                                    final int nanos,
                                                    final ZoneId tz )
    {
        return new IsSame<>( new ZonedDateTimeWrapper( year,
                                                       month,
                                                       dayOfMonth,
                                                       hour,
                                                       minute,
                                                       second,
                                                       nanos,
                                                       tz ),
                             new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameOrBefore( final ZonedDateTime date )
    {
        return new IsSameOrBefore<>( new ZonedDateTimeWrapper( date ), new ZonedDateTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 11, 59, 59, ZoneId.systemDefault()));
     * </pre>
     *
     * @param year   the year against which the examined date is checked
     * @param month  the month against which the examined date is checked
     * @param day    the day of the month against which the examined date is checked
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos  the nanosecond of the second
     * @param tz     the time zone of the date to check against
     */
    @Factory
    public static Matcher<ZonedDateTime> sameOrBefore( final int year,
                                                       final Month month,
                                                       final int day,
                                                       final int hour,
                                                       final int minute,
                                                       final int second,
                                                       final int nanos,
                                                       final ZoneId tz )
    {
        return new IsSameOrBefore<>( new ZonedDateTimeWrapper( year,
                                                               month,
                                                               day,
                                                               hour,
                                                               minute,
                                                               second,
                                                               nanos,
                                                               tz
        ),
                                     new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameOrAfter( final ZonedDateTime date )
    {
        return new IsSameOrAfter<>( new ZonedDateTimeWrapper( date ),
                                    new ZonedDateTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 11, 59, 59, ZoneId.systemDefault()));
     * </pre>
     *
     * @param year   the year against which the examined date is checked
     * @param month  the month against which the examined date is checked
     * @param day    the day of the month against which the examined date is checked
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     * @param nanos  the nanosecond of the second
     * @param tz     the time zone of the date to check against
     */
    @Factory
    public static Matcher<ZonedDateTime> sameOrAfter( final int year,
                                                      final Month month,
                                                      final int day,
                                                      final int hour,
                                                      final int minute,
                                                      final int second,
                                                      final int nanos,
                                                      final ZoneId tz )
    {
        return new IsSameOrAfter<>( new ZonedDateTimeWrapper( year,
                                                              month,
                                                              day,
                                                              hour,
                                                              minute,
                                                              second,
                                                              nanos,
                                                              tz
        ), new ZonedDateTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same month as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMonth(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameMonthOfYear( final ZonedDateTime date )
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
    public static Matcher<ZonedDateTime> isMonth( final Month month )
    {
        return new IsMonth<>( month, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the month as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDayOfMonth(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameDayOfMonth( final ZonedDateTime date )
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
    public static Matcher<ZonedDateTime> isDayOfMonth( final int dayOfMonth )
    {
        return new IsDayOfMonth<>( dayOfMonth, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameYear(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameYear( final ZonedDateTime date )
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
    public static Matcher<ZonedDateTime> isYear( final int year )
    {
        return new IsYear<>( year, t -> t );
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
    public static Matcher<ZonedDateTime> within( final long period,
                                                 final ChronoUnit unit,
                                                 final ZonedDateTime date )
    {
        return new IsWithin<>( period,
                               unit,
                               new ZonedDateTimeWrapper( date ),
                               new ZonedDateTimeFormatter()
        );
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
     * @param period     the time-unit interval the examined date should be with
     * @param unit       the time-unit to define the length of the period
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day
     * @param minute     the minute of the hour
     * @param second     the second of the minute
     * @param nanos      the nanon-seconds of the second
     * @param tz         the time zone of the reference date
     */
    public static Matcher<ZonedDateTime> within( final long period,
                                                 final ChronoUnit unit,
                                                 final int year,
                                                 final Month month,
                                                 final int dayOfMonth,
                                                 final int hour,
                                                 final int minute,
                                                 final int second,
                                                 final int nanos,
                                                 final ZoneId tz )
    {
        return new IsWithin<>( period,
                               unit,
                               new ZonedDateTimeWrapper( year,
                                                         month,
                                                         dayOfMonth,
                                                         hour,
                                                         minute,
                                                         second,
                                                         nanos,
                                                         tz
                               ), new ZonedDateTimeFormatter()
        );
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
    public static Matcher<ZonedDateTime> isYesterday()
    {
        return sameDay( ZonedDateTime.now().plusDays( -1 ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDay(ZonedDateTime.now()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameDay( final ZonedDateTime date )
    {
        return new IsSameDay<>( new ZonedDateTimeWrapper( date ),
                                new ZonedDateTimeFormatter()
        );
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
    public static Matcher<ZonedDateTime> isToday()
    {
        return sameDay( ZonedDateTime.now() );
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
    public static Matcher<ZonedDateTime> isTomorrow()
    {
        return sameDay( ZonedDateTime.now().plusDays( 1 ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDayOfWeek(LocalDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameDayOfWeek( final ZonedDateTime date )
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
    public static Matcher<ZonedDateTime> isDayOfWeek( final DayOfWeek... dayOfWeek )
    {
        return new IsDayOfWeek<>( asList( dayOfWeek ), t -> t );
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
    public static Matcher<ZonedDateTime> isMonday()
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
    public static Matcher<ZonedDateTime> isTuesday()
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
    public static Matcher<ZonedDateTime> isWednesday()
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
    public static Matcher<ZonedDateTime> isThursday()
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
    public static Matcher<ZonedDateTime> isFriday()
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
    public static Matcher<ZonedDateTime> isSaturday()
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
    public static Matcher<ZonedDateTime> isSunday()
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
    public static Matcher<ZonedDateTime> isWeekday()
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
    public static Matcher<ZonedDateTime> isWeekend()
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
    public static Matcher<ZonedDateTime> isFirstDayOfMonth()
    {
        return new IsMinimum<>( ChronoField.DAY_OF_MONTH,
                                t -> t,
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
    public static Matcher<ZonedDateTime> isMinimum( final ChronoField field )
    {
        return new IsMinimum<>( field,
                                t -> t,
                                new DatePartFormatter()
        );
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
    public static Matcher<ZonedDateTime> isLastDayOfMonth()
    {
        return new IsMaximum<>( ChronoField.DAY_OF_MONTH,
                                t -> t,
                                new DatePartFormatter(),
                                () -> "the date is the last day of the month"
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the maximum value of the given date part in its period
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMaximum(ChronoField.DAY_OF_MONTH));
     * </pre>
     *
     * @param field the temporal field to check
     */
    public static Matcher<ZonedDateTime> isMaximum( final ChronoField field )
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
    public static Matcher<ZonedDateTime> isJanuary()
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
    public static Matcher<ZonedDateTime> isFebruary()
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
    public static Matcher<ZonedDateTime> isMarch()
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
    public static Matcher<ZonedDateTime> isApril()
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
    public static Matcher<ZonedDateTime> isMay()
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
    public static Matcher<ZonedDateTime> isJune()
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
    public static Matcher<ZonedDateTime> isJuly()
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
    public static Matcher<ZonedDateTime> isAugust()
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
    public static Matcher<ZonedDateTime> isSeptember()
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
    public static Matcher<ZonedDateTime> isOctober()
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
    public static Matcher<ZonedDateTime> isNovember()
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
    public static Matcher<ZonedDateTime> isDecember()
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
    public static Matcher<ZonedDateTime> isLeapYear()
    {
        return new IsLeapYear<>( t -> t, new ZonedDateTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameHourOfDay(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameHourOfDay( final ZonedDateTime date )
    {
        return isHour( date.getHour() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected hour (0-23)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isHour(12));
     * </pre>
     *
     * @param hour the hour of the day (0-23)
     */
    public static Matcher<ZonedDateTime> isHour( final int hour )
    {
        return new IsHour<>( hour, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMinuteOfHour(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameMinuteOfHour( final ZonedDateTime date )
    {
        return isMinute( date.getMinute() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected minute (0-59)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isMinute(12));
     * </pre>
     *
     * @param minute the minute of the day (0-59)
     */
    public static Matcher<ZonedDateTime> isMinute( final int minute )
    {
        return new IsMinute<>( minute, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameSecondOfMinute(ZonedDateTime.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<ZonedDateTime> sameSecondOfMinute( final ZonedDateTime date )
    {
        return isSecond( date.getSecond() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the expected second (0-59)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isSecond(12));
     * </pre>
     *
     * @param Second the second of the day (0-59)
     */
    public static Matcher<ZonedDateTime> isSecond( final int Second )
    {
        return new IsSecond<>( Second, t -> t );
    }
}
