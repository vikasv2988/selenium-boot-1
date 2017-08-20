package selenium.boot.hamcrest.matchers.text.pattern.naming;


import java.util.Arrays;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class Path
{

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final String[] components;

    private final int offset;

    public Path( String... components )
    {
        this.components = components;
        this.offset = 0;
    }

    private Path( String[] components, int offset )
    {
        this.components = components;
        this.offset = offset;
    }

    //endregion

    public static Path parse( String pathAsString )
    {
        return new Path( pathAsString.split( "\\." ) );
    }

    public String head()
    {
        return component( 0 );
    }

    public String component( int i )
    {
        return components[ offset + i ];
    }

    public Path tail()
    {
        return new Path( this.components, offset + 1 );
    }

    @Override
    public int hashCode()
    {
        return offset ^ Arrays.hashCode( components );
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
        {
            return true;
        }
        if( obj == null )
        {
            return false;
        }
        if( getClass() != obj.getClass() )
        {
            return false;
        }

        final Path other = ( Path ) obj;

        if( size() != other.size() )
        {
            return false;
        }

        for( int i = 0; i < this.size(); i++ )
        {
            if( !component( i ).equals( other.component( i ) ) )
            {
                return false;
            }
        }

        return true;
    }

    public int size()
    {
        return this.components.length - offset;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for( String component : components )
        {
            if( builder.length() > 0 )
            {
                builder.append( "." );
            }
            builder.append( component );
        }

        return builder.toString();
    }
}
