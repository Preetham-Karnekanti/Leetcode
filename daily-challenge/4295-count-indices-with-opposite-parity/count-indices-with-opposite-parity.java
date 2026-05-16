class Solution {
    public int[] countOppositeParity(int[] nums) {
        int ecount = 0;
        int oddCount = 0;
        int result[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] % 2 == 0) {
                result[i] = oddCount;
                ecount++;
            } else {
                result[i] = ecount;
                oddCount++;

            }
        }
        return result;
    }
}
