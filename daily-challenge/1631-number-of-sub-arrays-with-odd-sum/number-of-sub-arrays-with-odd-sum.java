class Solution {
    public int numOfSubarrays(int[] arr) {
        int m = (int) 1e9 + 7;
        int odd = 0;
        int even = 1;
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                count += odd;
                even++;
            } else {
                count += even;
                odd++;
            }
            count %= m;
        }
        return count;
    }
}