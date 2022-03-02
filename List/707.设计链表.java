/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
}
class MyLinkedList {
    int size;
    //虚拟头节点
    // 有了虚拟节点后，head就是不变的，要注意index，size的边界判定
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if (index >= size || index < 0) return -1;
        ListNode cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <=0) index = 0;
        size++;
        ListNode preNode = head;
        for (int i=0; i<index; i++) {
            preNode = preNode.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = preNode.next;
        preNode.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0|| index>=size) return;
        size--;
        ListNode pred = head;
        for (int i=0; i<index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end

