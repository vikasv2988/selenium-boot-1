package selenium.boot.utils.dates.calc;


/**
 * Defines some standard Day Count bases.
 *
 * To read about the most common Day Count Conventions, you can refer to the
 * <a href="http://www.fincad.com/support/developerfunc/mathref/Daycount.htm">
 * following document</a> or <a href="https://en.wikipedia.org/wiki/Day_count_convention">here</a>.
 *
 * @author Benoit Xhenseval
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public enum PeriodCountBasis
{
    /**
     * 30/360, means that day count fractions are calculated assuming 30 day
     * months and 360 days in a year. The second date is only adjusted if the
     * first date is on the 31st of a month.
     */
    CONV_30_360,

    /**
     * 30E/360, means that day count fractions are calculated assuming 30 day
     * months and 360 days in a year. In this case, the second date is always
     * adjusted to the 30th, if it is the 31st.
     */
    CONV_360E_ISDA,

    /**
     * 30E+/360, means that day count fractions are calculated assuming 30 day
     * months and 360 days in a year. If the second date is on the 31st, it is
     * adjusted to the 30th and a second month is incremented by one.
     */
    CONV_360E_ISMA,

    /**
     * Actual/Actual, means that the numerator is the number of days between the
     * two dates. The denominator is the actual number of days in the coupon
     * period multiplied by the coupon frequency. This is mainly relates to
     * bonds. This normally results in day count factors of 1.0 for annual
     * coupons, 0.5 for semi annual coupons and 0.25 for quarterly coupons.
     */
    ACT_ACT,

    /**
     * Actual/360, known in the United States as money market basis, has a day
     * count fraction equal to the number of days between the payment dates,
     * divided by 360.
     */
    ACT_360,

    /**
     * Actual/365(Fixed), known as bond basis in the United States, means that
     * the day count fraction is equal to the number of days between the last
     * payment date and the next date divided by 365.
     */
    ACT_365
}
