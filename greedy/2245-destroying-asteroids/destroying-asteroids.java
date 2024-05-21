class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long mass1 = (long)mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (mass1 >= asteroids[i]) {
                mass1 += asteroids[i];
            } else {
                return false;
            }
        }
        return true;
    }
}