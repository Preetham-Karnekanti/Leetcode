//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int m = (int)1e5;
        boolean visited[] = new boolean[m];
        visited[start] = true;
        int steps = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int cur = q.poll();
                if(cur == end)
                    return steps;
                for(int i = 0;i<arr.length;i++){
                    int val = (cur*arr[i])%m;
                    if(!visited[val]){
                        visited[val] = true;
                        q.add(val);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
