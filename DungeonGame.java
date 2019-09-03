package DynamicProgramming;

import java.util.Arrays;

/*
 * 174. Dungeon Game
 * https://leetcode.com/problems/dungeon-game/description/
 * Explanation and Code from: https://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
 * https://leetcode.com/problems/dungeon-game/discuss/52774/C++-DP-solution?page=1
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=https://blog.csdn.net/qq508618087/article/details/51392072&prev=search
 * Microsoft
 * >Medium
 */

public class DungeonGame {

	public static int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
        
		System.out.println("n: "+n+" m: "+m);
		
		int[][] dp = new int[m+1][n+1];
        dp[m-1][n] = 1;

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                
            	System.out.println("i: "+i+" j: "+j+" dp[i+1][j]dp[j]: "+dp[i+1][j]+" dp[i][j+1]: "+dp[i][j+1]+" dungeon[i][j]: "+dungeon[i][j]);
            	
            	dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
            	System.out.println("dp[i][j]: "+dp[i][j]);
            	
                dp[i][j] = Math.max(1, dp[i][j]);
            }
        }
        return dp[0][0];
    }

	public static int calculateMinimumHP1(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		System.out.println("n: "+n+" m: "+m);
		
		int[] dp = new int[m+1];
        dp[m-1] = 1;

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                
            	System.out.println("i: "+i+" j: "+j+" dp[j]: "+dp[j]+" dp[j+1]: "+dp[j+1]+" dungeon[i][j]: "+dungeon[i][j]);
            	
            	dp[j] = Math.min(dp[j], dp[j+1]) - dungeon[i][j];
            	System.out.println("dp[j]: "+dp[j]);
            	
                dp[j] = Math.max(1, dp[j]);
                System.out.println("dp: "+Arrays.toString(dp));
            }
        }
        return dp[0];
    }

	
	/* A utility function to print a 2D matrix */
    public static void printMatrix(int matrix[][])
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
	
	public static void main(String[] args) {
		int[][] dungeon = {{-2,-3, 3}, {-5, -10, 1}, {10, 30, -5}};
		printMatrix(dungeon);
		System.out.println();
		System.out.println(calculateMinimumHP1(dungeon));
	}

}
