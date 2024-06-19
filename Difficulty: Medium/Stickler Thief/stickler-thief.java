//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        Integer dp [] = new Integer[arr.length];
        return helper(arr, 0, dp);
    }
    
    public int helper(int arr[], int idx, Integer dp[]){
        if(idx >= arr.length)
            return 0;
        if(dp[idx] != null)
            return dp[idx];
        int skip = helper(arr, idx+1, dp);
        int take = arr[idx] + helper(arr, idx+2, dp);
        return dp[idx] = Math.max(skip, take);
    }
}