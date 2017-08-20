package selenium.boot.hamcrest.date;

//@formatter:off

import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.DateMatchers;

import java.util.Calendar;
import java.util.Date;

import static selenium.boot.hamcrest.CoreMatchers.not;
import static selenium.boot.hamcrest.date.utils.DateMatcherTestUtils.addDateField;
import static selenium.boot.hamcrest.date.utils.Dates.AUG_04_2015_NOON_AS_DATE;



/**
 * Unit Tests for the {@link selenium.boot.hamcrest.matchers.date.IsMillisecond} class
 * testing the following  the {@link org.hamcrest.Factory @Factory} methods:
 * <ul>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#isMillisecond(int)}</li>
 *     <li>{@link selenium.boot.hamcrest.DateMatchers#sameMillisecondOfSecond(java.util.Date)}</li>
 * </ul>
 *
 * @author Stewart Bissett
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see selenium.boot.hamcrest.matchers.date.IsMillisecond
 * @see selenium.boot.hamcrest.DateMatchers#sameMillisecondOfSecond(java.util.Date)
 * @see selenium.boot.hamcrest.DateMatchers#isMillisecond(int)
 * @since 1.0
 */
@Test(
        enabled = true,
        description = "Validates the main hamcrest matcher selenium.boot.hamcrest.matchers.date.isMillisecond, " +
                              "testing the following hamcrest @Factory methods:\n" +
                              "01. DateMatchers#isMillisecond\n" +
                              "02. DateMatchers#sameMillisecondOfSecond"
)
public class IsMillisecondTests extends AbstractMatcherTest
{

    private static final String ASSERTION_PATTERN =
            ".*Expected: the date has the millisecond [0-9]{1,3}\\s.*but: the date has the millisecond [0-9]{1,3}.*";

    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    public void isDateMillisecond()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isMillisecond( 0 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isMillisecond( 0 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    public void isDateNotMillisecond()
    {
        describeTestCase();

        String desc = getDescription( not( DateMatchers.isMillisecond( 1 ) ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              not( DateMatchers.isMillisecond( 1 ) ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

    @Test(
            description = "Validates the IsMillisecond hamcrest mismatch message.",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isDateNotMillisecondMismatchMessage()
    {
        describeTestCase();

        String desc = getDescription( DateMatchers.isMillisecond( 1 ) );
        Assertion.assertThat( AUG_04_2015_NOON_AS_DATE,
                              DateMatchers.isMillisecond( 1 ),
                              "\"AUG_04_2015_NOON_AS_DATE\" matches " + desc
        );
    }

     public void isDateSameMilliSecond() throws Exception
    {
        describeTestCase();

        Date date = new Date(), other = new Date( date.getTime() );
        String desc = getDescription( DateMatchers.sameMillisecondOfSecond( date ) );
        Assertion.assertThat( other,
                              DateMatchers.sameMillisecondOfSecond( date ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    public void isNotDateSameMillisecond() throws Exception
    {
        describeTestCase();

        Date date = new Date(), other = addDateField( date, Calendar.MILLISECOND, 1 );
        String desc = getDescription( not( DateMatchers.sameMillisecondOfSecond( date ) ) );
        Assertion.assertThat( other,
                              not( DateMatchers.sameMillisecondOfSecond( date ) ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    @Test(
            description = "Testing sameMillisecondOfSecond() mismatch message",
            expectedExceptions = AssertionError.class,
            expectedExceptionsMessageRegExp = ASSERTION_PATTERN
    )
    public void isNotDateSameMillisecondMismatch() throws Exception
    {
        describeTestCase();

        Date date = new Date(), other = addDateField( date, Calendar.MILLISECOND, 1 );
        String desc = getDescription( DateMatchers.sameMillisecondOfSecond( date ) );
        Assertion.assertThat( other,
                              DateMatchers.sameMillisecondOfSecond( date ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    public void isDateSameMillisecondDifferentSecond()
    {
        describeTestCase();

        Date date = new Date(), other = addDateField( date, Calendar.SECOND, 1 );
        String desc = getDescription( DateMatchers.sameMillisecondOfSecond( date ) );
        Assertion.assertThat( other,
                              DateMatchers.sameMillisecondOfSecond( date ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    public void isDateSameMillisecondOfSecond()
    {
        Date date = new Date(), other = new Date( date.getTime() );
        String desc = getDescription( DateMatchers.sameMillisecondOfSecond( date ) );
        Assertion.assertThat( other,
                              DateMatchers.sameMillisecondOfSecond( date ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    public void isDateNotSameMillisecondOfSecond()
    {
        Date date = new Date(), other = addDateField( date, Calendar.MILLISECOND, 1 );
        String desc = getDescription( not( DateMatchers.sameMillisecondOfSecond( date ) ) );
        Assertion.assertThat( other,
                              not( DateMatchers.sameMillisecondOfSecond( date ) ),
                              "other \"" + other + "\" matches " + desc
        );
    }

    @Test
    public void isDateSameMillisecondOfSecondDifferentSecond()
    {
        Date date = new Date(), other = addDateField( date, Calendar.SECOND, 1 );
        String desc = getDescription( DateMatchers.sameMillisecondOfSecond( date ) );
        Assertion.assertThat( other,
                              DateMatchers.sameMillisecondOfSecond( date ),
                              "other \"" + other + "\" matches " + desc
        );
    }
}
