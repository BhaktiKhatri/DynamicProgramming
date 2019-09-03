package DynamicProgramming;

/*
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * Example 1: Input: "bbbab" Output: 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2: Input: "cbbd" Output:2
 * One possible longest palindromic subsequence is "bb".
 * Explanation and code from:@ckcz123 https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
 * https://www.youtube.com/watch?v=U4yPae3GEO0
 * https://www.youtube.com/watch?v=TLaGwTnd3HY
 */

public class LongestPalindromicSubsequence {

	/*
	 	dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
		State transition:
		dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
		otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
		Initialization: dp[i][i] = 1
	 */
    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        System.out.println("s: "+s+" len: "+len);

        for(int i=0; i<len; i++) {
            dp[i][i] = 1;
        }
        
        for(int d=1; d<len; d++) {
        	System.out.println("===============================================d: "+d);
            for(int i=0; i<len-d; i++) {
            	System.out.println("i: "+i+" d: "+d);
                int j = i + d;
                
                System.out.println("j: "+j+" s.charAt(i): "+s.charAt(i)+" s.charAt(j): "+s.charAt(j));
                
                if(s.charAt(i) == s.charAt(j)) {
                	dp[i][j] = 2 + dp[i+1][j-1];
                }
                else { 
                	dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);	//max of left and bottom values
                }
            }
        }
        return dp[0][len-1];
    }

	
	public static void main(String[] args) {
		String s = "LPASPAL";
		System.out.println(longestPalindromeSubseq(s));
	}
}