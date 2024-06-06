class Solution {
    int dx[] = new int[] { -1, 1, 0, 0 };
    int dy[] = new int[] { 0, 0, -1, 1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;

        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public void dfs(int image[][], int i, int j, int color, int ic) {
        image[i][j] = color;
        for (int x = 0; x < 4; x++) {
            int ni = i + dx[x];
            int nj = j + dy[x];
            if (!isValid(image, ni, nj) || image[ni][nj] != ic)
                continue;
            dfs(image, ni, nj, color, ic);
        }
    }

    public boolean isValid(int[][] image, int i, int j) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return false;
        return true;
    }
}