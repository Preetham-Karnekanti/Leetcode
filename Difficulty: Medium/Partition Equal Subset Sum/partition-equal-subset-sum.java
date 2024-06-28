//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i : arr)
            sum+=i;
        if(sum %2 == 1)
            return 0;
        int dp[][] = new int[N][1 + sum/2];
        for(int i[]: dp)
            Arrays.fill(i, -1);
        return helper(arr, 0, sum/2, dp) ? 1 : 0;
    }
    public static boolean helper(int arr[], int idx, int sum, int[][] dp){
        if(sum == 0)
            return true;
        if(sum < 0)
            return false;
        if(idx == arr.length)
            return false;
        if(dp[idx][sum] != -1)
            return dp[idx][sum] == 0 ? false : true;
        boolean val = helper(arr, idx + 1, sum - arr[idx], dp) || helper(arr, idx + 1, sum, dp);
        dp[idx][sum] = val?1:0;
        return val;
    }
}