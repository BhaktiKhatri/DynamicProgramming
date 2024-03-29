package DynamicProgramming;

/**
 * Leetcode 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/description/
 * Video Explanation: https://www.youtube.com/watch?v=CFQk7OQO_xM
 * Explanation and code from: Approach #4 - https://leetcode.com/problems/climbing-stairs/solution/
 * @author NisuBhakti
 * Time Complexity: O(n), Single loop upto n is required to calculate n^{th} fibonacci number; Space Complexity: O(1), Constant space is used.
 */

public class ClimbingStairs {

	/**
	 * In the above approach we have used dp array where dp[i]=dp[i-1]+dp[i-2] 
	 * It can be easily analyzed that dp[i] is nothing but i^{th} fibonacci number. Fib(n)=Fib(n-1)+Fib(n-2). 
	 * Now we just have to find n^{th} number of the fibonacci series having 11 and 22 their first and second term respectively 
	 * i.e. Fib(1)=1 and Fib(2)=2.
	 * @param n steps to reach the top
	 * @return distinct ways in which one can climb to the top
	 */
	
	public static int climbStairs(int n) {
		if(n <= 0)
			return 0;
		
		if(n == 1)
			return 1;

		if(n == 2)
			return 2;
		
		int first = 1;
		int second = 2;
		
		for(int i=3; i<=n; i++) {
			int third = first + second;
			first = second;
			second = third;
		}
		return second;
	}
	
	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

}
