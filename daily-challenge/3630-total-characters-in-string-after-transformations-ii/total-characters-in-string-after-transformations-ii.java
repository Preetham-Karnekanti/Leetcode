class Solution {
    static final int MOD = 1_000_000_007;
    static final int SIZE = 26;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] count = new int[SIZE];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[][] T = new int[SIZE][SIZE];

        // Build the transformation matrix
        for (int i = 0; i < SIZE; i++) {
            int steps = nums.get(i);
            for (int j = 1; j <= steps; j++) {
                T[(i + j) % SIZE][i] = (T[(i + j) % SIZE][i] + 1) % MOD;
            }
        }

        // Matrix exponentiation
        int[][] T_exp = matrixPower(T, t);

        // Multiply matrix with initial count vector
        int[] resultCount = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                resultCount[i] = (int)((resultCount[i] + 1L * T_exp[i][j] * count[j]) % MOD);
            }
        }

        // Sum the final counts
        int result = 0;
        for (int val : resultCount) {
            result = (result + val) % MOD;
        }
        return result;
    }

    // Matrix multiplication
    private int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                for (int j = 0; j < SIZE; j++) {
                    res[i][j] = (int)((res[i][j] + 1L * A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    // Fast matrix exponentiation
    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[SIZE][SIZE];
        // Initialize result as identity matrix
        for (int i = 0; i < SIZE; i++) result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            power >>= 1;
        }
        return result;
    }
}