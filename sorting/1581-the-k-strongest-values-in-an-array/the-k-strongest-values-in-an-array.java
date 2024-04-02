class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int median = arr[(n - 1) / 2];
        int ans[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Math.abs(a - median) == Math.abs(b - median) ? b - a : Math.abs(b - median) - Math.abs(a - median));
        for (int num : arr) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}