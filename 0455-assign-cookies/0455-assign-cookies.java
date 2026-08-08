import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;

        for (int cookie : s) {
            if (i < g.length && cookie >= g[i]) {
                i++;
            }
        }

        return i;
    }
}