class Solution {
    public int maxArea(int[] height) {
        int mx = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            if (height[i] > height[j]) {
                int cur = (j - i) * height[j];
                mx = Math.max(mx, cur);
                j--;
            } else {
                int cur = (j - i) * height[i];
                mx = Math.max(mx, cur);
                i++;
            }
        }
        return mx;
    }
}