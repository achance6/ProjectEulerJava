import java.util.ArrayList;

/**
 * Problem: What is the greatest product of four adjacent numbers 
 * in the same direction (up, down, left, right, or diagonally) in the 20 x 20 grid?
 * 08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
 * 49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
 * 81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
 * 52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
 * 22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
 * 24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
 * 32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
 * 67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
 * 24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
 * 21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
 * 78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
 * 16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
 * 86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
 * 19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
 * 04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
 * 88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
 * 04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
 * 20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
 * 20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
 * 01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
 */
public class EP11 implements EulerSolution {
	
	private static final int numAdj = 4;
	private static final String grid = 
			  "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\r\n"
			+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\r\n"
			+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\r\n"
			+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\r\n"
			+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\r\n"
			+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\r\n"
			+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\r\n"
			+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\r\n"
			+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\r\n"
			+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\r\n"
			+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\r\n"
			+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\r\n"
			+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\r\n"
			+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\r\n"
			+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\r\n"
			+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\r\n"
			+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\r\n"
			+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\r\n"
			+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\r\n"
			+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
	@Override
	public String run() {
		String[] lines = grid.split("\r\n");
		String[][] nums = new String[20][20];
		for (int i = 0; i < 20; ++i) {
			nums[i] = lines[i].split(" ");
		}
		// Each number from grid extracted as string in nums
		
		int[][] intGrid = new int[20][20];
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				intGrid[i][j] = Integer.parseInt(nums[i][j]);
			}
		}
		// Grid now represented as 20x20 array in intGrid
		ArrayList<Integer> products = new ArrayList<>();
		/**
		 * No validation is done to make sure indices stay within bounds.
		 * When they go out of bounds, it is simply caught and the functions
		 * return -1 so as to not interfere with the real products
		 * in the products array.
		 */
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 20; ++j) {
				products.add(checkUp(intGrid, i, j));
				products.add(checkUpRight(intGrid, i, j));
				products.add(checkRight(intGrid, i, j));
				products.add(checkDownRight(intGrid, i, j));
				products.add(checkDown(intGrid, i, j));
				products.add(checkDownLeft(intGrid, i, j));
				products.add(checkLeft(intGrid, i, j));
				products.add(checkUpLeft(intGrid, i, j));
			}
		}
		products.sort((a, b) -> b - a); // reverse natural order sort
		return Integer.toString(products.get(0));
	}
	
	private static int checkUp(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int j = y; j > y - numAdj; --j) {
				product *= grid[x][j];
			}
		}
		catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkUpRight(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x, j = y; i < x + numAdj && j > y - numAdj; ++i, --j) {
				product *= grid[i][j];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkRight(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x; i < x + numAdj; ++i) {
				product *= grid[i][y];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkDownRight(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x, j = y; i < x + numAdj && j < y + numAdj; ++i, ++j) {
				product *= grid[i][j];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkDown(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int j = y; j < y + numAdj; ++j) {
				product *= grid[x][j];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkDownLeft(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x, j = y; i > x - numAdj && j < y + numAdj; --i, ++j) {
				product *= grid[i][j];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkLeft(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x; i > x - numAdj; --i) {
				product *= grid[i][y];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}
	private static int checkUpLeft(int[][] grid, int x, int y) {
		int product = 1;
		try {
			for (int i = x, j = y; i > x - numAdj && j > y - numAdj; --i, --j) {
				product *= grid[i][j];
			}
		} catch(IndexOutOfBoundsException e) {return -1;}
		return product;
	}

}
