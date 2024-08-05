class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int leftBar = height[l];
        int rightBar = height[r];
        int ans = 0;
        while (l < r) {
            if (leftBar <= rightBar) {
                ans += leftBar - height[l];
                l++;
                leftBar = Math.max(leftBar, height[l]);
            } else {
                ans += rightBar - height[r];
                r--;
                rightBar = Math.max(rightBar, height[r]);
            }
        }
        return ans;
    }
}