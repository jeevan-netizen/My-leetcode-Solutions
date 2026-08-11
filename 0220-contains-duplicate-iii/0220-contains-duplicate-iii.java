class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> slidingWindow = new TreeSet<>();
      
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            Long ceilingValue = slidingWindow.ceiling((long) nums[currentIndex] - (long) valueDiff);
          
            if (ceilingValue != null && ceilingValue <= (long) nums[currentIndex] + (long) valueDiff) {
                return true;
            }
          
            slidingWindow.add((long) nums[currentIndex]);
          
            if (currentIndex >= indexDiff) {
                slidingWindow.remove((long) nums[currentIndex - indexDiff]);
            }
        }
      
        return false;
    }
}