class Solution {
    public String reverseVowels(String s) {
        boolean[] isVowel = new boolean[128];

        for(char vowel : "aeiouAEIOU".toCharArray()){
            isVowel[vowel] = true;
        }

        char[] character = s.toCharArray();

        int left = 0;
        int right = character.length - 1;

        while( left < right){
            while(left < right && !isVowel[character[left]]){
                left++;
            }
            while(left < right && !isVowel[character[right]]){
                right--;
            }

                char temp = character[left];
                character[left] = character[right];
                character[right] = temp;

                left++;
                right--;
        }
        return String.valueOf(character);
    }
}