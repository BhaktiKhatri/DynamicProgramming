package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
 * 95. Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * Example: Input: 3
 * Output:
 * 	[
 * 	  [1,null,3,2],
 * 	  [3,2,null,1],
 * 	  [3,1,null,null,2],
 * 	  [2,1,3],
 * 	  [1,null,2,null,3]
 * 	]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * 
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * Explanation and Code from: @mhhh https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/31494/A-simple-recursive-solution
 * Medium 
 */

public class UniqueBinarySearchTrees2 {

	public static List<TreeNode> generateTrees(int n) {
		System.out.println("n: "+n);
	    return genTreeList(1,n);
	}

	private static List<TreeNode> genTreeList(int start, int end) {
	    System.out.println("start: "+start+" end: "+end);
	    
		List<TreeNode> list = new ArrayList<TreeNode>();
		
	    if(start > end) {
	        list.add(null);
	    }
	    
	    for(int idx=start; idx<=end; idx++) {
	        System.out.println("idx: "+idx+" start: "+start+" end: "+end);
	    	
	    	List<TreeNode> leftList = genTreeList(start, idx - 1);
	        List<TreeNode> rightList = genTreeList(idx + 1, end);
	        
	        for(TreeNode left: leftList) {
	            for(TreeNode right: rightList) {
	                
	            	TreeNode root = new TreeNode(idx);
	                System.out.println("root: "+root.val);
	                
	                if(left != null && right != null)
	                	System.out.println("left: "+left.val+" right: "+right.val);
	                
	                root.left = left;
	                root.right = right;
	                list.add(root);
	                
	                //System.out.println("list: "+list);
	            }
	        }
	    }
	    //System.out.println("list: "+list);
	    
	    return list;
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateTrees(n));
	}
}