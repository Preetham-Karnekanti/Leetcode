//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        Integer dp[][] = new Integer[n][n];
        return helper(arr, 0, n-1, k, dp);
    }
    
    public int helper(int arr[], int i, int j, int k, Integer dp[][]){
        if(i >= j)
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(arr[j] - arr[i] <= k)
            return 0;
        
        else return dp[i][j] = 1 + Math.min(helper(arr, i+1, j, k, dp), helper(arr, i, j-1,k, dp));
    }
}