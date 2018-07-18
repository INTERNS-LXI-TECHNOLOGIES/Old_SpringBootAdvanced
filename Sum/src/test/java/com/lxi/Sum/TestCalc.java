import junit.framework.Assert;
import junit.framework.TestCase;
public class TestCalc extends TestCase
{
	public void testPrintHelloWorld() {

		Assert.assertEquals(Calc.getHelloWorld(), "Hello World");

	}
}