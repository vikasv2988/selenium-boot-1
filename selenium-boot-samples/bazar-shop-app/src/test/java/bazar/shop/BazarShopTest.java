package bazar.shop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.testng.annotations.Test;
import selenium.boot.test.AbstractTestNgTest;



/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
@SpringBootTest( webEnvironment = WebEnvironment.NONE )
public class BazarShopTest extends AbstractTestNgTest
{
    //region initialization and constructors section

    private static final Logger log = LoggerFactory.getLogger( BazarShopTest.class );

    public BazarShopTest()
    {
        super();
    }

    //endregion


    @Test
    public void test()
    {
        System.out.println( "BazarShopTest.test" );
    }
}
