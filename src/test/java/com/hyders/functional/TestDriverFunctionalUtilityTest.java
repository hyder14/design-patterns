package com.hyders.functional;

import com.hyders.designpatterns.factory.pizzafactory.TestDrive;
import junit.framework.TestCase;
import org.junit.Assert;

public class TestDriverFunctionalUtilityTest extends TestCase {

    private TestDriverFunctionalUtility utility;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testForEach() {

    }

    public void testSquare() {

        int x = TestDriverFunctionalUtility.square(10);

        Assert.assertEquals(x,100);
    }

    public void testAddOne() {
        int x =  TestDriverFunctionalUtility.addOne(TestDriverFunctionalUtility.square(10));

        Assert.assertEquals(x,101);
    }
}