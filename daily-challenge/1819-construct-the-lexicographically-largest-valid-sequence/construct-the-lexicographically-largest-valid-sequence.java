class Solution {
    int[] res;

    public int[] constructDistancedSequence(int n) {
        int arr[] = new int[2 * n - 1];
        int map[] = new int[n + 1];
        solve(n, arr, map, 0);
        return res;
    }

    public void solve(int n, int arr[], int map[], int idx) {
        if (res != null)
            return;
        if (idx == arr.length) {
            res = new int[arr.length];
            for (int i = 0; i < arr.length; i++)
                res[i] = arr[i];
            return;
        }
        if (arr[idx] != 0) {
            solve(n, arr, map, idx + 1);
            return;
        }
        for (int i = n; i >= 1; i--) {
            if (map[i] == 1)
                continue;
            if (i == 1) {
                arr[idx] = i;
                map[i] = 1;
                solve(n, arr, map, idx + 1);
                arr[idx] = 0;
                map[i] = 0;
            } else {
                if (idx + i < arr.length && arr[idx + i] == 0) {
                    arr[idx] = i;
                    arr[idx + i] = i;
                    map[i] = 1;
                    solve(n, arr, map, idx + 1);
                    map[i] = 0;
                    arr[idx] = 0;
                    arr[idx + i] = 0;
                }
            }
        }
    }
}