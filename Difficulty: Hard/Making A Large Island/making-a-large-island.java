//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    public int largestIsland(int n,int[][] grid) 
    {
        // code here
        DisjointSet ds = new DisjointSet(n*n);
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1, 1};
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 0)
                    continue;
                for(int k = 0;k<4;k++){
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if(!isValid(nr, nc, n) || grid[nr][nc] == 0)
                        continue;
                    int curNode = i * n + j;
                    int adjNode = nr * n + nc;
                    ds.unionBySize(curNode, adjNode);
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1)
                    continue;
                HashSet<Integer> hs = new HashSet<>();
                for(int k = 0; k < 4;k++){
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if(!isValid(nr, nc, n) || grid[nr][nc] == 0)
                        continue;
                    int adjNode = nr * n + nc;
                    hs.add(ds.findParent(adjNode));
                }
                int count = 0;
                for(int p : hs){
                    count += ds.size[p];
                }
                max = Math.max(max, count + 1);
            }
        }
        return max == 0 ? n * n: max;
    }
    
    public static boolean isValid(int r, int c, int n){
        if(r < 0 || c < 0 || r >= n || c >= n)
            return false;
        return true;
    }
}


class DisjointSet {
    int[] parent, size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            size[pu] += size[pv];
            parent[pv] = pu;
        } else {
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
}