package selenium.boot.autoconfigure.excel;


import com.google.common.collect.Lists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.integration.file.DefaultDirectoryScanner;
import org.springframework.integration.file.DirectoryScanner;
import org.springframework.integration.file.filters.RegexPatternFileListFilter;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */

@Getter( AccessLevel.PUBLIC )
public class ExcelScanner implements ResourceLoaderAware
{
    //region initialization and constructors section

    @Getter( AccessLevel.NONE )
    private static final Logger log = LoggerFactory.getLogger( ExcelScanner.class.getName() );

    private ResourceLoader resourceLoader = new FileSystemResourceLoader();

    @Value( "data.excel.supported-extensions" )
    @Setter( AccessLevel.PUBLIC )
    private Pattern supportedExtensions;

    private List<Resource> excelResources;

    private Path startFolder;

    //endregion

    /**
     * Set the ResourceLoader that this object runs in.
     *
     * This might be a ResourcePatternResolver, which can be checked through {@code instanceof ResourcePatternResolver}.
     * See also the {@link org.springframework.core.io.support.ResourcePatternUtils#getResourcePatternResolver} method.
     *
     * Invoked after population of normal bean properties but before an init callback
     * like InitializingBean's {@code afterPropertiesSet} or a custom init-method.
     * Invoked before ApplicationContextAware's {@code setApplicationContext}.
     *
     * @param resourceLoader ResourceLoader object to be used by this object
     *
     * @see org.springframework.core.io.support.ResourcePatternResolver
     * @see org.springframework.core.io.support.ResourcePatternUtils#getResourcePatternResolver
     */
    @Override
    public void setResourceLoader( ResourceLoader resourceLoader )
    {
        this.resourceLoader = resourceLoader;
    }

    @Required
    public void setStartFolder( Path startFolder )
    {
        this.startFolder = startFolder;
    }


    /**
     * scanning a directory for file matching {@code pattern}
     *
     * @see org.springframework.integration.file.filters.RegexPatternFileListFilter
     * @see #startFolder
     */
    public void scan()
    {
//        ListeningExecutorService service = SafeExecutors.newSingleThreadExecutor( "scanner" );
//        service.execute( () ->
//                         {
                             try
                             {
                                  /* scanning directory for marching excel files */
                                 if( log.isDebugEnabled() ) log.debug( "scanning for excel files on -> [ {} ]", startFolder.toString() );
                                 DirectoryScanner scanner = new DefaultDirectoryScanner();
                                 scanner.setFilter( new RegexPatternFileListFilter( supportedExtensions ) );

                                 List<File> files = scanner.listFiles( startFolder.toFile() );
                                 if( log.isDebugEnabled() )
                                 {
                                     log.debug( "found <{}> files matching pattern [ {} ]", files.size(), supportedExtensions );
                                 }

                                 /* populating excel resources list */
                                 excelResources = Lists.newArrayList();
                                 for( File f : files )
                                 {
                                     Resource resource = resourceLoader.getResource( f.toPath().toString() );
                                     excelResources.add( resource );
                                 }
                             }
                             catch( Exception e )
                             {
                                 e.printStackTrace();
                             }
//                         } );
    }

    public void tearDown()
    {
        if( excelResources != null && excelResources.size() > 0 )
        {
            excelResources.forEach( new Consumer<Resource>()
            {

                @Override
                public void accept( Resource excelFileResource )
                {
                   // excelFileResource.getWorkbook().close();
                }
            } );

            excelResources.clear();
        }
    }

}
