package selenium.boot.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;



/**
 * The TemporaryFolder allows creation of files and folders that should be deleted when the test method finishes (whether it passes or fails).
 * By default no exception will be thrown in case the deletion fails.
 * <p>
 * Example of usage:
 * <pre>
 * public static class HasTempFolder {
 *  &#064;Rule
 *  public TemporaryFolder folder= new TemporaryFolder();
 *
 *  &#064;Test
 *  public void testUsingTempFolder() throws IOException {
 *      File createdFile = folder.newFile(&quot;myfile.txt&quot;);
 *      File createdFolder = folder.newFolder(&quot;subfolder&quot;);
 *      // ...
 *     }
 * }
 * </pre>
 *
 * <p>TemporaryFolder rule supports assured deletion mode, which
 * will fail the test in case deletion fails with {@link AssertionError}.
 *
 * <p>Creating TemporaryFolder with assured deletion:
 * <pre>
 *  &#064;Rule
 *  public TemporaryFolder folder= TemporaryFolder.builder().assureDeletion().build();
 * </pre>
 *
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @see <a href='https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/rules/TemporaryFolder.java'>TemporaryFolder</a>
 * @since 1.0
 */
public class TemporaryFolder extends LifeCycleResource
{
    //region Static definitions, members, initialization and constructors

    //---------------------------------------------------------------------
    // Static definitions, members, initialization and constructors
    //---------------------------------------------------------------------

    private final Logger log = LoggerFactory.getLogger( TemporaryFolder.class.getName() );

    private static final int TEMP_DIR_ATTEMPTS = 10000;

    private static final String TMP_PREFIX = "testng";

    private final File parentFolder;

    private final boolean assureDeletion;

    private File folder;

    /**
     * Create a temporary folder which uses system default temporary-file
     * directory to create temporary resources.
     */
    public TemporaryFolder()
    {
        this( ( File ) null );
    }

    /**
     * Create a temporary folder which uses the specified directory to create temporary resources.
     *
     * @param parentFolder folder where temporary resources will be created.
     *                     If {@code null} then system default temporary-file directory is used.
     */
    public TemporaryFolder( File parentFolder )
    {
        this.parentFolder = parentFolder;
        this.assureDeletion = false;
    }

    /**
     * Create a {@code TemporaryFolder} initialized with values from a builder.
     */
    protected TemporaryFolder( Builder builder )
    {
        this.parentFolder = builder.parentFolder;
        this.assureDeletion = builder.assureDeletion;
    }

    //endregion

    /**
     * Returns a new builder for building an instance of {@link selenium.boot.logging.TemporaryFolder}.
     */
    public static Builder builder()
    {
        return new Builder();
    }

    @Override
    protected void before() throws Throwable
    {
        create();
    }

    /**
     * for testing purposes only. Do not use.
     */
    public void create() throws IOException
    {
        folder = createTemporaryFolderIn( parentFolder );
    }

    @SuppressWarnings( "ResultOfMethodCallIgnored" )
    private File createTemporaryFolderIn( File parentFolder ) throws IOException
    {
        File createdFolder = null;
        for( int i = 0; i < TEMP_DIR_ATTEMPTS; ++i )
        {
            /* Use createTempFile to get a suitable folder name. */
            String suffix = ".tmp";
            File tmpFile = File.createTempFile( TMP_PREFIX, suffix, parentFolder );
            String tmpName = tmpFile.toString();

            /* Discard .tmp suffix of tmpName. */
            String folderName = tmpName.substring( 0, tmpName.length() - suffix.length() );
            createdFolder = new File( folderName );

            if( createdFolder.mkdir() )
            {
                tmpFile.delete();
                return createdFolder;
            }

            tmpFile.delete();
        }

        throw new IOException( "Unable to create temporary directory in: "
                                       + parentFolder.toString() + ". Tried " + TEMP_DIR_ATTEMPTS + " times. "
                                       + "Last attempted to create: " + createdFolder.toString() );
    }

    // testing purposes only

    @Override
    protected void after()
    {
        delete();
    }

    /**
     * @return the location of this temporary folder.
     */
    public File getRoot()
    {
        if( folder == null )
        {
            throw new IllegalStateException( "The temporary folder has not yet been created" );
        }
        return folder;
    }

    /**
     * @return a new fresh file with the given name under the temporary folder.
     */
    public File newFile( String fileName ) throws IOException
    {
        File file = new File( getRoot(), fileName );
        if( !file.createNewFile() )
        {
            throw new IOException( "a file with the name \'" + fileName + "\' already exists in the test folder" );
        }
        return file;
    }

    /**
     * @return a new fresh file with a random name under the temporary folder.
     */
    public File newFile() throws IOException
    {
        return File.createTempFile( TMP_PREFIX, null, getRoot() );
    }

    /**
     * @return a new fresh folder with the given path under the temporary folder.
     */
    public File newFolder( String path ) throws IOException
    {
        return newFolder( new String[] { path } );
    }

    /**
     * @return a new fresh folder with the given paths under the temporary folder.
     * For example, if you pass in the strings {@code "parent"} and {@code "child"}
     * then a directory named {@code "parent"} will be created under the temporary folder
     * and a directory named {@code "child"} will be created under the newly-created {@code "parent"} directory.
     */
    public File newFolder( String... paths ) throws IOException
    {
        if( paths.length == 0 )
        {
            throw new IllegalArgumentException( "must pass at least one path" );
        }

        /*
         * Before checking if the paths are absolute paths, check if create() was ever called,
         * and if it wasn't, throw IllegalStateException.
         */
        File root = getRoot();
        for( String path : paths )
        {
            if( new File( path ).isAbsolute() )
            {
                throw new IOException( "folder path \'" + path + "\' is not a relative path" );
            }
        }

        File relativePath = null;
        File file = root;
        boolean lastMakeDirsCallSuccessful = true;

        for( int i = 0; i < paths.length; i++ )
        {
            relativePath = new File( relativePath, paths[ i ] );
            file = new File( root, relativePath.getPath() );

            lastMakeDirsCallSuccessful = file.mkdirs();
            if( !lastMakeDirsCallSuccessful && !file.isDirectory() )
            {
                throw new IOException( "could not create a folder with the path \'" + relativePath.getPath() + "\'" );
            }
        }
        if( !lastMakeDirsCallSuccessful )
        {
            throw new IOException( "a folder with the path \'" + relativePath.getPath() + "\' already exists" );
        }
        return file;
    }

    /**
     * Returns a new fresh folder with a random name under the temporary folder.
     */
    public File newFolder() throws IOException
    {
        return createTemporaryFolderIn( getRoot() );
    }

    /**
     * Delete all files and folders under the temporary folder.
     */
    public void delete()
    {
        if( !tryDelete() )
        {
            if( assureDeletion )
            {
                log.warn( "Unable to clean up temporary folder " + folder );
            }
        }
    }

    /**
     * Tries to delete all files and folders under the temporary folder and
     * returns whether deletion was successful or not.
     *
     * @return {@code true} if all resources are deleted successfully,
     * {@code false} otherwise.
     */
    protected boolean tryDelete()
    {
        if( folder == null )
        {
            return true;
        }
        return recursiveDelete( folder );
    }

    private boolean recursiveDelete( File file )
    {
        /* Try deleting file before assuming file is a directory to prevent following symbolic links */
        if( file.delete() )
        {
            return true;
        }

        boolean result = true;
        File[] files = file.listFiles();

        if( files != null )
        {
            for( File each : files )
            {
                result = result && recursiveDelete( each );
            }
        }
       
        return result && file.delete();
    }


    //region Implementation of inner Builder class

    //---------------------------------------------------------------------
    // Implementation of inner Builder class
    //---------------------------------------------------------------------

    /**
     * Builds an instance of {@link selenium.boot.logging.TemporaryFolder}.
     */
    public static class Builder
    {
        private File parentFolder;

        private boolean assureDeletion;

        protected Builder() {}

        /**
         * Specifies which folder to use for creating temporary resources.
         * If {@code null} then system default temporary-file directory is used.
         *
         * @return this
         */
        public Builder parentFolder( File parentFolder )
        {
            this.parentFolder = parentFolder;
            return this;
        }

        /**
         * Setting this flag assures that no resources are left un-deleted.
         * Failure to fulfill the assurance results in failure of tests with an {@link AssertionError}.
         *
         * @return this
         */
        public Builder assureDeletion()
        {
            this.assureDeletion = true;
            return this;
        }

        /**
         * Builds a {@code TemporaryFolder} instance using the values in this builder.
         */
        public TemporaryFolder build()
        {
            return new TemporaryFolder( this );
        }
    }

    //endregion
}
