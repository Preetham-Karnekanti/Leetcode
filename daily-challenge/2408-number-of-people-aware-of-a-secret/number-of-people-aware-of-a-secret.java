class Solution {
    Long[] dp = new Long[1001];
    int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        return (int) f(n,delay,forget,1);
    }
    public long f(int n,int delay,int forget,int day){
        if(day > n){
            return 0;
        }
        if(dp[day] != null){
            return dp[day];
        }
        long total = 0;
        if(day + forget > n){
            total = 1;
        }
        for(int i = day + delay; i <= Math.min(n,day + (forget - 1)); i++){
            total += f(n,delay,forget,i) % MOD;
        }
        return dp[day] = total % MOD;
    }
}