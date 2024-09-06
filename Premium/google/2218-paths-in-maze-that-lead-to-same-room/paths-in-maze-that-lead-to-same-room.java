class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        int[][] adj=new int[n+1][n+1];
        int result=0;
        for(int i=0;i<corridors.length;i++) {
            adj[corridors[i][0]][corridors[i][1]]=1;
            adj[corridors[i][1]][corridors[i][0]]=1;
        }
        for(int i=1;i<=n;i++) {
            for(int j=i+1;j<=n;j++) {
                if(adj[i][j]==1) {
                    for(int k=j+1;k<=n;k++) {
                        if(adj[j][k]==1 && adj[k][i]==1) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}