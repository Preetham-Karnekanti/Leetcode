class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (hm.get(mail) == null)
                    hm.put(mail, i);
                else {
                    ds.unionBySize(i, hm.get(mail));
                }
            }
        }
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++)
            mergedMail.add(new ArrayList<>());
        for (String mail : hm.keySet()) {
            int parent = ds.findParent(hm.get(mail));
            mergedMail.get(parent).add(mail);
        }
        List<List<String>> mergedWithName = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0)
                continue;
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(mergedMail.get(i));
            temp.addAll(mergedMail.get(i));
            mergedWithName.add(temp);

        }
        return mergedWithName;
    }
}


public class DisjointSet {
    ArrayList<Integer> rank;
    ArrayList<Integer> parent;
    ArrayList<Integer> size;

    DisjointSet(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node))
            return node;
        int pNode = findParent(parent.get(node));
        parent.set(node, pNode);
        return pNode;
    }

    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return;
        }
        int puRank = rank.get(pu);
        int pvRank = rank.get(pv);
        if (puRank > pvRank) {
            parent.set(pv, pu);
        } else if (puRank < pvRank) {
            parent.set(pu, pv);
        } else {
            parent.set(pu, pv);
            int uRank = rank.get(pu);
            rank.set(pv, uRank + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) {
            return;
        }
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}