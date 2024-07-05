class Solution {
    Integer dp[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        dp = new Integer[strs.length][m + 1][n + 1];
        return helper(strs, m, n, 0);
    }

    public int helper(String input[], int m, int n, int idx){
        if(idx == input.length)
            return 0;
        if(dp[idx][m][n] != null)
            return dp[idx][m][n];
        int skip = helper(input, m, n, idx + 1);
        int count[] = getZerosAndOnesCount(input[idx]);
        int zeroCount = count[0];
        int oneCount = count[1];
        int take = 0;
        if(zeroCount <= m && oneCount <= n)
            take = 1 + helper(input, m - zeroCount, n - oneCount, idx + 1);
        return dp[idx][m][n] = Math.max(skip, take);
    }

    public int[] getZerosAndOnesCount(String num){
        int one = 0;
        int zero = 0;
        for(int i = 0;i<num.length();i++){
            if(num.charAt(i) == '0')
                zero++;
            else
                one++;
        }
        return new int[]{zero, one};
    }
}