class Solution {
    public int minSwaps(int[] data) {
        int ans = Integer.MAX_VALUE;
        int windowSize = 0;
        for (int i : data) {
            windowSize += i;
        }

        int zeroCount = 0;
        int left = 0;
        for (int i = 0; i < windowSize; i++) {
            zeroCount += 1 - data[i];
        }
        ans = Math.min(ans, zeroCount);
        for (int right = windowSize; right < data.length; right++, left++) {
            zeroCount -= (1 - data[left]);
            zeroCount += (1 - data[right]);
            ans = Math.min(ans, zeroCount);
        }

        return ans;
    }
}