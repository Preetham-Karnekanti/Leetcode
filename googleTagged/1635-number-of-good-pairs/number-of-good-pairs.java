class Solution {
    public int numIdenticalPairs(int[] nums) {
        int freq[] = new int[100];
        for (int i = 0; i < nums.length; i++)
            freq[nums[i] - 1]++;
        int ans = 0;
        for (int i = 0; i < freq.length; i++) {
            ans = ans + (freq[i] * (freq[i] - 1)) / 2;
        }
        return ans;
    }
}