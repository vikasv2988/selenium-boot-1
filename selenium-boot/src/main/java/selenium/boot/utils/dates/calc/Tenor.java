package selenium.boot.utils.dates.calc;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;



/**
 * Holds only valid unit and TenorCode: Day, Week, Month, Year, Overnight,
 * Spot.
 *
 * @author Benoit Xhenseval
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@EqualsAndHashCode( of = { "units", "code" } )
public class Tenor implements Serializable
{
    //region initialization and constructors section

    private final Logger log = LoggerFactory.getLogger( Tenor.class );

    private static final long serialVersionUID = 1L;

    @Getter( AccessLevel.PUBLIC )
    private final int units;

    @Getter( AccessLevel.PUBLIC )
    private final TenorCode code;


    //endregion

    public boolean hasUnits()
    {
        return code.acceptUnits();
    }

    @Override
    public String toString()
    {
        return ( units != 0 ? String.valueOf( units ) : "" ) + code.getCode();
    }

    /**
     * @param tenor the tenor, e.g. 1D, 3W, SP etc
     *
     * @throws IllegalArgumentException if the tenor is not a valid on
     */
    public static Tenor valueOf( final String tenor )
    {
        final StringBuilder unitsBuf = new StringBuilder();
        final StringBuilder codeBuf = new StringBuilder();
        final boolean invalid = false;
        final int size = tenor.length();

        parseCode( tenor, unitsBuf, codeBuf, invalid, size );

        int parsedUnits = 0;
        if( unitsBuf.length() > 0 )
        {
            parsedUnits = Integer.parseInt( unitsBuf.toString() );
        }
        final TenorCode parsedCode = TenorCode.fromCode( codeBuf.toString() );
        if( parsedCode == null )
        {
            throw new IllegalArgumentException( "[" + codeBuf + "] is not a valid TenorCode" );
        }

        if( !parsedCode.acceptUnits() && unitsBuf.length() > 0 )
        {
            throw new IllegalArgumentException( "[" + codeBuf + "] does not accept units" );
        }

        if( parsedCode.acceptUnits() && unitsBuf.length() == 0 )
        {
            throw new IllegalArgumentException( "[" + codeBuf + "] requires units" );
        }

        return new Tenor( parsedUnits, parsedCode );
    }

    private static void parseCode( final String tenor, final StringBuilder unitsBuf, final StringBuilder codeBuf, final boolean invalid, final int size )
    {
        for( int i = 0; i < size && !invalid; i++ )
        {
            final char c = tenor.charAt( i );

            if( c >= '0' && c <= '9' )
            {
                if( codeBuf.length() != 0 )
                {
                    throw new IllegalArgumentException( "[" + tenor + "] is not a valid tenor" );
                }
                else
                {
                    unitsBuf.append( c );
                }
            }
            else
            {
                codeBuf.append( c );
            }
        }
    }
}
