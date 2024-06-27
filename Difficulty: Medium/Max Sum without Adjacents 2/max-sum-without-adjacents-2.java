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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        Integer dp[][] = new Integer[n][3];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        dp[0][2] = arr[0];
        for(int i = 1;i<n;i++){
            for(int cc = 0;cc<=2;cc++){
                int pick = 0;
                if(cc > 0)
                    pick = arr[i] + dp[i-1][cc-1];
                int notPick = dp[i-1][2];
                dp[i][cc] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][2];
    }
    
    public int helper(int arr[], int idx, int cc,  Integer dp[][]){
        if(idx == arr.length)
            return 0;
        if(dp[idx][cc] != null)
            return dp[idx][cc];
        int pick = 0;
        if(cc > 0)
            pick = arr[idx] + helper(arr, idx+1, cc - 1, dp);
        int notPick = helper(arr, idx + 1, 2, dp);
        return dp[idx][cc] = Math.max(pick, notPick);
    }   
}