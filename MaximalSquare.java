package DynamicProgramming;

/*
 * 221. Maximal Square
 * https://leetcode.com/problems/maximal-square/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * Explanation from: https://www.youtube.com/watch?v=_Lf1looyJMU    https://www.youtube.com/watch?v=FO7VXDfS8Gk
 * Code from: @stellari https://leetcode.com/problems/maximal-square/discuss/61803/C%2B%2B-space-optimized-DP
 * Time complexity: O(mn), Single pass.
 * Space complexity: O(n), Another array which stores elements in a row is used for dp.
 */

public class MaximalSquare {

	public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        
        System.out.println("rows: "+rows+" cols: "+cols);
        
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
            	
            	System.out.println("i: "+i+" j: "+j+" matrix[i-1][j-1]: "+matrix[i-1][j-1]);
            	
                if(matrix[i-1][j-1] == '1') {
                	
                	System.out.println("dp[i][j - 1]: "+dp[i][j - 1]+" dp[i - 1][j]: "+dp[i - 1][j]+" dp[i - 1][j - 1]: "+dp[i - 1][j - 1]);
                	
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    System.out.println("dp[i][j]: "+dp[i][j]+" maxsqlen: "+maxsqlen);
                    
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                    System.out.println("maxsqlen: "+maxsqlen);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
	
	public static void main(String[] args) {
		char[][] matrix = { 
							{'1', '0', '1', '0', '0'},
							{'1', '0', '1', '1', '1'},
							{'1', '1', '1', '1', '1'},
							{'1', '0', '0', '1', '0'}
						 };
	
		System.out.println(maximalSquare(matrix));
	
	}

}
