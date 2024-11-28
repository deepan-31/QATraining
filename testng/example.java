import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertSame;

public class example
{
    @Test
    public void testt1(){
        String d = "hi";
        String a = d;
        String b = d;

        assertSame(a,b);
    }
}
