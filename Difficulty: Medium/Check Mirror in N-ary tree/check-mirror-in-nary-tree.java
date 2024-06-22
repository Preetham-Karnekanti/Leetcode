//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        Map<Integer, Stack<Integer>> m = new HashMap<>();
        
        for(int i = 0; i < 2*e; i+=2) {
            if(!m.containsKey(A[i]))
                m.put(A[i], new Stack<Integer>());
            // in first array, edges are given in first to last order (in pairs)
            m.get(A[i]).add(A[i+1]);
        }
        
        for(int i = 0; i < 2*e; i+=2) {
            // in second array, edges have to be in last to first order (in pairs) for mirror
            if(!m.containsKey(B[i]) || m.get(B[i]).isEmpty() || m.get(B[i]).pop() != B[i+1])
                return 0;
        }
        
        return 1;
    }
}