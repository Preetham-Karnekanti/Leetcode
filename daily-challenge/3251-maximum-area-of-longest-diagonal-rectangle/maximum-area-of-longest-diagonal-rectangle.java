class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDia = 0;
        int maxArea = 0;
        for (int d[] : dimensions) {
            double dia = Math.sqrt((d[0] * d[0]) + (d[1] * d[1]));
            if (maxDia < dia) {
                maxDia = dia;
                maxArea = d[0] * d[1];
            } else if (maxDia == dia) {
                maxArea = Math.max(maxArea, d[0] * d[1]);
            }
        }
        return maxArea;
    }
}