class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int arr[] = new int[m * n];
        int idx = 0;
        for (int i[] : grid) {
            for (int j : i) {
                arr[idx++] = j;
            }
        }
        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int steps = 0;
        
        for (int num : arr) {
            if (num == median) {
                continue;
            }
            
            if (Math.abs(num - median) % x != 0) {
                return -1;
            }
            
            steps += (Math.abs(num - median) / x);
        }
        
        return steps;
    }
}