class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return ans;

        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < wordLen; start++) {

            int left = start;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = start; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!freq.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                while (window.get(word) > freq.get(word)) {
                    String remove = s.substring(left, left + wordLen);

                    window.put(remove, window.get(remove) - 1);
                    left += wordLen;
                    count--;
                }

                if (count == wordCount) {
                    ans.add(left);

                    String remove = s.substring(left, left + wordLen);
                    window.put(remove, window.get(remove) - 1);

                    left += wordLen;
                    count--;
                }
            }
        }

        return ans;
    }
}