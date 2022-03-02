import java.util.List;

import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 双指针法
        /*
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp; 
        }
        return pre;
        */

        // 递归法
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if(cur==null) return pre;
        ListNode tmp = cur.next;
        cur.next = pre;
        return reverse(cur, tmp);
    }

}
// @lc code=end

