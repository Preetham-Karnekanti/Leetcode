class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long m = (long)mass;
        for (int a : asteroids) {
            if (m < a)
                return false;
            m += a;
        }
        return true;
    }
}