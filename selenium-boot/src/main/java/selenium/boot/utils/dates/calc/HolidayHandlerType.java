package selenium.boot.utils.dates.calc;


import lombok.experimental.UtilityClass;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@UtilityClass
public class HolidayHandlerType
{
    /**
     * A Forward handler will move the date forward if it falls on a non working
     * day.
     */
    public static final String FORWARD = "forward";

    /**
     * A backward handler will move the date backward if it falls on a non
     * working day.
     */
    public static final String BACKWARD = "backward";

    /**
     * A modified following handler will move the date forward if it falls on a
     * non working day BUT, if the new date falls into another month, it will
     * revert to moving backward until it finds a working day.
     */
    public static final String MODIFIED_FOLLOWING = "modifiedFollowing";

    /**
     * A modified preceding handler will move the date backward if it falls on
     * a non working day BUT, if the new date falls into another month, it will
     * revert to moving forward until it finds a working day.
     */
    public static final String MODIFIED_PRECEDING = "modifiedPreceding";

    /**
     * A handler that moves the date forward unless the increment is negative
     * (eg moveByDays(-2)) in which case it behaves like a Backward handler.
     */
    public static final String FORWARD_UNLESS_MOVING_BACK = "forwardUnlessMovingBack";
}
