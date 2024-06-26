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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        Integer dp[][] = new Integer[str.length()][str.length()];
        return helper(str, str, 0, 0, dp);
    }
    
    public int helper(String str1, String str2, int i, int j, Integer dp[][]){
        if(i == str1.length() || j == str2.length())
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(i!=j && str1.charAt(i) == str2.charAt(j))
            return dp[i][j] = 1 + helper(str1, str2, i + 1, j + 1, dp);
        else
            return dp[i][j] = Math.max(helper(str1, str2, i + 1,j, dp) , helper(str1,str2, i, j+1, dp));
    }
}