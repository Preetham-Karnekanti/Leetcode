class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0, max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        if (hm.size() == k) {
            max = Math.max(max, sum);
        }

        for (int right = k; right < nums.length; right++) {
            sum -= nums[left];
            hm.put(nums[left], hm.get(nums[left]) - 1);
            if (hm.get(nums[left]) == 0)
                hm.remove(nums[left]);
            left++;
            sum += nums[right];
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            if (hm.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}