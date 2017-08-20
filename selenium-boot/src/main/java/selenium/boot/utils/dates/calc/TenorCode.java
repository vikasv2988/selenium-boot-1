package selenium.boot.utils.dates.calc;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public enum TenorCode
{
    OVERNIGHT( "ON", false ),

    SPOT( "SP", false ),

    TOM_NEXT( "TN", false ),

    SPOT_NEXT( "SN", false ),

    DAY( "D", true ),

    WEEK( "W", true ),

    MONTH( "M", true ),

    YEAR( "Y", true );

    private final String code;

    private final boolean acceptUnits;

    private TenorCode( final String code, final boolean acceptUnits )
    {
        this.code = code;
        this.acceptUnits = acceptUnits;
    }
    
    /**
     * @param code string representation of the {@code TenorCode}
     *
     * @return a {@code TenorCode} represented by the string argument
     */
    public static TenorCode fromCode( final String code )
    {
        for( final TenorCode ct : TenorCode.values() )
        {
            if( ct.getCode().equals( code ) )
            {
                return ct;
            }
        }
        return null;
    }

    /**
     * @return the string representation of this {@code TenorCode}
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @return true if the TenorCode can have units e.g. 1 Day, 3 Week but not 6 OVERNIGHT or 5 SPOT/SP
     */
    public boolean acceptUnits()
    {
        return acceptUnits;
    }
}
