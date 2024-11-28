import org.testng.annotations.*;

public class demoAnnotationorder {

    @Test
    public void test1(){
        System.out.println("test1 fired");
    }
    @Test
    public void test2(){
        System.out.println("test2 fired");
    }
    @BeforeMethod
    public void beforemethod(){
        System.out.println("before method fired");
    }
    @AfterMethod
    public void aftermethod(){
        System.out.println("after method fired");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("before class fired");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("after class fired");
    }
    @BeforeSuite
    public void beforesuite(){
        System.out.println("before suite fired");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("after suite fired");
    }
    @BeforeTest
    public  void beforetest(){
        System.out.println("before test fired");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("after test fired");
    }

}
