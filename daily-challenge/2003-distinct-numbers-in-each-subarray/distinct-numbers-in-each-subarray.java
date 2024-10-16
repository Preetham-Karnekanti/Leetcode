class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int idx = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[idx++] = freq.size();
        int left = 0;
        for (int right = k; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            freq.put(nums[left], freq.get(nums[left]) - 1);
            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
            }
            left++;
            ans[idx++] = freq.size();
        }
        return ans;
    }
}