class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            if (hm.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - hm.get(sum - k));
            }
            hm.putIfAbsent(sum, i);
        }
        return maxLen;
    }
}