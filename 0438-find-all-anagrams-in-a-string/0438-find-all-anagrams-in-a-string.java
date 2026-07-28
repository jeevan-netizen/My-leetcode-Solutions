class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] pcount = new int[26];
        int[] scount = new int[26];

        for(int i = 0 ; i < p.length() ; i++ ){
            pcount[p.charAt(i) - 'a']++;
            scount[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i <= s.length() - p.length() ; i++){
            if(arrayEqual(pcount,scount)) res.add(i);

            if(i + p.length() < s.length()){
                scount[s.charAt(i) - 'a']--;
                scount[s.charAt(i + p.length()) - 'a']++;
            }
        }
        return res;
    }

    private boolean arrayEqual(int arr1[] , int arr2[]){
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}