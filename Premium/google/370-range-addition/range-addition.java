class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int arr[] = new int[length];
        for (int u[] : updates) {
            int start = u[0];
            int end = u[1];
            arr[start] += u[2];
            if (end + 1 < length)
                arr[end + 1] -= u[2];
        }
        for (int i = 1; i < length; i++)
            arr[i] += arr[i - 1];
        return arr;
    }
}