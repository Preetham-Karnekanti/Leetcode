class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int r1 = x;
        int c1 = y;
        int r2 = x + k - 1;
        while(r1 < r2){
            int temp = grid[r1][c1];
            grid[r1][c1] = grid[r2][c1];
            grid[r2][c1] = temp;
            c1++;
            if(c1 > y + k - 1){
                r1++;
                r2--;
                c1 = y;
            }
        }
        return grid;
    }
}