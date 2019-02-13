package project2;

import helper.GroupTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRunRegressionGroupTest extends GroupTypes {

    @BeforeMethod()
    private void beforeMethod(){
        System.out.println("some before test actions ");
    }

    @Test(groups = REGRESSION)
    public void test2(){
        System.out.println("some test " + REGRESSION);
    }
}
