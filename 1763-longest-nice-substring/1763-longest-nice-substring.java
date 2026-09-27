class Solution {
    public String longestNiceSubstring(String s) {
        return solve(s, 0, s.length() - 1);
    }

    private String solve(String s, int left, int right) {
        if (left > right) {
            return "";
        }
        boolean[] present = new boolean[128];
        for (int i = left; i <= right; i++) {
            present[s.charAt(i)] = true;
        }
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                if (!present[Character.toUpperCase(c)]) {
                    String a = solve(s, left, i - 1);
                    String b = solve(s, i + 1, right);
                    return a.length() >= b.length() ? a : b;
                }
            } else {
                if (!present[Character.toLowerCase(c)]) {
                    String a = solve(s, left, i - 1);
                    String b = solve(s, i + 1, right);
                    return a.length() >= b.length() ? a : b;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}