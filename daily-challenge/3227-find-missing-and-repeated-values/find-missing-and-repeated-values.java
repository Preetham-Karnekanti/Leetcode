class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int xor = 0;
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                xor = xor ^ (i * n + j + 1);
                xor = xor ^ grid[i][j];
            }
        }

        int bit = setBit(xor);
        int set1 = 0;
        int set2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checkbit(grid[i][j], bit)) {
                    set1 ^= grid[i][j];
                } else {
                    set2 ^= grid[i][j];
                }
                if (checkbit(i * n + j + 1, bit)) {
                    set1 ^= (i * n + j + 1);
                } else {
                    set2 ^= (i * n + j + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == set1) {
                    return new int[] { set1, set2 };
                }
            }
        }

        return new int[] { set2, set1 };
    }

    public int setBit(int num) {
        for (int i = 0; i < 31; i++) {
            if (checkbit(num, i))
                return i;
        }
        return 0;
    }

    public boolean checkbit(int num, int i) {
        num = num >> i;
        return (num & 1) == 1;
    }
}