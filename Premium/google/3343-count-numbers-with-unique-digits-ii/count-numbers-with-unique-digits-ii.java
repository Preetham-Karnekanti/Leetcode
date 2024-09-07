class Solution {
    public int numberCount(int a, int b) {
        int count = 0;
        int arr[] = new int[10];
        for (int i = a; i <= b; i++) {
            int t = i;
            while (t > 0) {
                int rem = t % 10;
                if (arr[rem]++ > 0) {
                    count++;
                    break;
                }
                t /= 10;
            }
            arr = new int[10];
        }
        return b - a - count + 1;
    }
}