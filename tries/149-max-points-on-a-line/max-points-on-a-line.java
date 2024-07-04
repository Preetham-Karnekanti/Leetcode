class Solution {
    public int maxPoints(int[][] points) {
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> slopes = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    double slope = findSlope(points[i], points[j]);
                    slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                    maxPoints = Math.max(maxPoints, slopes.get(slope));
                }
            }
        }
        return maxPoints + 1;
    }

    public double findSlope(int p1[], int p2[]) {
        double x1 = p1[0] * 1.0;
        double x2 = p2[0] * 1.0;
        double y1 = p1[1] * 1.0;
        double y2 = p2[1] * 1.0;
        return (y2 - y1) / (x2 - x1);
    }
}