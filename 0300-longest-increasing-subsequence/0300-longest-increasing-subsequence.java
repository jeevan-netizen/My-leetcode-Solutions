class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int l = 0, r = size;

            while (l < r) {
                int m = l + (r - l) / 2;

                if (tails[m] < num)
                    l = m + 1;
                else
                    r = m;
            }

            tails[l] = num;

            if (l == size)
                size++;
        }

        return size;
    }
}