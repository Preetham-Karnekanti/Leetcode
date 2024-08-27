class Solution {
    public int kSimilarity(String s1, String s2) {
        HashSet<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s1);
        vis.add(s1);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(s2))
                    return steps;
                int idx = 0;
                while (idx < cur.length() && cur.charAt(idx) == s2.charAt(idx))
                    idx++;
                for (int j = idx + 1; j < cur.length(); j++) {
                    if (cur.charAt(j) == s2.charAt(idx)) {
                        String s = swap(cur, j, idx);
                        if (!vis.contains(s)) {
                            vis.add(s);
                            q.add(s);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        char chi = sb.charAt(i);
        char chj = sb.charAt(j);

        sb.setCharAt(i, chj);
        sb.setCharAt(j, chi);

        return sb.toString();
    }
}