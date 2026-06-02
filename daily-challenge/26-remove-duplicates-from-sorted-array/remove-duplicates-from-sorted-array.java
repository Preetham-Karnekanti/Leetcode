class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int curIdx = 0;
        while (i < nums.length) {
            int cur = nums[i];
            int j = i + 1;
            while(j < nums.length && nums[j] == cur){
                j++;
            }
            i = j;
            nums[curIdx++] = cur;
        }
        return curIdx;
    }
}