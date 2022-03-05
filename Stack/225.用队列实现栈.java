import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Queue<Integer> queueF;
    Queue<Integer> queueS;

    // 注意queueF 的构造，以及queue的函数
    public MyStack() {
        queueF = new LinkedList<>();
        queueS = new LinkedList<>();
    }
    
    public void push(int x) {
        queueS.offer(x);
        while(!queueF.isEmpty()) {
            queueS.offer(queueF.poll());
        }
        Queue<Integer> tmp;
        tmp = queueF;
        queueF = queueS;
        queueS = tmp;
        return;
    }
    
    public int pop() {
        return queueF.poll();
    }
    
    public int top() {
        return queueF.peek();
    }
    
    public boolean empty() {
        return queueF.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

