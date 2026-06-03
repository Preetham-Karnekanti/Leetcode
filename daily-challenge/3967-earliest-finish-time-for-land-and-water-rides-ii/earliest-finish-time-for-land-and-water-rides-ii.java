class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int a = solve(landStartTime, landDuration, waterStartTime, waterDuration);
        int b = solve(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(a, b);
    }

    public int solve(int[] a, int[] aD, int[] b, int[] bD) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            finish1 = Math.min(finish1, a[i] + aD[i]);
        }
        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < b.length; i++) {
            finish2 = Math.min(finish2, Math.max(b[i], finish1) + bD[i]);
        }
        return finish2;
    }
}