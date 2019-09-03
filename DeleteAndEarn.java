package DynamicProgramming;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DeleteAndEarn {

	public static int deleteAndEarn(int[] nums) {
		final Map<Integer, Integer> values = new TreeMap<>();
	    
		System.out.println(Arrays.toString(nums));
		
		for(final int num: nums) {
	        values.put(num, values.getOrDefault(num, 0) + num);
	    }
		System.out.println("values: "+values);
		
	    int pre = 0;
	    int cur = 0;
	    
	    System.out.println("values.keySet(): "+values.keySet());
	    
	    for(final int num : values.keySet()) {
	    	System.out.println("num: "+num+" pre: "+pre+" cur: "+cur);
	    	
	        if(!values.containsKey(num-1)) {
	            pre = cur;
	            cur = cur + values.get(num);
	            System.out.println("pre: "+pre+" cur: "+cur);
	        } 
	        else {
	            final int temp = Math.max(pre + values.get(num), cur);
	            System.out.println("temp: "+temp);
	            pre = cur;
	            cur = temp;
	            System.out.println("pre: "+pre+" cur: "+cur);
	        }
	    }
	    return cur;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 4, 2};
		System.out.println(deleteAndEarn(nums));
	}

}