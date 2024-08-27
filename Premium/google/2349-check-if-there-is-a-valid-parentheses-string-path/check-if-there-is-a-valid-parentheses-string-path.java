class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == ')' || grid[n - 1][m - 1] == '(' || (n + m - 1) % 2 != 0) {
            return false;
        }
        HashMap<String, Boolean> hm = new HashMap<>();
        return helper(grid, 0, 0, 0, hm);
    }

    public boolean helper(char grid[][], int i, int j, int open, HashMap<String, Boolean> dp) {
        int n = grid.length;
        int m = grid[0].length;
        String key = i + ":" + j + ":" + open;
        if (dp.containsKey(key))
            return dp.get(key);
        if (i >= n || j >= m || open < 0)
            return false;
        if (grid[i][j] == '(')
            open++;
        else
            open--;
        if (i == n - 1 && j == m - 1) {
            return open == 0;
        }
        boolean val = helper(grid, i + 1, j, open, dp)
                || helper(grid, i, j + 1, open, dp);
        dp.put(key, val);
        return val;
    }
}