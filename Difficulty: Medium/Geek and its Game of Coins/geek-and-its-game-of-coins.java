//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        // code here
        Boolean dp[] = new Boolean[n+1];
        dp[0] = false;
        dp[1] = true;
        for(int i = 2;i<=n;i++){
            if(i - 1>=0 && dp[i-1] == false){
                dp[i] = true;;
            }
            else if(i - x >= 0 && dp[i-x] == false)
                dp[i] = true;
            else if(i-y>=0 && dp[i-y] == false)
                dp[i] = true;
            else dp[i] = false;
        }
        return dp[n] ? 1 : 0;
    }
    
    public static boolean helper(int n, int x, int y, Boolean dp[]){
        if(n == 0)
            return false;
        if(n == 1)
            return true;
        if(dp[n] != null)
            return dp[n];
        if(n - 1>=0){
            if(helper(n-1, x, y, dp) == false)
                return dp[n] = true;
        }
        if(n - x >= 0){
            if(helper(n-x, x, y, dp) == false)
                return dp[n] = true;
        }
        if(n - y >= 0){
             if(helper(n-y, x, y, dp) == false)
                return dp[n] = true;
        }
        return dp[n] = false;
    }
}
