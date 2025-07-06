class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisjointSet ds = new DisjointSet(c + 1);

        for (int c1[] : connections) {
            int u = c1[0];
            int v = c1[1];
            ds.union(u, v);
        }

        HashMap<Integer, TreeSet<Integer>> components = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int parent = ds.findParent(i);
            components.computeIfAbsent(parent, k -> new TreeSet<>()).add(i);
        }
        List<Integer> answer = new ArrayList<>();
        for (int q[] : queries) {
            int type = q[0];
            int node = q[1];
            int parent = ds.findParent(node);
            TreeSet<Integer> connectedNodes = components.get(parent);
            if (type == 1) {
                if(connectedNodes.contains(node)){
                    answer.add(node);
                }else{
                    answer.add(connectedNodes.size() == 0 ? -1 : connectedNodes.first());
                }
            }else{
                connectedNodes.remove(node);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class DisjointSet {
    int parent[];
    int size[];

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int findParent(int u) {
        if (parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }

    void union(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return;
        if (size[pu] > size[pv]) {
            parent[pv] = pu;
            size[pu] += size[pv];
        } else {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
    }
}