class Solution {
    public long flowerGame(int n, int m) {
        long ocn = (n + 1) / 2;
        long ecn = n - ocn;
        long ocm = (m + 1) / 2;
        long ecm = m - ocm;
        return (ocn * ecm) + (ecn * ocm);
    }
}