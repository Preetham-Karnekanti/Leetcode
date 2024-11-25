class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : board) {
            for (int j : i)
                sb.append(j);
        }

        int moves[][] = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

        Queue<String> q = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();
        q.add(sb.toString());
        hs.add(sb.toString());
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals("123450"))
                    return steps;
                int zeroIdx = cur.indexOf('0');
                int validMoves[] = moves[zeroIdx];
                for (int i = 0; i < validMoves.length; i++) {
                    String swappedString = swap(cur, zeroIdx, validMoves[i]);
                    if (hs.contains(swappedString))
                        continue;
                    hs.add(swappedString);
                    q.add(swappedString);
                }
            }
            steps++;
        }

        return -1;
    }

    public String swap(String cur, int i, int j) {
        char[] ch = cur.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}