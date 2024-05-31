class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1')
                    height[j] += 1;
                else
                    height[j] = 0;
            }
            int area = largestArea(height);
            max = Math.max(max, area);
        }
        return max;
    }

    public int largestArea(int height[]) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (st.size() > 1 && height[i] < height[st.peek()]) {
                int cur = st.pop();
                int rb = i;
                int lb = st.peek();
                area = Math.max(area, (rb - lb - 1) * height[cur]);
            }
            st.push(i);
        }
        while (st.size() > 1) {
            int cur = st.pop();
            int rb = height.length;
            int lb = st.peek();
            area = Math.max(area, (rb - lb - 1) * height[cur]);
        }
        return area;
    }
}