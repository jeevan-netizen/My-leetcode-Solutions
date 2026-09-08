import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int result = n + 1;

        for (int i = 0; i <= n; i++) {

            while (!deque.isEmpty() &&
                   prefix[i] - prefix[deque.peekFirst()] >= k) {

                result = Math.min(result, i - deque.pollFirst());
            }

            while (!deque.isEmpty() &&
                   prefix[i] <= prefix[deque.peekLast()]) {

                deque.pollLast();
            }

            deque.addLast(i);
        }

        return result == n + 1 ? -1 : result;
    }
}