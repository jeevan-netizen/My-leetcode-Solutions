class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                if((nums[i+j]+nums[j])==target){
                    return new int[]{j,j+i};
                }
            }
        }
        return new int[]{};
    }
}