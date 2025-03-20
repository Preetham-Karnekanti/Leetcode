//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.maxProfit(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static Integer dp[][][];
    static int maxProfit(int prices[], int k) {
        // code here
        dp = new Integer[prices.length][2][k + 1];
        return solve(prices,0,0,k);
    }
    
    public static int solve(int prices[], int idx, int shouldBuy, int k){
        if(idx == prices.length || k == 0)
            return 0;
        if(dp[idx][shouldBuy][k] != null)
            return dp[idx][shouldBuy][k];
        if(shouldBuy == 0){
            int buy = -prices[idx] + solve(prices, idx + 1, 1, k);
            int skip = solve(prices, idx + 1, 0, k);
            return dp[idx][shouldBuy][k] = Math.max(buy, skip);
        }else{
            int sell = prices[idx] + solve(prices, idx + 1, 0, k - 1);
            int skip = solve(prices, idx + 1, 1, k);
            return dp[idx][shouldBuy][k] = Math.max(sell, skip);
        }
    }
}