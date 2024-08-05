class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[] = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = nums[i % n];
        }
        int windowSize = 0;
        for (int i = 0; i < n; i++) {
            windowSize += nums[i];
        }
        int ones = 0;
        int maxOnes = 0;
        for(int i = 0;i<arr.length;i++){
            ones += arr[i];
            if(i >= windowSize && arr[i-windowSize] == 1)
                ones--;
            maxOnes = Math.max(maxOnes, ones);
        }
        return windowSize - maxOnes;
    }
}