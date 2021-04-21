package 剑指;

import java.util.Stack;

public class 用两个栈实现队列 {
}
class CQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();
    public CQueue() {

    }
    //进入instack
    public void appendTail(int value) {
        inStack.push(value);
    }

    //outstack pop()  若队列中没有元素，deleteHead 操作返回 -1
    public int deleteHead() {
        stackTransfer();
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else return -1;
    }

    //将inStack中的元素全部弹到outStack中
    public void stackTransfer() {
        //弹入条件:1.outStack为空 2.inStack中的元素必须一次性全部弹入outStack
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
