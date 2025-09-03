public class Solution {

    public int numberOfPairs(int[][] points) {
        int ans = 0;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];
            int yi = pointA[1];
            int y = Integer.MIN_VALUE;
            for (int j = i + 1; j < points.length; j++) {
                int yj = points[j][1];
                if (yi >= yj && yj > y) {
                    y = yj;
                    ans++;
                }
            }
        }
        return ans;
    }
}