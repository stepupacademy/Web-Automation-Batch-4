import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {

    @Test
    public void test1()
    {
        System.out.println("First Line");
        Assert.assertEquals("Test","Test");
        System.out.println("Second Line");
    }
    @Test
    public void test2()
    {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("First Line");
        softAssert.assertEquals("Test","Test");
        softAssert.assertTrue(true);
        softAssert.assertFalse((1==2));
        System.out.println("Second Line");
        softAssert.assertAll();
        System.out.println("Third Line");
    }
}
