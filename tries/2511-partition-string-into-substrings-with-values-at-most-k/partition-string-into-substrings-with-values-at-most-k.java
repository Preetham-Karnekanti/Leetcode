class Solution {
    public int minimumPartition(String s, int k) {
        long sum = 0;
        int c = 0;
        for (char ch : s.toCharArray()) {
            sum = sum * 10 + (ch - '0');
            if (sum > k) {
                c++;
                sum = ch - '0';
                if (sum > k)
                    return -1;
            }
        }
        return c + 1;
    }
}