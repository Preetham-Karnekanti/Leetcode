//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean vis[] = new boolean[V];
        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int sum = 0;
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int wt = cur[0];
            int node = cur[1];
            if(vis[node]) continue;
            
            vis[node] = true;
            sum += wt;
            for(int[] ngh: adj.get(node)){
                int curwt = ngh[1];
                int adjNode = ngh[0];
                pq.add(new int[]{curwt, adjNode});
            }
        }
        return sum;
    }
}