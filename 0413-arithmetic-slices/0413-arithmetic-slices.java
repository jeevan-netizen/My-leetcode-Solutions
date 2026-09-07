class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int current = 0;

        for (int i = 2; i < nums.length; i++) {

            if ((long) nums[i] - nums[i - 1] ==
                (long) nums[i - 1] - nums[i - 2]) {

                current++;
                result += current;

            } else {
                current = 0;
            }
        }

        return result;
    }
}