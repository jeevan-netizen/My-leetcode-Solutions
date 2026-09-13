class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length, lower, upper);
    }

    private int mergeSort(long[] a, int left, int right, int lower, int upper) {
        if (right - left <= 1) return 0;

        int mid = (left + right) / 2;
        int count = mergeSort(a, left, mid, lower, upper)
                  + mergeSort(a, mid, right, lower, upper);

        int lo = mid, hi = mid;

        for (int i = left; i < mid; i++) {
            while (lo < right && a[lo] - a[i] < lower) lo++;
            while (hi < right && a[hi] - a[i] <= upper) hi++;
            count += hi - lo;
        }

        long[] temp = new long[right - left];
        int i = left, j = mid, k = 0;

        while (i < mid && j < right) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while (i < mid) temp[k++] = a[i++];
        while (j < right) temp[k++] = a[j++];

        System.arraycopy(temp, 0, a, left, temp.length);

        return count;
    }
}