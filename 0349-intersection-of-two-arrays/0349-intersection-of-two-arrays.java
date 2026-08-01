class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        sort(nums1);
        sort(nums2);

        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }

        return res;
    }

    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int left = 0;
            int right = i - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (nums[mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            for (int j = i - 1; j >= left; j--) {
                nums[j + 1] = nums[j];
            }

            nums[left] = key;
        }
    }
}