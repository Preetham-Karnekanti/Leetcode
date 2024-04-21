class Solution {
    public int maximalSquare(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            max = Math.max(max, largestArea(heights));
        }
        return max * max;
    }

    public int largestArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (st.size() > 1 && arr[st.peek()] > arr[i]) {
                int cur = arr[st.pop()];
                int lb = st.peek();
                int rb = i;
                int width = rb - lb - 1;
                if (width >= cur)
                    res = Math.max(res, cur);
            }
            st.push(i);
        }

        while (st.size() > 1) {
            int cur = arr[st.pop()];
            int lb = st.peek();
            int rb = arr.length;
            int width = rb - lb - 1;
            if (width >= cur)
                res = Math.max(res, cur);
        }
        return res;
    }
}