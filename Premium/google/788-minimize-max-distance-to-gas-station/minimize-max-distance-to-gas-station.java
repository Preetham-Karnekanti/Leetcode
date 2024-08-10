class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double low = 0;
        int n = stations.length;
        double high = stations[n - 1] - stations[0];
        while (high - low >= 1e-6) {
            double mid = (low + high) / 2.0;
            int x = ok(mid, stations);
            if (x > K) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public static int ok(double x, int v[]) {
        int ret = 0;
        for (int i = 0; i < v.length - 1; i++) {
            ret += Math.ceil((v[i + 1] - v[i]) / x) - 1;
        }
        return ret;
    }
}