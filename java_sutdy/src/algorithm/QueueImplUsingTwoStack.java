package algorithm;

import java.util.Stack;

class MyQueue {
    
    Stack<Integer> inStack;
    Stack<Integer> popStack;
    
    public MyQueue() {
        inStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        while(!inStack.isEmpty()){
            popStack.push(inStack.pop());
        }
        int res = popStack.pop();
        while(!popStack.isEmpty()){
            inStack.push(popStack.pop());
        }
        return res;
    }
    
    public int peek() {
        while(!inStack.isEmpty()){
            popStack.push(inStack.pop());
        }
        int res = popStack.peek();
        while(!popStack.isEmpty()){
            inStack.push(popStack.pop());
        }
        return res;
    }
    
    public boolean empty() {
        if(!inStack.isEmpty() || !popStack.isEmpty()){
            return false;
        }
        return true;
    }
}

public class QueueImplUsingTwoStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue que = new MyQueue();
		for(int i=0;i<10;i++) {
			que.push(i);
		}
		while(!que.empty()) {
			System.out.print(que.pop());
		}
	}

}


