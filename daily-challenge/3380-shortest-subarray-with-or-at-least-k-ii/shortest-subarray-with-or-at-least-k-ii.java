class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0;
        int min = nums.length + 1;
        int bitCounts[] = new int[32];
        for(int right = 0;right<nums.length;right++){
            updateBitCounts(nums[right], bitCounts, 1);
            while(left <= right && convertBitCountsToNumber(bitCounts) >= k){
                min = Math.min(min, right - left + 1);
                updateBitCounts(nums[left], bitCounts, -1);
                left++;
            }
        }
        return min == nums.length + 1 ? -1 : min;
    }

    public void updateBitCounts(int num, int setBits[], int delta) {
        for (int i = 0; i < 32; i++) {
            if (checkBit(num, i) == 1) {
                setBits[i] += delta;
            }
        }
    }

    public int checkBit(int num, int i) {
        num = num >> i;
        return (num & 1);
    }

    private int convertBitCountsToNumber(int[] bitCounts) {
        int result = 0;
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (bitCounts[bitPosition] != 0) {
                result |= 1 << bitPosition;
            }
        }
        return result;
    }
}