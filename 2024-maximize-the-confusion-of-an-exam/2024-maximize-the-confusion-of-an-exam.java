class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(
            longest(answerKey, k, 'T'),
            longest(answerKey, k, 'F')
        );
    }

    private int longest(String s, int k, char target) {
        int left = 0;
        int changes = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) != target) {
                changes++;
            }

            while (changes > k) {
                if (s.charAt(left) != target) {
                    changes--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}