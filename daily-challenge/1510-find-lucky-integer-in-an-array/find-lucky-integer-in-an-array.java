class Solution {
    public int findLucky(int[] nums) {
        int freq[] = new int[501];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        for (int i = 500; i > 0; i--)
            if (freq[i] == i) {
                return i;
            }
        return -1;
    }
}