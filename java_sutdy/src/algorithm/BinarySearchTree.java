package algorithm;

public class BinarySearchTree {
	//이진 탐색 트리란 정렬된 이진트리
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		int target = 5;
		int index = binarySearchTree(nums, target);
		System.out.println(index);
	}

	private static int binarySearchTree(int[] nums,int target) {
		
		int l = 0;
		int r = nums.length;
		while(l <= r ){
			int mid = (l+r)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(nums[mid] < target) {
				l = mid+1;
			}else {
				r = mid-1;
			}
        }
		System.out.println("찾는게 없음");
		return -1;
	}

}
