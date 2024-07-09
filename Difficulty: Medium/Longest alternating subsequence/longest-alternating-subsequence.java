//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int AlternatingaMaxLength(int[] nums) {
        // code here
        int dp[][] = new int[nums.length][2];
        for(int i[] : dp)
            Arrays.fill(i, -1);
        return Math.max(helper(nums,0,1, dp),helper(nums, 0, 0, dp)) ;
    }
    
    public int helper(int[] arr, int idx, int isIncreasing, int[][] dp){
        if(idx ==arr.length - 1)
            return 1;
        if(dp[idx][isIncreasing] != -1)
            return dp[idx][isIncreasing];
        int take = 0;
        if(isIncreasing == 1 && arr[idx] < arr[idx + 1])
            take = 1 + helper(arr, idx + 1, 0, dp);
        else if(isIncreasing == 0 && arr[idx] > arr[idx + 1])
            take = 1 + helper(arr, idx + 1, 1, dp);
        int skip = helper(arr, idx + 1, isIncreasing, dp);
        return dp[idx][isIncreasing] = Math.max(take, skip);
    }
}

//{ Driver Code Starts.

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.AlternatingaMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends