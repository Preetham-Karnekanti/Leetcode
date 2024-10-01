class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (int i : nums) {
            if (hm.get(i) == 1) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
}