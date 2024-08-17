class Solution {
    public long maximumValueSum(int[][] board) {
        // find the top 500 cells or so?
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0])); // value, <x, y> location
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                pq.add(new int[]{board[i][j], i, j});
            }
        }

        ArrayList<int[]> arr = new ArrayList<>();
        int s = pq.size();
        for (int i = 0; i < Math.min(s, 200); i++)
        {
            arr.add(pq.poll());
        }

        long ans = Long.MIN_VALUE + 9;
        for (int i = 0; i < arr.size(); i++)
        {
            for (int j = i + 1; j < arr.size(); j++)
            {
                for (int k = j + 1; k < arr.size(); k++)
                {
                    if (((arr.get(i)[1]) == arr.get(j)[1]) ||  ((arr.get(j)[1]) == arr.get(k)[1]) || ((arr.get(i)[1]) == arr.get(k)[1]))
                    continue;
                    if (((arr.get(i)[2]) == arr.get(j)[2]) ||  ((arr.get(j)[2]) == arr.get(k)[2]) || ((arr.get(i)[2]) == arr.get(k)[2]))
                    continue;
                    ans = Math.max(ans, (long)arr.get(i)[0] + (long)arr.get(j)[0] + (long)arr.get(k)[0]);
                }
            }
        }
        return ans;
    }
}