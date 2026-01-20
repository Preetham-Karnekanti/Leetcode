class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[] = new int[nums.size()];
        Arrays.fill(ans, -1);
        int idx = 0;
        for (int i : nums) {
            for (int k = 1; k <= i; k++) {
                if ((k | (k + 1)) == i) {
                    ans[idx] = k;
                    break;
                }
            }
            idx++;
        }
        return ans;
    }
}