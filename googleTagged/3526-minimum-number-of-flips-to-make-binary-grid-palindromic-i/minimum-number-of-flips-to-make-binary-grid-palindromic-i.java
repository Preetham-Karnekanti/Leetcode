class Solution {
    public int minFlips(int[][] grid) {
        return Math.min(rowFlip(grid), colFlip(grid));
    }

    public int rowFlip(int grid[][]) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += flips(grid[i]);
        }
        return count;
    }

    public int colFlip(int grid[][]) {
        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int col[] = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                col[j] = grid[j][i];
            }
            count += flips(col);
        }
        return count;
    }

    public int flips(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            if (arr[i] != arr[j])
                count++;
            i++;
            j--;
        }
        return count;
    }
}