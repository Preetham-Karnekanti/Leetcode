//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.canRepresentBST(arr, N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int preIndex = 0;
    static int canRepresentBST(int arr[], int N) {
        // code here
        preIndex = 0;
        helper(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return preIndex == N ? 1 : 0;
    }
    
    public static void helper(int arr[], int min, int max){
        if(preIndex >= arr.length)
            return;
        if(min <= arr[preIndex] && arr[preIndex] <= max){
            int data = arr[preIndex];
            preIndex++;
            helper(arr, min, data);
            helper(arr, data, max);
        }
    }
}