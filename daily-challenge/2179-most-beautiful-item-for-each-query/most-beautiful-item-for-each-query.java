class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }
        int answer[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = bs(items, queries[i]);
        }

        return answer;
    }

    public int bs(int items[][], int key) {
        int low = 0;
        int ans = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (items[mid][0] <= key) {
                ans = items[mid][1];
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return ans;
    }
}