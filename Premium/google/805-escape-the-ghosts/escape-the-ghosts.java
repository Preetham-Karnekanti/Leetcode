class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int len = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] arr : ghosts)
            if (len >= Math.abs(target[0] - arr[0]) + Math.abs(target[1] - arr[1]))
                return false;
        return true;
    }
}