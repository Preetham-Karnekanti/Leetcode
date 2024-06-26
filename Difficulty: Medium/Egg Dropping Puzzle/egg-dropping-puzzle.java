//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][] = new int[n+1][k+1];
	    for(int i[]:dp)
	      Arrays.fill(i, -1);
	    return helper(n, k, dp);
	}
	
	public static int helper(int n, int k, int[][] dp){
	    if (k == 1 || k == 0)
            return k;
        if (n == 1)
            return k;
        if(dp[n][k] != -1)
            return dp[n][k];
	    int ans = Integer.MAX_VALUE;
	    int start = 1;
	    int end = k;
	    while(start <= end){
	        int mid = (start + end)/2;
	        int broke = helper(n-1, mid - 1, dp);
	        int notBroke = helper(n, k - mid, dp);
	        ans = Math.min(ans, Math.max(broke, notBroke));
	        if(broke < notBroke)
                    start = mid + 1;
            else end  = mid-1;
	    }
	    return dp[n][k] = ans + 1;
	}
}