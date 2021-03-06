package selenium.boot.hamcrest.date;

import selenium.boot.hamcrest.DateMatchers;



/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
public class IsSameHourOfDayTest {

//    private static final String ASSERTION_PATTERN = "\\s*Expected: the date has the hour [0-9]*\\s*but: the date has the hour [0-9]*";
//
//	// Date Matchers
//	@Test
//	public void isDateSameHour() {
//		Date date = new Date(), other = new Date(date.getTime());
//		assertThat(other, DateMatchers.sameHour(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isDateNotSameHour() {
//		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
//		assertThat( other, DateMatchers.sameHour( date));
//	}
//
//	@Test
//	public void isDateSameMonthDifferentDay() {
//		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
//		assertThat(other, DateMatchers.sameHour(date));
//	}
//
//	@Test
//	public void isDateSameHourOfDay() {
//		Date date = new Date(), other = new Date(date.getTime());
//		assertThat(other, DateMatchers.sameHourOfDay(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isDateNotSameHourOfDay() {
//		Date date = new Date(), other = addDateField(date, Calendar.HOUR, 1);
//		assertThat(other, DateMatchers.sameHourOfDay(date));
//	}
//
//	@Test
//	public void isDateSameHourOfDayDifferentDay() {
//		Date date = new Date(), other = addDateField(date, Calendar.DAY_OF_WEEK, 1);
//		assertThat(other, DateMatchers.sameHourOfDay(date));
//	}
//
//	// LocalDateTime Matchers
//	@Test
//	public void isLocalDateTimeSameHourOfDay() {
//		LocalDateTime date = LocalDateTime.now(), other = date;
//		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isLocalDateTimeNotSameHourOfDay() {
//		LocalDateTime date = LocalDateTime.now(), other = date.plusHours(1);
//		assertThat(other, LocalDateTimeMatchers.sameHourOfDay(date));
//	}
//
//	@Test
//	public void isLocalDateTimeSameHourOfDayDifferentDay() {
//		LocalDateTime date = LocalDateTime.now(), other = date.plusDays(1);
//		assertThat( other, LocalDateTimeMatchers.sameHourOfDay( date));
//	}
//
//	// LocalTime Matchers
//	@Test
//	public void isLocalTimeSameHourOfDay() {
//		LocalTime date = LocalTime.now(), other = date;
//		assertThat( other, LocalTimeMatchers.sameHourOfDay( date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isLocalTimeNotSameHourOfDay() {
//		LocalTime date = LocalTime.now(), other = date.plusHours(1);
//		assertThat(other, LocalTimeMatchers.sameHourOfDay(date));
//	}
//
//	// ZonedDateTime Matchers
//	@Test
//	public void isZonedDateTimeSameHourOfDay() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date;
//		assertThat(other, ZonedDateTimeMatchers.sameHourOfDay(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isZonedDateTimeNotSameHourOfDay() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date.plusHours(1);
//		assertThat( other, ZonedDateTimeMatchers.sameHourOfDay( date));
//	}
//
//	@Test
//	public void isZonedDateTimeSameHourOfDayDifferentDay() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date.plusDays(1);
//		assertThat(other, ZonedDateTimeMatchers.sameHourOfDay(date));
//	}
}
