class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] hash = new int[nums.length];
        int dp[] = new int[nums.length];
        int max = 0, idx = 0;
        for (int i = 0; i < nums.length; i++) {
            hash[i] = i;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                idx = i;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(nums[idx]);
        while (hash[idx] != idx) {
            idx = hash[idx];
            al.add(nums[idx]);
        }
        return al;
    }
}