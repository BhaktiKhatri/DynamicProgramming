package DynamicProgramming;

import java.util.Arrays;

/*
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple
 * times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example: Input: [1,2,3,0,2]; Output: 3; Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Code from: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process
 */

public class BestTimeToBuyAndSellStockWithCooldown {

	public static int maxProfit(int[] prices) {
	    int sell = 0;
	    int prev_sell = 0;
	    int buy = Integer.MIN_VALUE;
	    int prev_buy;
	    
	    for(int price: prices) {
	    	System.err.println("price: "+price+" buy: "+buy);
	        
	    	prev_buy = buy;
	        System.out.println("prev_buy: "+prev_buy+" prev_sell: "+prev_sell+" price: "+price);
	    	
	        buy = Math.max(prev_sell - price, prev_buy);
	        System.out.println("buy: "+buy+" sell: "+sell+" prev_sell: "+prev_sell);
	        
	        prev_sell = sell;
	        System.out.println("prev_sell: "+prev_sell+" prev_buy "+prev_buy+" price: "+price);
	        
	        sell = Math.max(prev_buy + price, prev_sell);
	        System.out.println("sell: "+sell);
	    }
	    System.out.println("sell: "+sell);
	    return sell;
	}

	
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println("prices: "+Arrays.toString(prices));
		System.out.println(maxProfit(prices));
	}

}
