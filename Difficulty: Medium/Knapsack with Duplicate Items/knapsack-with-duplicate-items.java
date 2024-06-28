//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[N][W+1];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        return helper(val, wt, 0, W, dp);
    }
    
    public static int helper(int val[], int wt[], int idx, int capacity, int[][] dp){
        if(idx == wt.length)
            return 0;
        if(capacity == 0)
            return 0;
        if(dp[idx][capacity] != -1)
            return dp[idx][capacity];
        int pick = 0;
        if(capacity - wt[idx] >= 0)
            pick = helper(val, wt, idx, capacity - wt[idx], dp) + val[idx];
        int notPick = helper(val, wt, idx + 1, capacity, dp);
        return  dp[idx][capacity] = Math.max(pick, notPick);
    }
}