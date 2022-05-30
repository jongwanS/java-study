package algorithm;

import java.util.Stack;

public class QueueImplUsingTwoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		Stack<Integer> st = new Stack<>();
		Stack<Integer> que = new Stack<>();
		
		for(int n : nums) st.add(n);
		
		while(!st.isEmpty()) {
			que.add(st.pop());
		}
		
		while(!que.isEmpty()) {
			System.out.println(que.pop());
		}
	}

}
