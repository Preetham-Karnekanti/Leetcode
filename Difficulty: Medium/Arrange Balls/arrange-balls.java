//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int p = Integer.parseInt(S[0]);
            int q = Integer.parseInt(S[1]);
            int r = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            int ans = ob.CountWays(p, q, r);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int m = (int)1e9 + 7;
    public int CountWays(int p, int q, int r)
    {
        // code here
        Integer dp[][][][] = new Integer[p+1][q+1][r+1][4];
        
        return helper(p, q, r, 0, dp);
    }
    
    public int helper(int p, int q, int r, int prev, Integer dp[][][][]){
        if(p == 0 && q == 0 && r == 0)
            return 1;
        if(dp[p][q][r][prev] != null)
            return dp[p][q][r][prev];
        int one=0, two = 0, three = 0;
        if(prev!=1 && p > 0){
            one = helper(p-1,q, r, 1, dp);
        }
        if(prev!=2 && q > 0){
            two = helper(p,q-1, r, 2, dp);
        }
        if(prev!=3 && r > 0){
            three = helper(p,q, r-1, 3, dp);
        }
        return dp[p][q][r][prev] = ((one + two)%m + three)%m;
    }
}