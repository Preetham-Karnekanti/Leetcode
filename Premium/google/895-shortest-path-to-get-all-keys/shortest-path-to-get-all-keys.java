class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][][] = new boolean[m][n][64];
        int maskKey = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'z')
                    maskKey |= (1 << (grid[i].charAt(j) - 'a'));
                if (grid[i].charAt(j) == '@') {
                    q.add(new int[] { i, j, 0 });
                }
            }
        }
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, 1, -1 };
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                int key = cur[2];
                if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c][key])
                    continue;
                char ch = grid[r].charAt(c);
                if (ch == '#')
                    continue;
                if (ch > '@' && ch < 'a') {
                    if (checkBit(key, ch) == 0)
                        continue;
                }
                if (ch >= 'a' && ch <= 'z') {
                    key |= 1 << (ch - 'a');
                    if (key == maskKey)
                        return level;
                }
                vis[r][c][key] = true;
                q.add(new int[] { r + 1, c, key });
                q.add(new int[] { r - 1, c, key });
                q.add(new int[] { r, c + 1, key });
                q.add(new int[] { r, c - 1, key });
            }
            level++;
        }
        return -1;
    }

    public int checkBit(int key, char ch) {
        int bit = ch - 'A';
        key = key >> bit;
        return (key & 1);
    }
}