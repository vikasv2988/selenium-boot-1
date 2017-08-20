package selenium.boot.hamcrest.matchers.text.pattern.naming;


import java.util.HashMap;
import java.util.Map;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 1.0
 */
public class GroupNamespace
{

    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final GroupNamespace parent;

    private final Map<String, GroupNamespace> bindings = new HashMap<String, GroupNamespace>();

    private final IndexSequence nextGroupIndex;

    private final int groupIndex;

    public GroupNamespace()
    {
        this( null, new IndexSequence() );
    }

    private GroupNamespace( GroupNamespace parent, IndexSequence nextGroupIndex )
    {
        this.parent = parent;
        this.nextGroupIndex = nextGroupIndex;
        this.groupIndex = nextGroupIndex.next();
    }

    //endregion

    public int toIndex()
    {
        return groupIndex;
    }

    public GroupNamespace create( String name )
    {
        if( bindings.containsKey( name ) )
        {
            throw new IllegalArgumentException( "duplicate name '" + name + "'" );
        }

        GroupNamespace child = new GroupNamespace( this, nextGroupIndex );
        bindings.put( name, child );
        return child;
    }

    public int resolve( String pathAsString )
    {
        return resolve( Path.parse( pathAsString ) );
    }

    public int resolve( Path path )
    {
        return environmentContaining( path.head() ).resolveInternally( path.tail() );
    }

    public int resolveInternally( Path path )
    {
        if( path.size() == 0 )
        {
            return groupIndex;
        }
        else if( bindings.containsKey( path.head() ) )
        {
            return bindings.get( path.head() ).resolveInternally( path.tail() );
        }
        else
        {
            throw new IllegalArgumentException( "name '" + path.head() + "' not bound" );
        }
    }

    private GroupNamespace environmentContaining( String name )
    {
        if( bindings.containsKey( name ) )
        {
            return bindings.get( name );
        }
        else if( parent != null )
        {
            return parent.environmentContaining( name );
        }
        else
        {
            throw new IllegalArgumentException( "name '" + name + "' not bound" );
        }
    }
}
