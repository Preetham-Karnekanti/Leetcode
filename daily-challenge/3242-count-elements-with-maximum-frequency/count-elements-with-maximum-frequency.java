class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            max = Math.max(max, freq[nums[i]]);
        }

        if (max == 1)
            return nums.length;
        int ans = 0;
        for (int i = 0; i < 101; i++) {
            if (freq[i] == max)
                ans += max;
        }
        return ans;
    }
}