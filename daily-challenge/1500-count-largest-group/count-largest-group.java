class Solution {
    public int countLargestGroup(int n) {
        int count[] = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            count[sum]++;
        }
        int max = 0;
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                ans++;
            } else if (count[i] > max) {
                ans = 1;
                max = count[i];
            }
        }
        return ans;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}