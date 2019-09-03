package DynamicProgramming;

import java.util.Arrays;

/*
 * 416. Partition Equal Subset Sum
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note: Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1: Input: [1, 5, 11, 5] Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2: Input: [1, 2, 3, 5]
 * Output: false 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * Explanation and Code from: @Zhueason https://leetcode.com/problems/partition-equal-subset-sum/discuss/90592/01-knapsack-detailed-explanation
 * https://www.geeksforgeeks.org/partition-problem-dp-18/
 * https://www.youtube.com/watch?v=qca8opPZu2s
 * Similar Question: https://www.youtube.com/watch?v=qca8opPZu2s
 */

public class PartitionEqualSubsetSum {

	public static boolean canPartition(int[] nums) {
	    int sum = 0;
	    
	    System.out.println("nums: "+Arrays.toString(nums));
	    
	    for(int num: nums) {
	        sum = sum + num;
	    }
	    System.out.println("sum: "+sum);
	    
	    if(sum % 2 != 0) {
	        return false;
	    }
	    sum = sum / 2;
	    System.out.println("sum: "+sum);

	    int n = nums.length;
	    System.out.println("n: "+n);
	    
	    boolean[][] dp = new boolean[n+1][sum+1];
	    
	    dp[0][0] = true;
	    
	    for (int i = 1; i < n+1; i++) {
	        dp[i][0] = true;
	    }
	    
	    for (int j = 1; j < sum+1; j++) {
	        dp[0][j] = false;
	    }
	    printMatrix(dp);
	    
	    for(int i=1; i<n+1; i++) {
	        for(int j=1; j<sum+1; j++) {
	        	System.out.println("i: "+i+" j: "+j+" dp[i-1][j]: "+dp[i-1][j]+" dp[i][j]: "+dp[i][j]);
	        	
	        	dp[i][j] = dp[i-1][j];
	        	System.out.println("j: "+j+" nums[i-1]: "+nums[i-1]+" dp[i][j]: "+dp[i][j]);
	        	
	            if(j >= nums[i-1]) {
	            	System.out.println("dp[i][j]: "+dp[i][j]+" (j-nums[i-1]): "+(j-nums[i-1])+" dp[i-1][j-nums[i-1]]: "+dp[i-1][j-nums[i-1]]);
	                
	            	dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	                
	                System.out.println("dp[i][j]: "+dp[i][j]);
	            }
	        }
	    }
	    System.out.println("dp[n][sum]: "+dp[n][sum]);
	    printMatrix(dp);
	   
	    return dp[n][sum];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5};
		System.out.println(canPartition(nums));
	}

	public static void printMatrix(boolean[][] matrix) {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(" "+matrix[i][j]);
			}
			System.out.println();
		}
	}
}
