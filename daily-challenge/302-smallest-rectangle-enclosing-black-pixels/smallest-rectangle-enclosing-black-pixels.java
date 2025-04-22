class Solution {
    public int minArea(char[][] image, int x, int y) {
        int minX = x, maxX = x, minY = y, maxY = y;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        image[x][y] = '0';
        int dx[] = new int[] { -1, 1, 0, 0 };
        int dy[] = new int[] { 0, 0, -1, 1 };
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (!isValid(nr, nc, image) || image[nr][nc] == '0')
                    continue;
                image[nr][nc] = '0';
                q.add(new int[] { nr, nc });
                maxX = Math.max(maxX, nr);
                minX = Math.min(minX, nr);
                maxY = Math.max(maxY, nc);
                minY = Math.min(minY, nc);
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    public boolean isValid(int r, int c, char[][] image) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return false;
        return true;
    }
}