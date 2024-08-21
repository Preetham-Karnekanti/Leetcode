/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        if (mountainArr.get(peakIndex) == target)
            return peakIndex;
        int one = binarySearch(mountainArr, 0, peakIndex, target);
        if (one != -1)
            return one;
        return binarySearch2(mountainArr, peakIndex + 1, mountainArr.length() - 1, target);
    }

    public int binarySearch2(MountainArray mountainArr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target)
                return mid;
            else if (midValue > target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public int binarySearch(MountainArray mountainArr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target)
                return mid;
            else if (midValue > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int findPeakIndex(MountainArray mountainArr) {
        int low = 0;
        int n = mountainArr.length();
        int high = n - 1;
        while (low != high) {
            int testIndex = (low + high) / 2;
            if (mountainArr.get(testIndex) < mountainArr.get(testIndex + 1)) {
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        return low;
    }
}