class Solution {
    public int maxDistance(int[] colors) {
        int prev = colors[0];
        int idx = 0;
        int ans = 0;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] != prev) {
                ans = Math.max(ans, i - idx);
            }
        }
        prev = colors[colors.length - 1];
        idx = colors.length - 1;
        for (int i = colors.length - 2; i >= 0; i--) {
            if (colors[i] != prev) {
                ans = Math.max(ans, idx - i);
            }
        }
        return ans;
    }
}