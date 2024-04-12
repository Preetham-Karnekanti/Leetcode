class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color)
            return image;
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void helper(int[][] mat, int r, int c, int color, int ic) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(r, c));
        mat[r][c] = color;
        int dx[] = new int[] { 1, -1, 0, 0 };
        int dy[] = new int[] { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int xi = p.x + dx[i];
                int yi = p.y + dy[i];
                if (isValid(mat, xi, yi) && mat[xi][yi] == ic) {
                    q.add(new Pair(xi, yi));
                    mat[xi][yi] = color;
                }
            }
        }
    }

    public boolean isValid(int[][] mat, int r, int c) {
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length)
            return false;
        return true;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}