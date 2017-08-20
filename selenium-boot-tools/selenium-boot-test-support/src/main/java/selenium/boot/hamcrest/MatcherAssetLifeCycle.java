package selenium.boot.hamcrest;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
interface MatcherAssetLifeCycle
{
    /**
     * Run the assert command in parameter.
     */
    void executeAssert( MatcherAssertEvent<?> assertCommand );

    /**
     * Invoked when an assert succeeds.
     */
    void onAssertSuccess( MatcherAssertEvent<?> assertCommand );

    /**
     * Invoked when an assert fails.
     */
    void onAssertFailure( MatcherAssertEvent<?> assertCommand, AssertionError ex );

    /**
     * Invoked before an assert is run.
     */
    void onBeforeAssert( MatcherAssertEvent<?> assertCommand );

    /**
     * Invoked after an assert is run.
     */
    void onAfterAssert( MatcherAssertEvent<?> assertCommand );
}
