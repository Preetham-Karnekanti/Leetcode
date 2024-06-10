class Solution {
    public int heightChecker(int[] heights) {
        int arr[] = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != heights[i])
                count++;
        }
        return count;
    }
}