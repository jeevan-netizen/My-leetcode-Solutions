class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            right++;
            if (right - left == 10) {
                String dna = s.substring(left, right);

                if (seen.contains(dna)) {
                    result.add(dna);
                } else {
                    seen.add(dna);
                }
                left++;
            }
        }
        return new ArrayList<>(result);
    }
}