class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        boolean hash[] = new boolean[order.length + 1];
        for (int i : friends) {
            hash[i] = true;
        }
        int answer[] = new int[friends.length];
        int idx = 0;
        for (int i : order) {
            if (hash[i]) {
                answer[idx++] = i;
            }
        }
        return answer;
    }
}