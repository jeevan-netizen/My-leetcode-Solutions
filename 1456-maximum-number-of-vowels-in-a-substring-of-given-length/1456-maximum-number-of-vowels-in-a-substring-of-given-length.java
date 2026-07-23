class Solution {
    private boolean vowel(char ch){
        return ch =='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int count =0;
        int max = 0;
        for(int i = 0; i < k ; i++){
            if(vowel(s.charAt(i)))
                count++;
        }
        max = count;
        for(int i =k; i<n; i++){
            if(vowel(s.charAt(i - k)))
                count--;
            if(vowel(s.charAt(i)))
                count++;
            max = Math.max(count,max);
        }

        return max;
    }
}