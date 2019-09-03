package DynamicProgramming;

import java.util.Arrays;

/*
 * 96. Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * Example: Input: 3; Output: 5; Explanation: Given n = 3, there are a total of 5 unique BST's:
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * Explanation from: https://www.youtube.com/watch?v=YDf982Lb84o&t=2s  https://www.youtube.com/watch?v=JrTKVvYhT_k
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/31706/Dp-problem.-10+-lines-with-comments
 * Code from: https: @liaison https://leetcode.com/problems/unique-binary-search-trees/discuss/31666/DP-Solution-in-6-lines-with-explanation.-F(i-n)-G(i-1)-*-G(n-i)
 * Time Complexity: Time complexity of above implementation is O(n^2)
 * Snapchat
 * Medium
 */

public class UniqueBinarySeacrhTrees {
	    
	/*
	 * Given a sequence 1…n, we pick a number i out of the sequence as the root, then the number of unique BST with the specified root F(i), is the cartesian product
	 * of the number of BST for its left and right subtrees. For example, F(3, 7): the number of unique BST tree with number 3 as its root. To construct an unique BST 
	 * out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and
	 * another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product). The tricky part is that we could consider the 
	 * number of unique BST out of sequence [1,2] as G(2), and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).
	 */
    public static int numTrees(int n) {
    	int T[] = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        
        for(int i=2; i <= n; i++) {
        	System.out.println("i: "+i);
            
        	for(int j=1; j<=i; j++) {
            
        		System.out.println(Arrays.toString(T));
        		System.out.println("i: "+i+" T[i]: "+T[i]+" j: "+j+" T[j-1]: "+T[j-1]+" [i-j]: "+(i-j)+" T[i-j]: "+T[i-j]);
        		
            	T[i] = T[i] + T[j-1] * T[i-j];
            	
            	System.out.println("T[i]: "+T[i]);
            }
        }
        return T[n];
    }
 
	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
	}

}
