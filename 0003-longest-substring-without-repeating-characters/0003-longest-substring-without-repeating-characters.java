class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        Map<Character, Integer > map =new HashMap();
        int left = 0;
        int max = 0;

        for(int right = 0; right<n ; right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch,right);
            max= Math.max(max, right - left + 1);
        }
        return max;
    }
}