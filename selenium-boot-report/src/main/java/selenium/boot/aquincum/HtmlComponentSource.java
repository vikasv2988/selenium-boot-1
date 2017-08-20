package selenium.boot.aquincum;


import org.springframework.lang.Nullable;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public interface HtmlComponentSource extends HtmlComponentRenderer, Iterable<HtmlComponentSource>
{
    boolean contains( String name );

    @Nullable
    RowContent get( String name );
}
