class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int width = j - i;
            max = Math.max(max, width * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else
                i++;
        }
        return max;
    }
}