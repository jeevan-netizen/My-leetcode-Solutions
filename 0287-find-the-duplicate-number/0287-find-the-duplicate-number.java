class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                return nums[left];
            }

            left++;
            right++;
        }

        return -1;
    }
}