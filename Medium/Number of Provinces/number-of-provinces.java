//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds = new DisjointSet(V);
        for(int i = 0;i<adj.size();i++){
            for(int j = 0;j<adj.get(0).size();j++){
                if(adj.get(i).get(j) == 1)
                    ds.unionByRank(i, j);
            }
        }
        int count = 0;
        for(int i = 0;i< V;i++)
            if(ds.parent[i] == i) count++;
        return count;
    }
};

class DisjointSet{
    int[] parent, rank;
    DisjointSet(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 0;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    
    public int findParent(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    
    public void unionByRank(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        int puRank = rank[pu];
        int pvRank = rank[pv];
        if(puRank > pvRank){
            parent[pv] = pu;
        }else if(pvRank > puRank){
            parent[pu] = pv;
        }else{
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}