class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] best = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int i = start; i <= end; i++) {
            int[] seq1 = maxSubsequence(nums1, i);
            int[] seq2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(seq1, seq2);

            if (isGreater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }
        return best;
    }

    private int[] maxSubsequence(int[] nums, int len) {
        int[] res = new int[len];
        int top = -1;
        int drop = nums.length - len; 

        for (int num : nums) {
            while (top >= 0 && res[top] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < len - 1) {
                res[++top] = num;
            } else {
                drop--; 
            }
        }
        return res;
    }

    private int[] merge(int[] seq1, int[] seq2) {
        int len = seq1.length + seq2.length;
        int[] merged = new int[len];
        int i = 0, j = 0, idx = 0;

        while (idx < len) {
            if (isGreater(seq1, i, seq2, j)) {
                merged[idx++] = seq1[i++];
            } else {
                merged[idx++] = seq2[j++];
            }
        }
        return merged;
    }

    private boolean isGreater(int[] seq1, int i, int[] seq2, int j) {
        while (i < seq1.length && j < seq2.length && seq1[i] == seq2[j]) {
            i++;
            j++;
        }
        return j == seq2.length || (i < seq1.length && seq1[i] > seq2[j]);
    }
}