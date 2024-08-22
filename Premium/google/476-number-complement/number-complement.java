class Solution {
    public int findComplement(int num) {
        int ans = 0;
        int base = 1;
        while (num != 0) {
            int bit = 1 - (num % 2);
            ans = ans + bit * base;
            base *= 2;
            num /= 2;
        }
        return ans;
    }
}