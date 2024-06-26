//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int distance[][] = new int[n][m];
        for(int i[]: distance)
            Arrays.fill(i, (int)1e9);
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(grid[i][j] == 1){
                    q.add(new int[]{0, i, j});
                    distance[i][j] = 0;
                }
            }
        }
        
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1,1};
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int distanceSoFar = cur[0];
            int r = cur[1];
            int c = cur[2];
            for(int i = 0;i<4;i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
                if(!isValid(nr, nc, n, m) || grid[nr][nc] == 1)
                    continue;
                if(distance[nr][nc] > distanceSoFar + 1){
                    distance[nr][nc] = 1 + distanceSoFar;
                    q.add(new int[]{1 + distanceSoFar, nr, nc});
                }
            }
        }
        return distance;
    }
    
    public boolean isValid(int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >= n || c>=m)
            return false;
        return true;
    }
}