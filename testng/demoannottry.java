import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class demoannottry {

    @Test(dependsOnMethods = {"test_3"})
    public void test_1(){
        System.out.println("Test1 fired");
    }
    @Test(dependsOnMethods = {"test_1"})
    public void test_2(){
        System.out.println("Test2 fired");
    }
    @Test
    public void test_3(){
        System.out.println("test3 fired");
    }

}
