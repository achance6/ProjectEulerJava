import java.util.TreeSet;

/**
 * A permutation is an ordered arrangement of objects. 
 * For example, 3124 is one possible permutation 
 * of the digits 1, 2, 3 and 4. If all of the permutations 
 * are listed numerically or alphabetically, we call it lexicographic order. 
 * Problem: What is the millionth lexicographic permutation 
 * of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class EP24 implements EulerSolution {

	/**
	 * There are n! permutation of a set with n elements.
	 * This set has 10 elements, thus 10! = 3,628,800 permutations.
	 * Here we can implement Heap's algorithm to generate the permutations,
	 * then sort the resulting permutations and return the millionth.
	 */
	@Override
	public String run() {
		
		Integer[] elems = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeSet<String> perms = new TreeSet<String>();
		Methods.genPermutations(elems.length, elems, perms);
		return (perms.toArray()[999_999]).toString();
	}

	

}
