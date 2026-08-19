class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int n : count) {
                key.append('#').append(n);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>())
               .add(str);
        }

        return new ArrayList<>(map.values());
    }
}