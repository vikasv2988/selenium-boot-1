package selenium.boot.hamcrest.date;


import org.testng.annotations.Test;
import selenium.boot.hamcrest.AbstractMatcherTest;
import selenium.boot.hamcrest.Assertion;
import selenium.boot.hamcrest.CoreMatchers;
import selenium.boot.hamcrest.date.utils.Dates;
import selenium.boot.hamcrest.matchers.date.format.DateFormatter;
import selenium.boot.hamcrest.matchers.date.format.LocalDateFormatter;
import selenium.boot.hamcrest.matchers.date.format.LocalDateTimeFormatter;
import selenium.boot.hamcrest.matchers.date.format.LocalTimeFormatter;
import selenium.boot.hamcrest.matchers.date.format.ZonedDateTimeFormatter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;



/**
 * Unit test for the {@link ZonedDateTimeFormatter} class
 *
 * @author Stewart Bissett
 */
public class FormatterTests extends AbstractMatcherTest
{
    //---------------------------------------------------------------------
    // Date Matchers
    //---------------------------------------------------------------------

    @Test
    public void canDescribeDate() throws Exception
    {
        describeTestCase();

        String description = new DateFormatter().describe( Dates.AUG_04_2015_1159_AS_DATE );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM" ),
                              "\"date description\" matches " + desc
        );
    }

    @Test
    public void canDescribeDateFormatter()
    {
        describeTestCase();

        String description = new DateFormatter().describe( Dates.AUG_04_2015_1159_AS_DATE );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015" ),
                              "\"date description\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDate Matchers
    //---------------------------------------------------------------------

    public void canDescribeLocalDate() throws Exception
    {
        describeTestCase();

        String description = new LocalDateFormatter().describe( Dates.AUG_04_2015);
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015" ),
                              "\"local-date description\" matches " + desc
        );
    }

    @Test
    public void canDescribeLocalDateFormatter()
    {
        describeTestCase();

        String description = new DateFormatter().describe( Dates.AUG_04_2015_1159_AS_DATE );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015" ),
                              "\"date description\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalDateTime Matchers
    //---------------------------------------------------------------------

    public void canDescribeLocalDateTime() throws Exception
    {
        describeTestCase();

        String description = new LocalDateTimeFormatter().describe( Dates.AUG_04_2015_1159 );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM" ),
                              "\"local-datetime description\" matches " + desc
        );
    }

    public void canDescribeLocalDateTimeFormatter9() throws Exception
    {
        describeTestCase();

        String description = new LocalDateTimeFormatter().describe( Dates.AUG_04_2015_1159 );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015" ),
                              "\"local-datetime description\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // ZonedDateTime Matchers
    //---------------------------------------------------------------------

    public void canDescribeZonedDateTime() throws Exception
    {
        describeTestCase();

        String description = new ZonedDateTimeFormatter().describe( Dates.AUG_04_2015_11AM_UTC );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM +0000" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015 11:59:00.000 AM +0000" ),
                              "\"zoned-datetime description\" matches " + desc
        );
    }

    public void canDescribeZonedDateTimeFormatter() throws Exception
    {
        describeTestCase();

        String description = new ZonedDateTimeFormatter().describe( Dates.AUG_04_2015_11AM_UTC );
        String desc = getDescription( CoreMatchers.equalTo( "Tue, 04 Aug 2015" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "Tue, 04 Aug 2015" ),
                              "\"zoned-datetime description\" matches " + desc
        );
    }

    //---------------------------------------------------------------------
    // LocalTime Matchers
    //---------------------------------------------------------------------

    public void canDescribeLocalTime() throws Exception
    {
        describeTestCase();

        String description = new LocalTimeFormatter().describe( LocalTime.NOON.minus( 1, ChronoUnit.SECONDS ) );
        String desc = getDescription( CoreMatchers.equalTo( "11:59:59 AM" ) );
        Assertion.assertThat( description,
                              CoreMatchers.equalTo( "11:59:59 AM" ),
                              "\"local-time description\" matches " + desc
        );
    }
}
