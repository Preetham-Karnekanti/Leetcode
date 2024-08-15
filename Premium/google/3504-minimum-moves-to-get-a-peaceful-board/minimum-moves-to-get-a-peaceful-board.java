class Solution {

    public int minMoves(int[][] rooks) {
        int minMoves = 0;

        Arrays.sort(rooks, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < rooks.length; i++) {
            minMoves += Math.abs(i - rooks[i][0]);
        }

        Arrays.sort(rooks, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < rooks.length; i++) {
            minMoves += Math.abs(i - rooks[i][1]);
        }

        return minMoves;
    }
}