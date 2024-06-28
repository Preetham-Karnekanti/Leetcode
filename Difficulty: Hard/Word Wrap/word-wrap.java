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
    
    public int helper(int nums[], int k, int idx, int dp[]){
        if(idx == nums.length)
            return 0;
        if(dp[idx] != -1)
            return dp[idx];
        int min = (int)1e9;
        int letters = 0;
        for(int i = idx;i< nums.length;i++){
            letters += nums[i];
            if(letters <= k){
                if(i == nums.length - 1){
                    min = Math.min(min, helper(nums, k, i + 1, dp));
                }else{
                    int spaces = k - letters;
                    spaces *= spaces;
                    min = Math.min(min, spaces + helper(nums, k, i + 1, dp));
                }
            }
            letters++;
        }
        return dp[idx] = min;
    }
}