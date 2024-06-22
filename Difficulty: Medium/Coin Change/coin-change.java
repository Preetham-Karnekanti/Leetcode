//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long dp[][] = new long[N][sum+1];
        for(long i[]:dp)
            Arrays.fill(i, -1);
        return helper(coins, sum, 0, dp);
    }
    
    public long helper(int coins[], int sum,int idx, long dp[][]){
        if(sum == 0)
            return 1;
        if(idx == coins.length)     return 0;
        if(dp[idx][sum] != -1)
            return dp[idx][sum];
        long ans = 0;
        if(coins[idx] <= sum)
            ans += helper(coins, sum - coins[idx], idx, dp);
        ans += helper(coins, sum, idx + 1, dp);
        return dp[idx][sum] = ans;
    }   
}