
class Solution {
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < len; j++) {
                xor = xor ^ arr[j];
                if (xor == 0) {
                    count += j - i;
                }
            }
        }

        return count;
    }
}