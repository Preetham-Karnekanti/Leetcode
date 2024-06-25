//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int timer;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        timer = 1;
        int tin[] = new int[V];
        int low[] = new int[V];
        
        boolean vis[] = new boolean[V];
        int ans[] = new int[1];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
               dfs(vis, tin, low, adj, c, d, i, -1, ans);
            }
        }
        return ans[0];
    }
    
    public static void dfs(boolean vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int c, int d, int node, int parent, int ans[]){
        vis[node] = true;
        low[node] = tin[node] = timer++;
        for(int ngh : adj.get(node)){
            if(ngh == parent)
                continue;
            if(!vis[ngh]){
               dfs(vis, tin, low, adj,c,d,ngh, node, ans);
                low[node] = Math.min(low[ngh], low[node]);
                if(low[ngh]  > tin[node]){
                    if((ngh == c && node == d) || (ngh == d && node == c))
                        ans[0] = 1;
                }
            }else{
                low[node] = Math.min(low[ngh], low[node]);
            }
        }
    }
}