class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int minHeight = Math.min(height[i], height[j]);
        int area = minHeight * (j - i);
        while (i < j) {
            if (height[i] <= height[j])
                i++;
            else
                j--;
            minHeight = Math.min(height[i], height[j]);
            area = Math.max(area, minHeight * (j - i));
        }
        return area;
    }
}