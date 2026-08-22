class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            int best = dq.isEmpty() ? 0 : Math.max(0, dp[dq.peekFirst()]);
            dp[i] = nums[i] + best;
            ans = Math.max(ans, dp[i]);
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return ans;
    }
}