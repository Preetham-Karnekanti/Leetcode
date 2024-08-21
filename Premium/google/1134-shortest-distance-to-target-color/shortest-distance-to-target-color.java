class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int fromLeft[][] = new int[4][n];
        int closestIndexOf1 = Integer.MIN_VALUE;
        int closestIndexOf2 = Integer.MIN_VALUE;
        int closestIndexOf3 = Integer.MIN_VALUE;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 1) {
                closestIndexOf1 = i;
            } else if (colors[i] == 2) {
                closestIndexOf2 = i;
            } else {
                closestIndexOf3 = i;
            }
            fromLeft[1][i] = closestIndexOf1;
            fromLeft[2][i] = closestIndexOf2;
            fromLeft[3][i] = closestIndexOf3;
        }
        int fromRight[][] = new int[4][n];
        closestIndexOf1 = Integer.MAX_VALUE;
        closestIndexOf2 = Integer.MAX_VALUE;
        closestIndexOf3 = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] == 1) {
                closestIndexOf1 = i;
            } else if (colors[i] == 2) {
                closestIndexOf2 = i;
            } else {
                closestIndexOf3 = i;
            }
            fromRight[1][i] = closestIndexOf1;
            fromRight[2][i] = closestIndexOf2;
            fromRight[3][i] = closestIndexOf3;
        }
        int distance[][] = new int[4][n];
        for (int i[] : distance)
            Arrays.fill(i, -1);
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                if (fromLeft[i][j] == Integer.MIN_VALUE && fromRight[i][j] == Integer.MAX_VALUE) {
                    distance[i][j] = -1;
                } else if (fromLeft[i][j] != Integer.MIN_VALUE && fromRight[i][j] != Integer.MAX_VALUE) {
                    distance[i][j] = Math.min(Math.abs(j - fromLeft[i][j]), Math.abs(j - fromRight[i][j]));
                } else if (fromLeft[i][j] == Integer.MIN_VALUE) {
                    distance[i][j] = Math.abs(j - fromRight[i][j]);
                } else if (fromRight[i][j] == Integer.MAX_VALUE) {
                    distance[i][j] = Math.abs(j - fromLeft[i][j]);
                }
            }
        }
        for (int q[] : queries) {
            int idx = q[0];
            int color = q[1];
            ans.add(distance[color][idx]);
        }
        return ans;
    }
}