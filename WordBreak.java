package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 139. Word Break
 * https://leetcode.com/problems/word-break/description/
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * Explanation and Code from: Approach #4 https://leetcode.com/problems/word-break/solution/
 * Time complexity : O(n^2) Two loops are their to fill dp array. Space complexity : O(n). Length of p array is n+1.
 * Medium
 */

public class WordBreak {

	//https://www.youtube.com/results?search_query=139.+Word+Break
	public static boolean wordBreak(String s, List<String> wordDict) {
        //Set<String> wordDictSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        System.out.println("s: "+s+" wordDict: "+wordDict+" dp: "+Arrays.toString(dp));
        
        for (int i=1; i<=s.length(); i++) {
            for (int j=i-1; j>=0; j--) {
                
            	System.out.println("i: "+i+" j: "+j+" dp[j]: "+dp[j]+" s.substring(j, i): "+s.substring(j, i)+" wordDict: "+wordDict);
            	
            	if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		
		wordDict.add("leet");
		wordDict.add("code");
		//wordDict.add("dog");
		
		System.out.println(wordDict);
		
		System.out.println(wordBreak(s, wordDict));
	}

}
