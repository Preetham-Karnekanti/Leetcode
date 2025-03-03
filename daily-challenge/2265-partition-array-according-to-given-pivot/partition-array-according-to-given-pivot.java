class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0, equal = 0;
        for (int i : nums) {
            if (i < pivot) {
                less++;
            } else if (i == pivot) {
                equal++;
            }
        }
        int ans[] = new int[nums.length];
        int idx = 0;
        int lessI = 0;
        int equalI = less;
        int greaterI = less + equal;
        for (int i : nums) {
            if (i < pivot) {
                ans[lessI++] = i;
            } else if (i == pivot) {
                ans[equalI++] = i;
            } else
                ans[greaterI++] = i;
        }

        return ans;
    }
}