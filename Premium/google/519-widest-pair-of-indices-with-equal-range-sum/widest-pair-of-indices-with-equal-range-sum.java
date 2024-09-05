class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int result = 0, sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += (nums1[i] - nums2[i]);
            result = Math.max(result, i - hm.getOrDefault(sum, 1000000));
            hm.put(sum, hm.getOrDefault(sum, i));
        }
        return result;
    }
}