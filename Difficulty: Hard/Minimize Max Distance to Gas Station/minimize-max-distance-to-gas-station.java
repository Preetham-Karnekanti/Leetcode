//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int stations[], int K) {
        // code here
        double low = 0;
        int n = stations.length;
        double high = stations[n - 1] - stations[0];
        while (high - low >= 1e-6) {
            double mid = (low + high) / 2.0;
            int x = ok(mid, stations);
            if (x > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
    public static int ok(double x, int v[]) {
        int ret = 0;
        for (int i = 0; i < v.length - 1; i++) {
            ret += Math.ceil((v[i + 1] - v[i]) / x) - 1;
        }
        return ret;
    }
}

class Pair{
    double first;
    int second;
    Pair(double first, int second){
        this.first = first;
        this.second = second;
    }
}


