class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(nums);
        int dp[] = new int[nums.length];
        int hash[] = new int[nums.length];
        int max = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            hash[i] = i;
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
        answer.add(nums[idx]);
        while (hash[idx] != idx) {
            idx = hash[idx];
            answer.add(nums[idx]);
        }
        return answer;
    }
}