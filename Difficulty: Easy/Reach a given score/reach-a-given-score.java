//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        // Add your code here.
        long dp[][] = new long[3][n+1];
        for(long[] i: dp)
            Arrays.fill(i, -1);
        int[] coins = new int[]{3, 5, 10};
        long val = solve(2, n,coins, dp);
        return val;
    }
    public long solve(int ind, int target, int coins[], long dp[][]){
       if (ind < 0)
        {
            if(target == 0) return 1;
            return 0;
        }
        if (dp[ind][target] != -1)
        {
            return dp[ind][target];
        }

        long notTake = solve(ind - 1, target, coins,dp);
        long take = 0;
        if (target >= coins[ind])
        {
            take = solve(ind, target - coins[ind], coins,dp);
        }
        
        return dp[ind][target]= take+notTake;
    }
}