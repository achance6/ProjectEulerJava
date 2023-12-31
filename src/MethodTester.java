import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public final class MethodTester {
	final long LONG_VALUE = Integer.MAX_VALUE + 1;

	@Test
	public void test_generate_fib_seq() { 
		assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987]", 
			Methods.genFibSeq(1_000).toString()); 
		}
	
	@Test
	public void test_generate_fib_seq_string() { 
		assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987]", 
			Methods.genFibSeq("1000").toString()); 
		}
	
	@Test
	public void test_generate_fib_sequence_big_string() {
		assertEquals("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, "
				+ "610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, "
				+ "46368, 75025, 121393, 196418, 317811, 514229, 832040, "
				+ "1346269, 2178309, 3524578, 5702887, 9227465, 14930352, "
				+ "24157817, 39088169, 63245986, 102334155, 165580141, "
				+ "267914296, 433494437, 701408733, 1134903170, 1836311903]",
			Methods.genFibSeq("2247483648").toString());
	}
	
	@Test
	public void test_is_palindrome_zero() {
		assertEquals(true, Methods.isPalindrome(0));
	}
	
	@Test
	public void test_is_palindrome_1001() {
		assertEquals(true, Methods.isPalindrome(1001));
	}
	
	@Test
	public void test_is_palindrome_1002() {
		assertEquals(false, Methods.isPalindrome(1002));
	}
	
	@Test
	public void test_is_palindrome_big() {
		assertEquals(false, Methods.isPalindrome(LONG_VALUE));
	}
	
	// TODO: generatePrimes tests
	// TODO: genPrimeFactors tests
	// TODO: genTriangleNum tests
	// TODO: genTriNum tests
	// TODO: genCollatzSequence tests
	// TODO: binCo tests
	// TODO: fact tests
	// TODO: genProperDivisors tests
	// TODO: sumAll tests
	// TODO: sumProperDivisors tests
	// TODO: isAmicableNumbers tests
	// TODO: isAbundant tests
	// TODO: genPerms tests
	// TODO: swap tests
	
	
}
