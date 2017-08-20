package selenium.boot.hamcrest.date;

/**
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameMonthOfYearTest {

//    private static final String ASSERTION_PATTERN = "\\s*Expected: the date is in [A-Za-z]*\\s*but: the date is in [A-Za-z]*";
//
//	// Date Matchers
//	@Test
//	public void isDateSameMonth() {
//		Date date = new Date(), other = new Date(date.getTime());
//		assertThat(other, DateMatchers.sameMonth(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isDateNotSameMonth() {
//		Date date = new Date(), other = addDateField(date, Calendar.MONTH, 1);
//		assertThat( other, DateMatchers.sameMonth( date));
//	}
//
//	@Test
//	public void isDateSameMonthDifferentYear() {
//		Date date = new Date(), other = addDateField(date, Calendar.YEAR, 1);
//		assertThat(other, DateMatchers.sameMonth(date));
//	}
//
//	@Test
//	public void isDateSameMonthOfYear() {
//		Date date = new Date(), other = new Date(date.getTime());
//		assertThat(other, DateMatchers.sameMonthOfYear(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isDateNotSameMonthOfYear() {
//		Date date = new Date(), other = addDateField(date, Calendar.MONTH, 1);
//		assertThat(other, DateMatchers.sameMonthOfYear(date));
//	}
//
//	@Test
//	public void isDateSameMonthOfYearDifferentYear() {
//		Date date = new Date(), other = addDateField(date, Calendar.YEAR, 1);
//		assertThat(other, DateMatchers.sameMonthOfYear(date));
//	}
//
//	// LocalDate Matchers
//	@Test
//	public void isLocalDateSameMonthOfYear() {
//		LocalDate date = LocalDate.now(), other = date;
//		assertThat(other, LocalDateMatchers.sameMonthOfYear(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isLocalDateNotSameMonthOfYear() {
//		LocalDate date = LocalDate.now(), other = date.plusMonths(1);
//		assertThat(other, LocalDateMatchers.sameMonthOfYear(date));
//	}
//
//	@Test
//	public void isLocalDateSameMonthOfYearDifferentYear() {
//		LocalDate date = LocalDate.now(), other = date.plusYears(1);
//		assertThat( other, LocalDateMatchers.sameMonthOfYear( date));
//	}
//
//	// LocalDateTime Matchers
//	@Test
//	public void isLocalDateTimeSameMonthOfYear() {
//		LocalDateTime date = LocalDateTime.now(), other = date;
//		assertThat(other, LocalDateTimeMatchers.sameMonthOfYear(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isLocalDateTimeNotSameMonthOfYear() {
//		LocalDateTime date = LocalDateTime.now(), other = date.plusMonths(1);
//		assertThat(other, LocalDateTimeMatchers.sameMonthOfYear(date));
//	}
//
//	@Test
//	public void isLocalDateTimeSameMonthOfYearDifferentYear() {
//		LocalDateTime date = LocalDateTime.now(), other = date.plusYears(1);
//		assertThat( other, LocalDateTimeMatchers.sameMonthOfYear( date));
//	}
//
//	// ZonedDateTime Matchers
//	@Test
//	public void isZonedDateTimeSameMonthOfYear() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date;
//		assertThat(other, ZonedDateTimeMatchers.sameMonthOfYear(date));
//	}
//
//	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
//	public void isZonedDateTimeNotSameMonthOfYear() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date.plusMonths(1);
//		assertThat( other, ZonedDateTimeMatchers.sameMonthOfYear( date));
//	}
//
//	@Test
//	public void isZonedDateTimeSameMonthOfYearDifferentYear() {
//		ZonedDateTime date = ZonedDateTime.now(), other = date.plusYears(1);
//		assertThat(other, ZonedDateTimeMatchers.sameMonthOfYear(date));
//	}
}
