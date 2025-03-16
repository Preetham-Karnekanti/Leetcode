class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = ranks[0];
        for (int i = 0; i < ranks.length; i++) {
            high = Math.max(high, ranks[i]);
        }
        long ans = 0;
        high = high * cars * cars;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public boolean isPossible(int arr[], long cars, long minutes) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            long temp = minutes / arr[i];
            long repaired = (long)Math.sqrt(temp);
            count += repaired;
            if (count >= cars)
                return true;
        }
        return false;
    }
}