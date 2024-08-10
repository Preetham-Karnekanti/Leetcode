class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DisjointSet ds = new DisjointSet(n);
        boolean ans[] = new boolean[requests.length];
        int j = 0;
        for(int req[]: requests){
            int x = ds.findParent(req[0]);
            int y = ds.findParent(req[1]);
            boolean canRequest = true;
            for(int res[] : restrictions){
                int l = ds.findParent(res[0]);
                int m = ds.findParent(res[1]);
                if((l == x && m == y) || (l == y && x == m)){
                    canRequest = false;
                    break;
                }
            }
            ans[j++] = canRequest;
            if(canRequest){
                ds.union(req[0], req[1]);
            }
        }
        return ans;
    }
}

class DisjointSet {
    int parent[];
    int size[];

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

    public void union(int u, int v) {
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