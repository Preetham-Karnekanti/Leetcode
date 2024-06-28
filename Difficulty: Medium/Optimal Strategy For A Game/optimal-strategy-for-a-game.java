//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class OptimalStrategy {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];

            // inserting the elements
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            // calling the countMaximum() method of class solve
            System.out.println(new solve().maximumAmount(arr, n));
        }
    }
}
// } Driver Code Ends



class solve {
    // Function to find the maximum possible amount of money we can win.
    static long maximumAmount(int arr[], int n) {
        // Your code here
        long dp[][] = new long[n][n];
        for(long i[] : dp)
            Arrays.fill(i, -1);
        return helper(arr, 0, n-1, dp);
    }
    
    public static long helper(int arr[], int i, int j, long dp[][]){
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        long one = arr[i] + Math.min(helper(arr, i + 2, j, dp), helper(arr, i + 1, j - 1, dp));
        long two = arr[j] + Math.min(helper(arr, i + 1, j - 1, dp), helper(arr, i, j - 2, dp));
        return dp[i][j] = Math.max(one, two);
    }
}
