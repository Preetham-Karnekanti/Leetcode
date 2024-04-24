class Solution {
    public int minEatingSpeed(int[] input, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = 0; i < input.length; i++) {
            low = Math.min(low, input[i]);
            high = Math.max(high, input[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(mid, input, h)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public boolean isPossible(int speed, int[] input, int h) {
        int totalHours = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % speed == 0) {
                totalHours += input[i] / speed;
            } else {
                totalHours += input[i] / speed + 1;
            }
            if (totalHours > h)
                return false;
        }
        return true;
    }
}