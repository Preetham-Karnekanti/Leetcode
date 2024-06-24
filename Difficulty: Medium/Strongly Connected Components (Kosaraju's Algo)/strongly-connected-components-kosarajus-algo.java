//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs(st, adj, vis, i);
            }
        }
        vis = new boolean[V];
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0;i<V;i++)
            adjT.add(new ArrayList<>());
        for(int i = 0;i<V;i++){
            for(int v : adj.get(i)){
                adjT.get(v).add(i);
            }
        }
        int count  = 0;
        while(!st.isEmpty()){
            int cur = st.pop();
            if(!vis[cur]){
                count++;
                dfs2(adjT, cur,vis);
            }
        }
        return count;
    }
    public void dfs2(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[]){
        vis[node] = true;
        for(int ngh: adj.get(node)){
            if(!vis[ngh]){
                dfs2(adj, ngh, vis);
            }
        }
    }
    public void dfs(Stack<Integer> st,  ArrayList<ArrayList<Integer>> adj, boolean vis[], int node){
        vis[node] = true;
        for(int ngh : adj.get(node)){
            if(!vis[ngh]){
                dfs(st, adj, vis, ngh);
            }
        }
        st.push(node);
    }
}
