//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int total = rows*cols;
        int vis[][] = new int[rows][cols];
        DisJointSet ds = new DisJointSet(total);
        int k = operators.length;
        List<Integer> al = new ArrayList<>();
        int count = 0;
        for(int i = 0;i<k;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            if(vis[row][col] == 1){
                al.add(count);
                continue;
            }
            count++;
            vis[row][col] = 1;
            int dr[] = new int[]{-1,1,0,0};
            int dc[] = new int[]{0,0,-1,1};
            for(int j = 0;j<4;j++){
                int nr = row + dr[j];
                int nc = col + dc[j];
                if(!isValid(nr,nc, rows, cols) || vis[nr][nc] == 0)
                    continue;
                int nodeNo = row*cols + col;
                int adjNode = nr*cols + nc;
                if(ds.findParent(adjNode) != ds.findParent(nodeNo)){
                    count--;
                    ds.unionBySize(adjNode, nodeNo);
                }
            }
            al.add(count);
        }
        return al;
    }
    public boolean isValid(int r, int c, int rows, int cols){
        if(r < 0 || r>= rows || c< 0 || c>= cols)
            return false;
        return true;
    }
}



class DisJointSet{
    int[] size, parent;
    DisJointSet(int n){
        size = new int[n];
        parent = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0;i<n;i++)
            parent[i] = i;
    }
    
    public int findParent(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    
    public void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends