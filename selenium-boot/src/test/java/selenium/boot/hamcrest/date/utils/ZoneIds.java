/**
 *
 */


package selenium.boot.hamcrest.date.utils;


import java.time.ZoneId;



/**
 * Static repository of {@link java.time.ZoneId}
 *
 * @author Stewart Bissett
 */
public abstract class ZoneIds
{

    public static final ZoneId UTC = ZoneId.of( "UTC" );

    public static final ZoneId CET = ZoneId.of( "Europe/Paris" );

    public static final ZoneId EST = ZoneId.of( "America/New_York" );

}
