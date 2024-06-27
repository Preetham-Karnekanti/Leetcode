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

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends





class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        Integer dp[][] = new Integer[n][w+1];
        int ans = helper(cost, 0, w, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    
    public static int helper(int cost[], int idx, int w, Integer dp[][]){
        if(idx == cost.length){
            if(w == 0)
                return 0;
            return (int)1e9;
        }
        if(dp[idx][w] != null)
            return dp[idx][w];
        if(cost[idx] == -1)
            return dp[idx][w] = helper(cost, idx + 1, w, dp);
        else{
            int pick = (int)1e9;
            if(w - idx - 1 >=0)
                pick = cost[idx] + helper(cost, idx, w - idx - 1, dp);
            int notPick = helper(cost,idx+1, w, dp);
            return dp[idx][w] = Math.min(pick, notPick);
        }
    }
}
