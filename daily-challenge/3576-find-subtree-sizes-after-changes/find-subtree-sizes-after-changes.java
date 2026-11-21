class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = s.length();
        int answer[] = new int[n];
        int newParent[] = parent.clone();
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }
        int last[] = new int[26];
        Arrays.fill(last, -1);
        dfs(0, tree, newParent, last, s);
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            tree.get(newParent[i]).add(i);
        }
        dfs2(0, tree, answer);
        return answer;
    }

    public void dfs(int cur, ArrayList<ArrayList<Integer>> tree,
            int[] newParent, int[] last, String s) {
        int ch = s.charAt(cur) - 'a';
        int prev = last[ch];
        if (prev != -1) {
            newParent[cur] = prev;
        }
        last[ch] = cur;
        for (int ngh : tree.get(cur))
            dfs(ngh, tree, newParent, last, s);
        last[ch] = prev;
    }

    public int dfs2(int cur, ArrayList<ArrayList<Integer>> tree,
            int[] subTreeSize) {
        int size = 1;
        for (int ngh : tree.get(cur)) {
            size += dfs2(ngh, tree, subTreeSize);
        }
        return subTreeSize[cur] = size;
    }
}