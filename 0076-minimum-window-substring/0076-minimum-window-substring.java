class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        
        if(s.length() < t.length()) return "";

        for(char c: t.toCharArray())
            map.put(c,map.getOrDefault(c,0) + 1);

        int left = 0;
        int formed = 0;
        int start = 0;
        int minlen = Integer.MAX_VALUE;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);

            if(map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue())
                formed++;

                while(formed == map.size()){
                    if(right - left + 1 < minlen){
                        minlen = right - left +1;
                        start = left;
                    }

                    char ch = s.charAt(left);
                    window.put(ch,window.get(ch) -1);

                    if(map.containsKey(ch) && window.get(ch) < map.get(ch))
                        formed--;

                    left++;
                }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start,start + minlen);
    }
}