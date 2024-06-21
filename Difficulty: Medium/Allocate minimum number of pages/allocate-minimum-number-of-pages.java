//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m > n) return -1;
        long low = 0;
        long high = 0;
        for(int i: arr){
            low = Math.max(low, i);
            high += i;
        }
        long ans = -1;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(isPossible(arr, m, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static boolean isPossible(int[] arr, int students, long pages){
        int allocation = 1;
        long sum = 0;
        for(int i = 0;i<arr.length;i++){
            if(sum + arr[i] <= pages){
                sum += arr[i];
            }else{
                allocation++;
                sum = arr[i];
            }
        }
        return allocation <= students;
    }
};