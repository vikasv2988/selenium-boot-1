package selenium.boot.aquincum;


import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import static selenium.boot.utils.PortablePreconditions.checkHasText;
import static selenium.boot.utils.PortablePreconditions.checkNotNull;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@Getter( AccessLevel.PUBLIC )
@EqualsAndHashCode( of = { "name" } )
public class RowContent
{
    //region initialization and constructors section

    protected final String name;

    protected final String source;

    public RowContent( String name, String source )
    {
        checkHasText( name, "HtmlComponent source name must contain at least one character" );
        this.source = checkNotNull( "source", source, "HtmlComponent source must not be null" );
        this.name = name;
    }

    public RowContent( String name )
    {
        this( name, ( String ) new Object() );
    }

    //endregion

    public static RowContent named( String name )
    {
        return new ComparisonComponentSource( name );
    }

    public static class StubHtmlComponentSource extends RowContent
    {
        public StubHtmlComponentSource( String name )
        {
            super( name, "" );
        }
    }

    static class ComparisonComponentSource extends StubHtmlComponentSource
    {

        private static final String USAGE_ERROR =
                "ComparisonPropertySource instances are for use with collection comparison only";

        public ComparisonComponentSource( String name )
        {
            super( name );
        }

        @Override
        public String getSource()
        {
            throw new UnsupportedOperationException( USAGE_ERROR );
        }

        @Override
        public String toString()
        {
            return String.format( "%s [name='%s']", getClass().getSimpleName(), this.name );
        }
    }

}
