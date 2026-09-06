class Solution {
      public int[] intersect(int[] nums1, int[] nums2) {
          if (nums1.length > nums2.length) {
              return intersect(nums2, nums1);
          }

          Map<Integer, Integer> counts = new HashMap<>();
          for (int num : nums1) {
              counts.merge(num, 1, Integer::sum);
          }

          int[] result = new int[nums1.length];
          int idx = 0;
          for (int num : nums2) {
              int count = counts.getOrDefault(num, 0);
              if (count > 0) {
                  result[idx++] = num;
                  counts.put(num, count - 1);
              }
          }

          return Arrays.copyOfRange(result, 0, idx);
      }
  }