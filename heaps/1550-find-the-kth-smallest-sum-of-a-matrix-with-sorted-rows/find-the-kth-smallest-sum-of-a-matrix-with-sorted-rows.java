class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int row[] = mat[0];
        for (int i = 1; i < mat.length; i++) {
            row = helper(row, mat[i], k);
        }

        return row[k - 1];
    }

    public int[] helper(int[] arr1, int arr2[], int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr1.length; i++) {
            pq.add(new int[] { arr1[i] + arr2[0], 0 });
        }
        ArrayList<Integer> temp = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int cur[] = pq.poll();
            int idx = cur[1];
            int sum = cur[0];
            temp.add(cur[0]);

            if (idx + 1 < arr2.length) {
                pq.add(new int[] { sum - arr2[idx] + arr2[idx + 1], idx + 1 });
            }
        }
        return temp.stream().mapToInt(i -> i).toArray();
    }
}