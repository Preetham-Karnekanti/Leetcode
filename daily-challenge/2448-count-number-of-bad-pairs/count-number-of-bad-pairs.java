class Solution {
    public long countBadPairs(int[] nums) {
        long count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i] - i;
            if (hm.containsKey(target)) {
                count += hm.get(target);
            }
            hm.put(target, hm.getOrDefault(target, 0) + 1);
        }
        long n = nums.length;
        long allPairs = n * (n - 1) / 2;
        return allPairs - count;
    }
}