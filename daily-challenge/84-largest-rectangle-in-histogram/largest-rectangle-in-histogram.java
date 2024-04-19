class Solution {
    public int largestRectangleArea(int[] heights) {
        int left[] = nextSmallerElementOnLeft(heights);
        int right[] = nextSmallerElementOnRight(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    public int[] nextSmallerElementOnLeft(int[] heights) {
        int ans[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }

    public int[] nextSmallerElementOnRight(int heights[]) {
        int ans[] = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ans, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}