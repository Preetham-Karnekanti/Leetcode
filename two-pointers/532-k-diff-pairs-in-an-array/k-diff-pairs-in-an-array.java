class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int count = 0;
        int sum = Integer.MIN_VALUE;
        while (i < nums.length && j < nums.length) {
            if (i != j && nums[j] - nums[i] == k) {
                count++;
                i++;
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            } else if (nums[j] - nums[i] > k)
                i++;
            else
                j++;
        }
        return count;
    }
}