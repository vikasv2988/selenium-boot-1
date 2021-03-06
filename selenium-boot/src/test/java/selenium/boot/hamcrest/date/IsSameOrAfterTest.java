package selenium.boot.hamcrest.date;


import selenium.boot.hamcrest.DateMatchers;



/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings( "deprecation" )
public class IsSameOrAfterTest
{

//    private static final String ASSERTION_PATTERN = "\\s*Expected: the date is on the same date or after [A-Za-z0-9:,.+\\- ]*\\s*but: the date is [A-Za-z0-9:,.+\\- ]*";
//
//    // Date Matchers
//
//    @Test
//    public void isDateSameOrAfterEarlierDate()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( JUN_15_2012_11AM_AS_DATE ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterLaterDate()
//    {
//        assertThat( JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter( JUN_15_2012_11PM_AS_DATE ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameDate()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( JUN_15_2012_11PM_AS_DATE ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameDateEarlierZone()
//    {
//        assertThat( JAN_01_2012_11AM_PST_AS_DATE, DateMatchers.sameOrAfter( JAN_01_2012_11AM_GMT_AS_DATE ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterSameDateLaterZone()
//    {
//        assertThat( JAN_01_2012_11AM_GMT_AS_DATE, DateMatchers.sameOrAfter( JAN_01_2012_11AM_PST_AS_DATE ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterEarlierLocalDate()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( JUN_14_2012 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterLaterLocalDate()
//    {
//        assertThat( JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter( JUN_16_2012 ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameLocalDate()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( JUN_15_2012 ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterEarlierDay()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 14 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterLaterDay()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 16 ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameDay()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 15 ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterEarlierDayMonthYear()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( new DayMonthYear( 14, Month.JUNE, 2012 ) ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterLaterDayMonthYear()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( new DayMonthYear( 16, Month.JUNE, 2012 ) ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameDayMonthYear()
//    {
//        assertThat( JUN_15_2012_11PM_AS_DATE, DateMatchers.sameOrAfter( new DayMonthYear( 15, Month.JUNE, 2012 ) ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterEarlierDateTime()
//    {
//        assertThat( JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 15, 10, 59, 59 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isDateSameOrAfterLaterDateTime()
//    {
//        assertThat( JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 15, 11, 00, 01 ) );
//    }
//
//    @Test
//    public void isDateSameOrAfterSameDateTime()
//    {
//        assertThat( JUN_15_2012_11AM_AS_DATE, DateMatchers.sameOrAfter( 2012, Month.JUNE, 15, 11, 00, 00 ) );
//    }
//
//    // LocalDate Matchers
//
//    @Test
//    public void isLocalDateSameOrAfterEarlierLocalDate()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( AUG_03_2015 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalDateSameOrAfterLaterLocalDate()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( AUG_05_2015 ) );
//    }
//
//    @Test
//    public void isLocalDateSameOrAfterSameLocalDate()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( AUG_04_2015 ) );
//    }
//
//    @Test
//    public void isLocalDateSameOrAfterEarlierDay()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( 2015, AUGUST, 3 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalDateSameOrAfterLaterDay()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( 2015, AUGUST, 5 ) );
//    }
//
//    @Test
//    public void isLocalDateSameOrAfterSameDay()
//    {
//        assertThat( AUG_04_2015, LocalDateMatchers.sameOrAfter( 2015, AUGUST, 4 ) );
//    }
//
//    // LocalDateTime Matchers
//
//    @Test
//    public void isLocalDateTimeSameOrAfterEarlierLocalDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( AUG_04_2015_1159 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalDateTimeSameOrAfterLaterLocalDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( AUG_04_2015_1201 ) );
//    }
//
//    @Test
//    public void isLocalDateTimeSameOrAfterSameLocalDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( AUG_04_2015_NOON ) );
//    }
//
//    @Test
//    public void isLocalDateTimeSameOrAfterEarlierDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 11, 59, 0 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalDateTimeSameOrAfterLaterDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 1 ) );
//    }
//
//    @Test
//    public void isLocalDateTimeSameOrAfterSameDateTime()
//    {
//        assertThat( AUG_04_2015_NOON, LocalDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 0 ) );
//    }
//
//    // ZonedDateTime Matchers
//
//    @Test
//    public void isZonedDateTimeSameOrAfterEarlierZonedDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( AUG_04_2015_11AM_UTC ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isZonedDateTimeSameOrAfterLaterZonedDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( AUG_04_2015_01PM_UTC ) );
//    }
//
//    @Test
//    public void isZonedDateTimeSameOrAfterSameZonedDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( AUG_04_2015_NOON_UTC ) );
//    }
//
//    @Test
//    public void isZonedDateTimeSameOrAfterZonedDateTimeEarlierZone()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, sameOrAfter( AUG_04_2015_NOON_CET ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isZonedDateTimeSameOrAfterZonedDateTimeLaterZone()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, sameOrAfter( AUG_04_2015_NOON_EST ) );
//    }
//
//    @Test
//    public void isZonedDateTimeSameOrAfterEarlierDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 11, 59, 0, 0, ZoneIds.UTC ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isZonedDateTimeSameOrAfterLaterDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 1, 0, ZoneIds.UTC ) );
//    }
//
//    @Test
//    public void isZonedDateTimeSameOrAfterSameDateTime()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.UTC ) );
//    }
//
//    @Test
//    public void isZonedDateTimeSameOrAfterDateTimeEarlierZone()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.CET ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isZonedDateTimeSameOrAfterDateTimeLaterZone()
//    {
//        assertThat( AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.sameOrAfter( 2015, AUGUST, 4, 12, 0, 0, 0, ZoneIds.EST ) );
//    }
//
//    // LocalTime Matchers
//
//    @Test
//    public void isLocalTimeSameOrAfterEarlierLocalTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( LocalTime.NOON.minusSeconds( 1 ) ) );
//    }
//
//    @Test
//    public void isLocalTimeSameOrAfterSameLocalTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( LocalTime.NOON ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalTimeSameOrAfterLaterLocalTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( LocalTime.NOON.plusSeconds( 1 ) ) );
//    }
//
//    @Test
//    public void isLocalTimeSameOrAfterEarlierTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( 11, 59, 59 ) );
//    }
//
//    @Test
//    public void isLocalTimeSameOrAfterSameTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( 12, 0, 0 ) );
//    }
//
//    @Test( expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN )
//    public void isLocalTimeSameOrAfterLaterTime()
//    {
//        assertThat( LocalTime.NOON, LocalTimeMatchers.sameOrAfter( 12, 0, 1 ) );
//    }
}
