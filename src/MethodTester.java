import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public final class MethodTester {

	@Test
	public void testEP01() { assertEquals("233168", Methods.genFibSeq(1_000)); }
}
