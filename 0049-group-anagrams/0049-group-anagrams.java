class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length * 2);

        for (String s : strs) {
            int[] count = new int[26];

            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder(52);
            for (int i = 0; i < 26; i++) {
                key.append((char) count[i]);
            }

            String k = key.toString();

            List<String> list = map.get(k);
            if (list == null) {
                list = new ArrayList<>();
                map.put(k, list);
            }

            list.add(s);
        }

        return new ArrayList<>(map.values());
    }
}