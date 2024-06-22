//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        // code here
        if(m > n-1)
            return false;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<>());
        for(ArrayList<Integer> e: edges){
            int u = e.get(0);
            int v = e.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(adj, i, vis);
            }
            if(count > 1)
                return false;
        }
        return true;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[]){
        vis[node] = true;
        for(int ngh : adj.get(node)){
            if(!vis[ngh]){
                dfs(adj, ngh, vis);
            }
        }
    }
}

