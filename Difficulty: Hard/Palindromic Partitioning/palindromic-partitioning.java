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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int dp[] = new int[str.length()];
        Arrays.fill(dp, -1);
        return helper(str, 0, dp) - 1;
    }
    
    static public int helper(String str, int idx, int[] dp){
        if(idx == str.length())
            return 0;
        if(dp[idx] != -1) return dp[idx];
        int min = (int)1e9;
        for(int i = idx;i<str.length();i++){
            if(isPallindrome(str, idx, i)){
                int ops = 1 + helper(str, i+1, dp);
                min = Math.min(min, ops);
            }
        }
        return dp[idx] = min;
    }
    
    public static boolean isPallindrome(String str, int i, int j){
        while(i<=j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}