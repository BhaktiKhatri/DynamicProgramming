package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

	public static int rob(int[] nums) {
        int prevMax = 0;
        int curMax = 0;
        
        System.out.println("rob: "+Arrays.toString(nums));
        
        for(int x: nums) {
        	System.out.println("x: "+x+" curMax: "+curMax+" prevMax: "+prevMax);
            
        	int temp = curMax;
            curMax = Math.max(prevMax + x, curMax);
            prevMax = temp;
        }
        return curMax;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println(rob(nums));
	}

}
