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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int[] ans = obj.FindWays(matrix);
            for(int i = 0; i < ans.length; i++){
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{   
    int m = (int)1e9 + 7;
    public int[] FindWays(int[][] matrix)
    {
        // Code here
        int n = matrix.length;
        int waysDp[][] = new int[n][n];
        int pointsDp[][] = new int[n][n];
        for(int i[]:waysDp)
            Arrays.fill(i, -1);
         for(int i[]:pointsDp)
            Arrays.fill(i, -1);
        int maxPoints = helper(matrix, 0, 0, matrix.length, pointsDp);
        maxPoints = maxPoints < 0 ? 0 : maxPoints;
        int ways = helper2(matrix, 0 ,0, matrix.length, waysDp);
        return new int[]{ways, maxPoints};
    }
    
    public int helper(int matrix[][], int r, int c, int n, int[][] dp){
        if(r == n - 1 && c == n - 1){
            return matrix[r][c];
        }
        if(dp[r][c] != -1)
            return dp[r][c];
        int directions[][] = getDirections(matrix[r][c]);
        int max = (int)-1e9;
        for(int i = 0;i < directions.length;i++){
            int nr = r + directions[i][0];
            int nc = c + directions[i][1];
            if(!isValid(nr, nc, n))
                continue;
            max = Math.max(max, (matrix[r][c] + helper(matrix, nr, nc, n, dp)) %m);
        }
        return dp[r][c] = max % m;
    }
    public int helper2(int matrix[][], int r, int c, int n, int[][] dp){
        if(r == n - 1 && c == n - 1){
            return 1;
        }
        if(dp[r][c] != -1)
            return dp[r][c];
        int directions[][] = getDirections(matrix[r][c]);
        int ways = 0;
        for(int i = 0;i < directions.length;i++){
            int nr = r + directions[i][0];
            int nc = c + directions[i][1];
            if(!isValid(nr, nc, n))
                continue;
            ways = (ways + helper2(matrix, nr, nc, n, dp))%m;
        }
        return dp[r][c] = ways % m;
    }
    
    public boolean isValid(int r, int c, int n){
        if(r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
    
    public int[][] getDirections(int value){
        switch(value){
            case 1: return new int[][]{{0, 1}};
            case 2: return new int[][]{{1, 0}};
            case 3: return new int[][]{{0,1}, {1, 0}};
        }
        return new int[][]{{-1,-1}};
    }
}