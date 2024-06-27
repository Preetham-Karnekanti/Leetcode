//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max = 0;
        Integer dp[][] = new Integer[N][N];
        for(int i = 0;i<N;i++){
            max = Math.max(max, helper(Matrix, 0, i, dp));
        }
        return max;
    }
    
    public static int helper(int[][] mat, int r, int c, Integer dp[][]){
        if(r < 0 || c < 0 || r >=mat.length || c >= mat.length)
            return 0;
        if(dp[r][c] != null)
            return dp[r][c];
        int one = helper(mat, r + 1, c, dp);
        int two = helper(mat, r + 1, c - 1, dp);
        int three = helper(mat, r + 1, c + 1, dp);
        return dp[r][c] = Math.max(one, Math.max(three, two)) + mat[r][c];
    }
}