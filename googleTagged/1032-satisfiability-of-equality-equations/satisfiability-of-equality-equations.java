class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet();
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int u = str.charAt(0) - 'a';
                int v = str.charAt(3) - 'a';
                ds.union(u, v);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int u = str.charAt(0) - 'a';
                int v = str.charAt(3) - 'a';
                if(ds.findParent(u) == ds.findParent(v))
                    return false;
            }
        }
        return true;
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet() {
        parent = new int[26];
        size = new int[26];
        for (int i = 0; i < 26; i++) {
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