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
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                dfs(adj, i, st, vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0;i<V;i++)
            adjT.add(new ArrayList<>());
        for(int i = 0;i<V;i++){
            vis[i] = false;
            for(int adjNode: adj.get(i)){
                adjT.get(adjNode).add(i);
            }
        }
        int count = 0;
       while(!st.isEmpty()){
            int node = st.pop();
            if(!vis[node]){
                count++;
                dfs2(adjT, node, vis);
            }
        }
        return count;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean vis[]){
        vis[node] = true;
        for(int adjNode: adj.get(node)){
            if(!vis[adjNode]){
                dfs(adj,adjNode, st, vis);
            }
        }
        st.push(node);
    }
    
    public void dfs2(ArrayList<ArrayList<Integer>> adj, int start, boolean vis[]){
        vis[start]=true;
        for(int adjNode: adj.get(start)){
            if(!vis[adjNode])
                dfs2(adj, adjNode, vis);
        }
    }
}
