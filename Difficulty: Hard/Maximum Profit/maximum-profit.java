//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        // code here
        Integer dp[][][] = new Integer[N][K+1][2];
        return helper(A, 0, K, 1, dp);
    }
    
    public static int helper(int arr[], int idx, int k, int shouldBuy, Integer dp[][][]){
        if(idx == arr.length || k == 0)
            return 0;
        if(dp[idx][k][shouldBuy] != null)
            return dp[idx][k][shouldBuy];
        if(shouldBuy == 1){
            int buy = -arr[idx] + helper(arr, idx + 1, k, 0, dp);
            int skip = helper(arr, idx + 1,k, 1, dp);
            return dp[idx][k][shouldBuy] = Math.max(buy, skip);
        }else{
            int sell = arr[idx] + helper(arr, idx + 1, k-1, 1, dp);
            int skip = helper(arr, idx + 1, k, 0, dp);
            return dp[idx][k][shouldBuy] = Math.max(sell, skip);
        }
    }
}