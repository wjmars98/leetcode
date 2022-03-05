import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void push(int x) {
        stackIn.push(x);
    }
    
    public int pop() {
        clearStackIn();
        return stackOut.pop();
    }
    
    public int peek() {
        clearStackIn();
        return stackOut.peek();
    }
    
    public boolean empty() {
        clearStackIn();
        return stackOut.empty();
    }

    // 问题关键在清楚输入栈，能够极大的降低问题难度
    public void clearStackIn() {
        if (!stackOut.empty()) return;
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
        return;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

