class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            hm.put(nums[right], hm.getOrDefault(nums[right], 0) + 1);
            while (right - left + 1 > hm.size()) {
                sum -= nums[left];
                hm.put(nums[left], hm.get(nums[left]) - 1);
                if (hm.get(nums[left]) == 0)
                    hm.remove(nums[left]);
                left++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}