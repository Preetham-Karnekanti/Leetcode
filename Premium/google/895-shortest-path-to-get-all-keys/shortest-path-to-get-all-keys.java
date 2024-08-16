class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        boolean vis[][][] = new boolean[m][n][64];
        int maskedKey = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    q.add(new int[] { i, j, 0 });
                } else if(ch >='a' && ch <='z') {
                    maskedKey |= (1 << (ch - 'a'));
                }
            }
        }
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur[] = q.poll();
                int r = cur[0];
                int c = cur[1];
                int keys = cur[2];
                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];
                    if (!isValid(nr, nc, m, n) || vis[nr][nc][keys])
                        continue;
                    char ch = grid[nr].charAt(nc);
                    if (ch == '#')
                        continue;
                    if (ch >= 'A' && ch <= 'Z') {
                        if (checkBit(keys, ch) == 0)
                            continue;
                    }
                    int newKeys = keys;
                    if (ch >= 'a' && ch <= 'z') {
                        newKeys |= (1 << (ch - 'a'));
                        if (newKeys == maskedKey)
                            return level + 1;
                    }
                    vis[nr][nc][newKeys] = true;
                    q.add(new int[] { nr, nc, newKeys });
                }
            }
            level++;
        }
        return -1;
    }

    public int checkBit(int key, char ch) {
        int bit = ch - 'A';
        key >>= bit;
        return (key & 1);
    }

    public boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }
}