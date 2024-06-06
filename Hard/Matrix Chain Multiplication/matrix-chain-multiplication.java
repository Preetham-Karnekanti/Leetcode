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
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][];
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        dp = new int[N][N];
        for(int i[] :dp)
            Arrays.fill(i, -1);
        return helper(arr, 1, N-1);
    }
    public static int helper(int arr[], int i, int j){
        if(i == j)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for(int k = i;k<j;k++){
            int cost = arr[i-1] * arr[j] * arr[k] + helper(arr, i, k) + helper(arr, k+1, j);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}