//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int dx[] = new int[]{-1,1,0,0};
    int dy[] = new int[]{0,0,-1,1};
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rows = grid.length;
        int cols = grid[0].length;
        HashSet<ArrayList<String>> hs = new HashSet<>();
        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ArrayList<String> al = new ArrayList<>();
                    bfs(grid, i, j,i,j,al, visited);
                    hs.add(al);
                }
            }
        }
        return hs.size();
    }
    public void bfs(int grid[][], int i, int j, int br, int bc, ArrayList<String> al, boolean visited[][]){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            int val1 = br - r;
            int val2 = bc - c;
            al.add(new String(val1+":"+val2));
            for(int x = 0;x<4;x++){
                int nr = r + dx[x];
                int nc = c + dy[x];
                if(!isValid(grid, nr, nc) || visited[nr][nc] || grid[nr][nc] == 0)
                    continue;
                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
    public boolean isValid(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i>=grid.length || j>= grid[0].length)
            return false;
        return true;
    }
}
