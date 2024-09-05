class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        int ans = 0;
        hm.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(i - hm.getOrDefault(sum - k, i), ans);
            hm.put(sum, hm.getOrDefault(sum, i));
        }
        return ans;
    }
}