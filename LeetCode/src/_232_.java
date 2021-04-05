//232. 用栈实现队列
//https://leetcode-cn.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class _232_ {
}

//思路：使用两个栈，一个栈作为输入栈，一个栈作为输出栈
class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
         inStack = new Stack<>();
         outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        reverseElement();
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        reverseElement();
        return outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void reverseElement(){
        //outStack只要不为空，就说明队列前面的元素还没有出队，此时如果inStack中再添加元素(队列最后)，其实也是添加至outStack栈最后面的位置
        //如果此时outStack不为空，则按队列的顺序直接取出outStack中的元素即可
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
}
