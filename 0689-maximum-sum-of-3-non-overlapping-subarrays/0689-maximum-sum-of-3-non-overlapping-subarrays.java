class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int m = n - k + 1;

        int[] sum = new int[m];

        int window = 0;
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }

        sum[0] = window;

        for (int i = k; i < n; i++) {
            window += nums[i] - nums[i - k];
            sum[i - k + 1] = window;
        }

        int[] left = new int[m];

        int best = 0;

        for (int i = 0; i < m; i++) {
            if (sum[i] > sum[best]) {
                best = i;
            }
            left[i] = best;
        }

        int[] right = new int[m];

        best = m - 1;

        for (int i = m - 1; i >= 0; i--) {
            if (sum[i] >= sum[best]) {
                best = i;
            }
            right[i] = best;
        }

        int maxSum = 0;
        int[] ans = new int[3];

        for (int mid = k; mid < m - k; mid++) {

            int l = left[mid - k];
            int r = right[mid + k];

            int total = sum[l] + sum[mid] + sum[r];

            if (total > maxSum) {
                maxSum = total;
                ans[0] = l;
                ans[1] = mid;
                ans[2] = r;
            }
        }

        return ans;
    }
}