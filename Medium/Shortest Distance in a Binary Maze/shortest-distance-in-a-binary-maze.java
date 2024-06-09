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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,1,-1};
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(source);
        grid[source[0]][source[1]] = 0;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                if(r == destination[0] && c == destination[1])
                    return steps;
                for(int i = 0;i<4;i++){
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if(!isValid(rows, cols, nr, nc) || grid[nr][nc] == 0)
                        continue;
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
            steps++;
        }
        return -1;
    }
    
    public boolean isValid(int rows,int cols, int r, int c){
        if(r<0 || c<0 || r>=rows || c>=cols) return false;
        return true;
    }
}
