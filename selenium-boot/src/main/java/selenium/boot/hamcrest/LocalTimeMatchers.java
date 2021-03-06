package selenium.boot.hamcrest;


import lombok.experimental.UtilityClass;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import selenium.boot.hamcrest.matchers.date.*;
import selenium.boot.hamcrest.matchers.date.format.DatePartFormatter;
import selenium.boot.hamcrest.matchers.date.format.LocalTimeFormatter;
import selenium.boot.hamcrest.matchers.date.wrapper.LocalTimeWrapper;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;



/**
 * Static factory for creating {@link org.hamcrest.Matcher} instances for comparing {@link java.time.LocalTime} instances
 *
 * @author Stewart Bissett
 */
@UtilityClass
public class LocalTimeMatchers
{


    /**
     * Creates a matcher that matches when the examined time is after the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myTime, after(LocalTime.now()));
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> after( final LocalTime time )
    {
        return new IsAfter<>( new LocalTimeWrapper( time ),
                              new LocalTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined time is after the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myTime, after(23,59,59);
     * </pre>
     *
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> after( final int hour,
                                            final int minute,
                                            final int second )
    {
        return new IsAfter<>( new LocalTimeWrapper( hour, minute, second ), new LocalTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is before the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myTime, before(LocalTime.now()));
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> before( final LocalTime time )
    {
        return new IsBefore<>( new LocalTimeWrapper( time ),
                               new LocalTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined time is before the end of the reference year
     * <p/>
     * For example:
     * <p>
     * <pre>
     * MatcherAssert.assertThat(myTime, before(23,59,59);
     * </pre>
     *
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> before( final int hour, final int minute, final int second )
    {
        return new IsBefore<>( new LocalTimeWrapper( hour, minute, second ),
                               new LocalTimeFormatter()
        );
    }

    /**
     * Creates a matcher that matches when the examined time is at the same instant or before the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isSameOrBefore(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameOrBefore( final LocalTime time )
    {
        return new IsSameOrBefore<>( new LocalTimeWrapper( time ), new LocalTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the same day or before the start of the reference
     * time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isSameOrBefore(23, 59, 59));
     * </pre>
     *
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    @Factory
    public static Matcher<LocalTime> sameOrBefore( final int hour, final int minute, final int second )
    {
        return new IsSameOrBefore<>( new LocalTimeWrapper( hour, minute, second ), new LocalTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the same day or after the start of the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isSameOrAfter(23, 59, 59));
     * </pre>
     *
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> sameOrAfter( final int hour, final int minute, final int second )
    {
        return sameOrAfter( LocalTime.of( hour, minute, second ) );
    }

    /**
     * Creates a matcher that matches when the examined time is at the same instant or after the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isSameOrAfter(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameOrAfter( final LocalTime time )
    {
        return new IsSameOrAfter<>( new LocalTimeWrapper( time ), new LocalTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is within a defined period the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, within(10, TimeUnit.SECONDS, LocalTime.NOON))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> within( final long period, final ChronoUnit unit, final LocalTime time )
    {
        return new IsWithin<>( period, unit, new LocalTimeWrapper( time ), new LocalTimeFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is within a given period of the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, within(10, TimeUnit.SECONDS, 23, 59, 59));
     * </pre>
     *
     * @param period the timeunit interval the examined time should be with
     * @param unit   the timeunit to define the length of the period
     * @param hour   the hour of the day
     * @param minute the minute of the hour
     * @param second the second of the minute
     */
    public static Matcher<LocalTime> within( final long period,
                                             final ChronoUnit unit,
                                             final int hour,
                                             final int minute,
                                             final int second )
    {
        return new IsWithin<>( period,
                               unit,
                               new LocalTimeWrapper( hour, minute, second ),
                               new LocalTimeFormatter()
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
    public static Matcher<LocalTime> isMinimum( final ChronoField field )
    {
        return new IsMinimum<>( field, t -> t, new DatePartFormatter() );
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
    public static Matcher<LocalTime> isMaximum( final ChronoField field )
    {
        return new IsMaximum<>( field, t -> t, new DatePartFormatter() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the same hour as the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, sameHourOfDay(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameHourOfDay( final LocalTime time )
    {
        return isHour( time.getHour() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the expected hour (0-23)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isHour(12));
     * </pre>
     *
     * @param hour the hour of the day (0-23)
     */
    public static Matcher<LocalTime> isHour( final int hour )
    {
        return new IsHour<>( hour, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined time is on the same minute as the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, sameMinuteOfHour(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameMinuteOfHour( final LocalTime time )
    {
        return isMinute( time.getMinute() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the expected minute (0-59)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isMinute(12));
     * </pre>
     *
     * @param minute the minute of the day (0-59)
     */
    public static Matcher<LocalTime> isMinute( final int minute )
    {
        return new IsMinute<>( minute, t -> t );
    }

    /**
     * Creates a matcher that matches when the examined time is on the same second as the reference time
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, sameSecondOfMinute(LocalTime.now()))
     * </pre>
     *
     * @param time the reference time against which the examined time is checked
     */
    public static Matcher<LocalTime> sameSecondOfMinute( final LocalTime time )
    {
        return isSecond( time.getSecond() );
    }

    /**
     * Creates a matcher that matches when the examined time is on the expected second (0-59)
     * <p/>
     * For example:
     * <p>
     * <pre>
     * assertThat(myTime, isSecond(12));
     * </pre>
     *
     * @param Second the second of the day (0-59)
     */
    public static Matcher<LocalTime> isSecond( final int Second )
    {
        return new IsSecond<>( Second, t -> t );
    }
}
