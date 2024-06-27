//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    mat[i][j]=sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int[][] dp = new int[n+1][m+1];
        int maxi = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int right = dp[i][j+1];
                int diagonal = dp[i+1][j+1];
                int down = dp[i+1][j];
        
                if (mat[i][j] == 1) {
                    int ans = 1 + Math.min(right, Math.min(diagonal, down));
                    maxi = Math.max(maxi, ans);
                    dp[i][j] = ans;
                }
                else 
                    dp[i][j] = 0;
            }
         }
        return maxi;
    }
}