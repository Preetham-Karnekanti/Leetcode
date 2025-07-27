class Solution {
    public int countHillValley(int[] a) {
        int count = 0;
        int left = a[0];
        for (int i = 1; i < a.length - 1; i++)
            if (left < a[i] && a[i] > a[i + 1] || left > a[i] && a[i] < a[i + 1]) {
                count++;
                left = a[i];
            }
        return count;
    }
}