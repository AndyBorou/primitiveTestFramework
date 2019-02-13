package project2;

import helper.GroupTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRunUnitGroupTest extends GroupTypes {

    @BeforeMethod (groups = UNIT)
    private void beforeMethod(){
        System.out.println("some before test actions " + UNIT);
    }

    @Test(groups = UNIT)
    void test2(){
        System.out.println("some test " + UNIT);
    }
}
