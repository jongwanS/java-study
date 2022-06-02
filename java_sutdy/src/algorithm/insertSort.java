package algorithm;

import java.util.Arrays;

public class insertSort {
	
	public static void main(String[] args) {
		
		int[] nums = {5,4,3,2,1};
		
		for(int i=1;i<nums.length;i++) {
			
			int target = nums[i];
			int j = i-1;
			while(j>=0 && nums[j] > target) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = target; 
		}
		
		
		for(int n : nums) {
			System.out.print(n);
		}
		
	}
}
