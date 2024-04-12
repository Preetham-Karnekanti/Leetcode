class Solution {
    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];

        left[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int n = height.length;
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        System.out.println(Arrays.toString(left));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            ans += min - height[i];
        }

        return ans;
    }
}