//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[][] a = IntMatrix.input(br, 2, n);
            
            
            int[][] T = IntMatrix.input(br, 2, n);
            
            
            int[] e = IntArray.input(br, 2);
            
            
            int[] x = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            int res = obj.carAssembly(n, a, T, e, x);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int carAssembly(int n, int[][] stationCost, int[][] shiftingCost, int[] entryCost, int[] exitCost) {
        // code here
      
        for(int i=0;i<2;i++) {
            stationCost[i][0] += entryCost[i];
            stationCost[i][n-1] += exitCost[i];
        }
        
        
        for(int i=1;i<n;i++) {
            stationCost[0][i] += Math.min(stationCost[0][i-1], stationCost[1][i-1] + shiftingCost[1][i]);
            stationCost[1][i] += Math.min(stationCost[1][i-1], stationCost[0][i-1] + shiftingCost[0][i]);
        }
        
        return Math.min(stationCost[0][n-1], stationCost[1][n-1]) ;
    }
    
    public static int helper(int idx, int line, int[][] stationCost, int shiftingCost[][], int exitCost[], int n, Integer dp[][]){
        if(idx == n - 1){
            return exitCost[line] + stationCost[line][idx];
        }
        if(dp[line][idx] != null)
            return dp[line][idx];
        int costWithoutChangingLine = stationCost[line][idx] + helper(idx + 1, line, stationCost, shiftingCost, exitCost, n, dp);
        int costWithChangingLine = Integer.MAX_VALUE;
        if(idx + 1 < n)
            costWithChangingLine = shiftingCost[line][idx+1] + stationCost[line][idx] + 
                                    helper(idx + 1, 1 - line, stationCost, shiftingCost, exitCost, n, dp);
        return dp[line][idx] = Math.min(costWithoutChangingLine, costWithChangingLine);
    }
}
        
