class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j))
                    count++;
            }
        }
        return count;
    }

    public boolean isMagicSquare(int grid[][], int row, int col) {
        System.out.println("------------------------------------");
        HashSet<Integer> hs = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                System.out.print(grid[i][j] + " ");
                if (grid[i][j] >= 10)
                    return false;
                hs.add(grid[i][j]);
            }
            System.out.println();
        }
        if (hs.size() < 9)
            return false;
        int i = row, j = col;
        // row - wise sum
        System.out.println("row wise");
        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        System.out.println(grid[i][j] + " " + grid[i][j + 1] + " " + grid[i][j + 2] + " " + sum1);

        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        System.out.println(grid[i + 1][j] + " " + grid[i + 1][j + 1] + " " + grid[i + 1][j + 2] + " " + sum2);

        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        System.out.println(grid[i + 2][j] + " " + grid[i + 2][j + 1] + " " + grid[i + 2][j + 2] + " " + sum3);

        if (!(sum1 == 15 && 15 == sum3 && 15 == sum2))
            return false;
        // col wise sum
        System.out.println("col wise");

        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        System.out.println(grid[i][j] + " " + grid[i + 1][j] + " " + grid[i + 2][j] + " " + sum4);

        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        System.out.println(grid[i][j + 1] + " " + grid[i + 1][j + 1] + " " + grid[i + 2][j + 1] + " " + sum5);

        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        System.out.println(grid[i][j + 2] + " " + grid[i + 1][j + 2] + " " + grid[i + 2][j + 2] + " " + sum6);
        if (!(sum4 == 15 && 15 == sum5 && 15 == sum6))
            return false;

        // diagonals
        System.out.println("dia wise");

        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        System.out.println(grid[i][j] + " " + grid[i + 1][j + 1] + " " + grid[i + 2][j + 2] + " " + sum7);
        j = j + 2;
        int sum8 = grid[i][j] + grid[i + 1][j - 1] + grid[i + 2][j - 2];
        System.out.println(grid[i][j] + " " + grid[i + 1][j - 1] + " " + grid[i + 2][j - 2] + " " + sum8);
        return sum7 == 15 && sum8 == 15;
    }
}