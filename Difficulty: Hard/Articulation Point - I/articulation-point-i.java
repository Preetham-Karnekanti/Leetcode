//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    int timer;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        timer = 0;
        int time[] = new int[V];
        int low[] = new int[V];
        int mark[] = new int[V];
        boolean vis[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs(adj, time, low, mark, vis, i, -1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i<V;i++)
            if(mark[i] == 1)
                res.add(i);
        if(res.size()==0)
            res.add(-1);
        return res;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] time, int[] low, int[] mark, boolean vis[], int node, int parent){
        vis[node] = true;
        low[node] = time[node] = timer++;
        int child = 0;
        for(int ngh : adj.get(node)){
            if(ngh == parent)
                continue;
            if(!vis[ngh]){
                child++;
                dfs(adj, time, low, mark, vis, ngh, node);
                low[node] = Math.min(low[node], low[ngh]);
                if(low[ngh] >= time[node] && parent != -1)
                    mark[node] = 1;
            }else
                low[node] = Math.min(low[node], time[ngh]);
        }
        if(child > 1 && parent == -1)
            mark[node] = 1;
    }
}