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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int dx[] = new int[]{-2, -2, -1, +1, +2, +1,-1, +2};
        int dy[] = new int[]{-1, +1, +2, +2, -1, -2,-2, +1};
        boolean vis[][] = new boolean[N+1][N+1];
        Queue<Pair> q = new LinkedList<>();
        vis[KnightPos[0]][KnightPos[1]] = true;
        q.add(new Pair(KnightPos[0], KnightPos[1], 0));
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int steps = cur.steps;
            if(row == TargetPos[0] && col == TargetPos[1])
                return steps;
            for(int i = 0;i<8;i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                if(!isValid(nr, nc,N) || vis[nr][nc])
                    continue;
                vis[nr][nc] = true;
                q.add(new Pair(nr, nc, steps+1));
            }
        }
        return -1;
    }
    
    public boolean isValid(int r, int c, int n){
        if(r < 1 || c < 1 || r > n || c > n)
            return false;
        return true;
    }
}

class Pair{
    int row;
    int col;
    int steps;
    Pair(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}