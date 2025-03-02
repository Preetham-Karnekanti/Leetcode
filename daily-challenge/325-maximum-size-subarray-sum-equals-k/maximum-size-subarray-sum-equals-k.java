class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = Math.max(max, i + 1);
            }
            long target = sum - k;
            if (hm.containsKey(target)) {
                max = Math.max(max, i - hm.get(target));
            }
            hm.putIfAbsent(sum, i);
        }
        return max;
    }
}