class Solution {
    public int maxHeight(int[][] cuboids) {
        for (int i = 0; i < cuboids.length; i++)
            Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids, (a, b) -> {
            return b[0] * b[1] * b[2] - a[0] * a[1] * a[2];
        });
        for(int i = 0;i<cuboids.length;i++)
            System.out.println(Arrays.toString(cuboids[i]));
        return helper(cuboids, 0, -1);
    }

    public int helper(int[][] cuboids, int idx, int prev) {
        if (idx == cuboids.length)
            return 0;
        int notTake = helper(cuboids, idx + 1, prev);
        int take = 0;
        if (prev == -1 || check(cuboids[prev], cuboids[idx])) {
            take = cuboids[idx][2] + helper(cuboids, idx + 1, idx);
        }
        return Math.max(take, notTake);
    }

    public boolean check(int[] a, int b[]) {
        return a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2];
    }
}