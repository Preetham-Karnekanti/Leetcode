class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum == b.sum ? b.idx - a.idx : b.sum - a.sum);
        for (int i = 0; i < mat.length; i++) {
            pq.add(new Pair(count(mat[i]), i));
            if (pq.size() > k)
                pq.poll();
        }
        int i = k - 1;
        int ans[] = new int[k];
        while (!pq.isEmpty()) {
            ans[i--] = pq.poll().idx;
        }
        return ans;
    }

    public int count(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans + 1;
    }
}

class Pair {
    int sum;
    int idx;

    Pair(int s, int i) {
        sum = s;
        idx = i;
    }
}