//{ Driver Code Starts
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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, k, 0, dp);
    }
    
    public int helper(int[] nums, int maxLineWidth, int idx, int dp[]){
        if(idx >= nums.length - 1)
            return 0;
        if(dp[idx] !=-1)
            return dp[idx];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = idx;i<nums.length;i++){
            sum += nums[i];
            if(maxLineWidth >= sum && i == nums.length - 1){
                min = Math.min(min, helper(nums, maxLineWidth, i + 1, dp));
            }
            else if(maxLineWidth >= sum){
                int x = maxLineWidth - sum;
                x = x*x;
                min = Math.min(min, x +helper(nums, maxLineWidth, i + 1, dp));
            }
            sum++;
        }
        return dp[idx] = min;
    }
}