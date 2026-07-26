class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        int n = nums.length;

        for(int j = 0;j < n;j++){
            if(nums[j] == 1) current++;
            else{
                max = Math.max(max, current);
                current = 0;
            }
        }
        return Math.max(max, current);
    }
}