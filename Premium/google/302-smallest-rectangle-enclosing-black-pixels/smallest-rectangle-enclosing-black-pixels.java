class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        q.add(new int[] { x, y });
        image[x][y] = '0';
        int minX = m;
        int minY = n;
        int maxX = 0;
        int maxY = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            minX = Math.min(r, minX);
            minY = Math.min(c, minY);
            maxX = Math.max(r, maxX);
            maxY = Math.max(c, maxY);
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, m, n) || image[nr][nc] == '0')
                    continue;
                image[nr][nc] = '0';
                q.add(new int[] { nr, nc });
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return false;
        return true;
    }
}