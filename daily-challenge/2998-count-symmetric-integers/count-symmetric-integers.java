class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            if (s.length() % 2 == 1)
                continue;
            int sum1 = getSum(s, 0, s.length() / 2);
            int sum2 = getSum(s, s.length() / 2, s.length());
            if (sum1 == sum2)
                count++;
        }
        return count;
    }

    public int getSum(String s, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += (s.charAt(i) - '0');
        }
        return sum;
    }
}