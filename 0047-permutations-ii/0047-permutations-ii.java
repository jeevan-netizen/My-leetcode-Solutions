class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    void backtrack(int[] nums, boolean[] used,
                   List<Integer> cur, List<List<Integer>> res) {

        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            cur.add(nums[i]);

            backtrack(nums, used, cur, res);

            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}