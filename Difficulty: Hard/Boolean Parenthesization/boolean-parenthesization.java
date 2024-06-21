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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int n, String s){
        // code here
        Long dp[][][] = new Long[n][n][2];
        return (int)helper(s, 0, n-1, 1, dp);
    }
    
    public static long helper(String s, int i, int j, int isTrue, Long dp[][][]){
        if(i > j)
            return 0;
        if(i == j){
            if(isTrue == 1)
                return s.charAt(i) == 'T' ? 1 : 0;
            else 
                return s.charAt(i) == 'F' ? 1 : 0;
        }
        if(dp[i][j][isTrue] != null) return dp[i][j][isTrue];
        long ways = 0;
        int m = 1003;
        for(int idx = i + 1; idx < j; idx+=2){
            long LT = helper(s,i, idx - 1, 1, dp);
            long LF = helper(s,i, idx-1, 0, dp);
            long RT = helper(s, idx+1, j, 1, dp);
            long RF = helper(s, idx+1, j, 0, dp);
            if(s.charAt(idx) == '&'){
                if(isTrue == 1){
                    ways = (ways + (LT * RT)%m)%m;
                }else{
                    ways = (ways + (LF * RF + RF * LT + LF * RT)%m)%m;
                }
            }else if(s.charAt(idx) == '|'){
                if(isTrue == 1){
                    ways = (ways + (LF * RT + RF * LT + RT * LT)%m)%m;
                }else{
                    ways = (ways + (LF * RF)%m)%m;
                }
            }else if(s.charAt(idx)=='^'){
                if(isTrue==1)
                    ways = (ways+ (LF * RT + LT * RF)%m)%m;
                else    ways = (ways + (LT * RT + RF*LF)%m)%m;
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}