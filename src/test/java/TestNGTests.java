import org.testng.annotations.*;

public class TestNGTests {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test (priority = 3)
    public void Test1() {
        System.out.println("First Test");
    }

    @Test(priority = 1)
    public void Test2()
    {
        System.out.println("Second Test");
    }
    @Test (priority = 2,enabled = false)
    public void Test3()
    {
        System.out.println("This is a Test");
    }
}
