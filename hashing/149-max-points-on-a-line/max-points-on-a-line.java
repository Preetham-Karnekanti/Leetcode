class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> hm = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                double slope = findSlope(points[i], points[j]);
                hm.put(slope, hm.getOrDefault(slope, 0) + 1);
                ans = Math.max(ans, hm.get(slope));
            }
        }
        return ans + 1;
    }

    public double findSlope(int p1[], int p2[]) {
        double a = p2[0] - p1[0];
        double b = p2[1] - p1[1];
        return b / a;
    }
}