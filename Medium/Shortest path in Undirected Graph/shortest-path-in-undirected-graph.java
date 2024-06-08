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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(src);
        dist[src] = 0;
        vis[src] = true;
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int cur = q.poll();
                dist[cur] = distance;
                for(int ngh: adj.get(cur)){
                    if(!vis[ngh]){
                        q.add(ngh);
                        vis[ngh] = true;
                    }
                }
            }
            distance++;
        }
        for(int i =0;i<n;i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }
}