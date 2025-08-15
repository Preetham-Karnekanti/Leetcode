class Solution {
    public boolean isPowerOfFour(int n) {
        return (n % 3 == 1) && ((n & (n - 1)) == 0);
    }
}