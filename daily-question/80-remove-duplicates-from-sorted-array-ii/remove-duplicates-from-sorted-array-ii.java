class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            while (i + 2 < nums.length && k == nums[i + 2]) {
                i++;
            }
            nums[j++] = k;
        }
        return j;
    }
}