class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        Set<Integer> seen = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();

        int window = 0;

        for (int i = 0; i < s.length(); i++) {

            window = (window << 2) | encode(s.charAt(i));

            // Keep only last 10 characters = 20 bits
            if (i >= 10) {
                window &= 0xFFFFF;
            }

            // Window has exactly 10 characters
            if (i >= 9) {
                if (!seen.add(window)) {
                    repeated.add(window);
                }
            }
        }

        List<String> ans = new ArrayList<>();

        for (int code : repeated) {
            ans.add(decode(code));
        }

        return ans;
    }

    private int encode(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3; // T
    }

    private String decode(int code) {
        char[] dna = new char[10];

        for (int i = 9; i >= 0; i--) {
            int x = code & 3;

            if (x == 0) dna[i] = 'A';
            else if (x == 1) dna[i] = 'C';
            else if (x == 2) dna[i] = 'G';
            else dna[i] = 'T';

            code >>= 2;
        }

        return new String(dna);
    }
}