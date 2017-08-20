package selenium.boot.aquincum;


import org.apache.commons.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.PropertySource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class HtmlComponent implements HtmlComponentSource
{
    //region initialization and constructors section

    protected final Logger log;

    private final List<RowContent> contentList = new CopyOnWriteArrayList<>();

    /**
     * Create a new {@link HtmlComponent} object.
     */
    public HtmlComponent()
    {
        this.log = LoggerFactory.getLogger( getClass().getName() );
    }

    /**
     * Create a new {@code MutablePropertySources} from the given propertySources
     * object, preserving the original order of contained {@code PropertySource} objects.
     */
    public HtmlComponent( HtmlComponent component )
    {
        this();
//        for( RowContent propertySource : component.get(  ) )
//        {
//            addLast( propertySource );
//        }
    }


    //endregion



    @Override
    public StrBuilder toStrBuilder()
    {
        return null;
    }

    @Override
    public boolean contains( String name )
    {
        return this.contentList.contains( RowContent.named( name ) );
    }

    @Override
    public RowContent get( String name )
    {
        int index = this.contentList.indexOf( RowContent.named( name ) );
        return ( index != -1 ? this.contentList.get( index ) : null );
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<HtmlComponentSource> iterator()
    {
        return null;
    }

    //
//    @Override
//    public Iterator<RowContent> iterator()
//    {
//        return this.contentList.iterator();
//    }

    /**
     * Add the given content source object with highest precedence.
     */
    public void addFirst( RowContent content )
    {
        if( log.isDebugEnabled() )
        {
            log.debug( "Adding [ {} ] RowContent at first location", content.getName() );
        }

        removeIfPresent( content );
        this.contentList.add( 0, content );
    }

    /**
     * Add the given property source object with lowest precedence.
     */
    public void addLast( RowContent content) {

        if( log.isDebugEnabled() )
        {
            log.debug( "Adding [ {} ] RowContent to last location", content.getName() );
        }

        removeIfPresent( content );
        this.contentList.add( content );
    }


    /**
     * Add the given content source object with precedence immediately higher
     * than the named relative content source.
     */
    public void addBefore( String relativeContentName, RowContent content )
    {

        if( log.isDebugEnabled() )
        {
            log.debug( "Adding [ {} ] RowContent immediately before [ {} ]", content.getName(), relativeContentName );
        }

        assertLegalRelativeAddition( relativeContentName, content );
        removeIfPresent( content );
        int index = assertPresentAndGetIndex( relativeContentName );
        addAtIndex( index, content );
    }

    /**
     * Add the given content source object with precedence immediately lower
     * than the named relative content source.
     */
    public void addAfter( String relativeContentName, RowContent content )
    {
        if( log.isDebugEnabled() )
        {
            log.debug( "Adding [ {} ] RowContent immediately after [ {} ]", content.getName(), relativeContentName );
        }

        assertLegalRelativeAddition( relativeContentName, content );
        removeIfPresent( content );
        int index = assertPresentAndGetIndex( relativeContentName );
        addAtIndex( index + 1, content );
    }

    /**
     * Return the precedence of the given property source, {@code -1} if not found.
     */
    public int precedenceOf( RowContent content )
    {
        return this.contentList.indexOf( content );
    }

    /**
     * Remove and return the property content with the given name, {@code null} if not found.
     *
     * @param name the name of the content source to find and remove
     */
    @Nullable
    public RowContent remove( String name )
    {
        if( log.isDebugEnabled() )
        {
            log.debug( "Removing [ {} ] RowContent", name );
        }
        int index = this.contentList.indexOf( RowContent.named( name ) );
        return ( index != -1 ? this.contentList.remove( index ) : null );
    }

    /**
     * Replace the property source with the given name with the given property source object.
     *
     * @param name    the name of the property source to find and replace
     * @param content the replacement property source
     *
     * @throws java.lang.IllegalArgumentException if no property source with the given name is present
     * @see #contains
     */
    public void replace( String name, RowContent content )
    {

        if( log.isDebugEnabled() )
        {
            log.debug( "Replacing [ {} ] RowContent with [ {} ]", name, content.getName() );
        }

        int index = assertPresentAndGetIndex( name );
        this.contentList.set( index, content );
    }

    /**
     * @return the number of {@link RowContent} objects contained.
     */
    public int size()
    {
        return this.contentList.size();
    }


    @Override
    public String toString()
    {
        String[] names = new String[ this.size() ];
        for( int i = 0; i < size(); i++ )
        {
            names[ i ] = this.contentList.get( i ).getName();
        }
        return String.format( "[%s]", StringUtils.arrayToCommaDelimitedString( names ) );
    }

    /**
     * Ensure that the given property source is not being added relative to itself.
     */
    protected void assertLegalRelativeAddition( String relativeContentName, RowContent content )
    {
        String newContentName = content.getName();
        if( relativeContentName.equals( newContentName ) )
        {
            throw new IllegalArgumentException( String.format( "PropertySource named [%s] cannot be added relative to itself", newContentName ) );
        }
    }

    /**
     * Remove the given property source if it is present.
     */
    protected void removeIfPresent( RowContent content )
    {
        this.contentList.remove( content );
    }

    /**
     * Add the given property source at a particular index in the list.
     */
    private void addAtIndex( int index, RowContent content )
    {
        removeIfPresent( content );
        this.contentList.add( index, content );
    }

    /**
     * Assert that the named content source is present and return its index.
     *
     * @param name the {@linkplain PropertySource#getName() name of the content source} to find
     *
     * @throws IllegalArgumentException if the named content source is not present
     */
    private int assertPresentAndGetIndex( String name )
    {
        int index = this.contentList.indexOf( RowContent.named( name ) );
        if( index == -1 )
        {
            throw new IllegalArgumentException( String.format( "RowContent named [%s] does not exist", name ) );
        }
        return index;
    }


}
