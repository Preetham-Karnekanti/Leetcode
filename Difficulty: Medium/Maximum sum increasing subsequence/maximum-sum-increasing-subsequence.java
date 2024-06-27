//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[][] = new int[n][n+1];
	    for(int i[] : dp)
	        Arrays.fill(i, -1);
	    return helper(arr, 0, -1, dp);
	}
	
	public int helper(int arr[], int idx, int prev, int dp[][]){
	    if(idx == arr.length)
	        return 0;
	    if(dp[idx][prev+1] != -1)
	        return dp[idx][prev+1];
	    int pick = 0;
	    if(prev == -1 || arr[idx] > arr[prev]){
	        pick = arr[idx] + helper(arr, idx+1, idx, dp);
	    }
	    int notPick = helper(arr, idx+1, prev, dp);
	    return dp[idx][prev+1] = Math.max(pick, notPick);
	}
}