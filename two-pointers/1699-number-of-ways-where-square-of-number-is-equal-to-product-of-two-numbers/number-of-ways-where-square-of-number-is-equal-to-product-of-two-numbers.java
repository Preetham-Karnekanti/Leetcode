class Solution {
    private int countways(int[] nums1, int[] nums2) {
        int count = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int n : nums2) {
            map.put((long) n * n, map.getOrDefault((long) n * n, 0) + 1);
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long prod = (long) nums1[i] * (long) nums1[j];

                if (map.containsKey(prod))
                    count += map.get(prod);
            }
        }
        return count;
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        return countways(nums1, nums2) + countways(nums2, nums1);
    }
}