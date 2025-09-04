class Solution {
    public int findClosest(int x, int y, int z) {
        int one = Math.abs(x - z);
        int two = Math.abs(y - z);
        return one < two ? 1 : one > two ? 2 : 0;
    }
}