package selenium.boot.utils.dates.calc;


import java.util.List;



/**
 * A DateCalculator is a lightweight container with an optional reference to a set of holidays, a WorkingWeek (Mon-Fri by default),
 * a startDate and a current business date.
 *
 * The Calculator also uses a HolidayHandler to determine what to do when the calculated current Business Date falls on a weekend or
 * holiday (non-working day).
 * The CurrentDate date is changed every time that the {@linkplain #moveByDays} or {@linkplain #moveByBusinessDays} methods are called.
 * 'E' will be parameterized to be a Date-like class, i.e. {@link java.util.Date} or
 * {@link java.util.Calendar} (and LocalDate or YearMonthDay for Joda-time / JDK8).
 *
 * @author Benoit Xhenseval
 *
 * @param <E>  a representation of a date, typically JDK: Date, Calendar;  Joda:LocalDate, YearMonthDay
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface DateCalculator<E> extends BaseCalculator<E>
{
    /**
     * This is typically the name of the associated set of holidays.
     *
     * @return calculator name (Typically the name associated with the holiday set).
     */
    String getName();

    /**
     * Gives the startDate of this calculator (immutable once set via setStartDate).
     *
     * @return startDate the reference date for this calculator.
     */
    E getStartDate();

    /**
     * Setting the start date also sets the current business date (and if this is a non-working day,
     * the current business date will be moved to the next business day according to the HolidayHandler algorithm given).
     *
     * @param startDate the reference date for this calculator, the current business
     *                  date is also updated and may be moved if it falls on a non working day (holiday/weekend).
     */
    DateCalculator<E> setStartDate( E startDate );

    /**
     * Is the given date falling on a weekend, according to the WorkingWeek.
     *
     * @return true if the date falls on a weekend.
     */
    boolean isWeekend( E date );

    /**
     * Is the current business day a non-working day, this is useful if the
     * calculator does not have any algorithm to change the date when it falls on a non-working day.
     * This method can then be used to show a warning to the user.
     *
     * @return true if the current date is either a weekend or a holiday.
     */
    boolean isCurrentDateNonWorking();

    /**
     * Returns an immutable version of the HolidayCalendar.
     *
     * @return a copy of the holiday calendar
     */
    HolidayCalendar<E> getHolidayCalendar();

    // -----------------------------------------------------------------------
    //
    // ObjectLab, world leaders in the design and development of bespoke
    // applications for the securities financing markets.
    // www.ObjectLab.co.uk
    //
    // -----------------------------------------------------------------------

    /**
     * This is typically used at the construction of a DateCalculator to give a
     * reference to a Holiday Calendar, if not the case, the calculator will  make an immutable copy of the HolidayCalendar.
     *
     * @param calendar the holiday calendar (if null, no holidays taken into account)
     */
    DateCalculator<E> setHolidayCalendar( HolidayCalendar<E> calendar );

    /**
     * Allows user to define what their Working Week should be (default is Mon-Fri).
     *
     * @param week an immutable definition of a week.
     */
    DateCalculator<E> setWorkingWeek( WorkingWeek week );

    /**
     * Gives a current business date, it may be moved according to the
     * HolidayHandler algorithm if it falls on a non-working day.
     *
     * @param date
     *
     * @return new current business date if moved.
     */
    E setCurrentBusinessDate( E date );

    /**
     * Gives a current business date, it will NOT be moved.
     * Do NOT use this in 99.9% cases.
     *
     * @param date
     *
     * @return new current business date if moved.
     */
    E forceCurrentDateNoAdjustment( E date );

    /**
     * Gives the name of the holiday handler algorithm, see HolidayHandlerType
     * for some standard values.
     *
     * @return the holiday handler type, can be null
     */
    String getHolidayHandlerType();

    /**
     * This changes the current business date held in the calculator, it moves
     * the new current business date by the number of days and, if it falls on a
     * weekend or holiday, moves it further according to the HolidayHandler
     * given in this DateCalculator.
     *
     * @param days number of days (can be &lt;0 or &gt;0)
     *
     * @return the DateCalculator (so one can do
     * calendar.moveByDays(-2).getCurrentBusinessDate();)
     */
    DateCalculator<E> moveByDays( int days );

    /**
     * This changes the current business date held in the calculator, it moves
     * the current date by a number of business days, this means that if a date
     * is either a 'weekend' or holiday along the way, it will be skipped
     * acording to the holiday handler and not count towards the number of days
     * to move.
     *
     * @param businessDays (can be &lt;0 or &gt;0)
     *
     * @return the current DateCalculator (so one can do
     * calendar.moveByBusinessDays(2).getCurrentBusinessDate();)
     *
     * @throws IllegalArgumentException if the HolidayHandlerType is (MODIFIED_PRECEDING or
     *                                  BACKWARD) and businessDays &gt; 0 or (MODIFIED_FOLLOWING or
     *                                  FORWARD) and businessDays &lt; 0
     */
    DateCalculator<E> moveByBusinessDays( int businessDays );

    /**
     * Allows DateCalculators to be combined into a new one, the startDate and
     * currentBusinessDate will be the ones from the existing calendar (not the
     * parameter one). The name will be combined name1+"/"+calendar.getName().
     * If the Calendars have Early or Late boundaries, the result is the
     * narrowest interval (e.g. the later Early boundary and the earliest
     * Late boundary).
     *
     * @param calculator return the same DateCalculator if calendar is null or the
     *                   original calendar (but why would you want to do that?)
     *
     * @throws IllegalArgumentException if both calendars have different types of HolidayHandlers or
     *                                  WorkingWeek; Also, it is required that BOTH calendars either
     *                                  have Early/Late Boundaries or none.
     */
    DateCalculator<E> combine( DateCalculator<E> calculator );

    /**
     * Move the current date by a given tenor, please note that all tenors are
     * relative to the SPOT day which is a number of days from the current date.
     *
     * This method therefore, calculates the SPOT day first, moves it if it
     * falls on a holiday and then goes to the calculated day according to the Tenor.
     *
     * @param tenor   the Tenor to reach.
     * @param spotLag number of days to "spot" days, this can vary from one market
     *                to the other. It is sometimes called "settlement interval" or "offset".
     *
     * @return the current DateCalculator
     */
    DateCalculator<E> moveByTenor( Tenor tenor, int spotLag );

    /**
     * Move the current date by a given tenor, please note that all tenors are
     * relative to the CURRENT day (and NOT from spot).
     *
     * @param tenor the Tenor to reach.
     *
     * @return the current DateCalculator
     *
     * @since 1.1.0
     */
    DateCalculator<E> moveByTenor( Tenor tenor );

    /**
     * Calculate a series of Tenor codes in one go based on current day,
     * this does NOT change the current business date.
     *
     * @return list of dates in same order as tenors.
     */
    List<E> calculateTenorDates( List<Tenor> tenors );

    /**
     * Calculate a series of Tenor codes in one go based on SPOT day (calculated
     * with the spot lag), this does NOT change the current business date.
     *
     * @return list of dates in same order as tenors.
     */
    List<E> calculateTenorDates( List<Tenor> tenors, int spotLag );

    /**
     * This would be used by delegate methods to detect if the increment
     * if positive or negative (this will allow us to define a Handler that can act as Forward if positive and Backward if negative).
     *
     * @param increment
     */
    DateCalculator<E> setCurrentIncrement( int increment );
}
