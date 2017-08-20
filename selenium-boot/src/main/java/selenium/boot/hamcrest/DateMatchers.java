package selenium.boot.hamcrest;


import lombok.experimental.UtilityClass;
import org.hamcrest.Matcher;
import selenium.boot.hamcrest.matchers.date.*;
import selenium.boot.hamcrest.matchers.date.format.DateFormatter;
import selenium.boot.hamcrest.matchers.date.format.DatePartFormatter;
import selenium.boot.hamcrest.matchers.date.wrapper.DateWrapper;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import static java.time.ZoneId.systemDefault;



/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing dates
 *
 * @author Stewart Bissett
 */
@UtilityClass
public class DateMatchers
{

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, after(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> after( final Date date )
    {
        return new IsAfter<>( new DateWrapper( date ),
                              new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, after(Moments.today()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> after( final LocalDate date )
    {
        return new IsAfter<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, after(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year  the year against which the examined date is checked
     * @param month the month against which the examined date is checked
     * @param day   the day of the month against which the examined date is checked
     */
    public static Matcher<Date> after( final int year,
                                       final Month month,
                                       final int day )
    {
        return new IsAfter<>( new DateWrapper( year, month, day ), new DateFormatter() );
    }


    /**
     * Creates a matcher that matches when the examined date is after the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, after(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day against which the examined date is checked
     * @param minute     the minute of the hour against which the examined date is checked
     * @param second     the second of the minute against which the examined date is checked
     */
    public static Matcher<Date> after( final int year,
                                       final Month month,
                                       final int dayOfMonth,
                                       final int hour,
                                       final int minute,
                                       final int second )
    {
        return new IsAfter<>( new DateWrapper( year, month, dayOfMonth, hour, minute, second ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, before(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> before( final Date date )
    {
        return new IsBefore<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, before(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> before( final LocalDate date )
    {
        return new IsBefore<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is before the start of reference day
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, before(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static Matcher<Date> before( final int year, final Month month, final int dayOfMonth )
    {
        return new IsBefore<>( new DateWrapper( year, month, dayOfMonth ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is before the start of the reference date and time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, before(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day against which the examined date is checked
     * @param minute     the minute of the hour against which the examined date is checked
     * @param second     the second of the minute against which the examined date is checked
     */
    public static Matcher<Date> before( final int year,
                                        final Month month,
                                        final int dayOfMonth,
                                        final int hour,
                                        final int minute,
                                        final int second )
    {
        return new IsBefore<>( new DateWrapper( year,
                                                month,
                                                dayOfMonth,
                                                hour,
                                                minute,
                                                second
        ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameWeekday(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameDayOfWeek( final Date date )
    {
        return isDayOfWeek( DayOfWeek.from( date.toInstant().atZone( ZoneId.systemDefault() ) ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the week as the supplied day
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, isDayOfWeek(DayOfWeek.MONDAY))
     * </pre>
     *
     * @param daysOfWeek the reference weekday against which the examined date is checked
     */
    public static Matcher<Date> isDayOfWeek( final DayOfWeek... daysOfWeek )
    {
        return new IsDayOfWeek<>( Arrays.asList( daysOfWeek ),
                                  DateMatchers:: dateToZoneDateTime
        );
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
    public static Matcher<Date> sameDayOfMonth( final Date date )
    {
        return isDayOfMonth( extractField( date, ChronoField.DAY_OF_MONTH ) );
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
    public static Matcher<Date> isDayOfMonth( final int dayOfMonth )
    {
        return new IsDayOfMonth<>( dayOfMonth,
                                   DateMatchers:: dateToZoneDateTime
        );
    }

    private static int extractField( final Date date, final ChronoField field )
    {
        return dateToZoneDateTime( date ).get( field );
    }

    private static Temporal dateToZoneDateTime( final Date date )
    {
        return date.toInstant().atZone( systemDefault() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDay(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameDay( final Date date )
    {
        return new IsSameDay<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDayOfTheYear(2012, Month.JAN, 1))
     * </pre>
     *
     * @param dayOfMonth the reference day of the month against which the examined date is checked
     * @param month      the reference month against which the examined date is checked
     * @param year       the reference year against which the examined date is checked
     */
    public static Matcher<Date> isDay( final int year, final Month month, final int dayOfMonth )
    {
        return sameDay( LocalDate.of( year, month, dayOfMonth ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day of the year as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameDay(Moments.today()));
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameDay( final LocalDate date )
    {
        return new IsSameDay<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameHourOfDay(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameHourOfDay( final Date date )
    {
        return isHour( extractField( date, ChronoField.HOUR_OF_DAY ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same hour as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameHour(12));
     * </pre>
     *
     * @param hour the reference hour against which the examined date is checked
     */

    public static Matcher<Date> isHour( final int hour )
    {
        return new IsHour<>( hour, DateMatchers:: dateToZoneDateTime );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same instant as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameInstant(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameInstant( final Date date )
    {
        return new IsSame<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same UTC instant as the reference UTC epoch time
     * supplied
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameInstant(1325415600000L))
     * </pre>
     *
     * @param timestamp the time as milliseconds since the Unix epoch time
     */
    public static Matcher<Date> sameInstant( final long timestamp )
    {
        return new IsSame<>( new DateWrapper( new Date( timestamp ) ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same instance as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameInstant(2012, Months.MAY, 12, 23, 00, 01, 123));
     * </pre>
     *
     * @param year         the year against which the examined date is checked
     * @param month        the month against which the examined date is checked
     * @param dayOfMonth   the day of the month against which the examined date is checked
     * @param hour         the hour of the day against which the examined date is checked
     * @param minute       the minute of the hour against which the examined date is checked
     * @param second       the second of the minute against which the examined date is checked
     * @param milliseconds the milliseconds of the second against which the examined date is checked
     */
    public static Matcher<Date> isInstant( final int year,
                                           final Month month,
                                           final int dayOfMonth,
                                           final int hour,
                                           final int minute,
                                           final int second,
                                           final int milliseconds )
    {
        return new IsSame<>( new DateWrapper( year, month, dayOfMonth, hour, minute, second, milliseconds ),
                             new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameOrBefore( final Date date )
    {
        return new IsSameOrBefore<>( new DateWrapper( date ),
                                     new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or before the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameOrBefore( final LocalDate date )
    {
        return new IsSameOrBefore<>( new DateWrapper( date ),
                                     new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or before the start of the reference
     * date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static Matcher<Date> sameOrBefore( final int year,
                                              final Month month,
                                              final int dayOfMonth )
    {
        return new IsSameOrBefore<>( new DateWrapper( LocalDate.of( year, month, dayOfMonth ) ),
                                     new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or before the start of the reference
     * date and time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrBefore(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day against which the examined date is checked
     * @param minute     the minute of the hour against which the examined date is checked
     * @param second     the second of the minute against which the examined date is checked
     */

    public static Matcher<Date> sameOrBefore( final int year,
                                              final Month month,
                                              final int dayOfMonth,
                                              final int hour,
                                              final int minute,
                                              final int second )
    {
        return new IsSameOrBefore<>( new DateWrapper( year, month, dayOfMonth, hour, minute, second ),
                                     new DateFormatter()
        );
    }

    /**
     * F Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameOrAfter( final Date date )
    {
        return new IsSameOrAfter<>( new DateWrapper( date ),
                                    new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is at the same instant or after the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameOrAfter( final LocalDate date )
    {
        return new IsSameOrAfter<>( new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same day or after the start of the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     */
    public static Matcher<Date> sameOrAfter( final int year,
                                             final Month month,
                                             final int dayOfMonth )
    {
        return new IsSameOrAfter<>( new DateWrapper( year, month, dayOfMonth ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second or after the start of the reference
     * date and time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameOrAfter(2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param year       the year against which the examined date is checked
     * @param month      the month against which the examined date is checked
     * @param dayOfMonth the day of the month against which the examined date is checked
     * @param hour       the hour of the day against which the examined date is checked
     * @param minute     the minute of the hour against which the examined date is checked
     * @param second     the second of the minute against which the examined date is checked
     */

    public static Matcher<Date> sameOrAfter( final int year,
                                             final Month month,
                                             final int dayOfMonth,
                                             final int hour,
                                             final int minute,
                                             final int second )
    {
        return new IsSameOrAfter<>( new DateWrapper( year, month, dayOfMonth, hour, minute, second ),
                                    new DateFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same minute as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMinute(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameMinuteOfHour( final Date date )
    {
        return isMinute( extractField( date, ChronoField.MINUTE_OF_HOUR ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the reference minute
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMinute(55))
     * </pre>
     *
     * @param minute the reference minute against which the examined date is checked
     */
    public static Matcher<Date> isMinute( final int minute )
    {
        return new IsMinute<>( minute, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> sameMonthOfYear( final Date date )
    {
        return isMonth( Month.of( date.toInstant()
                                          .atZone( ZoneId.systemDefault() )
                                          .get( ChronoField.MONTH_OF_YEAR ) ) );
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
    public static Matcher<Date> isMonth( final Month month )
    {
        return new IsMonth<>( month, DateMatchers:: dateToZoneDateTime );
    }

    /**
     * Creates a matcher that matches when the examined date is on the same second as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameSecond(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameSecondOfMinute( final Date date )
    {
        return isSecond( extractField( date, ChronoField.SECOND_OF_MINUTE ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the reference second
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameSecond(33))
     * </pre>
     *
     * @param second the reference date against which the examined date is checked
     */
    public static Matcher<Date> isSecond( final int second )
    {
        return new IsSecond<>( second, DateMatchers:: dateToZoneDateTime );
    }


    /**
     * Creates a matcher that matches when the examined date is on the same millisecond as the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMillisecond(new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> sameMillisecondOfSecond( final Date date )
    {
        return isMillisecond( extractField( date, ChronoField.MILLI_OF_SECOND ) );
    }

    /**
     * Creates a matcher that matches when the examined date is on the reference second
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, sameMillisecond(123))
     * </pre>
     *
     * @param millisecond the millisecond against which the examined date is checked
     */
    public static Matcher<Date> isMillisecond( final int millisecond )
    {
        return new IsMillisecond<>( millisecond,
                                    DateMatchers:: dateToZoneDateTime
        );
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
    public static Matcher<Date> sameYear( final Date date )
    {
        return isYear( extractField( date, ChronoField.YEAR ) );
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
    public static Matcher<Date> isYear( final int year )
    {
        return new IsYear<>( year, DateMatchers:: dateToZoneDateTime );
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, within(10, TimeUnit.MINUTES, new Date()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> within( final long period, final ChronoUnit unit, final Date date )
    {
        return new IsWithin<>( period, unit, new DateWrapper( date ), new DateFormatter() );
    }

    private static ChronoUnit convertUnit( final TimeUnit unit )
    {
        switch( unit )
        {
            case DAYS:
                return ChronoUnit.DAYS;
            case HOURS:
                return ChronoUnit.HOURS;
            case MICROSECONDS:
                return ChronoUnit.MICROS;
            case MILLISECONDS:
                return ChronoUnit.MILLIS;
            case MINUTES:
                return ChronoUnit.MINUTES;
            case NANOSECONDS:
                return ChronoUnit.NANOS;
            case SECONDS:
                return ChronoUnit.SECONDS;
            default:
                throw new IllegalArgumentException( "Unknown TimeUnit '" + unit + "'" );
        }
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
     */
    public static Matcher<Date> within( final long period,
                                        final ChronoUnit unit,
                                        final int year,
                                        final Month month,
                                        final int dayOfMonth )
    {
        return within( period, unit, LocalDate.of( year, month, dayOfMonth ) );
    }

    /**
     * Creates a matcher that matches when the examined date is within a defined period the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, within(10, ChronoUnit.DAYS, LocalDate.now()))
     * </pre>
     *
     * @param date the reference date against which the examined date is checked
     */
    public static Matcher<Date> within( final long period, final ChronoUnit unit, final LocalDate date )
    {
        return new IsWithin<>( period, unit, new DateWrapper( date ), new DateFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined date is within a given period of the reference date
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myDate, within(1, TimeUnit.MINUTES, 2012, Months.MAY, 12, 23, 00, 01));
     * </pre>
     *
     * @param period      the time-unit interval the examined date should be with
     * @param unit        the time-unit to define the length of the period
     * @param year        the year against which the examined date is checked
     * @param month       the month against which the examined date is checked
     * @param dayOfMonth  the day of the month against which the examined date is checked
     * @param hour        the hour of the day against which the examined date is checked
     * @param minute      the minute of the hour against which the examined date is checked
     * @param second      the second of the minute against which the examined date is checked
     * @param millisecond the millisecond of the second against which the examined date is checked
     */
    public static Matcher<Date> within( final long period,
                                        final ChronoUnit unit,
                                        final int year,
                                        final Month month,
                                        final int dayOfMonth,
                                        final int hour,
                                        final int minute,
                                        final int second,
                                        final int millisecond )
    {
        return new IsWithin<>( period,
                               unit,
                               new DateWrapper( year, month, dayOfMonth, hour, minute, second, millisecond ),
                               new DateFormatter()
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
    public static Matcher<Date> isYesterday()
    {
        return sameDay( LocalDate.now().minusDays( 1 ) );
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
    public static Matcher<Date> isToday()
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
    public static Matcher<Date> isTomorrow()
    {
        return sameDay( LocalDate.now().plusDays( 1 ) );
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
    public static Matcher<Date> isMonday()
    {
        return new IsDayOfWeek<>( DayOfWeek.MONDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isTuesday()
    {
        return new IsDayOfWeek<>( DayOfWeek.TUESDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isWednesday()
    {
        return new IsDayOfWeek<>( DayOfWeek.WEDNESDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isThursday()
    {
        return new IsDayOfWeek<>( DayOfWeek.THURSDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isFriday()
    {
        return new IsDayOfWeek<>( DayOfWeek.FRIDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isSaturday()
    {
        return new IsDayOfWeek<>( DayOfWeek.SATURDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isSunday()
    {
        return new IsDayOfWeek<>( DayOfWeek.SUNDAY, DateMatchers:: dateToZoneDateTime );
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
    public static Matcher<Date> isWeekday()
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
    public static Matcher<Date> isWeekend()
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
    public static Matcher<Date> isFirstDayOfMonth()
    {
        return new IsMinimum<>( ChronoField.DAY_OF_MONTH,
                                DateMatchers:: dateToZoneDateTime,
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
    public static Matcher<Date> isMinimum( final ChronoField field )
    {
        return new IsMinimum<>( field,
                                DateMatchers:: dateToZoneDateTime,
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
    public static Matcher<Date> isLastDayOfMonth()
    {
        return new IsMaximum<>( ChronoField.DAY_OF_MONTH,
                                DateMatchers:: dateToZoneDateTime,
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
    public static Matcher<Date> isMaximum( final ChronoField field )
    {
        return new IsMaximum<>( field,
                                DateMatchers:: dateToZoneDateTime,
                                new DatePartFormatter()
        );
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
    public static Matcher<Date> isJanuary()
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
    public static Matcher<Date> isFebruary()
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
    public static Matcher<Date> isMarch()
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
    public static Matcher<Date> isApril()
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
    public static Matcher<Date> isMay()
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
    public static Matcher<Date> isJune()
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
    public static Matcher<Date> isJuly()
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
    public static Matcher<Date> isAugust()
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
    public static Matcher<Date> isSeptember()
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
    public static Matcher<Date> isOctober()
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
    public static Matcher<Date> isNovember()
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
    public static Matcher<Date> isDecember()
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
    public static Matcher<Date> isLeapYear()
    {
        return new IsLeapYear<>( DateMatchers:: dateToZoneDateTime, new DateFormatter() );
    }

}
