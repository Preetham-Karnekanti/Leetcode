class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int count = 1;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prev) {
                count++;
                prev = points[i][1];
            } else
                prev = Math.min(prev, points[i][1]);
        }
        return count;
    }
}