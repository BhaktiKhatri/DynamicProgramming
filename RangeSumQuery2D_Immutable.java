package DynamicProgramming;

/*
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Range Sum Query 2D
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [
 * 	  [3, 0, 1, 4, 2],
 * 	  [5, 6, 3, 2, 1],
 *	  [1, 2, 0, 1, 5],
 *	  [4, 1, 0, 1, 7],
 *	  [1, 0, 3, 0, 5]
 *	]
 *	
 *	sumRegion(2, 1, 4, 3) -> 8
 *	sumRegion(1, 1, 2, 2) -> 11
 *	sumRegion(1, 2, 2, 4) -> 12
 *	Note:
 *	You may assume that the matrix does not change.
 *	There are many calls to sumRegion function.
 *	You may assume that row1 ≤ row2 and col1 ≤ col2.
 * Explanation and Code from: Approach #4 (Caching Smarter) [Accepted] https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
 * @haoel https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/75350/Clean-C++-Solution-and-Explaination-O(mn)-space-with-O(1)-time
 * Time complexity : O(1) time per query, O(mn) time pre-computation. 
 * The pre-computation in the constructor takes O(mn) time. Each sumRegion query takes O(1) time.
 * Space complexity : O(mn), The algorithm uses O(mn) space to store the cumulative region sum.
 * Medium
 */

public class RangeSumQuery2D_Immutable {

	private int[][] sum;

	public RangeSumQuery2D_Immutable(int[][] matrix) {
	    if (matrix.length == 0 || matrix[0].length == 0) 
	    	return;
	    
	    sum = new int[matrix.length + 1][matrix[0].length + 1];
	    
	    for (int r=0; r<matrix.length; r++) {
	        for (int c=0; c<matrix[0].length; c++) {
	        	
	        	System.out.println("r: "+r+" c: "+c+" matrix[r][c]: "+matrix[r][c]+" sum[r + 1][c]: "+sum[r + 1][c]+" sum[r][c + 1]: "+sum[r][c + 1]+" sum[r][c]: "+sum[r][c]);
	            sum[r + 1][c + 1] = matrix[r][c] + sum[r + 1][c] + sum[r][c + 1] - sum[r][c];
	        }
	    }
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
	    return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
		                  {3, 0, 1, 4, 2},
		                  {5, 6, 3, 2, 1},
		                  {1, 2, 0, 1, 5},
		                  {4, 1, 0, 1, 7},
		                  {1, 0, 3, 0, 5}
						};
		
		RangeSumQuery2D_Immutable obj = new RangeSumQuery2D_Immutable(matrix);
		int sum = obj.sumRegion(2, 1, 4, 3);
		
		System.out.println("sum: "+sum);
	}

}
