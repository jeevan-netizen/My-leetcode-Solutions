class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            return ans;
        }

        int start, end;

        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k;
            end = n - 1;
        }

        int sum = 0;

        // Initial window sum
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        // Slide the window
        for (int i = 0; i < n; i++) {
            ans[i] = sum;

            sum -= code[start % n];
            start++;
            end++;
            sum += code[end % n];
        }

        return ans;
    }
}