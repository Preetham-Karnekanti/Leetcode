class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        int ans = 0;
        int count[] = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            count[sum]++;
            if (count[sum] > max) {
                ans = 1;
                max = count[sum];
            } else if (count[sum] == max)
                ans++;
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