class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for(int i =0; i<nums.length;i++){
            if(nums[i]==0){
                current=0;
            }
            current+=nums[i];
            max=Math.max(max,current);
        }
    return max; 
    }
}