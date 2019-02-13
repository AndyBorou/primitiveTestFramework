package project2;

import helper.GroupTypes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestRunAcceptanceGroupTest extends GroupTypes{

    @BeforeMethod(groups = UNIT)
    private void beforeMethod(){
        System.out.println("some before test UNIT actions in acceptance test");
    }

    @Test(groups = ACCEPTANCE)
    public void test(){
        System.out.println("some test " + ACCEPTANCE);
    }
}
