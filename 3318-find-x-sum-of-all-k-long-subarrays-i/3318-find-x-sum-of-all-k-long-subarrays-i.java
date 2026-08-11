class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }

            list.sort((a, b) -> {
                if (a[1] != b[1])
                    return Integer.compare(b[1], a[1]);

                return Integer.compare(b[0], a[0]);
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                sum += list.get(j)[0] * list.get(j)[1];
            }

            ans[i] = sum;
        }

        return ans;
    }
}