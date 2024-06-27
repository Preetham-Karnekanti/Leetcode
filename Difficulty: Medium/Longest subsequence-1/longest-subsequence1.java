//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int longestSubseq(int n, int[] a) {
        // code here
        int dp[][] = new int[n][n+1];
        for(int i[]: dp)
            Arrays.fill(i, -1);
       return helper(a, 0, -1, dp);
    }
    
    public static int helper(int[] arr, int idx, int prev, int[][] dp){
        if(idx == arr.length)
            return 0;
        if(dp[idx][prev+1] != -1)
            return dp[idx][prev+1];
        int pick = 0;
        if(prev == -1 || Math.abs(arr[prev] - arr[idx]) == 1)
            pick = 1 + helper(arr, idx+1, idx, dp);
        int notPick = helper(arr, idx+1, prev, dp);
        return dp[idx][prev+1] = Math.max(pick, notPick);
    }
}
