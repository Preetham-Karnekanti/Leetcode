//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0] == 0 || A[X][Y] == 0)
            return -1;
        int dx[] = new int[]{-1, 1 ,0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                if(r == X && c == Y)
                    return distance;
                for(int i = 0;i<4;i++){
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if(!isValid(nr, nc, N, M) || A[nr][nc] == 0)
                        continue;
                    A[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                }
            }
            distance++;
        }
        return -1;
    }
    public boolean isValid(int r, int c, int n, int m){
        if(r < 0 || c < 0 || r >=n || c >= m)
            return false;
        return true;
    }
};