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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int dp[][] = new int[n][m];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max, helper(M, i, 0, dp));
        }
        return max;
    }
    
    public static  int helper(int mat[][], int r, int c, int dp[][]){
        if(!isValid(r, c, mat))
            return 0;
        if(dp[r][c] != -1)
            return dp[r][c];
        int DU = helper(mat, r - 1, c + 1, dp);
        int R = helper(mat, r, c + 1, dp);
        int DD = helper(mat, r + 1, c + 1, dp);
        return dp[r][c] = mat[r][c] + Math.max(DU, Math.max(R,DD));
    }
    public static boolean isValid(int i, int j, int[][] mat){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return false;
        return true;
    }
    
}