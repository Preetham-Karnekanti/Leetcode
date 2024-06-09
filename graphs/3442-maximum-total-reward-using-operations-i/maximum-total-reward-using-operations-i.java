class Solution {
    Integer dp[];
    public int maxTotalReward(int[] rewards) {
        int sum = 0;
        for(int i : rewards)
            sum+=i;
        dp = new Integer[sum];
        Arrays.sort(rewards);
        return helper(rewards, 0, 0);
    }
    public int helper(int[] rewards, int idx, int x){
        if(idx == rewards.length)
            return 0;
        if(dp[x]!=null)
            return dp[x];
        int notTake = helper(rewards, idx+1, x);
        int take = 0;
        if(rewards[idx] > x)
            take = rewards[idx] + helper(rewards, idx+1, x + rewards[idx]);
        return  dp[x] = Math.max(take,notTake);
    }
}