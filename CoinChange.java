package DynamicProgramming;

import java.util.Arrays;

/*
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/description/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1: coins = [1, 2, 5], amount = 11; return 3 (11 = 5 + 5 + 1)
 * Example 2: coins = [2], amount = 3; return -1.
 * Note: You may assume that you have an infinite number of each kind of coin.
 * Explanation and Code from: Approach #3 (Dynamic programming - Bottom up) [Accepted] https://leetcode.com/problems/coin-change/solution/
 * https://www.youtube.com/watch?v=NJuKJ8sasGk
 * Time complexity : O(S*n); On each step the algorithm finds the next F(i) in n iterations, where S1≤i≤S. Therefore in total the iterations are S*n
 * Space complexity : O(S); We use extra space for the memoization table
 */

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        
        System.out.println("coins: "+Arrays.toString(coins)+" amount: "+amount);
        
        Arrays.fill(dp, max);  
        System.out.println("dp: "+Arrays.toString(dp));
        
        dp[0] = 0;   
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
            	System.out.println("i: "+i+" coins[j]: "+coins[j]);
            	
                if(coins[j] <= i) {
                	System.out.println("i: "+i+" dp[i]: "+dp[i]+" dp[i - coins[j]]: "+dp[i - coins[j]]);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    System.out.println("i: "+i+" dp[i]: "+dp[i]);
                }
            }
        }
        System.out.println("dp[amount]: "+dp[amount]);
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		
		System.out.println(coinChange(coins, amount));
	}

}
