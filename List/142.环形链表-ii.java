import java.util.List;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 快慢指针问题，判断有没有环，快慢指针相遇有环
        // 相遇节点与初始节点开始再次相遇，为入口节点
        // 需要一定的数学演算
        ListNode fn = head;
        ListNode sn = head;

        while (fn!=null && fn.next!=null) {
            fn = fn.next.next;
            sn = sn.next;
            if (fn == sn) {
                ListNode nn = head;
                ListNode pn = sn;
                while (nn != pn) {
                    pn = pn.next;
                    nn = nn.next;
                }
                return pn;
            }
        }
        return null;
    }
}
// @lc code=end

