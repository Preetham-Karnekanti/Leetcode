class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 1;
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        while (i < arr.length && arr[i - 1] < arr[i]) {
            isIncreasing = true;
            i++;
        }
        while (i < arr.length && arr[i - 1] > arr[i]) {
            isDecreasing = true;
            i++;
        }
        return isDecreasing && isIncreasing && i == arr.length;
    }
}