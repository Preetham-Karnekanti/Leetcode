class Solution {
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int i : data) {
            windowSize += i;
        }
        if(windowSize == 0)
            return 0;
        int ans = data.length;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < data.length; right++) {
            if (data[right] == 0)
                zeroCount++;
            if (right - left + 1 == windowSize) {
                ans = Math.min(ans, zeroCount);
                if (data[left] == 0)
                    zeroCount--;
                left++;
            }
        }
        return ans;
    }
}