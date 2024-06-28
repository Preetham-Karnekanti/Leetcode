//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        int arr[][] = new int[][]{{0,8},{1,2,4},{1,3,5,2},{3,6, 2},{4,1,5,7},{5,2,4,6,8},{6,3,5,9},{7,4,8},{0,8,5,7,9},{6,9,8}};
        long dp[][] = new long[n+1][10];
        for(long i[] : dp)
            Arrays.fill(i, -1);
        long ans = 0;
        for(int i = 0;i<=9;i++){
            ans += dfs(arr, i, n-1, dp);
        }
        return ans;
    }
    public long dfs(int arr[][], int i, int n, long dp[][]){
        if(n == 0)
            return 1;
        if(dp[n][i] != -1)
            return dp[n][i];
        long ways = 0;
        for(int ngh: arr[i]){
            ways += dfs(arr, ngh, n-1, dp);
        }
        return dp[n][i] = ways;
    }
}