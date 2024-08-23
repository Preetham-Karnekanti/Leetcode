class Solution {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int[] res = new int[n];

        for (int[] p : paint) {
            int work = 0;
            int start = p[0];
            int end = p[1];

            while (start < end) {
                if (map.containsKey(start)) {
                    int prevEnd = map.get(start);

                    // place the max area painted
                    map.put(start, Math.max(map.get(start), end));

                    start = prevEnd;
                } else {
                    map.put(start, end);
                    start += 1;
                    work += 1;
                }
            }
            res[i++] = work;
        }

        return res;
    }
}