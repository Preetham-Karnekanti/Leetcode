//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(); // Take size of both the strings as input
            int m = sc.nextInt();

            String str1 = sc.next(); // Take both the string as input
            String str2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(n, m, str1, str2));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        // your code here
        Integer dp[][] = new Integer[n+1][m+1];
        return helper(str1, str2, n, m, dp);
    }
    
    public static int helper(String s1, String s2, int i, int j, Integer dp[][]){
        if(i == 0 || j == 0)
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return dp[i][j] = 1 + helper(s1,s2,i-1,j-1, dp);
        else
            return dp[i][j] = Math.max(helper(s1,s2,i,j-1, dp), helper(s1,s2,i-1, j, dp));
    }
}