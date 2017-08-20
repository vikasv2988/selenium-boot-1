package selenium.boot.hamcrest;


/**
 * @author <a href="mailto:solmarkn@gmail.com">Dani Vainstein</a>
 * @version %I%, %G%
 * @since 2.0
 */
public class CoreMatchersTests //extends AbstractAssertion
{
    //region initialization and constructors section

    public CoreMatchersTests()
    {
        super();
    }

    //endregion



    //region Tests

    //---------------------------------------------------------------------
    // Tests
    //---------------------------------------------------------------------

//    @Test(
//            enabled = true,
//            description = "Validates descriptions of NumericMatchers#greaterThan(), #greaterThanOrEqualTo() "  +
//                                  " #comparesEqualTo(), #lessThanOrEqualTo() and #lessThan()"
//    )
//    public void numericMatchersDescription() throws Exception
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//
//        assertDescription( greaterThan( 1 ), "a value greater than <1>" );
//        assertDescription( greaterThanOrEqualTo( 1 ), "a value equal to or greater than <1>" );
//        assertDescription( comparesEqualTo( 1 ), "a value equal to <1>" );
//        assertDescription( lessThanOrEqualTo( 1 ), "a value less than or equal to <1>" );
//        assertDescription( lessThan( 1 ), "a value less than <1>" );
//
//        assertAll();
//    }
//
//    @Test(
//            enabled = true,
//            description = "Validates mismatch descriptions of #greaterThan(), #greaterThanOrEqualTo() " +
//                                  " #comparesEqualTo(), #lessThanOrEqualTo() and #lessThan()"
//    )
//    public void numericMismatchDescription()  throws Exception
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//
//        assertMismatchDescription( greaterThan( 1 ), 0, "<0> was less than <1>" );
//        assertMismatchDescription( greaterThan( 1 ), 1, "<1> was equal to <1>" );
//        assertMismatchDescription( lessThan( 0 ), 1, "<1> was greater than <0>" );
//        assertMismatchDescription( lessThan( 2 ), 2, "<2> was equal to <2>" );
//
//        assertAll();
//    }
//
//    @Test(
//            enabled = true,
//            dependsOnMethods = { "numericMismatchDescription" },
//            description = "Validates NumericMatchers#greaterThan() matcher."
//    )
//    public void testComparesObjectsForGreaterThan() throws Exception
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//        CheckpointFactory.createCheckpoint( "2_greater_than_1",
//                                            "validates that 2 greaterThan 1",
//                                            2,
//                                            greaterThan( 1 )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "1.1_greater_than_1.0",
//                                            "validates that 1.1 greaterThan 1.0",
//                                            1.1,
//                                            greaterThan( 1.0 )
//        ).execute();
//
//
//        CheckpointFactory.createCheckpoint( "0_not_greater_than_1",
//                                            "validates that 0 is not greaterThan 1",
//                                            0,
//                                            not( greaterThan( 1 ) )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "1.1_greater_than_1.0",
//                                            "validates that 1.1 greaterThan 1.0",
//                                            new BigDecimal( "1.1" ),
//                                            greaterThan( new BigDecimal( "1.0" ) )
//        ).execute();
//
//
//        CheckpointFactory.assertAll();
//
//    }
//
//    @Test(
//            enabled = true,
//            dependsOnMethods = { "numericMismatchDescription" },
//            description = "Validates NumericMatchers#lessThan() matcher."
//    )
//    public void testComparesObjectsForLessThan() throws Exception
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//        CheckpointFactory.createCheckpoint( "2_lessThan_3",
//                                            "validates that 2 lessThan 3",
//                                            2, lessThan( 3 )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "0_not_lessThan_0",
//                                            "validates that 0 is not lessThan 0",
//                                            0, not( lessThan( 0 ) )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "1.0f_lessThan_1.1f",
//                                            "validates that 1.0f lessThan 1.1f",
//                                            1.0f, lessThan( 1.1f )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "1.0d_lessThan_1.1d",
//                                            "validates that 1.0d is lessThan 1.1d",
//                                            1.0d, lessThan( 1.1d )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "2L_lessThan_3L",
//                                            "validates that 2L is lessThan 3L",
//                                            2L, lessThan( 3L )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "2L_lessThan_3L",
//                                            "validates that 10( BD ) is not lessThan 10.00( BD )",
//                                            new BigDecimal( "10" ), not( lessThan( new BigDecimal( "10.00" ) ) )
//        ).execute();
//
//        CheckpointFactory.assertAll();
//    }
//
//    @Test(
//            enabled = true,
//            dependsOnMethods = { "numericMismatchDescription" },
//            description = "Validates NumericMatchers#comparesEqualTo() matcher."
//    )
//    public void testComparesObjectsForEquality()
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//        CheckpointFactory.createCheckpoint( "3_compares_equals_3",
//                                            "validates that 3 comparesEqualTo 3",
//                                            3,
//                                            comparesEqualTo( 3 )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "3_not_compares_equals_4",
//                                            "validates that 3 not comparesEqualTo 4",
//                                            3,
//                                            not( comparesEqualTo( 4 ) )
//        ).execute();
//
//        CheckpointFactory.assertAll();
//    }
//
//    @Test(
//            enabled = true,
//            dependsOnMethods = { "numericMismatchDescription", "testComparesObjectsForEquality" },
//            description = "Validates NumericMatchers#lessThanOrEqualTo() and  NumericMatchers#greaterThanOrEqualTo() matcher."
//    )
//    public void testAllowsForInclusiveComparisons() throws Exception
//    {
//        log.info( "testing [ {} ]", Reporter.getCurrentTestResult().getMethod().getDescription() );
//        CheckpointFactory.createCheckpoint( "3_lessThanOrEqualTo_3",
//                                            "validates that 3 lessThanOrEqualTo 3",
//                                            3,
//                                            lessThanOrEqualTo( 3 )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "2_not_greaterThanOrEqualTo_3",
//                                            "validates that 2 not greaterThanOrEqualTo 3",
//                                            3,
//                                            not( lessThanOrEqualTo( 2 ) )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "3_greaterThanOrEqualTo_3",
//                                            "validates that 3 greaterThanOrEqualTo 4",
//                                            3,
//                                            greaterThanOrEqualTo( 3 )
//        ).execute();
//
//        CheckpointFactory.createCheckpoint( "3_not_greaterThanOrEqualTo_2",
//                                            "validates that 2 not greaterThanOrEqualTo 3",
//                                            2,
//                                            not( greaterThanOrEqualTo( 3 ) )
//        ).execute();
//
//        CheckpointFactory.assertAll();
//    }

    ///endregion
}
