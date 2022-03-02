import java.util.List;

/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        /*
            递归出口为末尾节点为null，或者末尾节点.next为null(奇偶两种情况)
            单次递归过程为，1，2节点互换，2节点指向1，1节点指向3的递归
        */
        /*
        if (head==null || head.next==null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
        */

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
    
        while (prev.next != null && prev.next.next != null) {
          ListNode temp = head.next.next; // 缓存 next
          prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
          head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
          head.next = temp;               // 将head 的 next 接上缓存的temp
          prev = head;                    // 步进1位
          head = head.next;               // 步进1位
        }
        return dummyNode.next;
    }
}
// @lc code=end

