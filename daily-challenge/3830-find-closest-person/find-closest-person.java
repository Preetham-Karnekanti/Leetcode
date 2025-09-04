class Solution {
    public int findClosest(int x, int y, int z) {
        int one = Math.abs(x - z);
        int two = Math.abs(y - z);
        if (one < two)
            return 1;
        if (one > two)
            return 2;
        return 0;
    }
}