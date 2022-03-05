import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    // 这题主要是需要构造一个最小堆，维护最小堆的个数为K
    // 主要需要注意最小堆的构造方法，默认是升序
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
            new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Map.Entry<Integer, Integer> entry:entries){
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i=k-1; i>=0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
// @lc code=end

