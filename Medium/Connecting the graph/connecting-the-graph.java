//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int edges = edge.length;
        int extra = 0;
        if(edges < n-1) return -1;
        for(int e[] : edge){
            if(ds.findParent(e[0]) == ds.findParent(e[1])){
                extra++;
            }else
                ds.unionBySize(e[0], e[1]);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(ds.parent[i] == i) count++;
        }
        int ans = count - 1;
        if(ans > extra) return -1;
        return ans;
    }
}


class DisjointSet{
    int[] parent, size;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int u){
        if(parent[u] == u) return u;
        return parent[u] = findParent(parent[u]);
    }
    
    public void unionBySize(int u, int v){
        int pu = parent[u];
        int pv = parent[v];
        if(pu == pv) {
            return;
        };
        if(size[pu] > size[pv]){
            parent[pv] = pu;
            size[pu] += size[pv];
        }else{
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}