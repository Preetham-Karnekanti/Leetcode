class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0, i = 0;
        int n = nums.length;
        while (i < nums.length) {
            int val = nums[i];
            while (i + 1 < nums.length && val == nums[i + 1])
                i++;
            nums[j++] = val;
            i++;
        }
        return j;
    }
}