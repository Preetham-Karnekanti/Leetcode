class Solution {

    public int minMoves(int[][] rooks) {
        int minMoves = 0;

        int[] row = new int[rooks.length];
        int[] col = new int[rooks.length];
        for (int i = 0; i < rooks.length; i++) {
            row[rooks[i][0]]++;
            col[rooks[i][1]]++;
        }

        int rowMinMoves = 0, colMinMoves = 0;
        for (int i = 0; i < rooks.length; i++) {
            rowMinMoves += row[i] - 1;
            colMinMoves += col[i] - 1;

            minMoves += Math.abs(rowMinMoves) + Math.abs(colMinMoves);
        }

        return minMoves;
    }
}